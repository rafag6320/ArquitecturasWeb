package com.arqui.integrador3.service;

import com.arqui.integrador3.dto.request.MatriculaRequestDTO;
import com.arqui.integrador3.dto.response.MatriculaResponseDTO;
import com.arqui.integrador3.entity.Carrera;
import com.arqui.integrador3.entity.Estudiante;
import com.arqui.integrador3.entity.Matricula;
import com.arqui.integrador3.entity.MatriculaSerializable;
import com.arqui.integrador3.mapper.MatriculaMapper;
import com.arqui.integrador3.repository.CarreraRepository;
import com.arqui.integrador3.repository.EstudianteRepository;
import com.arqui.integrador3.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {
    private final MatriculaRepository matriculaRepository;
    private final MatriculaMapper matriculaMapper;
    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, MatriculaMapper matriculaMapper, EstudianteRepository estudianteRepository, CarreraRepository carreraRepository) {
        this.matriculaRepository = matriculaRepository;
        this.matriculaMapper = matriculaMapper;
        this.estudianteRepository = estudianteRepository;
        this.carreraRepository = carreraRepository;
    }

    public MatriculaResponseDTO save (MatriculaRequestDTO req) {
        Estudiante estudiante = estudianteRepository.findById(req.getId_estudiante()).orElseThrow(() -> new IllegalArgumentException("No existe estudiante registrado con este DNI"));
        Carrera carrera = carreraRepository.findById(req.getId_carrera()).orElseThrow(() -> new IllegalArgumentException("No existe carrera registrada con este ID"));

        MatriculaSerializable serializable = new MatriculaSerializable(req.getId_estudiante(),req.getId_carrera());

        if(matriculaRepository.existsById(serializable.hashCode())){
            throw new IllegalStateException("La matricula ya existe para el estudiante " +
                    req.getId_estudiante() + " en la carrera " + req.getId_carrera());
        }

        Matricula m = matriculaMapper.convertFromDTO(req, estudiante, carrera);

        Matricula insert = matriculaRepository.save(m);
        return matriculaMapper.convertFromEntity(insert);
    }

    public MatriculaResponseDTO findById(Integer id) {
        Matricula m = matriculaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontro matricula registrada con este ID"));
        return matriculaMapper.convertFromEntity(m);
    }

    public List<MatriculaResponseDTO> findAll (){
        List<Matricula> matriculas = matriculaRepository.findAll();
        return matriculas.stream().map(matriculaMapper::convertFromEntity).toList();
    }

    public boolean delete(Integer id){
        Matricula m = matriculaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe matricula registrada con este ID"));
        matriculaRepository.delete(m);
        return true;
    }
}
