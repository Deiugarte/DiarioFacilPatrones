/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.dao;

import edu.ulatina.diariofacil.idao.IItemDAO;
import edu.ulatina.diariofacil.jdbc.Conector;
import edu.ulatina.diariofacil.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author blaken
 */
public class ItemDAO implements IItemDAO {

    private final Conector conectorJDBC = Conector.getConector();
    private static final Logger LOG = LogManager.getLogger(OrdenDAO.class.getName());

    @Override
    public int crear(Item item) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        int id = 0;
        try {
            ps = conn.prepareStatement("Insert Into Items (idProducto,cantidad)  values (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, item.getProducto().getId());
            ps.setInt(2, item.getCantidad());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del item: " + item, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
        return id;
    }

    @Override
    public void borrar(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item obtener(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
