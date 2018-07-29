
package edu.ulatina.clases;


public class Item {
    
    int cantidad;
    String nombre;
    int subtotal;

    //Item puede estar compuesto de producto, combo o promo
    public Item(int cantidad, String nombre, int subtotal) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.subtotal = subtotal * cantidad;
    }

    @Override
    public String toString() {
        return cantidad + " | " + nombre + " | " + subtotal + ".\n";
    }
}
