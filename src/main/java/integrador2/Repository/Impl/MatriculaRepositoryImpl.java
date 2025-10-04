package integrador2.Repository.Impl;

import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;
import integrador2.Entities.Matricula;
import integrador2.Repository.Interfaces.MatriculaRepository;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class MatriculaRepositoryImpl implements MatriculaRepository {
    private EntityManager em;

    public MatriculaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Boolean save(Estudiante estudiante, Carrera carrera) {
        Matricula ec  = new Matricula();
        LocalDate currentDate = LocalDate.now();
        ec.setInscripcion(currentDate.getYear()); // Año de inscripción
        ec.setGraduado(currentDate.getYear() + carrera.getDuracion()); // Año estimado de graduación
        ec.setCarrera(carrera);
        ec.setEstudiante(estudiante);
        ec.setAntiguedad(0);

        em.persist(ec);
        return true;
    }
}
