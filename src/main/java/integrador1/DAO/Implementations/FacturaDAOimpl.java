package integrador1.DAO.Implementations;

import integrador1.DAO.Interfaces.FacturaDAO;
import integrador1.Entities.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAOimpl implements FacturaDAO {
    private Connection conn;

    public FacturaDAOimpl(Connection conn) {
        this.conn = conn;
    }

    public void insertar(Factura factura) {
        String sql = "INSERT INTO Factura (idFactura, idCliente) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, factura.getIdFactura());
            ps.setInt(2, factura.getIdCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Factura obtenerPorId(int id) {
        String sql = "SELECT idFactura, idCliente FROM Factura WHERE idFactura = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Factura(
                        rs.getInt("idFactura"),
                        rs.getInt("idCliente")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // si no encontró nada
    }

    @Override
    public List<Factura> obtenerTodos() {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT idFactura, idCliente FROM Factura";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Factura f = new Factura(
                        rs.getInt("idFactura"),
                        rs.getInt("idCliente")
                );
                lista.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    @Override
    public void actualizar(Factura factura) {
        String sql = "UPDATE Factura SET idCliente = ? WHERE idFactura = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, factura.getIdCliente());
            ps.setInt(2, factura.getIdFactura());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Factura WHERE idFactura = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}