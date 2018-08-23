
package edu.ulatina.diariofacil.model;

public class Item {
    private int id;
    private Producto producto;
    private int cantidad;
    private double subtotal;

    public Item() {
    }

    public Item(int id, Producto producto, int cantidad, double subtotal) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setNombreProducto(Producto producto) {
        this.producto = producto;
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
                + "\nProducto: "+ producto.getNombre()
                + "\nCantidad: "+ cantidad 
                + "\nSubtotal: " + subtotal
                +"\n----------------------------------------";
    }    
    
}
