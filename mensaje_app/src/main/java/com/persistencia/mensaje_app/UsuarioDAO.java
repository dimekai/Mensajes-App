package com.persistencia.mensaje_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kaimorts
 */
public class UsuarioDAO {

    public static void crearUsuarioDB(Usuario usuario) {
        Conexion dbConexion = new Conexion();
        try (Connection conexion = dbConexion.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO Usuarios (nombre, correo, sexo, edad) VALUES (?,?,?,?);";
                ps = conexion.prepareStatement(query);
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getCorreo());
                ps.setString(3, usuario.getSexo());
                ps.setInt(4, usuario.getEdad());

                ps.executeUpdate();
                System.out.println("\t== The new user was created ==");
            } catch (SQLException e) {
                System.err.println("There was an exception to create the new user");
                System.err.println(e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("There was an exception to connect to database");
            System.err.println(e.getMessage());
        }
    }

    public static void leerUsuariosDB() {
        Conexion dbConexion = new Conexion();
        try (Connection conexion = dbConexion.getConnection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT id_usuario, nombre, correo, sexo, edad FROM Usuarios;";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                
                System.out.println("\t== The list of Users ==");
                while (rs.next()) {
                    System.out.println("ID Usuario:\t" + rs.getInt("id_usuario"));
                    System.out.println("Nombre:\t\t" + rs.getString("nombre"));
                    System.out.println("Correo:\t\t" + rs.getString("correo"));
                    System.out.println("Sexo:\t\t" + rs.getString("sexo"));
                    System.out.println("Edad:\t\t" + rs.getInt("edad"));
                    System.out.println("");
                }

            } catch (SQLException e) {
                System.err.println("There was an exception to list the users");
                System.err.println(e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("There was an exception to connect to database");
            System.err.println(e.getMessage());
        }
    }

    public static void eliminarUsuario(int id_usuario) {
        Conexion dbConexion = new Conexion();
        try (Connection conexion = dbConexion.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM Usuarios WHERE id_usuario = ?;";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_usuario);
                ps.executeUpdate();
                System.out.println("\t== The user was deleted ==");
            } catch (SQLException e) {
                System.err.println("There was an exception when deleting the message");
                System.err.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("There was an exception in the connection.\n" + e.getMessage());
        }
    }

    public static void actualizarUsuario(Usuario usuario) {
        Conexion dbConexion = new Conexion();
        try (Connection conexion = dbConexion.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "UPDATE Usuarios SET nombre = ?, correo = ?, sexo = ?, edad = ? WHERE id_usuario = ?;";
                ps = conexion.prepareStatement(query);
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getCorreo());
                ps.setString(3, usuario.getSexo());
                ps.setInt(4, usuario.getEdad());
                ps.setInt(5, usuario.getId_usuario());
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
