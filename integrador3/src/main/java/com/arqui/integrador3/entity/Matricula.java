package com.arqui.integrador3.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Matricula")
public class Matricula {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para generar el ID automaticamente
    private int id;
    private int inscripcion, graduado, antiguedad;

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="id_estudiante", referencedColumnName = "DNI")
    private Estudiante estudiante;
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="id_carrera")
    private Carrera carrera;

    public Matricula() {}
    public Matricula(int id, int inscripcion, int graduado, int antiguedad, int id_carrera, int id_estudiante) {
        this.id = id;
        this.inscripcion = inscripcion;
        this.graduado = graduado;
        this.antiguedad = antiguedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public int getGraduado() {
        return graduado;
    }

    public void setGraduado(int graduado) {
        this.graduado = graduado;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
