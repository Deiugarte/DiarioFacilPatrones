/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.model;

/**
 *
 * @author madrizdm
 */
public class Admin extends Usuario{

    public Admin(int id, String nombre, String apellido, String correo, String contrasena, int tipoUsuario){
        super(id, nombre, apellido, correo, contrasena, tipoUsuario, new ComportamientoAdmin());
    }    
}
