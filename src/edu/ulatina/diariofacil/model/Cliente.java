package edu.ulatina.diariofacil.model;

public class Cliente extends Usuario {
    public Cliente(int id, String nombre, String apellido, String correo, String contrasena, int tipoUsuario, IComportamiento comportamiento){
        super(id, nombre, apellido, correo, contrasena, tipoUsuario, comportamiento);
    }     
}
