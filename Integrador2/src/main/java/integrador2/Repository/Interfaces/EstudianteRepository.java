package integrador2.Repository.Interfaces;

import integrador2.DTO.EstudianteCarreraDTO;
import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    Estudiante find(int DNI);
    Estudiante findByLU(int LU); // Ej 2 (d)
    Boolean save(Estudiante estudiante); // Ej 2 (a) - Dar de alta
    List<Estudiante> findAllOrderedByAge(); // Ej 2 (c)
    List<Estudiante> findByGenero(String genero); // Ej 2 (e)
    List<EstudianteCarreraDTO> findByCarrera(Carrera carrera, String ciudad); // Ej 2 (i) - Recuperar estudiantes por ciudad
}
