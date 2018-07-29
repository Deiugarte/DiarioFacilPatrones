
package edu.ulatina.recuperar;

import edu.ulatina.clases.Item;
import java.util.ArrayList;
import java.util.List;


public class RecuperarAccion {
    private List<Item> itemGuardar;

    public RecuperarAccion() {
        itemGuardar = new ArrayList<Item>();
    }

    
    public RecuperarAccion(List<Item> itemGuardar) {
        this.itemGuardar = itemGuardar;
    }

    
    public List<Item> getItemGuardar() {
        return itemGuardar;
    }

    public void setItemGuardar(List<Item> itemGuardar) {
        this.itemGuardar = itemGuardar;
    }
    
    public void addMemento(Item m) { itemGuardar.add(m); }
   public Item getMemento(int index) { return itemGuardar.get(index); }

    @Override
    public String toString() {
        return "RecuperarAccion{" + "itemGuardar=" + itemGuardar + '}';
    }
   
}
