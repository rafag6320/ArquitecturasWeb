package integrador1.DAO.Factory;

import integrador1.DAO.Interfaces.ClienteDAO;
import integrador1.DAO.Interfaces.FacturaDAO;
import integrador1.DAO.Interfaces.FacturaProductoDAO;
import integrador1.DAO.Interfaces.ProductoDAO;

public abstract class DAOFactory {
    public static final int MYSQL_JDBC = 1;

    public abstract ClienteDAO getClienteDAO();
    public abstract FacturaDAO getFacturaDAO();
    public abstract FacturaProductoDAO getFacturaProductoDAO();
    public abstract ProductoDAO getProductoDAO();

    public static DAOFactory getDAOFactory (int factory) {
        switch(factory) {
            case MYSQL_JDBC: return new MySQLJDBCFactory();
            default: return null;
        }
    }
}