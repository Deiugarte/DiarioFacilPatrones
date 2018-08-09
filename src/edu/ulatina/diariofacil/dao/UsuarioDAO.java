/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.dao;

import edu.ulatina.diariofacil.jdbc.Conector;
import edu.ulatina.diariofacil.idao.IUsuarioDAO;
import edu.ulatina.diariofacil.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            LOG.error( "No se puedo realizar la insercion del usuario: " + usuario );
        }
        finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
       
    }

    @Override
    public void borrarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtenerUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
