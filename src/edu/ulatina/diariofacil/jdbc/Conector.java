/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 *
 * @author blaken
 */
public class Conector {
    
    private static final Logger LOG = LogManager.getLogger(Conector.class.getName());
    private final String DB_URL = "jdbc:mysql://db4free.net:3306/patrones?useSSL=false";
    //  Database credentials
    private final String USER = "patrones";
    private final String PASS = "patrones123";

    public Conector() {
    }

    public Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);  
        } catch (SQLException ex) {
            LOG.error("Error conectando a la base de datos", ex);
        }
        return conn;
    }

    public void cerrarConexion(Connection conn, PreparedStatement ps,  ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            LOG.error("No se pudo cerrar la conexion con la base de datos", e);
        }
    }
}
