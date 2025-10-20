package com.arqui.integrador3.dto.response;

// Entidad para mapear la solución del ejercicio 3
public class ReporteCarreraDTO {
    String carrera;
    int inscriptos;
    int anio;
    int graduados;

    public ReporteCarreraDTO(String carrera, int inscriptos, int anio, int graduados) {
        this.carrera = carrera;
        this.inscriptos = inscriptos;
        this.anio = anio;
        this.graduados = graduados;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getGraduados() {
        return graduados;
    }

    public void setGraduados(int graduados) {
        this.graduados = graduados;
    }

    public int getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(int inscriptos) {
        this.inscriptos = inscriptos;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String toString(){
        return "{ carrera: " + getCarrera() + ", año: " + getAnio() + ", inscriptos: " + getInscriptos() + ", graduados: " + getGraduados() + " }";
    }
}
