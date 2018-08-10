/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.idao;

import edu.ulatina.diariofacil.model.Provedor;

/**
 *
 * @author blaken
 */
public interface IProvedorDAO {
    public void crear(Provedor proveedor);
    public void borrar(Provedor proveedor);
    public Provedor obtener(Provedor proveedor);
    public void actualizar(Provedor proveedor);
}
