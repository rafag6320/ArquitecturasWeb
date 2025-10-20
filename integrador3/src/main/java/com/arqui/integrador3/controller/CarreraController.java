package com.arqui.integrador3.controller;

import com.arqui.integrador3.dto.response.EstadisticaCarreraDTO;
import com.arqui.integrador3.service.CarreraService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
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
}
