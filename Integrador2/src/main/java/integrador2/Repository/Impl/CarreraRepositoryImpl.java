package integrador2.Repository.Impl;

import integrador2.DTO.EstadisticaCarreraDTO;
import integrador2.DTO.ReporteCarreraDTO;
import integrador2.Entities.Carrera;
import integrador2.Repository.Interfaces.CarreraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManagerFactory emf;
    private static CarreraRepositoryImpl instance;

    public CarreraRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static CarreraRepositoryImpl getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new CarreraRepositoryImpl(emf);
        }
        return instance;
    }

    public Carrera findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Carrera.class, id);
        } finally {
            em.close();
        }
    }

    public Boolean save(Carrera c) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<EstadisticaCarreraDTO> getEstadisticaInscriptos() {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT new integrador2.DTO.EstadisticaCarreraDTO(c.id, c.carrera, COUNT(ec)) " +
                    "FROM Matricula ec " +
                    "JOIN ec.carrera c " +
                    "GROUP BY c " +
                    "ORDER BY COUNT(ec) DESC";

            return em.createQuery(jpql, EstadisticaCarreraDTO.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<ReporteCarreraDTO> obtenerEstadisticas() {
        EntityManager em = emf.createEntityManager();
        try {
            String sql =
                    "SELECT c.carrera, " +
                            "       anios.anio, " +
                            "       SUM(CASE WHEN anios.tipo = 'I' THEN 1 ELSE 0 END) AS inscriptos, " +
                            "       SUM(CASE WHEN anios.tipo = 'E' THEN 1 ELSE 0 END) AS egresados " +
                            "FROM Carrera c " +
                            "JOIN Matricula m ON m.id_carrera = c.id_carrera " +
                            "JOIN ( " +
                            "       SELECT id_estudiante, id_carrera, inscripcion AS anio, 'I' AS tipo " +
                            "       FROM Matricula " +
                            "       WHERE inscripcion IS NOT NULL AND (graduado = 0 OR graduado IS NULL) " +
                            "       UNION ALL " +
                            "       SELECT id_estudiante, id_carrera, graduado AS anio, 'E' AS tipo " +
                            "       FROM Matricula " +
                            "       WHERE graduado IS NOT NULL AND graduado <> 0 " +
                            "     ) anios ON anios.id_estudiante = m.id_estudiante AND anios.id_carrera = m.id_carrera " +
                            "GROUP BY c.carrera, anios.anio " +
                            "ORDER BY c.carrera ASC, anios.anio ASC";

            List<Object[]> results = em.createNativeQuery(sql).getResultList();

            List<ReporteCarreraDTO> reporte = new ArrayList<>();
            for (Object[] row : results) {
                String carrera = (String) row[0];
                int anio = ((Number) row[2]).intValue();
                int inscriptos = ((Number) row[1]).intValue();
                int egresados = ((Number) row[3]).intValue();
                reporte.add(new ReporteCarreraDTO(carrera, anio, inscriptos, egresados));
            }

            return reporte;
        } finally {
            em.close();
        }
    }
}
