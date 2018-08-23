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
import edu.ulatina.diariofacil.model.Item;
import java.util.ArrayList;
import java.util.List;
public class FacturaConDetalle implements iFactura {
    List <Item> items = new ArrayList<>();
    
    FacturaConDetalle(){
        
    }
    FacturaConDetalle(List<Item> items){
        this.items = items;
    }
    @Override
    public void generarFactura(){
        System.out.println("---** Factura Detallada **---");  
    }
    
}
