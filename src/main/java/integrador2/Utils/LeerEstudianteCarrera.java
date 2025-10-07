package integrador2.Utils;

import integrador2.Entities.Estudiante;
import integrador2.Entities.estudianteCarrera;
import integrador2.Main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeerEstudianteCarrera {

    public static List<estudianteCarrera> obtenerRegistros() {
        InputStream ruta = Main.class.getResourceAsStream("/CSVs/estudianteCarrera.csv");

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            List<estudianteCarrera> estudiante_carrera = new ArrayList<>();
            for (CSVRecord row : parser) {
                int id =  Integer.parseInt(row.get("id"));
                int id_carrera =  Integer.parseInt(row.get("id_carrera"));
                int id_estudiante =  Integer.parseInt(row.get("id_estudiante"));
                int inscripcion =  Integer.parseInt(row.get("inscripcion"));
                int graduacion =  Integer.parseInt(row.get("graduacion"));
                int antiguedad =  Integer.parseInt(row.get("antiguedad"));

                estudianteCarrera ec = new estudianteCarrera(id, id_carrera,id_estudiante, inscripcion,graduacion,antiguedad);
                estudiante_carrera.add(ec);
            }
            return estudiante_carrera;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
