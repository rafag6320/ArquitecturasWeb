package integrador1.Utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;

public class LeerFacturasProductos {

    public static void main(String[] args) {
        String archivo = "facturas-productos.csv";

        try (
            FileReader reader = new FileReader(archivo);
            CSVParser parser = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader)
        ) {
            for (CSVRecord row : parser) {
                int idFactura = Integer.parseInt(row.get("idFactura"));
                int idProducto = Integer.parseInt(row.get("idProducto"));
                int cantidad = Integer.parseInt(row.get("cantidad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}