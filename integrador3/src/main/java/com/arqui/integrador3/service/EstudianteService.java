package com.arqui.integrador3.service;

import com.arqui.integrador3.dto.request.EstudianteRequestDTO;
import com.arqui.integrador3.dto.response.EstudianteResponseDTO;
import com.arqui.integrador3.entity.Estudiante;
import com.arqui.integrador3.mapper.EstudianteMapper;
import com.arqui.integrador3.repository.EstudianteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    public EstudianteService(EstudianteRepository estudianteRepository,  EstudianteMapper estudianteMapper) {
        this.estudianteRepository = estudianteRepository;
        this.estudianteMapper = estudianteMapper;
    }

    public EstudianteResponseDTO save(EstudianteRequestDTO req) {
        if(req.getDni() == null) {
            throw new IllegalArgumentException("El campo documento es obligatorio");
        }
        if(estudianteRepository.existsById(req.getDni())) {
            throw new IllegalArgumentException("Un estudiante ya se ha registrado con este DNI");
        }
        if(req.getLU() == null) {
            throw new IllegalArgumentException("El campo libreria universitaria es obligatoria");
        }

        Estudiante estudiante = new Estudiante(req.getDni(), req.getLU(), req.getEdad(), req.getNombre(), req.getApellido(), req.getGenero(), req.getCiudad());
        estudianteRepository.save(estudiante);
        return estudianteMapper.convertFromEntity(estudiante);
    }

    public List<EstudianteResponseDTO> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "edad");
        return estudianteRepository.findAllOrderedByAge(sort).stream().map(estudianteMapper::convertFromEntity).toList();
    }

    public List<EstudianteResponseDTO> findByGender(String gender) {
        List<Estudiante> rawList = estudianteRepository.findByGender(gender);
        return rawList.stream().map(estudianteMapper::convertFromEntity).toList();
    }

    public EstudianteResponseDTO findByDni(Integer dni){
        Estudiante e = estudianteRepository.findById(dni).orElseThrow(() -> new IllegalArgumentException("No existe estudiante registrado con este DNI"));
        return estudianteMapper.convertFromEntity(e);
    }

    public EstudianteResponseDTO findByLU(Integer LU){
        Estudiante e = estudianteRepository.findByLU(LU).orElseThrow(() -> new IllegalArgumentException("No existe estudiante registrado con esta libreta universitaria"));
        return estudianteMapper.convertFromEntity(e);
    }

    public boolean delete(Integer dni){
        Estudiante e = estudianteRepository.findById(dni).orElseThrow(() -> new IllegalArgumentException("No existe estudiante registrado con este DNI"));
        estudianteRepository.delete(e);
        return true;
    }

    public EstudianteResponseDTO update(Integer dni, EstudianteRequestDTO req) {
        Estudiante updatedRow = estudianteRepository.findById(dni).orElseThrow(() -> new IllegalArgumentException("No existe estudiante registrado con este DNI"));

        if(req.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if(req.getApellido().isBlank()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        if(req.getCiudad().isBlank()) {
            throw new IllegalArgumentException("La ciudad es obligatoria");
        }
        if(req.getLU() == null) {
            throw new IllegalArgumentException("La libreta universitaria es obligatoria");
        }
        if(req.getGenero().isBlank()) {
            throw new IllegalArgumentException("El genero es obligatorio");
        }

        updatedRow.setNombre(req.getNombre());
        updatedRow.setApellido(req.getApellido());
        updatedRow.setCiudad(req.getCiudad());
        updatedRow.setLU(req.getLU());
        updatedRow.setGenero(req.getGenero());
        updatedRow.setEdad(req.getEdad());

        estudianteRepository.save(updatedRow);
        return estudianteMapper.convertFromEntity(updatedRow);
    }
}
