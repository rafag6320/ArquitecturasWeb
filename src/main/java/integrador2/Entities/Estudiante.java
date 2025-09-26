package integrador2.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Estudiante")
public class Estudiante {
    @Id
    @Column(name="DNI")
    private int DNI;
    private int LU;
    private int edad;
    private String nombre,apellido,genero;

    public Estudiante() {}

    public Estudiante(int DNI, int LU, int edad, String nombre, String apellido, String genero) {
        this.DNI = DNI;
        this.LU = LU;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    public int getDNI() {
        return DNI;
    }

    public int getLU() {
        return LU;
    }

    public int getEdad() {
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
}
