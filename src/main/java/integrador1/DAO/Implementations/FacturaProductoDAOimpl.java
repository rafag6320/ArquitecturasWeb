package integrador1.DAO.Implementations;

import integrador1.DAO.Interfaces.FacturaProductoDAO;
import integrador1.Entities.FacturaProducto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class FacturaProductoDAOimpl implements FacturaProductoDAO {
    private Connection conn;

    public FacturaProductoDAOimpl(Connection conn) {
        this.conn = conn;
        inicializarTabla();
    }

    // Esta función no la expone FacturaDAO ya que se ejecuta cada vez creada la clase.
    private void inicializarTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS FacturaProducto (" +
                "idFactura INT, " +
                "idProducto INT, " +
                "cantidad INT NOT NULL, " +
                "PRIMARY KEY (idFactura, idProducto), " +
                "CONSTRAINT fk_facturaprod_factura FOREIGN KEY (idFactura) REFERENCES Factura(idFactura) ON DELETE CASCADE, " +
                "CONSTRAINT fk_facturaprod_producto FOREIGN KEY (idProducto) REFERENCES Producto(idProducto) ON DELETE CASCADE" +
                ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertar(FacturaProducto facturaProducto) {

    }

    @Override
    public List<FacturaProducto> obtenerPorFactura(int idFactura) {
        return List.of();
    }

    @Override
    public void eliminar(int idFactura, int idProducto) {

    }
}
