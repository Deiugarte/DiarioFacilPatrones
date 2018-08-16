package edu.ulatina.diariofacil.model;

import edu.ulatina.diariofacil.dao.ProductoDAO;
import edu.ulatina.diariofacil.dao.ProvedorDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;

public class ComportamientoAdmin implements IComportamiento {
    Memento mementoMovimientos= new Memento();
    ProvedorDAO provedorDAO = new ProvedorDAO();
    ProductoDAO productoDAO = new ProductoDAO();
    Scanner leer = new Scanner(System.in);

    //Acciones de sobre Productos.
    public void agregarProducto() {
        //Inicializar lista de provedores registrados:
        List<Provedor> listProvedores = provedorDAO.obtenerTodos();
        System.out.println("--- * Agregar Producto * ---\n"
                + "Digite el nombre del producto: ");
        leer.nextLine();
        String nombre = leer.nextLine();

        System.out.println("Digite la descripcion del producto: ");
        String descripcion = leer.nextLine();
        System.out.println("Digite el precio: ");
        double precio = leer.nextDouble();
        System.out.println("Digite el descuento a aplicar: ");
        double descuento = leer.nextDouble();
        System.out.println("Digite el inventario: ");
        int inventario = leer.nextInt();

        List<Provedor> lp = new ArrayList<>();
        System.out.println("---- * Agregue uno o mas provedores:\n");
        boolean k = true;
        while (k) {
            System.out.println("Digite el ID del provedor: ");
            listProvedores.forEach((a) -> System.out.println(a));
            int id = leer.nextInt();
            lp.add(provedorDAO.obtener(id));
            System.out.println("Desea agregar mas provedores(S/N):");
            k = leer.next().toLowerCase().equals("s");
        }
        System.out.println("Agregando Producto "+nombre);
        productoDAO.crear(new Producto(nombre, descripcion, precio, descuento, inventario, lp));
        mementoMovimientos.MementoAgregadoProducto(new Producto(nombre, descripcion, precio, descuento, inventario, lp));
    }

    public void editarProducto() {
        //Inicializar lista de provedores registrados:
        List<Provedor> listProvedores = provedorDAO.obtenerTodos();
        List<Producto> listProductos = productoDAO.obtenerProductos();

        System.out.println("--- * Editar Productos * ---\n");
        productoDAO.obtenerProductos().forEach((a) -> System.out.println(a));
        System.out.println("Digite el codigo del producto a editar: ");
        int id = leer.nextInt();

        System.out.println("Que desea editar?\n1. Nombre.\n2. Descripcion."
                + "\n3. Precio.\n4. Descuento.\n5. Inventario.");
                //TODO :   + "\n6. Lista de Provedores.\n");
        String nuevoValorStr;
        double nuevoValorDoub;

        switch (leer.nextInt()) {
            case 1: {
                System.out.println("Digite el nuevo Nombre");
                leer.nextLine();                        
                nuevoValorStr = leer.nextLine();
                
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setNombre(nuevoValorStr);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 2: {
                System.out.println("Digite la nueva Descripcion");
                leer.nextLine();                        
                nuevoValorStr = leer.nextLine();
                
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setDescripcion(nuevoValorStr);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 3: {
                System.out.println("Digite el nuevo Precio");
                leer.nextLine();                        
                nuevoValorDoub = leer.nextDouble();
                
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setPrecio(nuevoValorDoub);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 4: {
                System.out.println("Digite el nuevo Descuento");
                leer.nextLine();                        
                nuevoValorDoub = leer.nextDouble();
                
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setDescuento(nuevoValorDoub);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 5: {
                System.out.println("Digite el Inventario");
                leer.nextLine();
                        
                nuevoValorDoub = leer.nextDouble();
                
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setInventario((int)nuevoValorDoub);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 6: {
                System.out.println("Digite el nuevo nombre");
                leer.nextLine();
                        
                String nuevoNombre = leer.nextLine();
                
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setNombre(nuevoNombre);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 7: {
               //TODO EDIT LISTA PROVEDORES...
            }
        }
    }

    public void eliminarProducto() {
        int idProductoAEliminar;
        Producto productoAEliminar=null;
        List<Producto> lstProductos=new ArrayList<>();
        lstProductos=productoDAO.obtenerProductos();
        for (Producto p : lstProductos) {
            System.out.println("Id: "+p.getId()+"\nNombre: "+p.getNombre()+"\nDescripcion: "+p.getDescripcion());
        }
        System.out.println("Ingrese el id del producto a eliminar.");
        idProductoAEliminar=leer.nextInt();
        for (Producto p : lstProductos) {
            
            if(p.getId()==idProductoAEliminar){
                productoAEliminar=p;
            }
        }
        if(productoAEliminar!=null){
            mementoMovimientos.MementoEliminadoProducto(productoAEliminar);
            System.out.println("Eliminando "+productoAEliminar.getNombre()+"con id "+productoAEliminar.getId());
        productoDAO.borrar(productoAEliminar);
        }else{
            System.out.println("No se pudo eliminar su producto.");
        }
        menuMantProductos();
    }

    public void verProductos() {
        //TODO
    }

    public void verInventarioProducto(String codigoProducto) {
        //TODO
    }

    //Acciones de sobre Promociones. 
    public void agregarPromocion() {
        //TODO    
    }

    public void editarPromocion() {
        //TODO     
    }

    public void eliminarPromocion() {
        //TODO     
    }

    public void verPromociones() {
        //TODO
    }

    //Acciones sobre Combos.
    public void agregarCombo() {
        //TODO
    }

    public void editarCombo() {
        //TODO
    }

    public void eliminarCombo() {
        //TODO
    }

    public void verCombos() {
        //TODO
    }

    //Acciones sobre Provedores.
    public void agregarProvedor() {
        ProvedorDAO provedor = new ProvedorDAO();

    }

    public void editarProvedor() {
        //TODO
    }

    public void eliminarProvedor() {
        //TODO
    }

    public void verProvedores() {
        //TODO
    }

    public void solicitarPedido() {
        //TODO
    }

    public void verPedidos() {
        //TODO
    }

    // -------------- MENUS ADMIN -----------   
    @Override
    public void menuPrincipal() {
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
    public void verMovimientosProductos(){
        int aux=1;
        System.out.println("==================================Productos agregados recientemente================================");
        for (Producto producto : mementoMovimientos.getLstMovimientosAgregadosProducto()) {
            System.out.println("Movimiento#"+aux);
            System.out.println(producto);
            aux=aux+1;
        }
        aux=1;
        System.out.println("==================================Productos eliminados recientemente================================");
        for (Producto producto : mementoMovimientos.getLstMovimientosEliminadosProducto()) {
            System.out.println("Movimiento#"+aux);
            System.out.println(producto);
            aux=aux+1;
        }
        int opc;
        System.out.println("Deseas deshacer algun movimiento(Si=1/No=2)");
        opc=leer.nextInt();
        if(opc==1){
            System.out.println("Desea deshacer un agregado(1) o un eliminado(2)");
            opc=leer.nextInt();
            if(opc==1){
                System.out.println("Ingrese el numero de movimiento referente en la lista de agregados");
                aux=leer.nextInt()-1;
                Producto productoRecuperadoAgregado=mementoMovimientos.getLstMovimientosAgregadosProducto().get(aux);
                mementoMovimientos.getLstMovimientosAgregadosProducto().remove(aux);
                productoDAO.crear(productoRecuperadoAgregado);
            }else if(opc==2){
                System.out.println("Ingrese el numero de movimiento referente en la lista de eliminados");
                aux=leer.nextInt()-1;
                Producto productoRecuperadoEliminado=mementoMovimientos.getLstMovimientosEliminadosProducto().get(aux);
                mementoMovimientos.getLstMovimientosEliminadosProducto().remove(aux);
                productoDAO.crear(productoRecuperadoEliminado);
            }
        }
        menuMantProductos();
    }
    public void menuMantProductos() {
        Memento mementoProducto=new Memento();
        System.out.print("OPCIONES DE PRODUCTO" + "\n"
                + "1. Agregar Producto" + "\n"
                + "2. Editar Producto" + "\n"
                + "3. Eliminar Producto" + "\n"
                + "4. Ver inventario mínimo" + "\n"
                + "5. Ver Productos" + "\n"
                + "6. Ver Movimientos hechos" + "\n"
                + "7. Regresar" + "\n"
                + "Elija una opción:"
        );

        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                agregarProducto();
                break;
            case 2:
                editarProducto();
                break;
            case 3:
                eliminarProducto();
                break;
            case 4:
                //verInventarioProducto();
                break;
            case 5:
                // verProductos();
                break;
            case 6:
                verMovimientosProductos();
                break;
            case 7:
                menuPrincipal();
                break;    
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

        switch (opcion) {
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

    public void menuMantCombos() {
        System.out.print("OPCIONES DE COMBO" + "\n"
                + "1. Agregar Combo" + "\n"
                + "2. Eliminar Combo" + "\n"
                + "3. Ver Combos" + "\n"
                + "4. Regresar" + "\n"
                + "Elija una opción:");
        int option = leer.nextInt();

        switch (option) {
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
