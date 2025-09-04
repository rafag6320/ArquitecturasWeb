package integrador1.Utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;

public class LeerProductos {

    public static void main(String[] args) {
        String archivo = "productos.csv";

        try (
            FileReader reader = new FileReader(archivo);
            CSVParser parser = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader);
        ) {
            for (CSVRecord row : parser) {
                int idProducto = Integer.parseInt(row.get("idProducto"));
                String nombre = row.get("nombre");
                float valor = Float.parseFloat(row.get("valor"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}