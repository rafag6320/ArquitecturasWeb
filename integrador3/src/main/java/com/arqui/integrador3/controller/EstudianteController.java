package com.arqui.integrador3.controller;

import com.arqui.integrador3.dto.request.EstudianteRequestDTO;
import com.arqui.integrador3.dto.response.EstudianteResponseDTO;
import com.arqui.integrador3.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService service) {
        this.estudianteService = service;
    }

    // Ej 2 (a) - Dar de alta estudiante
    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody EstudianteRequestDTO dto){
        EstudianteResponseDTO insertedRow =  estudianteService.save(dto);
        return ResponseEntity.ok().body(insertedRow);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<EstudianteResponseDTO> findByDni(@PathVariable Integer dni){
        EstudianteResponseDTO row =  estudianteService.findByDni(dni);
        return ResponseEntity.ok().body(row);
    }

    // Ej 2 (e) - Recuperar todos los estudiantes, en base a su género.
    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<EstudianteResponseDTO>> findByGender(@PathVariable String gender){
        List<EstudianteResponseDTO> rows =  estudianteService.findByGender(gender);
        return ResponseEntity.ok().body(rows);
    }

    // Ej 2 (d) - Recuperar un estudiante, en base a su número de libreta universitaria.
    @GetMapping("/lu/{lu}")
    public ResponseEntity<EstudianteResponseDTO> findByLU(@PathVariable Integer lu){
        EstudianteResponseDTO row =  estudianteService.findByDni(lu);
        return ResponseEntity.ok().body(row);
    }

    // Ej 2 (c) - Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    // En este caso al obtener todos, por defecto los ordena por edad
    @GetMapping("")
    public ResponseEntity<List<EstudianteResponseDTO>> findAll(){
        List<EstudianteResponseDTO> rows =  estudianteService.findAll();
        return ResponseEntity.ok().body(rows);
    }

    // Ej 2 (g) - Recuperar todos los estudiantes filtrados por ciudad de residencia y carrera
    @GetMapping("/{carrer}/{city}")
    public ResponseEntity<List<EstudianteResponseDTO>> findByCareerAndCity(@PathVariable String career, @PathVariable String city){
        List<EstudianteResponseDTO> rows =  estudianteService.findByCareerAndCity(career, city);
        return ResponseEntity.ok().body(rows);
    }


    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> delete(@PathVariable Integer dni){
        Boolean deletedRow =  estudianteService.delete(dni);
        if(deletedRow) return  ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/{dni}")
    public ResponseEntity<EstudianteResponseDTO> update(@PathVariable Integer dni, @RequestBody EstudianteRequestDTO dto){
        EstudianteResponseDTO updatedRow =  estudianteService.update(dni, dto);
        return ResponseEntity.ok().body(updatedRow);
    }
}
