package edu.ulatina.diariofacil.model;

import edu.ulatina.diariofacil.dao.ComboDAO;
import edu.ulatina.diariofacil.dao.ItemDAO;
import edu.ulatina.diariofacil.dao.OrdenDAO;
import edu.ulatina.diariofacil.dao.ProductoDAO;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComportamientoCliente implements IComportamiento {

    List<Item> lstItemsOrden = new ArrayList<>();
    Memento mementoMovimientos = new Memento();
    ComboDAO comboDao = new ComboDAO();
    ItemDAO itemDao = new ItemDAO();
    ProductoDAO productoDAO = new ProductoDAO();
    OrdenDAO ordenDao = new OrdenDAO();
    Orden ordenCliente = new Orden();
    Scanner leer = new Scanner(System.in);

    @Override
    public void menuPrincipal() {
        System.out.println(
                "\n================================ Menu Principal ==================================\n"
                + "1. Ver productos.\n"
                + "2. Ver promociones.\n"
                + "3. Ver combos.\n"
                + "4. Ver carrito.\n"
                + "5. Ver movimientos.\n"
                + "6. Pagar orden.\n"
                + "7. Salir.\n"
                + "================================================================================\n"
                + "Elija una opcion:\n");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                menuVerProductos();
                break;
            case 2:
                menuVerPromociones();
                break;
            case 3:
                menuVercombos();
                break;
            case 4:
                menuVerItemsOrden();
                break;
            case 5:
                menuVerMovimientos();
                break;
            case 6:
                menuPagarOrden();
                break;
            case 7:
                System.out.println("\nSaliendo...\n");
                break;
        }
    }

    public void menuVerProductos() {
        int opc;
        int auxId, auxCantidad;
        Item nuevoItem = new Item();
        List<Producto> lstProductos = productoDAO.obtenerProductosSinPromo();
        for (Producto Producto : lstProductos) {
            System.out.println(Producto);
        }
        System.out.println("Deseas agregar un producto(Si=1/No=2)");
        opc = leer.nextInt();
        if (opc == 1) {
            System.out.println("Ingrese el id del producto a agregar");
            auxId = leer.nextInt();
            System.out.println("Ingrese la cantidad deseada");
            auxCantidad = leer.nextInt();
            for (Producto producto : lstProductos) {
                if (producto.getId() == auxId) {
                    nuevoItem = new Item(producto.getId(), producto.getNombre(), auxCantidad, producto.getPrecio() * auxCantidad);
                }
            }
            if (nuevoItem.getNombreProducto() != null) {
                mementoMovimientos.MementoAgregadoItem(nuevoItem);
                System.out.println("Producto " + nuevoItem.getNombreProducto() + " agregado con exito");
                lstItemsOrden.add(nuevoItem);
            }
        }

        menuPrincipal();
    }
    public void menuVerPromociones() {
        int opc;
        int auxId, auxCantidad;
        Item nuevoItem = new Item();
        List<Producto> lstProductos = productoDAO.obtenerProductosConPromo();
        for (Producto Producto : lstProductos) {
            System.out.println(Producto);
            
        }
        System.out.println("Deseas agregar una promocion(Si=1/No=2)");
        opc = leer.nextInt();
        if (opc == 1) {
            System.out.println("Ingrese el id de la promocion a agregar");
            auxId = leer.nextInt();
            System.out.println("Ingrese la cantidad deseada");
            auxCantidad = leer.nextInt();
            for (Producto producto : lstProductos) {
                if (producto.getId() == auxId) {
                    nuevoItem = new Item(producto.getId(), producto.getNombre(), auxCantidad, producto.getPrecio() * auxCantidad);
                }
            }
            if (nuevoItem.getNombreProducto() != null) {
                mementoMovimientos.MementoAgregadoItem(nuevoItem);
                System.out.println("promocion " + nuevoItem.getNombreProducto() + " agregado con exito");
                lstItemsOrden.add(nuevoItem);
            }
        }

        menuPrincipal();
    }

    public void menuVercombos() {
        int opc;
        int auxId, auxCantidad;
        Item nuevoItem = new Item();
        /*List<Producto> lstProductos = comboDao.;
        for (Producto Producto : lstProductos) {
            System.out.println(Producto);
        }
        System.out.println("Deseas agregar un producto(Si=1/No=2)");
        opc = leer.nextInt();
        if (opc == 1) {
            System.out.println("Ingrese el id del producto a agregar");
            auxId = leer.nextInt();
            System.out.println("Ingrese la cantidad deseada");
            auxCantidad = leer.nextInt();
            for (Producto producto : lstProductos) {
                if (producto.getId() == auxId) {
                    nuevoItem = new Item(producto.getId(), producto.getNombre(), auxCantidad, producto.getPrecio() * auxCantidad);
                }
            }
            if (nuevoItem.getNombreProducto() != null) {
                ordenCliente.getItems().add(nuevoItem);
            }
        }*/
        menuPrincipal();
    }

    public void menuVerItemsOrden() {
        Item auxItem = new Item();
        double auxPrecio;
        int opc, auxcounter, auxCantidadProducto;
        int auxNumItem, auxCantidad;
        auxcounter = 1;
        for (Item item : lstItemsOrden) {
            System.out.println("Item#" + auxcounter);
            System.out.println(item);
            auxcounter = auxcounter + 1;
        }
        System.out.println("Deseas eliminar un producto(Si=1/No=2)");
        opc = leer.nextInt();
        if (opc == 1) {
            System.out.println("Ingrese el numero del Producto a eliminar");
            auxNumItem = leer.nextInt();
            auxNumItem = auxNumItem - 1;
            System.out.println("Ingrese la cantidad a eliminar");
            auxCantidad = leer.nextInt();
            auxCantidadProducto = lstItemsOrden.get(auxNumItem).getCantidad();
            auxPrecio = auxCantidad / lstItemsOrden.get(auxNumItem).getSubtotal();
            lstItemsOrden.get(auxNumItem).setSubtotal(auxPrecio * auxCantidad);
            if (auxCantidad < auxCantidadProducto) {
                lstItemsOrden.get(auxNumItem).setCantidad(auxCantidadProducto - auxCantidad);
                auxItem.setId(lstItemsOrden.get(auxNumItem).getId());
                auxItem.setNombreProducto(lstItemsOrden.get(auxNumItem).getNombreProducto());
                auxItem.setSubtotal(auxPrecio * auxCantidad);
                auxItem.setCantidad(auxCantidad);
                System.out.println("Se a quitado " + auxCantidad + " de " + auxItem.getNombreProducto() + "de tu orden.");
                mementoMovimientos.MementoEliminadoItem(auxItem);
            } else if (auxCantidad == auxCantidadProducto) {
                mementoMovimientos.MementoEliminadoItem(lstItemsOrden.get(auxNumItem));
                System.out.println("Eliminando:\n" + lstItemsOrden.get(auxNumItem));
                lstItemsOrden.remove(auxNumItem);
            } else {
                System.out.println("No es posible, la cantidad que deseas quitar es erronea");
            }
        }
        menuPrincipal();
    }

    public void menuVerMovimientos() {
        int auxcounter, opc, aux;
        auxcounter = 1;
        System.out.println("==================================Items eliminados recientemente=============================");
        for (Object item : mementoMovimientos.getLstMovimientosEliminadosItems()) {
            System.out.println("Movimiento#" + auxcounter);
            System.out.println(item);
            auxcounter = auxcounter + 1;
        }
        auxcounter = 1;
        System.out.println("==================================Items agregados recientemente=============================");
        for (Object item : mementoMovimientos.getLstMovimientosAgregadosItems()) {
            System.out.println("Movimiento#" + auxcounter);
            System.out.println(item);
            auxcounter = auxcounter + 1;
        }
        System.out.println("Deseas deshacer algun movimiento(Si=1/No=2)");
        opc = leer.nextInt();
        if (opc == 1) {
            System.out.println("Desea deshacer un agregado(1) o un eliminado(2)");
            opc = leer.nextInt();
            if (opc == 1) {
                System.out.println("Ingrese el numero de movimiento referente en la lista de agregados");
                aux = leer.nextInt() - 1;
                Item itemRecuperadoAgregado = mementoMovimientos.getLstMovimientosAgregadosItems().get(aux);
                mementoMovimientos.getLstMovimientosAgregadosItems().remove(aux);
                lstItemsOrden.remove(itemRecuperadoAgregado);
            } else if (opc == 2) {
                System.out.println("Ingrese el numero de movimiento referente en la lista de eliminados");
                aux = leer.nextInt() - 1;
                Item itemRecuperadoEliminado = mementoMovimientos.getLstMovimientosEliminadosItems().get(aux);
                mementoMovimientos.getLstMovimientosEliminadosItems().remove(aux);
                lstItemsOrden.add(itemRecuperadoEliminado);
            }
        }
        menuPrincipal();
    }

    public void menuPagarOrden() {
        ordenCliente.setItems(lstItemsOrden);
        ordenCliente.setFecha(Time.valueOf(LocalTime.now()));
        ordenCliente.setId(lstItemsOrden.size() + mementoMovimientos.getLstMovimientosAgregadosItems().size());
        ordenCliente.setDescuento(lstItemsOrden.size() / 2);
        System.out.println(ordenCliente);
    }
}
