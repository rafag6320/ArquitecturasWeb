package com.arqui.integrador3.controller;

import com.arqui.integrador3.dto.response.EstadisticaCarreraDTO;
import com.arqui.integrador3.dto.response.ReporteCarreraDTO;
import com.arqui.integrador3.service.CarreraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }


    // Ej 2 (f) - Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    @GetMapping("")
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
}
