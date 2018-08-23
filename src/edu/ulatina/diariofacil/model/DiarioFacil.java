/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.model;

import edu.ulatina.diariofacil.dao.UsuarioDAO;
import java.util.List;
import java.util.Scanner;

public class DiarioFacil {
    
    public void LogInDiarioFacil(){
       List<Usuario> lstUsuarios=new UsuarioDAO().obtenerUsuarios();
        Scanner sc=new Scanner(System.in);
        String nombre,contrasena;
        System.out.println("Ingrese su nombre:");
        nombre=sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        contrasena=sc.nextLine();
        for (Usuario U : lstUsuarios) {
            if(U.getNombre().equals(nombre) &&U.getContrasena().equals(contrasena)){
                U.menuPrincipal();
            }   
        } 
    }
}
