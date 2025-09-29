package integrador2.Repository.Impl;

import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;
import integrador2.Entities.EstudianteCarrera;
import integrador2.Repository.Interfaces.EstudianteCarreraRepository;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {
    private EntityManager em;

    public EstudianteCarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Boolean save(Estudiante estudiante, Carrera carrera) {
        EstudianteCarrera ec  = new EstudianteCarrera();
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
