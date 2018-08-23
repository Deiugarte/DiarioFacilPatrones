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
public class ComboNavideno extends Combo{

    public ComboNavideno() {
        super("Combo Navideno", 0, 8.99);
    }
    
    

    public ComboNavideno(String descripcion, int id, double precio) {
        super(descripcion, id, precio);
    }
    
    
    
    @Override
    public double costo(){
        return 8.99;
    }
}
