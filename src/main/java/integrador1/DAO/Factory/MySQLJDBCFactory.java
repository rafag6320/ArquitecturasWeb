package integrador1.DAO.Factory;

import integrador1.DAO.Implementations.ClienteDAOimpl;
import integrador1.DAO.Implementations.FacturaDAOimpl;
import integrador1.DAO.Implementations.FacturaProductoDAOimpl;
import integrador1.DAO.Implementations.ProductoDAOimpl;
import integrador1.DAO.Interfaces.ClienteDAO;
import integrador1.DAO.Interfaces.FacturaDAO;
import integrador1.DAO.Interfaces.FacturaProductoDAO;
import integrador1.DAO.Interfaces.ProductoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLJDBCFactory extends DAOFactory {
    private Connection conexion;
    private static final String URL = "jdbc:mysql://localhost:3306/sistema?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public MySQLJDBCFactory () {
        this.conexion = getConexion();
    }

    private Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null; // Se retorna null para evitar problemas de compilacion
        }
    }

    public FacturaDAO getFacturaDAO() {
        return new FacturaDAOimpl(conexion);
    }
    public FacturaProductoDAO getFacturaProductoDAO() {
        return new FacturaProductoDAOimpl(conexion);
    }
    public ProductoDAO getProductoDAO() {
        return new ProductoDAOimpl(conexion);
    }
    public ClienteDAO getClienteDAO() {
        return new ClienteDAOimpl(conexion);
    }
}
