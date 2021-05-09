package com.persistencia.mensaje_app;

/**
 *
 * @author kaimorts
 */
public class Mensaje {
    private int id_mensaje;
    private String mensaje;
    private String autor;
    private String fecha;

    public Mensaje(String mensaje, String autor, String fecha) {
        this.mensaje = mensaje;
        this.autor = autor;
        this.fecha = fecha;
    }

    public Mensaje(){}
    
    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
