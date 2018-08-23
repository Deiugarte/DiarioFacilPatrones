package edu.ulatina.diariofacil.model;

public class Cliente extends Usuario {
    public Cliente(int id, String nombre, String apellido, String correo, String contrasena, int tipoUsuario){
        super(id, nombre, apellido, correo, contrasena, tipoUsuario, new ComportamientoCliente());
    } 
    public Cliente(String nombre, String apellido, String correo, String contrasena, int tipoUsuario){
        super(nombre, apellido, correo, contrasena, tipoUsuario, new ComportamientoCliente());
    }     

    public Cliente() {
        super();
    }
    
    
}
