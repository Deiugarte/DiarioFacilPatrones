package edu.ulatina.diariofacil.model;

import java.util.Scanner;
public class ComportamientoAdmin implements IComportamiento{
    Scanner leer = new Scanner(System.in); 
     
    //Acciones de sobre Productos.
    public void agregarProducto(Producto prod){
        //TODO    
    }
    public void editarProducto(Producto prod){
        //TODO     
    }
    public void eliminarProducto(String nombreProducto){
        //TODO     
    }
    public void verProductos(){
        //TODO
    }
    public void verInventarioProducto(String codigoProducto){
        //TODO
    }

   //Acciones de sobre Promociones. 
    public void agregarPromocion(){
        //TODO    
    }
    public void editarPromocion(){
        //TODO     
    }
    public void eliminarPromocion(){
        //TODO     
    }
    public void verPromociones(){
        //TODO
    }

   //Acciones sobre Combos.
    public void agregarCombo(){
        //TODO
    }
    public void editarCombo(){
        //TODO
    }
    public void eliminarCombo(){
        //TODO
    }
    public void verCombos(){
        //TODO
    }
    
   //Acciones sobre Provedores.
    public void agregarProvedor(){
        //TODO
    }
    public void editarProvedor(){
        //TODO
    }
    public void eliminarProvedor(){
        //TODO
    }
    public void verProvedores(){
        //TODO
    }
    public void solicitarPedido(){
        //TODO
    }
    public void verPedidos(){
        //TODO
    }    

    // -------------- MENUS ADMIN -----------   
    @Override
    public void menuPrincipal(){
        System.out.println(
                "\n--- * Menu Principal * ---\n"
                + "1. Manteniento de Productos\n"
                + "2. Mantenimiento de Proveedores\n"
                + "3. Mantenimiento de Promocion\n"
                + "4. Mantenimiento de Combo\n"
                + "5. Salir.\n\n------\n"
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
            case 5: 
                System.out.println("\nSaliendo...\n");
                break;
        }
    }     
    public void menuMantProductos() {
           System.out.print("OPCIONES DE PRODUCTO" + "\n"
                   + "1. Agregar Producto" + "\n"
                   + "2. Editar Producto" + "\n"
                   + "3. Eliminar Producto" + "\n"
                   + "4. Ver inventario mínimo" + "\n"
                   + "5. Ver Productos" + "\n"
                   + "6. Regresar" + "\n"
                   + "Elija una opción:"
           );

           int opcion = leer.nextInt();
           switch (opcion) {
               case 1:                    
                   //agregarProducto();
                   break;
               case 2:
                  // editarProducto();
                   break;
               case 3:
                 // elininarProducto();
                   break;
               case 4:
                   //verInventarioProducto();
                   break;
               case 5:
                  // verProductos();
                   break;
               case 6:
                   menuPrincipal();
           }
       } 
    public void menuMantPromociones() {
           System.out.println("OPCIONES DE PROMOCION" + "\n"
                   + "1.Agregar Promoción" + "\n"
                   + "2.Eliminar Promoción" + "\n"
                   + "3.Ver Promociones" + "\n"
                   + "4. Regresar" + "\n"
                   + "Digite una opcion: " + "\n"
           );

           int opcion = leer.nextInt();

           switch (opcion){
               case 1:
                  // agregarPromocion();
                   break;
               case 2:
                   //eliminarPromocion();
                   break;
               case 3:
                   //verPromociones();
                   break;
               case 4:
                  // menuAdmin();
                   break;
           }
       }
    public void menuMantCombos(){
           System.out.print("OPCIONES DE COMBO" + "\n"
                   + "1. Agregar Combo" + "\n"
                   + "2. Eliminar Combo" + "\n"
                   + "3. Ver Combos" + "\n"
                   + "4. Regresar" + "\n"
                   + "Elija una opción:");
           int option = leer.nextInt();

           switch (option){
               case 1:
                  //agregarCombo();
                   break;
               case 2:
                   //eliminarCombo();
                   break;
               case 3:
                   //verCombos();
               case 4:
                   //menuAdmin();
           }
       }
    public void menuMantProveedores() {
           System.out.print("Mantenimiento de Provedores\n"
                   + "1. Agregar Proveedor\n"
                   + "2. Editar Proveedor\n"
                   + "3. Eliminar Proveedor\n"
                   + "4. Solicitar pedido\n"
                   + "5. Ver Proveedores\n"
                   + "6. Ver Pedidos\n"
                   + "7.Regresar\n"
                   + "Digite una opcion:\n");
           int opcion = leer.nextInt();
           switch (opcion) {
               case 1:
                  // agregarProveedor();
                   break;
               case 2:
                  // editarProveedor();
                   break;
               case 3:
                   //eliminarProveedor();
                   break;
               case 4:
                  // solicitarPedido();
                   break;
               case 5:
                  // verProveedores();
               case 6:
                  // verPedidos();
               case 7:
                 // menuAdmin();
           }
       }  
}
