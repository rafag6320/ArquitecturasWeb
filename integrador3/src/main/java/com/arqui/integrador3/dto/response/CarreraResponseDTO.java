package com.arqui.integrador3.dto.response;

public class CarreraResponseDTO {
    private int id_carrera, duracion;
    private String carrera;

    public CarreraResponseDTO(int id_carrera, int duracion, String carrera) {
        this.id_carrera = id_carrera;
        this.duracion = duracion;
        this.carrera = carrera;
    }

    public CarreraResponseDTO() {}

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
