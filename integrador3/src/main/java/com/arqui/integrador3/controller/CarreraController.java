package com.arqui.integrador3.controller;

import com.arqui.integrador3.dto.request.CarreraRequestDTO;
import com.arqui.integrador3.dto.response.CarreraResponseDTO;
import com.arqui.integrador3.dto.response.EstadisticaCarreraDTO;
import com.arqui.integrador3.dto.response.ReporteCarreraDTO;
import com.arqui.integrador3.service.CarreraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    // Ej 2 (f) - Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    @GetMapping("/inscriptos")
    public ResponseEntity<List<EstadisticaCarreraDTO>> findCareerOrderedByStudents() {
        List<EstadisticaCarreraDTO> careers = carreraService.findCareerOrderedByStudents();
        return ResponseEntity.ok().body(careers);
    }

    // Ej 2 (h) - Generar un reporte de las carreras, que para cada carrera incluya información de los
    // inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y
    // presentar los años de manera cronológica.
    @GetMapping("/reporte")
    public ResponseEntity<List<ReporteCarreraDTO>> generateCareerReport() {
        List<ReporteCarreraDTO> report = carreraService.generateCareerReport();
        return ResponseEntity.ok().body(report);
    }

    @GetMapping("")
    public ResponseEntity<List<CarreraResponseDTO>> findAll() {
        List<CarreraResponseDTO> res = carreraService.findAll();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarreraResponseDTO> findById(@PathVariable Integer id) {
        CarreraResponseDTO res = carreraService.findById(id);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("")
    public ResponseEntity<CarreraResponseDTO> save(@RequestBody CarreraRequestDTO dto){
        CarreraResponseDTO res = carreraService.save(dto);
        return ResponseEntity.ok().body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        if(carreraService.delete(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarreraResponseDTO> update(@PathVariable Integer id, @RequestBody CarreraRequestDTO dto){
        CarreraResponseDTO res = carreraService.update(id, dto);
        return ResponseEntity.ok().body(res);
    }
}
