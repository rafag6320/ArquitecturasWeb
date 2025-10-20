package com.arqui.integrador3.service;

import com.arqui.integrador3.entity.Carrera;
import com.arqui.integrador3.entity.Estudiante;
import com.arqui.integrador3.entity.Matricula;
import com.arqui.integrador3.entity.MatriculaSerializable;
import com.arqui.integrador3.repository.CarreraRepository;
import com.arqui.integrador3.repository.EstudianteRepository;
import com.arqui.integrador3.repository.MatriculaRepository;
import com.sun.tools.javac.Main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CSVReaderService {
    private final MatriculaRepository matriculaRepository;
    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;

    public CSVReaderService(MatriculaRepository matriculaRepository, EstudianteRepository estudianteRepository, CarreraRepository carreraRepository) {
        this.matriculaRepository = matriculaRepository;
        this.estudianteRepository = estudianteRepository;
        this.carreraRepository = carreraRepository;
    }

    @Transactional
    public void importarDatos() throws IOException {
        importarEstudiantes();
        importarCarreras();
        importarMatriculas();
    }


    public void importarEstudiantes() throws IOException {
        InputStream ruta = Objects.requireNonNull(this.getClass().getResourceAsStream("/csv/estudiantes.csv"));
        List<Estudiante> estudiantes = new ArrayList<>();

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            for (CSVRecord row : parser) {
                int DNI =  Integer.parseInt(row.get("DNI"));
                String nombre = row.get("nombre");
                String apellido = row.get("apellido");
                int edad = Integer.parseInt(row.get("edad"));
                String genero = row.get("genero");
                String ciudad = row.get("ciudad");
                int LU =  Integer.parseInt(row.get("LU"));

                Estudiante est = new Estudiante(DNI, LU, edad, nombre, apellido, genero, ciudad);
                estudiantes.add(est);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        estudianteRepository.saveAll(estudiantes);
    }
    public void importarCarreras() throws IOException {
        InputStream ruta = Objects.requireNonNull(this.getClass().getResourceAsStream("/csv/carreras.csv"));
        List<Carrera> carreras = new ArrayList<>();

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            for (CSVRecord row : parser) {
                int id_carrera =  Integer.parseInt(row.get("id_carrera"));
                String carrera = row.get("carrera");
                int duracion = Integer.parseInt(row.get("duracion"));
                Carrera c = new Carrera(id_carrera, duracion, carrera);
                carreras.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        carreraRepository.saveAll(carreras);
    }
    public void importarMatriculas() throws IOException {
        InputStream ruta = Objects.requireNonNull(this.getClass().getResourceAsStream("/csv/estudianteCarrera.csv"));
        List<Matricula> matriculas = new ArrayList<>();

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            for (CSVRecord row : parser) {
                Estudiante estudiante = estudianteRepository.findById(Integer.parseInt(row.get("id_estudiante")))
                        .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + row.get("id_estudiante")));
                Carrera carrera = carreraRepository.findById(Integer.parseInt(row.get("id_carrera")))
                        .orElseThrow(() -> new RuntimeException("Carrera no encontrada con ID: " + row.get("id_carrera")));
                MatriculaSerializable serial =  new MatriculaSerializable(estudiante.getDNI(), carrera.getId_carrera());
                int inscripcion =  Integer.parseInt(row.get("inscripcion"));
                int graduacion =  Integer.parseInt(row.get("graduacion"));
                int antiguedad =  Integer.parseInt(row.get("antiguedad"));
                Matricula m = new Matricula(serial, inscripcion, graduacion, antiguedad, estudiante, carrera);
                matriculas.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        matriculaRepository.saveAll(matriculas);
    }
}
