/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.idao;

import edu.ulatina.diariofacil.model.Usuario;

/**
 *
 * @author blaken
 */
public interface IUsuarioDAO {
    public void crearUsuario(Usuario usuario);
    public void borrarUsuario(Usuario usuario);
    public Usuario obtenerUsuario(Usuario usuario);
    public void actualizarUsuario(Usuario usuario);
}
