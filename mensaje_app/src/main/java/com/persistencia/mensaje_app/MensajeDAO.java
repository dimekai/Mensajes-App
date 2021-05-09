package com.persistencia.mensaje_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kaimorts
 */
public class MensajeDAO {

    public static void crearMensajeDB(Mensaje mensaje) {
        Conexion dbConexion = new Conexion();
        try (Connection conexion = dbConexion.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO Mensajes (mensaje, autor) VALUES (?,?);";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor());

                ps.executeUpdate();
                System.out.println("\t== The new message was created ==");

            } catch (SQLException e) {
                System.err.println("There was an exception when the message was updating");
                System.err.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("There was an exception in the connection.\n" + e.getMessage());
        }
    }

    public static void leerMensajesDB() {
        Conexion dbConexion = new Conexion();
        try (Connection conexion = dbConexion.getConnection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT id_mensaje, mensaje, autor, fecha FROM Mensajes;";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();

                System.out.println("\t== The list of messages ==");
                while (rs.next()) {
                    System.out.println("ID Mensaje:\t" + rs.getInt("id_mensaje"));
                    System.out.println("Mensaje:\t" + rs.getString("mensaje"));
                    System.out.println("Autor:\t\t" + rs.getString("autor"));
                    System.out.println("Fecha:\t\t" + rs.getString("fecha"));
                    System.out.println("");
                }

            } catch (SQLException e) {
                System.err.println("There was an exception when retrieving messages");
                System.err.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("There was an exception in the connection.\n" + e.getMessage());
        }
    }

    public static void borrarMensajeDB(int id_mensaje) {
        Conexion dbConexion = new Conexion();
        try (Connection conexion = dbConexion.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM Mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("\t== The message was deleted ==");

            } catch (SQLException e) {
                System.err.println("There was an exception when deleting the message");
                System.err.println(e.getMessage());

            }
        } catch (SQLException e) {
            System.err.println("There was an exception in the connection.\n" + e.getMessage());
        }
    }

    public static void actualizarMensajeDB(Mensaje mensaje) {
        Conexion dbConexion = new Conexion();
        try (Connection conexion = dbConexion.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "UPDATE Mensajes SET mensaje = ? WHERE id_mensaje = ?;";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                
                ps.executeUpdate();
                System.out.println("\t== The message was successfully updated ==");
            } catch (SQLException e) {
                System.err.println("There was an exception when updating the message");
                System.err.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("There was an exception in the connection.\n" + e.getMessage());
        }
    }

}
