package integrador1.DAO;

import integrador1.model.Factura;
import java.util.List;

public interface FacturaDAO {
    void insertar(Factura factura);
    Factura obtenerPorId(int id);
    List<Factura> obtenerTodos();
    void actualizar(Factura factura);
    void eliminar(int id);
}