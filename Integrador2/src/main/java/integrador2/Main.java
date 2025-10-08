package integrador2;

import integrador2.DTO.EstudianteCarreraDTO;
import integrador2.Entities.Estudiante;
import integrador2.Factory.JPAFactory;
import integrador2.Repository.Impl.CarreraRepositoryImpl;
import integrador2.Repository.Impl.EstudianteRepositoryImpl;
import integrador2.Repository.Impl.MatriculaRepositoryImpl;
import integrador2.Repository.Interfaces.CarreraRepository;
import integrador2.Repository.Interfaces.EstudianteRepository;
import integrador2.Repository.Interfaces.MatriculaRepository;
import integrador2.Utils.LeerCarreras;
import integrador2.Utils.LeerEstudiantes;
import integrador2.Utils.LeerMatricula;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = JPAFactory.getEntityManagerFactory();
        CarreraRepository carreraRepository = CarreraRepositoryImpl.getInstance(emf);
        EstudianteRepository estudianteRepository = EstudianteRepositoryImpl.getInstance(emf);
        MatriculaRepository matriculaRepository = MatriculaRepositoryImpl.getInstance(emf);

        // Cargar datos de prueba mediante CSV
        /*LeerCarreras.importarCarreras(carreraRepository);
        LeerEstudiantes.importarEstudiantes(estudianteRepository);}
        LeerMatricula.importarMatriculas(matriculaRepository);*/

        // Ej 2 - (a) Dar de alta un estudiante
        /*Estudiante estudiante = new Estudiante(812517, 85930, 32, "Nikita", "Stoichov", "Male", "Pergamino");
        estudianteRepository.save(estudiante);

        // Ej 2 - (b) Matricular estudiante en una carrera
        matriculaRepository.save(estudiante.getDNI(), 1, 2023, 0, 2);

        // Ej 2 - (c) Recuperar los estudiantes con un criterio basico de ordenamiento
        estudianteRepository.findAllOrderedByAge().forEach(System.out::println);

        // Ej 2 - (d) Recuperar un estudiante, en base a su numero de librera universitaria
        System.out.println(estudianteRepository.findByLU(8593));;

        // Ej 2 - (e) Recuperar todos los estudiantes en base a un genero
        estudianteRepository.findByGenero("Male").forEach(System.out::println);

        // Ej 2 - (f) Recuperar todas las carreras con estudiantes inscriptos y ordenar por inscriptos.
        carreraRepository.getEstadisticaInscriptos().forEach(System.out::println);

        // Ej 2 - (g) Recuperar los estudiantes de una determinada carrera filtrado por ciudad de residencia.
        estudianteRepository.findByCarrera(carreraRepository.findById(1), "Rauch").forEach(System.out::println);*/

        // Ej 3 - Generar reporte
        carreraRepository.obtenerEstadisticas().forEach(System.out::println);
    }
}