package com.arqui.integrador3.service;

import com.arqui.integrador3.dto.response.EstadisticaCarreraDTO;
import com.arqui.integrador3.dto.response.ReporteCarreraDTO;
import com.arqui.integrador3.mapper.ReportMapper;
import com.arqui.integrador3.repository.CarreraRepository;
import com.arqui.integrador3.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {
    private final CarreraRepository carreraRepository;
    private final MatriculaRepository matriculaRepository;
    private final ReportMapper reportMapper;

    public CarreraService(CarreraRepository carreraRepository, MatriculaRepository matriculaRepository, ReportMapper reportMapper) {
        this.carreraRepository = carreraRepository;
        this.matriculaRepository = matriculaRepository;
        this.reportMapper = reportMapper;
    }

    public List<EstadisticaCarreraDTO> findCareerOrderedByStudents (){
        return matriculaRepository.findCarrerasConCantidadDeInscriptos();
    }

    public List<ReporteCarreraDTO> generateCareerReport () {
        List<Object[]> analytic = matriculaRepository.generateCareerReport();
        return analytic.stream().map(reportMapper::convertFromEntity).toList();
    }
}
