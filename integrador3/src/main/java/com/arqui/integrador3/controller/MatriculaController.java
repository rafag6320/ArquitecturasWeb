package com.arqui.integrador3.controller;

import com.arqui.integrador3.dto.request.MatriculaRequestDTO;
import com.arqui.integrador3.dto.response.MatriculaResponseDTO;
import com.arqui.integrador3.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    // Ej 2 (b) - Matricular un estudiante en una carrera
    @PutMapping("")
    public ResponseEntity<MatriculaResponseDTO> save (@RequestBody MatriculaRequestDTO req) {
        MatriculaResponseDTO matriculaResponseDTO = matriculaService.save(req);
        return ResponseEntity.ok().body(matriculaResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponseDTO> findById(@PathVariable Integer id){
        MatriculaResponseDTO res = matriculaService.findById(id);
        return res != null ? ResponseEntity.ok().body(res) : ResponseEntity.notFound().build();
    }

    @GetMapping("")
    public ResponseEntity<List<MatriculaResponseDTO>> findAll(){
        List<MatriculaResponseDTO> res = matriculaService.findAll();
        return res != null ? ResponseEntity.ok().body(res) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        matriculaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
