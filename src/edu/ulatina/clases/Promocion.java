
package edu.ulatina.clases;

public class Promocion {
    private String nombrePromocion;
    private double descuento;
    private int precio;
    
    public Promocion() {
    }

    public Promocion(String nombrePromocion,int precio, double descuento) {
        this.nombrePromocion = nombrePromocion;
        this.precio = precio;
        this.descuento = descuento;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Promoción de " + nombrePromocion + ", Precio: " + precio + ", Descuento: " + descuento+"%";
    }
}
