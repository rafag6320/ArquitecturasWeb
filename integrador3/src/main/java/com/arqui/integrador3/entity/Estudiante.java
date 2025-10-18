package com.arqui.integrador3.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Estudiante")
public class Estudiante {
    @Id
    @Column(name="DNI")
    private Integer DNI;
    private Integer LU;
    private Integer edad;
    private String nombre,apellido,genero,ciudad;

    public Estudiante() {}

    public Estudiante(Integer DNI, Integer LU, Integer edad, String nombre, String apellido, String genero, String ciudad) {
        this.DNI = DNI;
        this.LU = LU;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.ciudad = ciudad;
    }

    public Integer getDNI() {
        return DNI;
    }

    public Integer getLU() {
        return LU;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setLU(int LU) {
        this.LU = LU;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String toString () {
        return "{ nombre: "+ getNombre() + ", apellido: "+getApellido() + ", LU: "+ getLU() + ", edad: " + getEdad() + ", ciudad: " + getCiudad() + ", genero: " + getGenero() + " }";
    }
}
