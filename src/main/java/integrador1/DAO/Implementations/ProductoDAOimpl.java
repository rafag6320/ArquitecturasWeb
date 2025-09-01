package integrador1.implementations;

import integrador1.DAO.ProductoDAO;
import integrador1.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class ProductoDAOimpl implements ProductoDAO {
        private Connection conn;

        public void ProductoDAOimpl(Connection conn) {
            this.conn = conn;
        }

        @Override
        public void insertar(Producto producto) {
            String sql = "INSERT INTO Producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, producto.getIdProducto());
                ps.setString(2, producto.getNombre());
                ps.setFloat(3, producto.getValor());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Producto obtenerPorId(int id) {
            String sql = "SELECT idProducto, nombre, valor FROM Producto WHERE idProducto = ?";
            try ( PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return new Producto(
                            rs.getInt("idProducto"),
                            rs.getString("nombre"),
                            rs.getFloat("valor")
                    );
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null; // si no lo encontró
        }

        @Override
        public List<Producto> obtenerTodos() {
            List<Producto> lista = new ArrayList<>();
            String sql = "SELECT idProducto, nombre, valor FROM Producto";
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    Producto p = new Producto(
                            rs.getInt("idProducto"),
                            rs.getString("nombre"),
                            rs.getFloat("valor")
                    );
                    lista.add(p);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return lista;
        }

        @Override
        public void actualizar(Producto producto) {
            String sql = "UPDATE Producto SET nombre = ?, valor = ? WHERE idProducto = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, producto.getNombre());
                ps.setFloat(2, producto.getValor());
                ps.setInt(3, producto.getIdProducto());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void eliminar(int id) {
            String sql = "DELETE FROM Producto WHERE idProducto = ?";
            try ( PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


