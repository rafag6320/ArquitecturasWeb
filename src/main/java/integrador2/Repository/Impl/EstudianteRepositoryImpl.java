package integrador2.Repository.Impl;

import integrador2.Entities.Estudiante;
import integrador2.Repository.Interfaces.EstudianteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager em;

    public EstudianteRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Estudiante find(int DNI) {
        return em.find(Estudiante.class, DNI);
    }

    @Override
    public Estudiante findByLU(int LU) {
        TypedQuery<Estudiante> query = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.LU = :lu", Estudiante.class);
        query.setParameter("lu", LU);

        List<Estudiante> students = query.getResultList();
        return students.isEmpty() ? null : students.get(0);
    }


    @Override
    public List<Estudiante> findByGenero(String gender) {
        TypedQuery<Estudiante> query = em.createQuery(
                "SELECT e FROM Estudiante e WHERE e.genero = :gender", Estudiante.class);
        query.setParameter("gender", gender);

        List<Estudiante> students = query.getResultList();
        return students;
    }

    @Override
    public Boolean save(Estudiante estudiante) {
        if(find(estudiante.getDNI()) == null) {
            em.persist(estudiante);
            return true;
        }
        return false;
    }

    @Override
    public List<Estudiante> findAll() {
        TypedQuery<Estudiante> query = em.createQuery(
                "SELECT e FROM Estudiante e", Estudiante.class);

        List<Estudiante> students = query.getResultList();
        return students;
    }
}
