/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.clases;

/**
 *
 * @author Xpc
 */
public class Combo {
   String nombreDeCombo;
    String descripcionDeCombo;
    int precioDeCombo;

    public Combo() {
    }

    public Combo(String nombreDeCombo, String descripcionDeCombo, int precioDeCombo) {
        this.nombreDeCombo = nombreDeCombo;
        this.descripcionDeCombo = descripcionDeCombo;
        this.precioDeCombo = precioDeCombo;
    }

    public String getNombreDeCombo() {
        return nombreDeCombo;
    }

    public void setNombreDeCombo(String nombreDeCombo) {
        this.nombreDeCombo = nombreDeCombo;
    }

    public String getDescripcionDeCombo() {
        return descripcionDeCombo;
    }

    public void setDescripcionDeCombo(String descripcionDeCombo) {
        this.descripcionDeCombo = descripcionDeCombo;
    }

    public int getPrecioDeCombo() {
        return precioDeCombo;
    }

    public void setPrecioDeCombo(int precioDeCombo) {
        this.precioDeCombo = precioDeCombo;
    }

    @Override
    public String toString() {
        return "Combo: " + nombreDeCombo + "(" + descripcionDeCombo + ")"+ "Precio: " + precioDeCombo;
    } 
}
