package integrador2.Repository.Interfaces;

import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;

public interface EstudianteCarreraRepository {
    Boolean save(Estudiante estudiante, Carrera carrera); // Matricular estudiante
}
