package integrador2.Utils;

import integrador2.Main;
import integrador2.Repository.Interfaces.MatriculaRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;

public class LeerMatricula {

    public static void importarMatriculas(MatriculaRepository matriculaRepository) {
        InputStream ruta = Main.class.getResourceAsStream("/CSVs/estudianteCarrera.csv");

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            for (CSVRecord row : parser) {
                int id_carrera =  Integer.parseInt(row.get("id_carrera"));
                int id_estudiante =  Integer.parseInt(row.get("id_estudiante"));
                int inscripcion =  Integer.parseInt(row.get("inscripcion"));
                int graduacion =  Integer.parseInt(row.get("graduacion"));
                int antiguedad =  Integer.parseInt(row.get("antiguedad"));
                matriculaRepository.save(id_estudiante, id_carrera, inscripcion, graduacion, antiguedad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
