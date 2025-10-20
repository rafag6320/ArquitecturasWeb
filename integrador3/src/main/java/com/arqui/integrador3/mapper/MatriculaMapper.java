package com.arqui.integrador3.mapper;

import com.arqui.integrador3.dto.request.MatriculaRequestDTO;
import com.arqui.integrador3.dto.response.MatriculaResponseDTO;
import com.arqui.integrador3.entity.Estudiante;
import com.arqui.integrador3.entity.Matricula;
import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {
    public static Matricula convertFromDTO(MatriculaRequestDTO dto){
        return new Matricula(
                dto.getId(),
                dto.getInscripcion(),
                dto.getGraduado(),
                dto.getAntiguedad(),
                dto.getId_carrera(),
                dto.getId_estudiante()
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
