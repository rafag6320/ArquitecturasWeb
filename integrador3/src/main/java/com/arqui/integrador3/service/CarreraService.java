package com.arqui.integrador3.service;

import com.arqui.integrador3.dto.request.CarreraRequestDTO;
import com.arqui.integrador3.dto.response.CarreraResponseDTO;
import com.arqui.integrador3.dto.response.EstadisticaCarreraDTO;
import com.arqui.integrador3.dto.response.ReporteCarreraDTO;
import com.arqui.integrador3.entity.Carrera;
import com.arqui.integrador3.mapper.CarreraMapper;
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
    private final CarreraMapper carreraMapper;

    public CarreraService(CarreraRepository carreraRepository, MatriculaRepository matriculaRepository, ReportMapper reportMapper, CarreraMapper carreraMapper) {
        this.carreraRepository = carreraRepository;
        this.matriculaRepository = matriculaRepository;
        this.reportMapper = reportMapper;
        this.carreraMapper = carreraMapper;
    }

    public List<EstadisticaCarreraDTO> findCareerOrderedByStudents (){
        return matriculaRepository.findCarrerasConCantidadDeInscriptos();
    }

    public List<ReporteCarreraDTO> generateCareerReport () {
        List<Object[]> analytic = matriculaRepository.generateCareerReport();
        return analytic.stream().map(reportMapper::convertFromEntity).toList();
    }

    public List<CarreraResponseDTO> findAll() {
        List<Carrera> carreras = carreraRepository.findAll();
        return carreras.stream().map(carreraMapper::convertFromEntity).toList();
    }

    public CarreraResponseDTO findById(Integer id) {
        Carrera c = carreraRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe una carrera registrada con este identificador"));
        return carreraMapper.convertFromEntity(c);
    }

    public CarreraResponseDTO save(CarreraRequestDTO req) {
        if(carreraRepository.existsById(req.getId_carrera())){
            throw new IllegalStateException("Ya existe una carrera registrada con este identificador");
        }

        Carrera c = new Carrera(req.getId_carrera(), req.getDuracion(), req.getCarrera());
        carreraRepository.save(c);
        return carreraMapper.convertFromEntity(c);
    }

    public Boolean delete(Integer id) {
        if(!carreraRepository.existsById(id)){
            throw new IllegalStateException("No existe una carrera registrada con este identificador");
        }

        Carrera c = carreraRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe una carrera registrada con este identificador"));
        carreraRepository.delete(c);
        return true;
    }

    public CarreraResponseDTO update(Integer id, CarreraRequestDTO req) {
        Carrera c = carreraRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe una carrera registrada con este identificador"));
        c.setDuracion(req.getDuracion());
        c.setCarrera(req.getCarrera());
        carreraRepository.save(c);
        return carreraMapper.convertFromEntity(c);
    }
}
