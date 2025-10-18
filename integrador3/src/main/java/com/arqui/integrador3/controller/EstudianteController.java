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
    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    // Ej 2 (a) - Dar de alta estudiante
    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody EstudianteRequestDTO dto){
        EstudianteResponseDTO insertedRow =  service.save(dto);
        return ResponseEntity.ok().body(insertedRow);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<EstudianteResponseDTO> findByDni(@PathVariable Integer dni){
        EstudianteResponseDTO row =  service.findByDni(dni);
        return ResponseEntity.ok().body(row);
    }

    // Ej 2 (e) - Recuperar todos los estudiantes, en base a su género.
    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<EstudianteResponseDTO>> findByGender(@PathVariable String gender){
        List<EstudianteResponseDTO> rows =  service.findByGender(gender);
        return ResponseEntity.ok().body(rows);
    }

    // Ej 2 (d) - Recuperar un estudiante, en base a su número de libreta universitaria.
    @GetMapping("/lu/{lu}")
    public ResponseEntity<EstudianteResponseDTO> findByLU(@PathVariable Integer lu){
        EstudianteResponseDTO row =  service.findByDni(lu);
        return ResponseEntity.ok().body(row);
    }

    // Ej 2 (c) - Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    // En este caso al obtener todos, por defecto los ordena por edad
    @GetMapping("")
    public ResponseEntity<List<EstudianteResponseDTO>> findAll(){
        List<EstudianteResponseDTO> rows =  service.findAll();
        return ResponseEntity.ok().body(rows);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> delete(@PathVariable Integer dni){
        Boolean deletedRow =  service.delete(dni);
        if(deletedRow) return  ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/{dni}")
    public ResponseEntity<EstudianteResponseDTO> update(@PathVariable Integer dni, @RequestBody EstudianteRequestDTO dto){
        EstudianteResponseDTO updatedRow =  service.update(dni, dto);
        return ResponseEntity.ok().body(updatedRow);
    }
}
