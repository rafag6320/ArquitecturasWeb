package com.arqui.integrador3.utils;

import com.arqui.integrador3.repository.CarreraRepository;
import com.arqui.integrador3.repository.EstudianteRepository;
import com.arqui.integrador3.repository.MatriculaRepository;
import com.arqui.integrador3.service.CSVReaderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CSVReader implements CommandLineRunner {
    private final CSVReaderService csvReaderService;
    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;
    private final MatriculaRepository matriculaRepository;

    public CSVReader(CSVReaderService csvReaderService,
                      EstudianteRepository estudianteRepository,
                      CarreraRepository carreraRepository, MatriculaRepository matriculaRepository) {
        this.csvReaderService = csvReaderService;
        this.estudianteRepository = estudianteRepository;
        this.carreraRepository = carreraRepository;
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        csvReaderService.importarDatos();

        System.out.println("Carreras cargadas: " + carreraRepository.count());
        System.out.println("Estudiantes cargados: " + estudianteRepository.count());
        System.out.println("Inscripciones cargadas: " + matriculaRepository.count());
    }
}
