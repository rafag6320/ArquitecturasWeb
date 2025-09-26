package integrador2.Entities;

public class EstudianteCarrera {
    private int id, inscripcion, graduado, antiguedad, id_carrera, id_estudiante;

    public EstudianteCarrera() {}
    public EstudianteCarrera(int id, int inscripcion, int graduado,  int antiguedad, int id_carrera, int id_estudiante) {
        this.id = id;
        this.inscripcion = inscripcion;
        this.graduado = graduado;
        this.antiguedad = antiguedad;
        this.id_carrera = id_carrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public int getGraduado() {
        return graduado;
    }

    public void setGraduado(int graduado) {
        this.graduado = graduado;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }
}
