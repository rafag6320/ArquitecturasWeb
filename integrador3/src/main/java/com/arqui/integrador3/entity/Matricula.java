package com.arqui.integrador3.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Matricula")
public class Matricula {
    @Id
    @Column(name="id")
    private MatriculaSerializable id;
    private int inscripcion, graduado, antiguedad;

    @MapsId("dni")
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="id_estudiante", referencedColumnName = "DNI")
    private Estudiante estudiante;
    @MapsId("id_carrera")
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="id_carrera")
    private Carrera carrera;

    public Matricula() {}
    public Matricula(MatriculaSerializable id, int inscripcion, int graduado, int antiguedad, Estudiante estudiante, Carrera carrera) {
        this.id = id;
        this.inscripcion = inscripcion;
        this.graduado = graduado;
        this.antiguedad = antiguedad;
        this.estudiante = estudiante;
        this.carrera = carrera;
    }

    public MatriculaSerializable getId() {
        return id;
    }

    public void setId(MatriculaSerializable id) {
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
