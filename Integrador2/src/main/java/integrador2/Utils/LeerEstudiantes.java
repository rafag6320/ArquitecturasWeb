package integrador2.Utils;

import integrador2.Entities.Estudiante;
import integrador2.Main;
import integrador2.Repository.Interfaces.EstudianteRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeerEstudiantes {
    public static void importarEstudiantes(EstudianteRepository estudianteRepository) {
        InputStream ruta = Main.class.getResourceAsStream("/CSVs/estudiantes.csv");

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            for (CSVRecord row : parser) {
                int DNI =  Integer.parseInt(row.get("DNI"));
                String nombre = row.get("nombre");
                String apellido = row.get("apellido");
                int edad = Integer.parseInt(row.get("edad"));
                String genero = row.get("genero");
                String ciudad = row.get("ciudad");
                int LU =  Integer.parseInt(row.get("LU"));

                Estudiante est = new Estudiante(DNI, LU, edad, nombre, apellido, genero, ciudad);
                estudianteRepository.save(est);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

