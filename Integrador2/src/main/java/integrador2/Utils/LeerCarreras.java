package integrador2.Utils;

import integrador2.Entities.Carrera;
import integrador2.Entities.Estudiante;
import integrador2.Main;
import integrador2.Repository.Interfaces.CarreraRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeerCarreras {

    public static void importarCarreras(CarreraRepository carreraRepository) {
        InputStream ruta = Main.class.getResourceAsStream("/CSVs/carreras.csv");

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            for (CSVRecord row : parser) {
                int id_carrera =  Integer.parseInt(row.get("id_carrera"));
                String carrera = row.get("carrera");
                int duracion = Integer.parseInt(row.get("duracion"));
                Carrera c = new Carrera(id_carrera, duracion, carrera);
                carreraRepository.save(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
