package edu.ulatina.diariofacil.model;

import java.util.Scanner;
public class ComportamientoAdmin implements IComportamiento{
    
    public void agregarProductos(){
        //TODO
    }
    
    
    
    
    // ---------- MENUS ADMIN -----------
    
    
    public void menuMantProductos(){
        System.out.println("Mantenimiento Provedores");
    }
    
    public void menuMantProveedores(){
        //TODO
    }
    public void menuMantPromociones(){
        //TODO
    }
    public void menuMantCombos(){
        //TODO
    }
    
    @Override
    public void menuPrincipal(){
        System.out.println(
                  "1. Manteniento de Productos\n"
                + "2. Mantenimiento de Proveedores\n"
                + "3. Mantenimiento de Promocion\n"
                + "4. Mantenimiento de Combo\n\n------"
                + "Elija una opcion:\n");
        Scanner leer = new Scanner(System.in);
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
               menuMantProductos();
                break;
            case 2:
               menuMantProveedores();
                break;
            case 3:
               menuMantPromociones();
                break;
            case 4:
                menuMantCombos();
                break;
        }
    }                
}
