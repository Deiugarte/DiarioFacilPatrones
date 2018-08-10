/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.idao;

import edu.ulatina.diariofacil.model.Combo;

/**
 *
 * @author blaken
 */
public interface IComboDAO {
    public void crear(Combo combo);
    public void borrar(Combo combo);
    public Combo obtener(Combo combo);
    public void actualizar(Combo combo);
}
