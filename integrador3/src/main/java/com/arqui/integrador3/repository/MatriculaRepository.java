package com.arqui.integrador3.repository;

import com.arqui.integrador3.dto.response.EstadisticaCarreraDTO;
import com.arqui.integrador3.entity.Estudiante;
import com.arqui.integrador3.entity.Matricula;
import com.arqui.integrador3.entity.MatriculaSerializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaSerializable> {
    @Query("SELECT m.estudiante FROM Matricula m " +
            "WHERE m.carrera.carrera = :nombreCarrera AND m.estudiante.ciudad = :ciudad")
    List<Estudiante> findEstudiantesByCarreraAndCiudad(@Param("nombreCarrera") String nombreCarrera,
                                                       @Param("ciudad") String ciudad);
    @Query("SELECT new com.arqui.integrador3.dto.response.EstadisticaCarreraDTO(" +
            "m.carrera.id_carrera, m.carrera.carrera, COUNT(m)) " +
            "FROM Matricula m " +
            "GROUP BY m.carrera.id_carrera, m.carrera.carrera " +
            "ORDER BY COUNT(m) DESC")
    List<EstadisticaCarreraDTO> findCarrerasConCantidadDeInscriptos();
    @Query(
            value = "SELECT c.carrera AS carrera, a.anio, " +
                    "SUM(CASE WHEN a.tipo = 'I' THEN 1 ELSE 0 END) AS inscriptos, " +
                    "SUM(CASE WHEN a.tipo = 'G' THEN 1 ELSE 0 END) AS egresados " +
                    "FROM (" +
                    "   SELECT m1.id_carrera AS id_carrera, m1.inscripcion AS anio, 'I' AS tipo FROM matricula m1 " +
                    "   UNION ALL " +
                    "   SELECT m2.id_carrera AS id_carrera, m2.graduado AS anio, 'G' AS tipo FROM matricula m2 WHERE m2.graduado IS NOT NULL" +
                    ") a " +
                    "JOIN carrera c ON c.id_carrera = a.id_carrera " +
                    "GROUP BY c.carrera, a.anio " +
                    "ORDER BY c.carrera ASC, a.anio ASC",
            nativeQuery = true
    )
    List<Object[]> generateCareerReport();
}
