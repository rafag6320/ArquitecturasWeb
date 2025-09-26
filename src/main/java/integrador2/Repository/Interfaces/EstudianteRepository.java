package integrador2.Repository.Interfaces;

import integrador2.Entities.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    Estudiante find(int DNI);
    Estudiante findByLU(int LU);
    Boolean save(Estudiante estudiante); // Dar de alta
    List<Estudiante> findAll();
    List<Estudiante> findByGenero(String genero);
}
