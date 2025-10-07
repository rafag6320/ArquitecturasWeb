package integrador2.Repository.Impl;

import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;
import integrador2.Entities.Matricula;
import integrador2.Repository.Interfaces.MatriculaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class MatriculaRepositoryImpl implements MatriculaRepository {
    private EntityManagerFactory emf;
    private static MatriculaRepositoryImpl instance;

    public MatriculaRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static MatriculaRepositoryImpl getInstance(EntityManagerFactory emf) {
        if(instance == null){
            instance = new MatriculaRepositoryImpl(emf);
        }
        return instance;
    }

    @Override
    public Boolean save(int id_estudiante, int id_carrera, int inscripcion, int graduacion, int antiguedad) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Estudiante e = em.find(Estudiante.class, id_estudiante);
            Carrera c = em.find(Carrera.class, id_carrera);
            Matricula ec  = new Matricula();
            ec.setInscripcion(inscripcion);
            ec.setGraduado(graduacion);
            ec.setCarrera(c);
            ec.setEstudiante(e);
            ec.setAntiguedad(antiguedad);

            em.persist(ec);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
