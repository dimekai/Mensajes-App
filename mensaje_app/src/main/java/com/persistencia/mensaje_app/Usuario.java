package com.persistencia.mensaje_app;

/**
 *
 * @author kaimorts
 */
public class Usuario {

    private int id_usuario;
    private String nombre;
    private String correo;
    private String sexo;
    private int edad;

    public Usuario(String nombre, String correo, String sexo, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.sexo = sexo;
        this.edad = edad;
    }

    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
