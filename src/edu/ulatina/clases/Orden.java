
package edu.ulatina.clases;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orden {
    private int codigo;
    private LocalDateTime fechaDeCreacion;
    private Cliente cliente;
    private double montoTotal;
    private List<Item> listItems = new ArrayList<>();

    public Orden(int codigo, LocalDateTime fechaDeCreacion, Cliente cliente, double montoTotal) {
        this.codigo = codigo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.cliente = cliente;
        this.montoTotal = montoTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }
    
    @Override
    public String toString(){
        String separador =
                "+----+------+--------------------+----------+-----------+-----------+\n";
        String topBotSep =
                "+-------------------------------------------------------------------+\n";
        
        String format = "|%-66s |\n";
        
        String misc = "";
        misc += topBotSep + misc.format(format, "Cliente:");
                
                
              
        //Informacion del cliente. 
        String infoCliente = "";
        //Formato Clientes.
        format = "|%-13s | %-15s | %-20s   |\n";
        infoCliente +=
                infoCliente.format(format
                , "Cedula: " + cliente.getCedula()
                , "Nombre: " + cliente.getNombre()
                , "Telefono: " + cliente.getTelefono()
                );
       
        

        //Formato Columnas.
        format = "| %-2s | %-18s | %-8s\n";
        
        //Columnas Items.
        String columnas = topBotSep 
                + ("| Cant.| Descripcion:       | Precio: |\n")
                + separador;       
        

        
    /*    //Items.
        String items = "";
        for (Item i: listItems) {
           items += items.format(format
                   , i.getMiProducto().getCantidad()
                   , i.getMiProducto().getNombre()
                   , i.getMiProducto().getPrecio()
                   );
       }
        
        Concatenar:
        return misc + infoCliente + columnas + items + topBotSep;*/
    return "";
}
}
