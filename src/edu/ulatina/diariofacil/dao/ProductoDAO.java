/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.dao;

import edu.ulatina.diariofacil.idao.IProductoDAO;
import edu.ulatina.diariofacil.jdbc.Conector;
import edu.ulatina.diariofacil.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author blaken
 */
public class ProductoDAO implements IProductoDAO {

    private final Conector conectorJDBC = new Conector();
    private static final Logger LOG = LogManager.getLogger(ProductoDAO.class.getName());

    @Override
    public List<Producto> obtenerProductos() {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Producto> resultado = new ArrayList<>();
        try {
            ps = conn.prepareStatement("Select id, nombre, descripcion, precio, descuento, inventario from Productos");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int precio = rs.getInt("precio");
                int descuento = rs.getInt("descuento");
                int inventario = rs.getInt("inventario");
                resultado.add(new Producto(id, nombre, descripcion, precio, descuento, inventario));
            }

        } catch (SQLException ex) {
            LOG.error("No se pudo obtener el producto", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, rs);
        }
        return resultado;
    }

    @Override
    public void crear(Producto producto) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Insert Into Productos (nombre, descripcion, precio, descuento, inventario)  values (?,?,?,?,?)");
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setDouble(4, producto.getDescuento());
            ps.setInt(5, producto.getInventario());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del producto: " + producto, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    @Override
    public void borrar(int id) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Delete from Productos Where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo borrar el producto: ", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    @Override
    public Producto obtener(Producto producto) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto resultado = null;
        try {
            ps = conn.prepareStatement("Select id, nombre, descripcion, precio, descuento, inventario from Productos where id=? ");
            ps.setInt(1, producto.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int precio = rs.getInt("precio");
                int descuento = rs.getInt("descuento");
                int inventario = rs.getInt("inventario");
                resultado = new Producto(id, nombre, descripcion, precio, descuento, inventario);
            }

        } catch (SQLException ex) {
            LOG.error("No se pudo obtener el producto", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, rs);
        }
        return resultado;
    }

 public Producto obtener(int id) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto resultado = null;
        try {
            ps = conn.prepareStatement("Select id, nombre, descripcion, precio, descuento, inventario from Productos where id=? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int precio = rs.getInt("precio");
                int descuento = rs.getInt("descuento");
                int inventario = rs.getInt("inventario");
                resultado = new Producto(id, nombre, descripcion, precio, descuento, inventario);
            }

        } catch (SQLException ex) {
            LOG.error("No se pudo obtener el producto", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, rs);
        }
        return resultado;
    }
    @Override
    public void actualizar (Producto producto) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Update Productos set nombre=? , descripcion=?, precio=?, descuento=?, inventario=? where id=?");
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setDouble(4, producto.getDescuento());
            ps.setInt(5, producto.getInventario());
            ps.setInt(6, producto.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del producto: " + producto, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }
}
