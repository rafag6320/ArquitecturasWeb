package com.arqui.integrador3.mapper;

import com.arqui.integrador3.dto.request.EstudianteRequestDTO;
import com.arqui.integrador3.dto.response.EstudianteResponseDTO;
import com.arqui.integrador3.entity.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {
    public static Estudiante convertFromDTO(EstudianteRequestDTO dto){
        return new Estudiante(
                dto.getDni(),
                dto.getLU(),
                dto.getEdad(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getGenero(),
                dto.getCiudad()
        );
    }

    public EstudianteResponseDTO convertFromEntity(Estudiante entity){
        EstudianteResponseDTO dto = new EstudianteResponseDTO();
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setLU(entity.getLU());
        dto.setEdad(entity.getEdad());
        dto.setCiudad(entity.getCiudad());

        return dto;
    }
}
