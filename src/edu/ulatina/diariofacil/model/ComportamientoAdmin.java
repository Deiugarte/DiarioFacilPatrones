package edu.ulatina.diariofacil.model;

import edu.ulatina.diariofacil.dao.ProductoDAO;
import edu.ulatina.diariofacil.dao.ProvedorDAO;
import java.util.ArrayList;
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
                duplicado.setInventario((int) nuevoValorDoub);
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
        System.out.println("Espere a que la lista de productos cargue por completo...");
        productoDAO.obtenerProductos().forEach((a) -> System.out.println(a));
        System.out.println("Seleccione el id del producto que desea eliminar:");
        productoDAO.borrar(leer.nextInt());
    }

    public void verProductos() {
        System.out.println("Listado de productos:");
        productoDAO.obtenerProductos().forEach((a) -> System.out.println(a));
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

    public void volverMenuMantProductos() {
        leer.nextLine();
        System.out.println("Presione:\n1. Volver al Menu de mantenimiento de productos. \n2. Volver al menu principal.");
        switch (leer.nextInt()) {
            case 1:
                menuMantProductos();
            case 2:
                menuPrincipal();
                break;
            default:
                System.out.println("Error: numero incorrecto. Volviendo al menu principal...");
                menuPrincipal();
                break;
        }
    }

    public void menuMantProductos() {
        System.out.print("OPCIONES DE PRODUCTO" + "\n"
                + "1. Agregar Producto" + "\n"
                + "2. Editar Producto" + "\n"
                + "3. Eliminar Producto" + "\n"
                + "4. Ver Productos" + "\n"
                //+ "5. Ver Productos" + "\n"
                + "5. Menu Principal" + "\n"
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
                break;
            case 3:
                eliminarProducto();
                break;
            case 4:
                verProductos();
                break;
            case 5:
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
