package integrador1.Utils;

import integrador1.Entities.FacturaProducto;
import integrador1.Main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeerFacturasProductos {
    public static List<FacturaProducto> obtenerRegistros() {
        InputStream ruta = Main.class.getResourceAsStream("/CSVs/facturas-productos.csv");

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            List<FacturaProducto> facturas = new ArrayList<>();
            for (CSVRecord row : parser) {
                int idFactura = Integer.parseInt(row.get("idFactura"));
                int idProducto = Integer.parseInt(row.get("idProducto"));
                int cantidad = Integer.parseInt(row.get("cantidad"));
                FacturaProducto cc =  new FacturaProducto(idFactura, idProducto, cantidad);
                facturas.add(cc);
            }
            return facturas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}