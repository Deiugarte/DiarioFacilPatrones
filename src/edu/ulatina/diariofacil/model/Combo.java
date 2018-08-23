/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author murip
 */
public abstract class Combo{
    private String descripcion;
    private int id;
    private double precio;
    private List<Producto> productos = new ArrayList<>();

    public Combo(){
    }

    public Combo(String descripcion, int id, double precio) {
        this.descripcion = descripcion;
        this.id = id;
        this.precio = precio;
    }
    
    
    
    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    

    public List<Producto> getProductos() {
        return productos;
    }
    
    public abstract double costo();
}
