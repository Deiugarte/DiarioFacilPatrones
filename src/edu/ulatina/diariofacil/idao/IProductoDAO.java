/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.idao;

import edu.ulatina.diariofacil.model.Producto;
import java.util.List;

/**
 *
 * @author blaken
 */
public interface IProductoDAO {
    public List<Producto> obtenerProductos();
    public void crear(Producto producto);
    public void borrar(Producto producto);
    public Producto obtener(Producto producto);
    public void actualizar(Producto producto);
}
