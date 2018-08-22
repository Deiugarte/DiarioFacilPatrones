/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.patrones;

import edu.ulatina.diariofacil.model.Admin;
import edu.ulatina.diariofacil.model.Cliente;

/**
 *
 * @author Xpc
 */
public class TesterCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente0 = new Cliente(1, "Josue", "Vega", "sgtxjosue@gmail.com",
                 "pass", 1);
        cliente0.menuPrincipal();
    }
    
}
