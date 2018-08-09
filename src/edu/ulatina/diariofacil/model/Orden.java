/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author blaken
 */
public class Orden {
    private int id;
    private Usuario usuario;
    private int descuento;
    private Date fecha;
    private List<Item> items = new ArrayList();

    public Orden(int id, Usuario usuario, int descuento, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.descuento = descuento;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    
}
