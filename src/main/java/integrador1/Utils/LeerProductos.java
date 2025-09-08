package integrador1.Utils;

import integrador1.Entities.Factura;
import integrador1.Entities.Producto;
import integrador1.Main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeerProductos {
    public static List<Producto> obtenerRegistros() {
        InputStream ruta = Main.class.getResourceAsStream("/CSVs/productos.csv");

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            List<Producto> productos = new ArrayList<>();
            for (CSVRecord row : parser) {
                int idProducto = Integer.parseInt(row.get("idProducto"));
                String nombre = row.get("nombre");
                float valor = Float.parseFloat(row.get("valor"));
                Producto cc =  new Producto(idProducto, nombre, valor);
                productos.add(cc);
            }
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}