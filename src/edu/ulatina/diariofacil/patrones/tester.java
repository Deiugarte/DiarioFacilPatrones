/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.patrones;
import edu.ulatina.diariofacil.model.Admin;
import edu.ulatina.diariofacil.dao.UsuarioDAO;
import edu.ulatina.diariofacil.model.*;
/**
 *
 * @author blaken
 */
public class tester {
    
    public static void main(String[] args) {
        Admin admin0 = new Admin(1,"Daniel", "Segura", "daniel@gmail.com"
                ,"pass", 1,new ComportamientoAdmin());
        admin0.getComportamiento().menuPrincipal();
                
    }
    
}
