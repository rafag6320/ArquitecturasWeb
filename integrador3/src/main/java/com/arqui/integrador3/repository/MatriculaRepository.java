package com.arqui.integrador3.repository;

import com.arqui.integrador3.entity.Estudiante;
import com.arqui.integrador3.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
    @Query("SELECT m.estudiante FROM Matricula m " +
            "WHERE m.carrera.carrera = :nombreCarrera AND m.estudiante.ciudad = :ciudad")
    List<Estudiante> findEstudiantesByCarreraAndCiudad(@Param("nombreCarrera") String nombreCarrera,
                                                       @Param("ciudad") String ciudad);
}
