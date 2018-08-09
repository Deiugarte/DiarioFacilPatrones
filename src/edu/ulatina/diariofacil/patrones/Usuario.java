/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.patrones;

/**
 *
 * @author blaken
 */
public abstract class Usuario {
    private IComportamiento comportamiento;

    public Usuario(IComportamiento comportamiento) {
        this.comportamiento = comportamiento;
    }
    
    
    
    public void login (){
        comportamiento.login();
    }

    public IComportamiento getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(IComportamiento comportamiento) {
        this.comportamiento = comportamiento;
    }
    
}
