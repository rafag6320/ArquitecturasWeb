package integrador1.DAO;

import java.util.List;
import integrador1.model.FacturaProducto;

public interface FacturaProductoDAO {
    void insertar(FacturaProducto facturaProducto);
    List<FacturaProducto> obtenerPorFactura(int idFactura);
    void eliminar(int idFactura, int idProducto);
}