package integrador1.DAO.Factory;

import integrador1.DAO.Implementations.ClienteDAOimpl;
import integrador1.DAO.Implementations.FacturaDAOimpl;
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

    private Connection getConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FacturaDAO getFacturaDAO() {
        return new FacturaDAOimpl(conexion);
    }
    public FacturaProductoDAO getFacturaProductoDAO() {
        // Return de FacturaProductoDAOimpl
        return null;
    }
    public ProductoDAO getProductoDAO() {
        // Return de ProductoDAOimpl
        return null;
    }
    public ClienteDAO getClienteDAO() {
        return new ClienteDAOimpl(conexion);
    }
}
