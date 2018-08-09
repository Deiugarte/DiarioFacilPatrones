/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.idao;

import edu.ulatina.diariofacil.model.Proveedor;

/**
 *
 * @author blaken
 */
public interface IProveedorDAO {
    public void crear(Proveedor proveedor);
    public void borrar(Proveedor proveedor);
    public Proveedor obtener(Proveedor proveedor);
    public void actualizar(Proveedor proveedor);
}
