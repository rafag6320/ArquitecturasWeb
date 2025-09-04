package integrador1.Utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;

public class LeerFacturas {

    public static void main(String[] args) {
        String archivo = "facturas.csv";

        try (
            FileReader reader = new FileReader(archivo);
            CSVParser parser = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader);
        ) {
            for (CSVRecord row : parser) {
                int idFactura = Integer.parseInt(row.get("idFactura"));
                int idCliente = Integer.parseInt(row.get("idCliente"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}