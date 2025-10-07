package integrador2.Repository.Interfaces;

import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    Estudiante find(int DNI);
    Estudiante findByLU(int LU); // Ej 2 (d)
    Boolean save(Estudiante estudiante); // Ej 2 (a) - Dar de alta
    List<Estudiante> findAll(); // Ej 2 (c)
    List<Estudiante> findByGenero(String genero); // Ej 2 (e)
    List<Estudiante> findByCarrera(Carrera carrera, String ciudad); // Ej 2 (i) - Recuperar estudiantes por ciudad
}
