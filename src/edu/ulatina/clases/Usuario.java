/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.clases;

/**
 *
 * @author Xpc
 */
public abstract class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String login;
    private String contraseña;
     

    public Usuario(String nombre, String apellido, String correo, String login, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.login = login;
        this.contraseña = contraseña;
    }
    
    private void cambiarContraseña (String nuevaContraseña){
        this.setContraseña(nuevaContraseña);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
