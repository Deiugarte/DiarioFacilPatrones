
package edu.ulatina.clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido_Proveedor {
    private Proveedor proveedor;
    private Date fecha;
    private List<Producto> lstProductos = new ArrayList<>();
    private int cantidad;
    private String producto;

    public Pedido_Proveedor() {
    }
    

    public Pedido_Proveedor(Proveedor proveedor, Date fecha, int cantidad, String producto) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public void agregarProductoPedido(Producto producto) {
        this.lstProductos.add(producto);
    }

    @Override
    public String toString() {
        return (new SimpleDateFormat("dd-MM-yyyy").format(fecha)) + "\n" + " Proveedor: " + proveedor + "\n" + " Producto: " + producto + " Cantidad: " + cantidad + "\n";
    }
    
    public void imprimirProductos (){
        int a;
        for (a=0; a<lstProductos.size();a++){
            System.out.print(lstProductos.get(a).nombre+lstProductos.get(a).cantidad);
        }
    }
    
}
