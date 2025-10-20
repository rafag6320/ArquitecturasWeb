package com.arqui.integrador3.mapper;

import com.arqui.integrador3.dto.response.ReporteCarreraDTO;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {
    public ReporteCarreraDTO convertFromEntity(Object[] row){
        ReporteCarreraDTO dto = new ReporteCarreraDTO();
        dto.setCarrera((String) row[0]); // nombre de la carrera
        dto.setAnio(((Number) row[1]).intValue()); // año (cast seguro)
        dto.setInscriptos(((Number) row[2]).intValue()); // cantidad de inscriptos
        dto.setGraduados(((Number) row[3]).intValue());  // cantidad de egresados
        return dto;
    }
}
