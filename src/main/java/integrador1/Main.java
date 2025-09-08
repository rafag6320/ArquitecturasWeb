package integrador1;

import integrador1.DAO.Factory.DAOFactory;
import integrador1.DAO.Interfaces.ClienteDAO;
import integrador1.DAO.Interfaces.FacturaDAO;
import integrador1.DAO.Interfaces.FacturaProductoDAO;
import integrador1.DAO.Interfaces.ProductoDAO;
import integrador1.Entities.Cliente;
import integrador1.Utils.LeerClientes;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_JDBC);

        // Las tablas se inicializan por si no estan creadas.
        ClienteDAO operaciones_cliente = daoFactory.getClienteDAO();
        ProductoDAO operaciones_producto = daoFactory.getProductoDAO();
        FacturaDAO operaciones_factura = daoFactory.getFacturaDAO();
        FacturaProductoDAO operaciones_facturaproducto = daoFactory.getFacturaProductoDAO();

        // Correr 1 vez, o dara error de duplicadas.
        List<Cliente> registros_de_prueba = LeerClientes.obtenerRegistros();

        for(Cliente cliente : registros_de_prueba){
            operaciones_cliente.insertar(cliente);
        }
    }
}