package integrador1.Utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;

public class LeerClientes {

    public static void main(String[] args) {
        String archivo = "clientes.csv";

        try (
            FileReader reader = new FileReader(archivo);
            CSVParser parser = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader);
        ) {
            for (CSVRecord row : parser) {
                int idCliente = Integer.parseInt(row.get("idCliente"));
                String nombre = row.get("nombre");
                String email = row.get("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
