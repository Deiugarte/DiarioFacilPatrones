/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.dao;

import edu.ulatina.diariofacil.jdbc.Conector;
import edu.ulatina.diariofacil.idao.IUsuarioDAO;
import edu.ulatina.diariofacil.model.Admin;
import edu.ulatina.diariofacil.model.Cliente;
import edu.ulatina.diariofacil.model.ComportamientoAdmin;
import edu.ulatina.diariofacil.model.ComportamientoCliente;
import edu.ulatina.diariofacil.model.IComportamiento;
import edu.ulatina.diariofacil.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author blaken
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final Conector conectorJDBC = new Conector();
    private static final Logger LOG = LogManager.getLogger(UsuarioDAO.class.getName());

    @Override
    public void crearUsuario(Usuario usuario) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Insert Into Usuarios (nombre, apellido, idTipoUsuario, correo, contrasena) values (?,?,?,?,?)");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setInt(3, usuario.getTipoUsuario());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getContrasena());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del usuario: " + usuario, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }

    }

    @Override
    public void borrarUsuario(Usuario usuario) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Delete from Usuarios Where id=?");
            ps.setInt(1, usuario.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo borrar el usuario: " + usuario, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    @Override
    public Usuario obtenerUsuario(Usuario usuario) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario resultado = null;
        try {
            ps = conn.prepareStatement("Select id,nombre, apellido, idTipoUsuario, correo, contrasena from Usuarios where id=? ");
            ps.setInt(1, usuario.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String contrasena = rs.getString("contrasena");
                int idTipoUsuario = rs.getInt("idTipoUsuario");
               //                Cliente resultado = idTipoUsuario == 1 ? new TODO: change to admin or client if tipo usuario
//                usuarios.add(new Usuario(id, nombre, apellido, correo, contrasena, idTipoUsuario));
            }

        } catch (SQLException ex) {
            LOG.error("No se pudo obtener el usuario", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, rs);
        }
        return resultado;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Update  Usuarios set nombre=? , apellido=?, idTipoUsuario=?, correo=?, contrasena=? where id=?");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setInt(3, usuario.getTipoUsuario());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getContrasena());
            ps.setInt(6, usuario.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del usuario: " + usuario, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }



    @Override
    public List<Usuario> obtenerUsuarios() {
        IComportamiento comportamiento;
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ps = conn.prepareStatement("Select id,nombre, apellido, idTipoUsuario, correo, contrasena from Usuarios ");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String contrasena = rs.getString("contrasena");
                int idTipoUsuario = rs.getInt("idTipoUsuario");
                if(rs.getInt("idTipoUsuario")==1){
                    comportamiento=new ComportamientoAdmin();
                }else if(rs.getInt("idTipoUsuario")==2){
                    comportamiento=new ComportamientoCliente();
                }
                if(rs.getInt("idTipoUsuario")==2){
                usuarios.add(new Cliente(id, nombre, apellido, correo, contrasena, idTipoUsuario));
                }else if(rs.getInt("idTipoUsuario")==1){
                usuarios.add(new Admin(id, nombre, apellido, correo, contrasena, idTipoUsuario));
                }        
            }

        } catch (SQLException ex) {
            LOG.error("No se pudo obtener los usuarios", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, rs);
        }
        return usuarios;
    }

}
