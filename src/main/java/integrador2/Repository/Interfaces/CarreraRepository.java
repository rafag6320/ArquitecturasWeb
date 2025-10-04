package integrador2.Repository.Interfaces;

import integrador2.DTO.EstadisticaCarreraDTO;

import java.util.List;

public interface CarreraRepository {
    List<EstadisticaCarreraDTO> getEstadisticaInscriptos(); // Ej 2 (f) recuperar carreras e inscriptos.
}
