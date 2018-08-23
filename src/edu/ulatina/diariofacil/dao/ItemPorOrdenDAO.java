/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.dao;

import edu.ulatina.diariofacil.idao.IItemPorOrdenDAO;
import edu.ulatina.diariofacil.jdbc.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author blaken
 */
public class ItemPorOrdenDAO implements IItemPorOrdenDAO {

    private final Conector conectorJDBC = Conector.getConector();
    private static final Logger LOG = LogManager.getLogger(OrdenDAO.class.getName());

    @Override
    public void crear(int idOrden, int idItem) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Insert Into ItemsPorOrdenes (idOrden,idItems)  values (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idOrden);
            ps.setInt(2, idItem);
            ps.executeUpdate();
        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del item en la orden ", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    @Override
    public void borrar(int idOrden) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
