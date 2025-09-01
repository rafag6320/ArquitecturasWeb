package integrador1.DAO;

import integrador1.model.Producto;
import java.util.List;

public interface ProductoDAO {
    void insertar(Producto producto);
    Producto obtenerPorId(int id);
    List<Producto> obtenerTodos();
    void actualizar(Producto producto);
    void eliminar(int id);
}
