package com.arqui.integrador3.dto.response;

public class MatriculaResponseDTO {
    private int id_estudiante, id_carrera, inscripcion, graduado, antiguedad;

    public MatriculaResponseDTO(int id_estudiante, int id_carrera, int inscripcion, int graduado, int antiguedad) {
        this.inscripcion = inscripcion;
        this.graduado = graduado;
        this.antiguedad = antiguedad;
        this.id_carrera = id_carrera;
        this.id_estudiante = id_estudiante;
    }

    public MatriculaResponseDTO() {

    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
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
}
