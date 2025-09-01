package integrador1.DAO.Interfaces;

import integrador1.Entities.Producto;
import java.util.List;

public interface ProductoDAO {
    void insertar(Producto producto);
    Producto obtenerPorId(int id);
    List<Producto> obtenerTodos();
    void actualizar(Producto producto);
    void eliminar(int id);
}
