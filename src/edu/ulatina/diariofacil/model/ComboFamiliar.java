/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.model;

/**
 *
 * @author murip
 */
public class ComboFamiliar extends Combo{

    public ComboFamiliar() {
        super("Combo Familiar", 1, 9.99);
    }

    public ComboFamiliar(String descripcion, int id, double precio) {
        super(descripcion, id, precio);
    }
    
    
    
    @Override
    public double costo(){
        
        return 9.99;
    }
}
