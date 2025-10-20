package com.arqui.integrador3.mapper;

import com.arqui.integrador3.dto.request.MatriculaRequestDTO;
import com.arqui.integrador3.dto.response.MatriculaResponseDTO;
import com.arqui.integrador3.entity.Carrera;
import com.arqui.integrador3.entity.Estudiante;
import com.arqui.integrador3.entity.Matricula;
import com.arqui.integrador3.entity.MatriculaSerializable;
import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {
    public static Matricula convertFromDTO(MatriculaRequestDTO dto, Estudiante estudiante, Carrera carrera){
        return new Matricula(
                new MatriculaSerializable(estudiante.getDNI(), carrera.getId_carrera()),
                dto.getInscripcion(),
                dto.getGraduado(),
                dto.getAntiguedad(),
                estudiante,
                carrera
        );
    }

    public MatriculaResponseDTO convertFromEntity(Matricula entity){
        MatriculaResponseDTO dto = new MatriculaResponseDTO();
        dto.setId_carrera(entity.getCarrera().getId_carrera());
        dto.setId_estudiante(entity.getEstudiante().getDNI());
        dto.setInscripcion(entity.getInscripcion());
        dto.setGraduado(entity.getGraduado());
        dto.setAntiguedad(entity.getAntiguedad());
        return dto;
    }
}
