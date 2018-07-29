
package edu.ulatina.clases;

public class Producto {
    protected String nombre;
    protected int precio;
    protected String codigo;
    protected int cantidad;
    protected int inventarioMinimo;
    protected Proveedor proveedor;
    protected String miCategoria;

    public Producto() {

    }

    public Producto(String nombre, int precio, String codigo, int cantidad, int inventarioMinimo, Proveedor proveedor, String miCategoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.inventarioMinimo = inventarioMinimo;
        this.proveedor = proveedor;
        this.miCategoria = miCategoria;
    }

    public int getInventarioMinimo() {
        return inventarioMinimo;
    }

    public void setInventarioMinimo(int inventarioMinimo) {
        this.inventarioMinimo = inventarioMinimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getMiCategoria() {
        return miCategoria;
    }

    public void setMiCategoria(String miCategoria) {
        this.miCategoria = miCategoria;
    }

    @Override
    public String toString() {
        return  nombre + ", precio: " + precio + ", codigo: " + codigo + ", (" + cantidad + "/" + inventarioMinimo +")"+" proveedor: " + proveedor.getNombreEmpresa() + " Categoria: [" + miCategoria + ']';
    }
}
