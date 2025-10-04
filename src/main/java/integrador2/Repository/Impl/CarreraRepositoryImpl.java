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
}
