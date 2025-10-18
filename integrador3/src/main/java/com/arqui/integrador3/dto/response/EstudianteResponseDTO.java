package com.arqui.integrador3.dto.response;

public class EstudianteResponseDTO {
    private String nombre;
    private String apellido;
    private String ciudad;
    private Integer edad;
    private Integer LU;

    public EstudianteResponseDTO() {};

    public EstudianteResponseDTO(String nombre, String apellido, String ciudad, Integer edad, Integer LU) {
        this.nombre = nombre;
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

    public Integer getEdad() {
        return edad;
    }

    public Integer getLU() {
        return LU;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setLU(Integer LU) {
        this.LU = LU;
    }

    public String toString(){
        return "{ nombre: " + getNombre() + ", apellido: " + getApellido() + ", ciudad: " + getCiudad() + ", LU: " + getLU() + " }";
    }
}
