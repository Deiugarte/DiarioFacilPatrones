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
public interface Observable {
    public void addObserver(Observer o);
    public void notifyObserver();
}
