package com.arqui.integrador3.dto;

public class EstudianteCarreraDTO {
    private String nombre;
    private String apellido;
    private String ciudad;
    private String carrera;
    private int edad;
    private int LU;

    public EstudianteCarreraDTO(String nombre, String apellido, String ciudad, String carrera, int edad, int LU) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.carrera = carrera;
        this.edad = edad;
        this.LU = LU;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public int getLU() {
        return LU;
    }

    public String getCarrera() {
        return carrera;
    }

    public String toString(){
        return "{ nombre: " + getNombre() + ", apellido: " + getApellido() + ", ciudad: " + getCiudad() + ", carrera: " + getCarrera() + ", LU: " + getLU() + " }";
    }
}
