
package edu.ulatina.diariofacil.model;

public class Item {
    private int id;
    private String nombreProducto;
    private int cantidad;
    private double subtotal;

    public Item() {
    }

    public Item(int id, String nombreProducto, int cantidad, double subtotal) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return  "------------------Item------------------"
                + "\nId: "+ id 
                + "\nProducto: "+ nombreProducto 
                + "\nCantidad: "+ cantidad 
                + "\nSubtotal: " + subtotal
                +"\n----------------------------------------";
    }
    
    
    
    
}
