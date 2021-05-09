package com.persistencia.mensaje_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author kaimorts
 */
public class Inicio {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("===========================");
            System.out.println(" Aplicacion de mensajes ");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensaje");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Salir");
            opcion = Integer.valueOf(sc.nextLine());

            switch (opcion) {
                case 1:
                    MensajeService.crearMensaje();
                    break;

                case 2:
                    MensajeService.listarMensajes();
                    break;

                case 3:
                    MensajeService.editarMensaje();
                    break;

                case 4:
                    MensajeService.borrarMensaje();
                    break;

                default:
                    break;
            }

        } while (opcion != 5);

        try (Connection cnx = conexion.getConnection()) {

        } catch (Exception e) {
            System.err.println("There was an exception\n" + e.getMessage());
        }
    }
}
