package com.persistencia.mensaje_app;

import java.sql.Connection;

/**
 *
 * @author kaimorts
 */
public class Inicio {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        try (Connection cnx = conexion.getConnection()) {
            
        } catch (Exception e) {
            System.err.println("There was an exception\n" + e.getMessage());
        }
    }
}
