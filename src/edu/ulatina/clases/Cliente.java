/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.clases;

import java.util.Scanner;

/**
 *
 * @author Xpc
 */
public class Cliente extends Usuario{
    private String cedula;
    private String telefono;
    private boolean clienteFrecuente = false;
    private Carrito carrito = new Carrito();

    Scanner sc = new Scanner(System.in);


    
    public Cliente(DiarioFacil b, String cedula, String telefono, String nombre, String apellido, String correo, String login, String contraseña) {
        super(nombre, apellido, correo, login, contraseña);
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isClienteFrecuente() {
        return clienteFrecuente;
    }

    public void setClienteFrecuente(boolean clienteFrecuente) {
        this.clienteFrecuente = clienteFrecuente;
    }

    public boolean getClienteFrecuente() {
        return clienteFrecuente;
    }

    @Override public String toString(){
        return 
                "Login: " + this.getLogin() + ".\n"
                + "Nombre: " + this.getNombre() + ".\n"
                + "Cedula:" + cedula + ".\n"
                + "Telefono: " + telefono + ".\n"
                + "Correo: " + this.getCorreo() + ".\n"
                ;
    }  
}
