package integrador2.Repository.Impl;

import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;
import integrador2.Repository.Interfaces.EstudianteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManagerFactory emf;
    private static EstudianteRepositoryImpl instance;

    public EstudianteRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static EstudianteRepositoryImpl getInstance(EntityManagerFactory emf) {
        if(instance == null){
            instance = new EstudianteRepositoryImpl(emf);
        }
        return instance;
    }

    @Override
    public Estudiante find(int DNI) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Estudiante.class, DNI);
        } finally {
            em.close();
        }
    }

    @Override
    public Estudiante findByLU(int LU) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Estudiante> query = em.createQuery(
                    "SELECT e FROM Estudiante e WHERE e.LU = :lu", Estudiante.class);
            query.setParameter("lu", LU);

            List<Estudiante> students = query.getResultList();
            return students.isEmpty() ? null : students.get(0);
        } finally {
            em.close();
        }
    }


    @Override
    public List<Estudiante> findByGenero(String gender) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Estudiante> query = em.createQuery(
                    "SELECT e FROM Estudiante e WHERE e.genero = :gender", Estudiante.class);
            query.setParameter("gender", gender);

            List<Estudiante> students = query.getResultList();
            return students;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Estudiante> findByCarrera(Carrera carrera, String ciudad) {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT e.nombre, e.apellido, e.ciudad, c.carrera " +
                    "FROM Matricula ec " +
                    "JOIN ec.estudiante e " +
                    "JOIN ec.carrera c " +
                    "WHERE c.carrera = :carrera AND e.ciudad = :ciudad";

            return em.createQuery(jpql, Estudiante.class).setParameter("carrera", carrera.getCarrera()).setParameter("ciudad", ciudad).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Boolean save(Estudiante estudiante) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if(find(estudiante.getDNI()) == null) {
                em.persist(estudiante);
                em.getTransaction().commit();
                return true;
            }
            em.merge(estudiante);
            em.getTransaction().commit();
            return false;
        } catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Estudiante> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Estudiante> query = em.createQuery(
                    "SELECT e FROM Estudiante e", Estudiante.class);

            List<Estudiante> students = query.getResultList();
            return students;
        } finally {
            em.close();
        }
    }
}
