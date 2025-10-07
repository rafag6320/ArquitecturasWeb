package integrador1.Utils;

import integrador1.Entities.Cliente;
import integrador1.Main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeerClientes {
    public static List<Cliente> obtenerRegistros() {
        InputStream ruta = Main.class.getResourceAsStream("/CSVs/clientes.csv");

        try (
                CSVParser parser = CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(new InputStreamReader(ruta));
        ) {
            List<Cliente> clientes = new ArrayList<>();
            for (CSVRecord row : parser) {
                int idCliente = Integer.parseInt(row.get("idCliente"));
                String nombre = row.get("nombre");
                String email = row.get("email");
                Cliente cc =  new Cliente(idCliente, nombre, email);
                clientes.add(cc);
            }
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
