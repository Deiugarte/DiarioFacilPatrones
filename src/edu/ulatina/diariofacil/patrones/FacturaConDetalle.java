/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.patrones;
/**
 *
 * @author madrizdm
 */

import edu.ulatina.diariofacil.model.Orden;

public class FacturaConDetalle implements iFactura {
    Orden orden;
    
    FacturaConDetalle(Orden orden){
        this.orden = orden;
    }
    FacturaConDetalle(){
        
    }
    @Override
    public void generarFactura(){
        System.out.println("---** Factura Detallada **---\n"
                + "Cliente: " + orden.getUsuario().getNombre() + 
                orden.getUsuario().getApellido() + ".\n"
                        + "Fecha: " + orden.getFecha());        
        System.out.println("Cant de Productos: " + orden.getItems().size());
        System.out.println("Precio: " + orden.getCosto());        
    }
    
}
