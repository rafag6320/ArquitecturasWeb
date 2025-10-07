package integrador1;

import integrador1.DAO.Factory.DAOFactory;
import integrador1.DAO.Interfaces.ClienteDAO;
import integrador1.DAO.Interfaces.FacturaDAO;
import integrador1.DAO.Interfaces.FacturaProductoDAO;
import integrador1.DAO.Interfaces.ProductoDAO;
import integrador1.Entities.*;
import integrador1.Utils.LeerClientes;
import integrador1.Utils.LeerFacturas;
import integrador1.Utils.LeerFacturasProductos;
import integrador1.Utils.LeerProductos;

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
        List<Cliente> registros_de_cliente = LeerClientes.obtenerRegistros();
        // Cargar clientes
        for(Cliente cliente : registros_de_cliente){
            operaciones_cliente.insertar(cliente);
        }

        List<Producto> registros_de_producto = LeerProductos.obtenerRegistros();
        // Cargar productos
        for (Producto producto : registros_de_producto) {
            operaciones_producto.insertar(producto);
        }

        List<Factura> registro_de_factura = LeerFacturas.obtenerRegistros();
        // Cargar facturas
        for (Factura factura : registro_de_factura) {
            operaciones_factura.insertar(factura);
        }

        List<FacturaProducto> registro_de_facturaproducto = LeerFacturasProductos.obtenerRegistros();
        // Cargar detalle factura-producto
        for (FacturaProducto fp : registro_de_facturaproducto) {
            operaciones_facturaproducto.insertar(fp);
        }

        System.out.println("=== Clientes ordenados por total facturado ===");
        List<ClienteTotalFacturado> ranking_clientes = operaciones_cliente.obtenerClientesPorFacturacion();
        for (ClienteTotalFacturado cf : ranking_clientes) {
            System.out.println(cf);
        }

        System.out.println("=== Producto con mayor recaudación ===");
        List<ProductoTotalRecaudado> ranking_productos = operaciones_producto.obtenerProductosMasRecaudados();
        for (ProductoTotalRecaudado pr : ranking_productos) {
            System.out.println(pr);
        }
    }
}