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
public class Admin extends Usuario {    
    DiarioFacil df = null;
    

    public Admin(DiarioFacil df,String nombre, String apellido, String correo, String login, String contraseña) {
        super(nombre, apellido, correo, login, contraseña);
        this.df = df;
    }

    public DiarioFacil getDf() {
        return df;
    }

    public void setDf(DiarioFacil df) {
        this.df = df;
    }
    
        
    public void verFaltante (){
       int a;
       for (a=0; a>df.getListProductos().size();a++){
           if (df.getListProductos().get(a).getCantidad()<df.getListProductos().get(a).getInventarioMinimo()){
               System.out.print("Faltante en producto: "+df.getListProductos().get(a).getNombre()+"("+df.getListProductos().get(a).getCantidad()+"/"+df.getListProductos().get(a).getInventarioMinimo()+")");
           }
       }
       
    }
    
}
