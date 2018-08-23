/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.idao;

import edu.ulatina.diariofacil.model.Provedor;
import java.util.List;

/**
 *
 * @author blaken
 */
public interface IProvedorDAO {
    public void crear(String nombre, String correo);
    public void borrar(int id);
    public Provedor obtener(int id);
    public List <Provedor> obtenerTodos();
    public List<Provedor> obtenerProvedorXProducto(int idProducto);
    public void actualizar(Provedor provedor);
}
