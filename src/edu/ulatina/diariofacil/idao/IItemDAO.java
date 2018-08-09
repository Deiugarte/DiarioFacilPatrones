/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.idao;

import edu.ulatina.diariofacil.model.Item;

/**
 *
 * @author blaken
 */
public interface IItemDAO {
    public void crear(Item item);
    public void borrar(Item item);
    public Item obtener(Item item);
    public void actualizar(Item item);
}
