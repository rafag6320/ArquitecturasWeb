package integrador2.Repository.Interfaces;

import integrador2.DTO.EstadisticaCarreraDTO;
import integrador2.DTO.ReporteCarreraDTO;
import integrador2.Entities.Carrera;

import java.util.List;

public interface CarreraRepository {
    Carrera findById(int id);
    Boolean save(Carrera c);
    List<EstadisticaCarreraDTO> getEstadisticaInscriptos(); // Ej 2 (f) recuperar carreras e inscriptos.
    List<ReporteCarreraDTO> obtenerEstadisticas(); // Ej 3 - Generar reportes
}
