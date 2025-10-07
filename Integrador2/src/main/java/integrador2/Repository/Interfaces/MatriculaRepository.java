package integrador2.Repository.Interfaces;

public interface MatriculaRepository {
    Boolean save(int id_estudiante, int id_carrera, int inscripcion, int graduacion, int antiguedad); // Ej 2 (b) - Matricular estudiante
}
