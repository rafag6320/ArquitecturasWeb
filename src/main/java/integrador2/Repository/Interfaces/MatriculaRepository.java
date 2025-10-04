package integrador2.Repository.Interfaces;

import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;

public interface MatriculaRepository {
    Boolean save(Estudiante estudiante, Carrera carrera); // Ej 2 (b) - Matricular estudiante
}
