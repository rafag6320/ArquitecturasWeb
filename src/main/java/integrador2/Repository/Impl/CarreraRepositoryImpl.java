package integrador2.Repository.Impl;

import integrador2.DTO.EstadisticaCarreraDTO;
import integrador2.Repository.Interfaces.CarreraRepository;
import jakarta.persistence.EntityManager;

import java.util.List;


public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManager em;

    public CarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }

   public List<EstadisticaCarreraDTO> getEstadisticaInscriptos() {
        String jpql = "SELECT c.id, c.carrera, COUNT(ec) " +
                "FROM Matricula ec " +
                "JOIN ec.carrera c " +
                "GROUP BY c " +
                "ORDER BY COUNT(ec) DESC";

        return em.createQuery(jpql, EstadisticaCarreraDTO.class).getResultList();
    }
    public List<EstadisticaCarreraDTO> obtenerEstadisticas() {
        String jpql =
                "SELECT new dto.EstadisticaCarreraDTO(" +
                        "   c.nombre, " +
                        "   ec.anioInscripcion, " +
                        "   COUNT(ec), " +
                        "   SUM(CASE WHEN ec.anioGraduacion IS NOT NULL THEN 1 ELSE 0 END)" +
                        ") " +
                        "FROM EstudianteCarrera ec " +
                        "JOIN ec.carrera c " +
                        "GROUP BY c.nombre, ec.anioInscripcion " +
                        "ORDER BY c.nombre ASC, ec.anioInscripcion ASC";

        return em.createQuery(jpql, EstadisticaCarreraDTO.class).getResultList();
    }

}
