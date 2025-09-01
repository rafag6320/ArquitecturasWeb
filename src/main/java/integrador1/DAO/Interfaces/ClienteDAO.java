package integrador1.DAO.Interfaces;

import java.util.List;
import integrador1.Entities.Cliente;

public interface ClienteDAO {
    void insertar(Cliente cliente);
    Cliente obtenerPorId(int id);
    List<Cliente> obtenerTodos();
    void actualizar(Cliente cliente);
    void eliminar(int id);
}