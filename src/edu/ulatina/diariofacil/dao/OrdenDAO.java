/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.dao;

import edu.ulatina.diariofacil.idao.IOrdenDAO;
import edu.ulatina.diariofacil.jdbc.Conector;
import edu.ulatina.diariofacil.model.Cliente;
import edu.ulatina.diariofacil.model.Item;
import edu.ulatina.diariofacil.model.Orden;
import edu.ulatina.diariofacil.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrdenDAO implements IOrdenDAO {

    private final Conector conectorJDBC = Conector.getConector();
    private static final Logger LOG = LogManager.getLogger(OrdenDAO.class.getName());
    private final ItemDAO itemDao = new ItemDAO();
    private final ItemPorOrdenDAO itemPorOrdenDAO = new ItemPorOrdenDAO();

    @Override
    public void crear(Orden orden) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Insert Into Ordenes (idUsuario,descuento, fecha)  values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, orden.getUsuario().getId());
            ps.setDouble(2, orden.getDescuento());
            ps.setDate(3, new java.sql.Date(orden.getFecha().getTime()));
            int ordenId = ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ordenId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            System.out.println(ordenId);
            conectorJDBC.cerrarConexion(conn, ps, null);
            for (Item item : orden.getItems()) {
                itemPorOrdenDAO.crear(ordenId, itemDao.crear(item));
            }
            

        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del orden: " + orden, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    @Override
    public void borrar(Orden orden) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Delete from Ordens Where id=?");
            ps.setInt(1, orden.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            LOG.error("No se puedo borrar el orden: " + orden, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

    @Override
    public Orden obtener(Orden orden) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Orden resultado = null;
        try {
            ps = conn.prepareStatement("Select id, idUsuario,descuento, fecha from Ordens where id=? ");
            ps.setInt(1, orden.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Usuario idUsuario = new Cliente();//rs.getInt("idUsuario");
                int descuento = rs.getInt("descuento");
                Date precio = rs.getDate("fecha");
                resultado = new Orden(id, idUsuario, descuento, precio);
            }

        } catch (SQLException ex) {
            LOG.error("No se pudo obtener el orden", ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, rs);
        }
        return resultado;
    }
    @Override
    public void actualizar(Orden orden) {
        Connection conn = conectorJDBC.conectar();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("Update Ordens set idUsuario=? , descuento=?, fecha=? where id=?");
            ps.setInt(1, orden.getUsuario().getId());
            ps.setDouble(2, orden.getDescuento());
            ps.setDate(3, new java.sql.Date(orden.getFecha().getTime()));
            ps.setInt(4, orden.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            LOG.error("No se puedo realizar la insercion del orden: " + orden, ex);
        } finally {
            conectorJDBC.cerrarConexion(conn, ps, null);
        }
    }

}
