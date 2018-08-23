/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.model;

import edu.ulatina.diariofacil.dao.ProvedorDAO;
import edu.ulatina.diariofacil.patrones.Observable;
import edu.ulatina.diariofacil.patrones.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author blaken
 */
public class Producto implements Observable{
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private double descuento;
    private int inventario;
    private List<Provedor> provedores = new ArrayList<>();

    public Producto(int id, String nombre, String descripcion, double precio, double descuento, int inventario) {
        ProvedorDAO pDao = new ProvedorDAO();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.inventario = inventario;
        this.provedores = pDao.obtenerProvedorXProducto(id);
    }

    public Producto(String nombre, String descripcion, double precio, double descuento, int inventario, List<Provedor> provedores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.inventario = inventario;
        this.provedores = provedores;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
        if(this.inventario < 5) notifyObserver();
    }

    public List<Provedor> getProveedores() {
        return provedores;
    }

    public void setProveedores(List<Provedor> proveedores) {
        this.provedores = proveedores;
    }

    @Override
    public String toString() {
        return "ID: " + id + ". |  Nombre: " + nombre + ". | Descripcion: " + descripcion + ". | Precio: " + precio
                + ". | Descuento:"+ descuento + ". | Inventario: " + inventario + ".";
    }



    @Override
    public void notifyObserver() {
        this.provedores.forEach(provedor -> provedor.update());
    }

    @Override
    public void addObserver(Observer o) {
        this.provedores.add((Provedor) o);
    }
    
}
