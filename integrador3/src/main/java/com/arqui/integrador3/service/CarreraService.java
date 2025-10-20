package com.arqui.integrador3.service;

import com.arqui.integrador3.dto.response.EstadisticaCarreraDTO;
import com.arqui.integrador3.repository.CarreraRepository;
import com.arqui.integrador3.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {
    private final CarreraRepository carreraRepository;
    private final MatriculaRepository matriculaRepository;

    public CarreraService(CarreraRepository carreraRepository, MatriculaRepository matriculaRepository) {
        this.carreraRepository = carreraRepository;
        this.matriculaRepository = matriculaRepository;
    }

    public List<EstadisticaCarreraDTO> findCareerOrderedByStudents (){
        return matriculaRepository.findCarrerasConCantidadDeInscriptos();
    }
}
