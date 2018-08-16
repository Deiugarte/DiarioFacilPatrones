package edu.ulatina.diariofacil.model;

import edu.ulatina.diariofacil.dao.ProductoDAO;
import edu.ulatina.diariofacil.dao.ProvedorDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;

public class ComportamientoAdmin implements IComportamiento {

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

        productoDAO.crear(new Producto(nombre, descripcion, precio, descuento, inventario, lp));
    }

    public void editarProducto() {
        //Inicializar lista de provedores registrados:
        List<Provedor> listProvedores = provedorDAO.obtenerTodos();
        List<Producto> listProductos = productoDAO.obtenerProductosSinPromo();

        System.out.println("--- * Editar Productos * ---\n");
        productoDAO.obtenerProductosSinPromo().forEach((a) -> System.out.println(a));
        System.out.println("Digite el codigo del producto a editar: ");
        int id = leer.nextInt();

        System.out.println("Que desea editar?\n1. Nombre.\n2. Descripcion."
                + "\n3. Precio.\n4. Descuento.\n5. Inventario.\n6. Salir al menu principal.");
        //TODO :   + "\n6. Lista de Provedores.\n");
        String nuevoValorStr;
        double nuevoValorDoub;

        switch (leer.nextInt()) {
            case 1: {
                System.out.println("Digite el nuevo Nombre");
                nuevoValorStr = leer.nextLine();
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setNombre(nuevoValorStr);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 2: {
                System.out.println("Digite la nueva Descripcion");
                nuevoValorStr = leer.nextLine();

                Producto duplicado = productoDAO.obtener(id);
                duplicado.setDescripcion(nuevoValorStr);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 3: {
                System.out.println("Digite el nuevo Precio");
                nuevoValorDoub = leer.nextDouble();
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setPrecio(nuevoValorDoub);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 4: {
                System.out.println("Digite el nuevo Descuento");
                nuevoValorDoub = leer.nextDouble();
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setDescuento(nuevoValorDoub);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 5: {
                System.out.println("Digite el Inventario");
                nuevoValorDoub = leer.nextDouble();
                Producto duplicado = productoDAO.obtener(id);
                duplicado.setInventario((int) nuevoValorDoub);
                productoDAO.actualizar(duplicado);
                break;
            }
            case 6: {
                menuPrincipal();
                break;
            }
            case 7: {
                //TODO EDIT LISTA PROVEDORES...
                break;
            }
        }
    }
    public void eliminarProducto() {
        System.out.println("Espere a que la lista de productos cargue por completo...");
        productoDAO.obtenerTodosLosProductos().forEach((a) -> System.out.println(a));
        System.out.println("Seleccione el id del producto que desea eliminar:");
        productoDAO.borrar(leer.nextInt());
    }

    public void verTodosLosProductos() {
        System.out.println("Listado de Promociones y Productos:");
        productoDAO.obtenerTodosLosProductos().forEach((a) -> System.out.println(a));
    }
    public void verProductosConPromo() {
        System.out.println("Listado de Promociones:");
        productoDAO.obtenerProductosConPromo().forEach((a) -> System.out.println(a));
    }
    
        public void verProductosSinPromo() {
        System.out.println("Listado de Productos SIN Promocion:");
        productoDAO.obtenerProductosSinPromo().forEach((a) -> System.out.println(a));
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
        List<Provedor> listProvedores = provedorDAO.obtenerTodos();
        System.out.println("--- * Agregar Provedor * ---\n"
                + "Digite el nombre del Provedor: ");
        leer.nextLine();
        String nombre = leer.nextLine();

        System.out.println("Digite el correo del Provedor: ");
        String correo = leer.nextLine();
        provedorDAO.crear(nombre, correo);
    }

    public void editarProvedor() {
        provedorDAO.obtenerTodos().forEach((a) -> System.out.println(a));
        System.out.println("--- * Editarr Provedor * ---\n"
                + "Digite el ID del Provedor a editar: ");
        int id = leer.nextInt();

        Provedor provedor = provedorDAO.obtener(id);

        System.out.println("Digite:\n1. Editar nombre del provedor.\n"
                + "2. Editar correo del provedor.");
        int opc = leer.nextInt();
        if (opc == 1) {
            System.out.println("Digite el nuevo nombre: ");
            leer.nextLine();
            provedor.setNombre(leer.nextLine());
        } else if (opc == 2) {
            System.out.println("Digite el nuevo correo: ");
            leer.nextLine();
            provedor.setCorreo(leer.nextLine());
        }
        provedorDAO.actualizar(provedor);
    }

    public void eliminarProvedor() {
        System.out.println("Espere a que la lista de provedores cargue por completo...");
        provedorDAO.obtenerTodos().forEach((a) -> System.out.println(a));
        System.out.print("Seleccione el id del provedor que desea eliminar:");
        provedorDAO.borrar(leer.nextInt());
    }

    public void verProvedores() {
        System.out.println("Listado de Provedores:");
        provedorDAO.obtenerTodos().forEach((a) -> System.out.println(a));
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
                + "3. Mantenimiento de Combo\n"
                + "4. Salir.\n\n------\n"
                + "Elija una opcion:\n");
        Scanner leer = new Scanner(System.in);
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                menuMantProductos();
                break;
            case 2:
                menuMantProvedores();
                break;
            case 3:
                menuMantCombos();
                break;
            case 4:                
                System.out.println("\nSaliendo...\n");
                return;
        }
    }

    public void volverMenuMantProductos() {
        leer.nextLine();
        System.out.println("Presione:\n1. Volver al Menu de mantenimiento de productos. \n2. Volver al menu principal.");
        switch (leer.nextInt()) {
            case 1:
                menuMantProductos();
                break;
            case 2:
                menuPrincipal();
                break;
            default:
                System.out.println("Error: numero incorrecto. Volviendo al menu principal...");
                menuPrincipal();
                break;
        }
    }

    //Menu productos listo.
    public void menuMantProductos() {
        System.out.print("OPCIONES DE PRODUCTO\n"
                + "1. Agregar Producto\n"
                + "2. Editar Producto\n"
                + "3. Eliminar Producto\n"
                + "4. Ver Todos los Productos\n"
                + "5. Ver Productos SIN Promocion.\n"
                + "6. Ver Productos CON Promocion.\n"
                + "7. Menu Principal" + "\n"
                + "Elija una opción:"
        );

        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                agregarProducto();
                volverMenuMantProductos();
                break;
            case 2:
                editarProducto();
                volverMenuMantProductos();
                break;
            case 3:
                eliminarProducto();
                volverMenuMantProductos();
                break;
            case 4:
                verTodosLosProductos();
                volverMenuMantProductos();
                break;
            case 5:
                verProductosSinPromo();
                volverMenuMantProductos();
                break;
            case 6:
                verProductosConPromo();
                volverMenuMantProductos();
                break;
            case 7:
                menuPrincipal();
                break;
        }
    }
    
    

    public void menuMantProvedores() {
        System.out.print("Mantenimiento de Provedores\n"
                + "1. Agregar Proveedor\n"
                + "2. Editar Proveedor\n"
                + "3. Eliminar Proveedor\n"
                + "4. Ver Proveedores\n"
                + "5. Ver Pedidos\n" // TODO
                + "6. Regresar\n"
                + "Digite una opcion:\n");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                agregarProvedor();
                volverMenuMantProvedores();
                break;
            case 2:
                editarProvedor();
                volverMenuMantProvedores();
                break;
            case 3:
                eliminarProvedor();
                volverMenuMantProvedores();
                break;
            case 4:
            verProvedores();
            volverMenuMantProvedores();
            case 5:
            // TODO TODO verPedidos();
            case 6:
            menuPrincipal();
            break;
                    
        }
    }

        public void volverMenuMantProvedores() {
        leer.nextLine();
        System.out.println("Presione:\n1. Volver al Menu de mantenimiento de Provedores. \n2. Volver al menu principal.");
        switch (leer.nextInt()) {
            case 1:
                menuMantProvedores();
            case 2:
                menuPrincipal();
                break;
            default:
                System.out.println("Error: numero incorrecto. Volviendo al menu principal...");
                menuPrincipal();
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
                menuPrincipal();
        }
    }

}
