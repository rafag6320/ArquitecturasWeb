package integrador2.Entities;

public class estudianteCarrera {
    private int id;
    private int id_estudiante;
    private int id_carrera;
    private int inscripcion;
    private int graduacion;
    private int antiguedad;

    public estudianteCarrera(int id, int id_carrera, int id_estudiante, int inscripcion, int graduacion, int antiguedad) {
        this.id = id;
        this.id_carrera = id_carrera;
        this.id_estudiante = id_estudiante;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
        this.antiguedad = antiguedad;
    }

}
