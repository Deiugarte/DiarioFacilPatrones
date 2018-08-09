/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.idao;

import edu.ulatina.diariofacil.model.Orden;

/**
 *
 * @author blaken
 */
public interface IOrdenDAO {
    public void crear(Orden orden);
    public void borrar(Orden orden);
    public Orden obtener(Orden orden);
    public void actualizar(Orden orden);
}
