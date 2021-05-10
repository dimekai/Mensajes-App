package com.persistencia.mensaje_app;

import java.util.Scanner;

/**
 *
 * @author kaimorts
 */
public class UsuarioService {
    
    public static void crearUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Correo: ");
        String correo = sc.nextLine();
        System.out.println("Sexo: ");
        String sexo = sc.nextLine();
        System.out.println("Edad: ");
        int edad = sc.nextInt();
        
        Usuario usuario = new Usuario(nombre, correo, sexo, edad);
        UsuarioDAO.crearUsuarioDB(usuario);
        
    }
    
    public static void listarUsuarios(){
        UsuarioDAO.leerUsuariosDB();
    }
    
    public static void eliminarUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del usuario a borrar");
        int id_usuario = sc.nextInt();
        UsuarioDAO.eliminarUsuario(id_usuario);
    }
    
    public static void actualizarUsuario() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        
        System.out.println("Correo: ");
        String correo = sc.nextLine();
        
        System.out.println("Sexo: ");
        String sexo = sc.nextLine();
        
        System.out.println("Edad: ");
        int edad = sc.nextInt();
        
        System.out.println("Indica el ID del usuario: ");
        int id_usuario = sc.nextInt();
        
        Usuario userUpdated = new Usuario();
        userUpdated.setId_usuario(id_usuario);
        userUpdated.setNombre(nombre);
        userUpdated.setCorreo(correo);
        userUpdated.setSexo(sexo);
        userUpdated.setEdad(edad);
        
        UsuarioDAO.actualizarUsuario(userUpdated);
    }    
    
}
