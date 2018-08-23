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
public class FacturaFactory {
    public iFactura getFactura(String tipoFactura){
      if(tipoFactura == null){
         return null;
      }		
      if(tipoFactura.equalsIgnoreCase("simple")){
         return new FacturaSimple();
         
      } else if(tipoFactura.equalsIgnoreCase("detallada")){
         return new FacturaConDetalle();
      }
      return null;
   }
}