package integrador1.DAO.Interfaces;

import java.util.List;
import integrador1.Entities.FacturaProducto;

public interface FacturaProductoDAO {
    void insertar(FacturaProducto facturaProducto);
    List<FacturaProducto> obtenerPorFactura(int idFactura);
    void eliminar(int idFactura, int idProducto);
}