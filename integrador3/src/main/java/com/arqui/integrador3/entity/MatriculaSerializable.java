package com.arqui.integrador3.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatriculaSerializable implements Serializable {
    private Integer dni;
    private Integer id_carrera;

    public MatriculaSerializable(Integer dni, Integer id_carrera) {
        this.dni = dni;
        this.id_carrera = id_carrera;
    }

    public MatriculaSerializable() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatriculaSerializable)) return false;
        MatriculaSerializable that = (MatriculaSerializable) o;
        return Objects.equals(id_carrera, that.id_carrera) &&
                Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_carrera, dni);
    }


    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getIdCarrera() {
        return id_carrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.id_carrera = idCarrera;
    }
}