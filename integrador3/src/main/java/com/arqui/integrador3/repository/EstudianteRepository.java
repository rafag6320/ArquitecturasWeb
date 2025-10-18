package com.arqui.integrador3.repository;

import com.arqui.integrador3.entity.Estudiante;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EstudianteRepository extends JpaRepository<Estudiante,Integer> {
    Optional<Estudiante> findByLU(Integer LU);
    List<Estudiante> findByGender(String gender);
    List<Estudiante> findAllOrderedByAge(Sort sort);
}
