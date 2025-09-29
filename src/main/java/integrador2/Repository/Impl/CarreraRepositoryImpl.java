package integrador2.Repository.Impl;

import integrador2.DTO.EstadisticaInscriptos;
import integrador2.Repository.Interfaces.CarreraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;


public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManager em;

    public CarreraRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public List<EstadisticaInscriptos> getEstadisticaInscriptos() {
        String jpql = "SELECT c.id, c.carrera, COUNT(ec) " +
                "FROM EstudianteCarrera ec " +
                "JOIN ec.carrera c " +
                "GROUP BY c " +
                "ORDER BY COUNT(ec) DESC";

        return em.createQuery(jpql, EstadisticaInscriptos.class).getResultList();
    }
}
