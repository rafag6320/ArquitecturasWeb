package integrador2.DTO;

public class EstadisticaCarreraDTO {
    private int id_carrera;
    private String carrera;
    private int inscriptos;
    private int anio;
    private int egresados;


    public EstadisticaCarreraDTO(int id_carrera, String carrera, int inscriptos, int anio, int egresados  ) {
        this.id_carrera = id_carrera;
        this.carrera = carrera;
        this.inscriptos = inscriptos;
        this.anio = anio;
        this.egresados = egresados;
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
