package com.arqui.integrador3.dto.request;

public class EstudianteRequestDTO {
    private Integer dni;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String genero;
    private Integer edad;
    private Integer LU;

    public EstudianteRequestDTO(String nombre, String genero, String apellido, String ciudad, Integer edad, Integer LU, Integer dni) {
        this.dni = dni;
        this.nombre = nombre;
        this.genero = genero;
        this.apellido = apellido;
        this.ciudad = ciudad;
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

    public String getGenero() {
        return genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getLU() {
        return LU;
    }

    public Integer getDni() {
        return dni;
    }

    public String toString(){
        return "{ nombre: " + getNombre() + ", apellido: " + getApellido() + ", ciudad: " + getCiudad() + ", LU: " + getLU() + " }";
    }
}
