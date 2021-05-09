package com.persistencia.mensaje_app;

import java.util.Scanner;

/**
 *
 * @author kaimorts
 */
public class MensajeService {
    
    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();
        
        System.out.println("Autor del mensaje: ");
        String autor = sc.nextLine();
        
        Mensaje register = new Mensaje();
        register.setMensaje(mensaje);
        register.setAutor(autor);
        
        MensajeDAO.crearMensajeDB(register);
    }
    
    public static void listarMensajes() {
        MensajeDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        MensajeDAO.borrarMensajeDB(id_mensaje);
    }
    
    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje: ");
        String mensaje = sc.nextLine();
        
        System.out.println("Indica el ID del mensaje: ");
        int id_mensaje = sc.nextInt();
        
        Mensaje regiserUpdated = new Mensaje();
        regiserUpdated.setId_mensaje(id_mensaje);
        regiserUpdated.setMensaje(mensaje);
        
        MensajeDAO.actualizarMensajeDB(regiserUpdated);
    }
}
