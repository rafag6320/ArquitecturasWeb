package integrador1.Utils;

import integrador1.Entities.Factura;
import integrador1.Main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeerFacturas {
    public static List<Factura> obtenerRegistros() {
        InputStream ruta = Main.class.getResourceAsStream("/CSVs/facturas.csv");

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            List<Factura> facturas = new ArrayList<>();
            for (CSVRecord row : parser) {
                int idCliente = Integer.parseInt(row.get("idCliente"));
                int idFactura = Integer.parseInt(row.get("idFactura"));
                Factura cc =  new Factura(idFactura, idCliente);
                facturas.add(cc);
            }
            return facturas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}