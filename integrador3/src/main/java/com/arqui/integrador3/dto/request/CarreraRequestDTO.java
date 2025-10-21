package com.arqui.integrador3.dto.request;

public class CarreraRequestDTO {
    private int id_carrera;
    private int duracion;
    private String carrera;

    public CarreraRequestDTO() {}

    public CarreraRequestDTO(int id_carrera, int duracion, String carrera) {
        this.id_carrera = id_carrera;
        this.duracion = duracion;
        this.carrera = carrera;
    }

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
