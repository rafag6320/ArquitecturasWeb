package integrador2.DTO;

// Entidad para mapear la solución del ejercicio 2 punto F
public class EstadisticaCarreraDTO {
    private int id_carrera;
    private String carrera;
    private int inscriptos;

    public EstadisticaCarreraDTO(int id_carrera, String carrera, int inscriptos) {
        this.id_carrera = id_carrera;
        this.carrera = carrera;
        this.inscriptos = inscriptos;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(int inscriptos) {
        this.inscriptos = inscriptos;
    }
}
