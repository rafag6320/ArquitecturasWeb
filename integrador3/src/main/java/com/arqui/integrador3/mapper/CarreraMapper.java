package com.arqui.integrador3.mapper;

import com.arqui.integrador3.dto.request.CarreraRequestDTO;
import com.arqui.integrador3.dto.response.CarreraResponseDTO;
import com.arqui.integrador3.entity.Carrera;
import org.springframework.stereotype.Component;

@Component
public class CarreraMapper {
    public static Carrera convertFromDTO(CarreraRequestDTO dto){
        return new Carrera(
                dto.getId_carrera(),
                dto.getDuracion(),
                dto.getCarrera()
        );
    }

    public CarreraResponseDTO convertFromEntity(Carrera entity){
        CarreraResponseDTO dto = new CarreraResponseDTO();
        dto.setId_carrera(entity.getId_carrera());
        dto.setDuracion(entity.getDuracion());
        dto.setCarrera(entity.getCarrera());

        return dto;
    }
}
