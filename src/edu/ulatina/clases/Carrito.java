
package edu.ulatina.clases;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Item> Items = new ArrayList<>();

    public ArrayList<Item> getItems() {
        return Items;
    }

    public String toString() {
        String s = "";
        for (Item i : Items) {
            s
                    += i.toString();
        }
        return s;
    }
}
