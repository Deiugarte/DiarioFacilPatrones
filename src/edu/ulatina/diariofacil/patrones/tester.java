/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.patrones;
import edu.ulatina.diariofacil.dao.UsuarioDAO;
import edu.ulatina.diariofacil.model.Usuario;
/**
 *
 * @author blaken
 */
public class tester {
    
    public static void main(String[] args) {
       Usuario user = new Usuario(0,"Deivid","Alberto","deividauq93@hotmail.com","123",1);
       UsuarioDAO u = new UsuarioDAO();
       u.crearUsuario(user);
              u.crearUsuario(user);

    }
    
}
