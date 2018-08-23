/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.idao;


/**
 *
 * @author blaken
 */
public interface IItemPorOrdenDAO {
    public void crear(int idOrden , int idItem);
    public void borrar(int idOrden);
}
