package com.persistencia.mensaje_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kaimorts
 */
public class Conexion {

    private static final String PORT = "3306";
    private static final String DATABASE = "mensaje_app";
    private static final String URL = "jdbc:mysql://localhost:" + Conexion.PORT + "/" + Conexion.DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getConnection() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(Conexion.URL, Conexion.USER, Conexion.PASSWORD);
        } catch (SQLException e) {
            System.err.println("There was an exception\n" + e.getMessage());
        }
        
        return conexion;
    }
}
