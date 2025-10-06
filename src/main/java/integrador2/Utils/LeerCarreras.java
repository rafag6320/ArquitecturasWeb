package integrador2.Utils;

import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;
import integrador2.Main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeerCarreras {

    public static List<Carrera> obtenerRegistros() {
        InputStream ruta = Main.class.getResourceAsStream("/CSVs/carreras.csv");

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            List<Carrera> carreras = new ArrayList<>();
            for (CSVRecord row : parser) {
                int id_carrera =  Integer.parseInt(row.get("id_carrera"));
                String carrera = row.get("carrera");
                int duracion = Integer.parseInt(row.get("duracion"));
                Carrera car = new Carrera(id_carrera,duracion,carrera);
                carreras.add(car);
            }
            return carreras;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
