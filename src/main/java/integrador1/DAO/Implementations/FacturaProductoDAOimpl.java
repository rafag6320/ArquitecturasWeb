package integrador1.DAO.Implementations;

import integrador1.DAO.Interfaces.FacturaProductoDAO;
import integrador1.Entities.FacturaProducto;

import java.sql.Connection;
import java.util.List;

public class FacturaProductoDAOimpl implements FacturaProductoDAO {
    private Connection conn;

    public FacturaProductoDAOimpl(Connection conn) {
        this.conn = conn;
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
