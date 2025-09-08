package integrador1.DAO.Implementations;

import integrador1.DAO.Interfaces.FacturaProductoDAO;
import integrador1.Entities.Factura;
import integrador1.Entities.FacturaProducto;

import java.sql.*;
import java.util.ArrayList;
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
        String sql = "INSERT INTO FacturaProducto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, facturaProducto.getIdFactura());
            ps.setInt(2, facturaProducto.getIdProducto());
            ps.setInt(3, facturaProducto.getCantidad());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FacturaProducto> obtenerPorFactura(int idFactura) {
        List<FacturaProducto> lista = new ArrayList<>();

        String sql = "SELECT idFactura, idProducto, cantidad FROM Factura_Producto WHERE idFactura = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFactura);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FacturaProducto fp = new FacturaProducto(
                        rs.getInt("idFactura"),
                        rs.getInt("idProducto"),
                        rs.getInt("cantidad")
                );
                lista.add(fp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    @Override
    public void eliminar(int idFactura, int idProducto) {
        String sql = "DELETE FROM FacturaProducto WHERE idFactura = ? AND idProducto = ?";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, idFactura);
            ps.setInt(2, idProducto);
            ResultSet rs = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
