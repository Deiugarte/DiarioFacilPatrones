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
public class ListaProductoCombo extends DecoradorCombo{
    Combo combo;
    List<Producto> productos = new ArrayList<>();

    public ListaProductoCombo(Combo combo, Producto producto){
        this.combo = combo;
        this.productos.add(producto);
        //agregar precio
    }

    ListaProductoCombo() {
        
    }
    
    
    
    public List<Producto> getLstProductos() {
        return productos;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.productos = lstProductos;
    }
    
        
    public void agregarProductoLista(Producto producto){
        this.productos.add(producto);
    }

    @Override
    public String getDescripcion() {
        String produ = "";
        for(Producto prod : this.productos){
            produ.concat(prod.getNombre());
        }
        return "Esta es la lista de productos" + produ ;
    }

    @Override
    public double costo() {
        double costo = this.combo.getPrecio();
        
        for (Producto lstProducto : productos) {
            costo += lstProducto.getPrecio();
            //System.out.println(lstProducto.getPrecio());
        }
        
        return costo;
    }
}
