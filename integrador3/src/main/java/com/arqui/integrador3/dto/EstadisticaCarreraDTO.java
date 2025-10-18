package com.arqui.integrador3.dto;

// Entidad para mapear la solución del ejercicio 2 punto F
public class EstadisticaCarreraDTO {
    private int id_carrera;
    private String carrera;
    private Long inscriptos;

    public EstadisticaCarreraDTO(int id_carrera, String carrera, Long inscriptos) {
        this.id_carrera = id_carrera;
        this.carrera = carrera;
        this.inscriptos = inscriptos;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Long getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(Long inscriptos) {
        this.inscriptos = inscriptos;
    }

    public String toString(){
        return "{ carrera: " + getCarrera() + ", inscriptos: " + getInscriptos() + " }";
    }
}
