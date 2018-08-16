/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.dao;

import edu.ulatina.diariofacil.jdbc.Conector;
import edu.ulatina.diariofacil.model.Provedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.ulatina.diariofacil.idao.IProvedorDAO;
import java.util.ArrayList;
import java.util.List;


public class ProvedorDAO implements IProvedorDAO {
    
    private final Conector conectorJDBC = new Conector();
    private static final Logger LOG = LogManager.getLogger(UsuarioDAO.class.getName());

    @Override
    public void crear(String nombre, String correo) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Insert Into Proveedores (nombre, correo)  values (?,?)");
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del proveedor: ", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    @Override
    public void borrar(int id) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Delete from Proveedores Where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo borrar el proveedor: ", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
       }
    }

    @Override
    public Provedor obtener(int id) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Provedor resultado = null;
        try {
            ps = conn.prepareStatement("Select id, nombre, correo from Proveedores where id=? ");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                resultado = new Provedor(id, nombre, correo);
            }

        } catch (SQLException ex) {
            LOG.error("No se pudo obtener el proveedor", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, rs);
        }
        return resultado;
    }
    @Override
    public List<Provedor> obtenerTodos() {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Provedor> resultado = new ArrayList<>();
        try {
            ps = conn.prepareStatement("Select id, nombre, correo from Proveedores");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                resultado.add(new Provedor(id, nombre, correo));
            }

        } catch (SQLException ex) {
            LOG.error("No se pudieron obtener los provedores", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, rs);
        }
        
        return resultado;
    }

    @Override
    public void actualizar(Provedor proveedor) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Update Proveedores set nombre=? , correo=? where id=?");
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getCorreo());
            ps.setInt(3, proveedor.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del proveedor: " + proveedor, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
       }
    
}
