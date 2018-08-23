/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.dao;

import edu.ulatina.diariofacil.idao.IComboDAO;
import edu.ulatina.diariofacil.jdbc.Conector;
import edu.ulatina.diariofacil.model.Combo;
import edu.ulatina.diariofacil.model.ComboNavideno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author blaken
 */
public class ComboDAO implements IComboDAO {

    private final Conector conectorJDBC = new Conector();
    private static final Logger LOG = LogManager.getLogger(OrdenDAO.class.getName());
    
    @Override
    public void crear(Combo combo) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Insert Into Combos (id,precio, descripcion)  values (?,?,?)");
            ps.setInt(1, combo.getId());
            ps.setDouble(2, combo.getPrecio());
            ps.setString(3, combo.getDescripcion());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del orden: " + combo, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    @Override
    public void borrar(Combo combo) {
       Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM Combos WHERE id = ?");
            ps.setInt(1, combo.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del orden: " + combo, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    @Override
    public Combo obtener(Combo combo) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Combo resultado = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Combos WHERE id = ?");
            ps.setInt(1, combo.getId());
            ps.executeUpdate();
            int id = rs.getInt("id");
            Double precio = rs.getDouble("precio");
            String descr = rs.getString("descripcion");
            resultado = new Combo(descr, id, precio) {
                @Override
                public double costo() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
            
                
        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del orden: " + combo, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
        return resultado;
    }
    
    @Override
    public void actualizar(Combo combo) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Combos SET precio = ?, descripcion = '?' WHERE id = ?");
            ps.setDouble(1, combo.getPrecio());
            ps.setString(2, combo.getDescripcion());
            ps.setInt(3, combo.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del orden: " + combo, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    
    
}
