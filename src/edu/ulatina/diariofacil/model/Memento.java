
package edu.ulatina.diariofacil.model;

import java.util.ArrayList;
import java.util.List;


public class Memento {
       private List<Producto> lstMovimientosEliminadosProducto=new ArrayList<>();
       private List<Producto> lstMovimientosAgregadosProducto=new ArrayList<>();
       private List<Item> lstMovimientosEliminadosItems=new ArrayList<>();
       private List<Item> lstMovimientosAgregadosItems=new ArrayList<>();

    
 
    public void MementoAgregadoProducto(Producto proAgregado)
    {
      this.lstMovimientosAgregadosProducto.add(proAgregado); 
    }
    public void MementoEliminadoProducto(Producto proEliminado)
    {
      lstMovimientosEliminadosProducto.add(proEliminado); 
    }
    public void MementoAgregadoItem(Item itemAgregado)
    {
      this.lstMovimientosAgregadosItems.add(itemAgregado); 
    }
    public void MementoEliminadoItem(Item itemEliminado)
    {
      lstMovimientosEliminadosItems.add(itemEliminado); 
    }

    public List<Producto> getLstMovimientosEliminadosProducto() {
        return lstMovimientosEliminadosProducto;
    }

    public void setLstMovimientosEliminadosProducto(List<Producto> lstMovimientosEliminadosProducto) {
        this.lstMovimientosEliminadosProducto = lstMovimientosEliminadosProducto;
    }

    public List<Producto> getLstMovimientosAgregadosProducto() {
        return lstMovimientosAgregadosProducto;
    }

    public void setLstMovimientosAgregadosProducto(List<Producto> lstMovimientosAgregadosProducto) {
        this.lstMovimientosAgregadosProducto = lstMovimientosAgregadosProducto;
    }

    public List<Item> getLstMovimientosEliminadosItems() {
        return lstMovimientosEliminadosItems;
    }

    public void setLstMovimientosEliminadosItems(List<Item> lstMovimientosEliminadosItems) {
        this.lstMovimientosEliminadosItems = lstMovimientosEliminadosItems;
    }

    public List<Item> getLstMovimientosAgregadosItems() {
        return lstMovimientosAgregadosItems;
    }

    public void setLstMovimientosAgregadosItems(List<Item> lstMovimientosAgregadosItems) {
        this.lstMovimientosAgregadosItems = lstMovimientosAgregadosItems;
    }
    

    public Memento() {
    }

    
}
