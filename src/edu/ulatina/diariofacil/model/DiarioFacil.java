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
    Usuario usuario;   

    public void menuInicio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---*** Bienvenido a Diario Facil! ***---\n"
                + "Digite:\n"
                + "1. Login.\n"
                + "2. Crear Usuario.\n"
                + "3. Salir.");
        switch (sc.nextInt()) {
            case 1: {
                logInDiarioFacil();
                break;
            }
            case 2: {
                crearCliente();
                System.out.print("Exito! Volviendo al inicio...");
                menuInicio();
                break;
            }
            case 3:{
                System.out.println("Saliendo...");
                break;
            }
            default:{
                System.out.println("Error! Saliendo...");
                break;
            }
        }       
    }

    public void logInDiarioFacil() {
        Scanner sc = new Scanner(System.in);
        List<Usuario> lstUsuarios = new UsuarioDAO().obtenerUsuarios();
        String email, contrasena;
        System.out.println("Ingrese su email:");
        email = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        contrasena = sc.nextLine();
        for (Usuario U : lstUsuarios) {
            if (U.getCorreo().equals(email) && U.getContrasena().equals(contrasena)) {
                if (U.getTipoUsuario() == 1) {
                    ((Admin) U).getComportamiento().menuPrincipal();
                    
                } else {
                    ((Cliente) U).getComportamiento().menuPrincipal();
                    
                }
            }
        }
    }
    
    public void crearCliente(){
        Scanner sc = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();       
        System.out.println("Digite su Nombre: ");
        String nom = sc.next();
        System.out.println("Digite su Apellido: ");
        String ape = sc.next();
        System.out.println("Digite su Email: ");
        String email = sc.next();
        System.out.println("Digite su Contrasena: ");
        String pass = sc.next();    
        usuarioDAO.crearUsuario(nom,ape,2,email,pass);       
    }
}
