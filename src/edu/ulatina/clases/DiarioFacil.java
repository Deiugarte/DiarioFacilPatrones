
package edu.ulatina.clases;

import edu.ulatina.recuperar.RecuperarAccion;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class DiarioFacil {
    private String nombre;
    private RecuperarAccion recuperar=new RecuperarAccion();
    //Loggeado como
    Cliente cliLogged;
    Admin admLogged;

    //Ordenes del Cliente loggeado.
    private List<Orden> listOrdCli = new ArrayList<>();

    //Contenedores.
    private List<Cliente> listClientes = new ArrayList<>();
    private List<Admin> listAdmins = new ArrayList<>();

    private List<Orden> listOrdenes = new ArrayList<>();
    private List<Producto> listProductos = new ArrayList<>();
    private List<Promocion> listPromociones = new ArrayList<>();
    private List<Combo> listCombos = new ArrayList<>();
    private List<Proveedor> listProveedores = new ArrayList<>();
    private List<Pedido_Proveedor> listPedidos = new ArrayList<>();
    private List<String> listCategorias = new ArrayList<String>();

    public List<Proveedor> getListProveedores() {
        return listProveedores;
    }

    //input.
    Scanner sc = new Scanner(System.in);

    //Implementaciones.
    public DiarioFacil(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getListCategorias() {
        return listCategorias;
    }

    public void registrarCliente() {
        Scanner sc = new Scanner(System.in);
        String ced, tel, nom, ape, corr, log, cont;
        try {
            //Recolectar info personal

            System.out.println("---------- Registro de Usuario ----------");

            System.out.println("--- Digite su informacion:");

            System.out.println("Digite su cedula:");
            ced = sc.next();

            System.out.println("Digite su nombre:");
            nom = sc.next();

            System.out.println("Digite su apellido:");
            ape = sc.next();

            System.out.println("Digite su correo:");
            corr = sc.next();

            System.out.println("Digite su telefono:");
            tel = sc.next();

            System.out.println("--- Crear Usuario:"
                    + "\nEscoja su login:");
            log = sc.next();

            System.out.println("Escoja su contraseña:");
            cont = sc.next();

            System.out.println("** Usuario Creado con Exito! **"
                    + "\n\n **Redirigiendo");

            listClientes.add(new Cliente(this, ced, tel, nom, ape, corr, log, cont));

        } catch (Exception ex) {
            System.out.println("Datos invalidos!"
                    + "\n Intentar de nuevo? (S/N)\n");
            if (sc.next().equals("S")) {
                this.registrarCliente();
            }
        }
    }

    public void registrarAdmin(String nombre, String apellido, String correo, String login, String contraseña) {
        listAdmins.add(new Admin(this, nombre, apellido, correo, login, contraseña));
    }

    public Usuario iniciarSesion() {

        String login,
                pwrd,
                prompt;

        System.out.println("Digite su login:");
        login = sc.next();

        System.out.println("Digite su contraseña:");
        pwrd = sc.next();

        try {

            //Recorrer lista de Admin primero ya que hay pocos...
            for (Admin a : listAdmins) {
                if (a.getLogin().equals(login) && a.getContraseña().equals(pwrd)) {
                    return admLogged = (Admin) a;
                }
            }

            //Si no esta en admin, buscar como cliente.
            for (Cliente c : listClientes) {
                if (c.getLogin().equals(login) && c.getContraseña().equals(pwrd)) {
                    cliLogged = (Cliente) c;

                    //Cargar ordenes del Cliente.
                    for (Orden o : listOrdenes) {
                        if (o.getCliente().getLogin().equals(c.getLogin())) {
                            listOrdCli.add(o);
                        }
                    }

                    //Determinar si es clientefrecuente.
                    if (listOrdCli.size() > 4) {
                        cliLogged.setClienteFrecuente(true);
                    }
                    return cliLogged;
                }
            }

            //Si no se coincide con usuarios de listAdmins o listClientes.
            throw new Exception("Usuario o Contraseña incorrectos");
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "\n"
                    + "Desea intentar de nuevo? (S/N): \n");
            prompt = sc.next();
            if (prompt.equals("S") || prompt.equals("s")) {
                menuInicio();
            } else {
                System.out.println("** Saliendo... \n Gracias por Visitarnos **  \n");
            }
        }
        return null;
    }

    public void menuInicio() {
        int path = 0;

        System.out.println("DiarioFacil.com, aqui todo lo encuentra!\n\n"
                + "Digite:\n"
                + "1. Ingresar.\n"
                + "2. Registrarse.\n"
                + "3. Salir.\n"
        );

        //Validar input
        try {
            path = sc.nextInt();

            if (!(0 < path && path < 4) && path % 2 != 0) {
                throw new Exception("Ingrese un valor que este en la lista.");
            }
        } catch (Exception ex) {
            String error = "Valor Invalido! ";
            if (ex.getMessage() != null) {
                error.concat(ex.getMessage());
            }
            System.out.println(error);
        }

        //Determinar flujo del programa.
        switch (path) {
            case 1: //Ingresar al sistema.
                if (iniciarSesion() instanceof Cliente) {
                    menuPrincipalCliente(true);
                } else if (admLogged != null) {
                    bienvenidoAdmin();
                    menuAdmin();
                }
                break;
            case 2: //Registrar Usuario:

                this.registrarCliente();

                System.out.println("\nExito... redirigiendo! \n");
                menuInicio();
                break;
            case 3:
                System.out.println("** Saliendo... \n Gracias por Visitarnos **  \n");
                break;

            default:
                System.out.println("** Saliendo... \n Gracias por Visitarnos **  \n");
                break;
        }
    }

    public void menuBienvenida() {
        //Pantalla de bienvenida.
        System.out.println("---- Bienvenid@, " + cliLogged.getNombre() + ".");

        //Mostrar Promociones si es cliente Frecuente.
        if (!cliLogged.getClienteFrecuente()) {
            //Mostrar promociones:
            System.out.println("Desea ver las promociones para "
                    + "clientes frecuentes? 1 = Si | 2 = No \n");
            if (sc.nextInt() == 1) {
                System.out.println(mostrarPromociones());
            }
        }

        //Mostrar Ultima Orden.
        System.out.println("Desea ver su ultima orden?"
                + " 1 = Si | 2 = No \n");
        if (sc.nextInt() == 1) {
            if (listOrdCli.isEmpty()) {
                System.out.println("* Usted no tiene ordenes *");
            } else {
                System.out.println(
                        listOrdCli.get(listOrdCli.size() - 1).toString());

            }
        }

        //Ofrecer comprar de nuevo esta orden.
    }

    public void volverMenuPrincipalCliente() {
        System.out.println("\nDigite:\n"
                + "1. Volver al menu principal.\n"
                + "2. Cerrar programa.");
        if (sc.nextInt() == 1) {
            menuPrincipalCliente(false);
        } else {
            System.out.println("** Saliendo... \n Gracias por Visitarnos **  \n");
            System.exit(0);
        }
    }

    public void menuPrincipalCliente(boolean k) {
        //Recuperar accion empieza aqui(Aplicacion del patron Memento)
   
        if (k) { //Mostrar o no pantalla de bienvenida.
            menuBienvenida();
        }

        //Menu del Cliente.
        System.out.println("-- Menu Principal\nDigite:\n"
                + "1. Ver Productos Individuales.\n"
                + "2. Ver Productos con Promocion.\n"
                + "3. Ver Combos Disponibles.\n"
                + "4. Ver Carrito.\n"
                + "5. Ver mi ordenes recientes.\n"
                + "6. Recuperar eliminaciones hechas.\n"
                + "6. Ver mi Perfil.\n"
                + "7. Salir.\n"
        );

        int path = 1;
        //Validar input.
        try {
            path = sc.nextInt();

            if (!(0 < path && path < 8) && path % 2 != 0) {
                throw new Exception("Ingrese un valor que este en la lista.");
            }
        } catch (Exception ex) {
            String error = "Valor Invalido! ";
            if (ex.getMessage() != null) {
                error.concat(ex.getMessage());
            }
            System.out.println(error);
        }

        //Determinar flujo del programa.
        switch (path) {

            case 1: //Ver Productos.
                while (true) {
                    System.out.println("-- Nuestros Productos:\n"
                            + mostrarProductos());

                    //Ofrecer agregar al carrito.
                    System.out.println("Desea agregar productos al carrito?"
                            + " 1 = Si | 2 = No");

                    if (sc.nextInt() == 1) {
                        //Agregar al carrito por numero de producto.

                        System.out.println("-- Nuestros Productos:\n"
                                + mostrarProductos());

                        System.out.println("Para agregar un producto al carrito,"
                                + " digite el numero de producto"
                                + " seguido de la tecla Enter.");

                        int item = sc.nextInt();

                        System.out.println("Digite la cantidad que necesita del producto: ");

                        int cantidad = sc.nextInt();

                        //El 1 en agregarCarrito() indica que se agregara
                        //un producto...
                        agregarACarrito(1, item, cantidad);
                    } else {
                        volverMenuPrincipalCliente();
                    }
                }

            case 2: //Ver Promociones.
                while (true) {
                    System.out.println("-- Nuestros Productos en Promocion:\n"
                            + mostrarPromociones());

                    //Ofrecer agregar al carrito.
                    System.out.println("Desea agregar promociones al carrito?"
                            + " 1 = Si | 2 = No");

                    if (sc.nextInt() == 1) {
                        //Agregar al carrito por numero de producto.
                        System.out.println("-- Nuestros Productos en Promocion:\n"
                                + mostrarPromociones());

                        System.out.println("Para agregar un producto al carrito,"
                                + " digite el numero de producto"
                                + " seguido de la tecla Enter.");

                        int item = sc.nextInt();

                        System.out.println("Digite la cantidad que necesita del producto: ");

                        int cantidad = sc.nextInt();

                        //El 2 en agregarCarrito() indica que se agregara
                        //una Promocion.
                        agregarACarrito(2, item, cantidad);
                    } else {
                        volverMenuPrincipalCliente();
                    }
                }
            case 3: //Ver Combos.
                while (true) {

                    System.out.println("-- Nuestros Combos:\n"
                            + mostrarCombos());

                    //Ofrecer agregar al carrito.
                    System.out.println("Desea agregar combos al carrito?"
                            + " 1 = Si | 2 = No");

                    if (sc.nextInt() == 1) {
                        //Agregar al carrito por numero de Combo.

                        System.out.println("-- Nuestros Combo:\n"
                                + mostrarCombos());

                        System.out.println("Para agregar un combo al carrito,"
                                + " digite el numero de combo"
                                + " seguido de la tecla Enter.");

                        int item = sc.nextInt();

                        System.out.println("Digite la cantidad que necesita del combo: ");

                        int cantidad = sc.nextInt();

                        //El 3 en agregarCarrito() indica que se agregara
                        //un combo...
                        agregarACarrito(3, item, cantidad);

                    } else {
                        volverMenuPrincipalCliente();

                    }
                }
            case 4://Ver carrito.
                String carrito = "";
                int total = 0;
                System.out.println("Carrito:\n");
                for (Item i : cliLogged.getCarrito().getItems()) {
                    carrito += i.toString();
                    total += i.subtotal;
                }

                System.out.println(carrito);
                System.out.println("Subtotal de los productos en carrito: " + total);
                // System.out.println(cliLogged.getCarrito().getItems().toString());
                
                //Ofrecer eliminar del carrito.
                    System.out.println("Desea eliminar algo de su carrito?"
                            + " 1 = Si | 2 = No");
                    
                    if (sc.nextInt() == 1) {
                        //Agregar al carrito por numero de Combo.

                        System.out.println("Para quitar de su carrito,"
                                + " digite el nombre del item"
                                + " seguido de la tecla Enter.");

                        String item = sc.next();

                        System.out.println("Digite la cantidad que desee quitar: ");

                        int cantidad = sc.nextInt();

                        //El 3 en agregarCarrito() indica que se agregara
                        //un combo...
                        EliminarACarrito(cliLogged.getCarrito(), item, cantidad);

                    } else {
                        volverMenuPrincipalCliente();

                    }

                volverMenuPrincipalCliente();

                break;

            case 5://Mostrar 5 ordenes mas recientes.
                System.out.println("-- Ordenes recientes:\n" + mostrarNordenes(5));
                mostrarNordenes(5);
                break;
                
            case 6://Mostrar acciones hechas y revertir las deseadas
                String carritoRecuperar = "";
                int totalRecuperar = 0;
                System.out.println("Carrito:\n");
                int aux=1;
                for (Item i : recuperar.getItemGuardar()) {
                    carritoRecuperar +="Movimiento #"+(aux)+":\n"+ i.toString();
                    aux=aux+1;
                }

                System.out.println(carritoRecuperar);
                // System.out.println(cliLogged.getCarrito().getItems().toString());
                
                //Ofrecer eliminar del carrito.
                    System.out.println("Desea recuperar algo de su carrito?"
                            + " 1 = Si | 2 = No");
                    
                    if (sc.nextInt() == 1) {
                        //Agregar al carrito por numero de Combo.

                        System.out.println("Para recuperar de su carrito,"
                                + " digite el numero de movimiento"
                                + " seguido de la tecla Enter.");

                        int movimiento = sc.nextInt();
                        
                        RecuperarACarrito(cliLogged.getCarrito(), movimiento);

                    } else {
                        volverMenuPrincipalCliente();

                    }

                volverMenuPrincipalCliente();
                break;
                
            case 7://Ver Perfil .               
                System.out.println("Mi Perfil:\n" + cliLogged.toString());
                volverMenuPrincipalCliente();
                break;
            case 8://Salir.

                System.out.println("** Saliendo... \n Gracias por Visitarnos **  \n");
                System.exit(0);
                break;
            default:
                System.out.println("** Saliendo... \n Gracias por Visitarnos **  \n");
                break;
        }
    }

    public String mostrarProductos() {
        if (listProductos.isEmpty()) {
            return "No se han encontrado productos, favor intente mas tarde.";
        }

        String prods = "";
        int i = 0;
        for (Producto p : listProductos) {
            prods += "Producto #" + ++i + ":\n"
                    + p.getNombre()
                    + ".\nPrecio: "
                    + p.getPrecio()
                    + ".\n\n";
        }
        return prods;
    }

    public String mostrarPromociones() {
        if (listPromociones.isEmpty()) {
            return "No hay promociones en este momento... Intente mas tarde.";
        }

        String promos = "";
        int i = 0;
        for (Promocion p : listPromociones) {
            promos += "Promo #" + ++i + ":\n"
                    + p.getNombrePromocion()
                    + ".\nPrecio: "
                    + p.getPrecio()
                    + ".\n\n";
        }
        return promos;
    }

    public String mostrarCombos() {
        if (listCombos.isEmpty()) {
            return "No se han encontrado combos, favor intente mas tarde.";
        }

        String combos = "";
        int i = 0;
        for (Combo c : listCombos) {
            combos += "Combo #" + ++i + ":\n"
                    + c.getNombreDeCombo()
                    + ".\nPrecio: "
                    + c.getPrecioDeCombo()
                    + ".\n\n";
        }
        return combos;
    }

    public String mostrarNordenes(int n) {
        if (listOrdCli.isEmpty()) {
            return "No hay ordenes para mostrar.";
        }

        String nOrdenes = "";

        //Si el cliente tiene menos de n ordenes, muestra las que tiene.
        if (listOrdCli.size() < n) {
            for (Orden o : listOrdCli) {
                nOrdenes += "\n" + o.toString();
            }
            return nOrdenes;
        }

        //Muestra n ordenes. 
        for (int i = 0; i < n; i++) {
            nOrdenes += listOrdCli.get(i).toString();
        }
        return nOrdenes;
    }

    //Mantenimiento de cuenta.
    void cambiarContraseña(String login, String newPwrd) {
        for (Admin a : listAdmins) {
            if (a.getLogin() == login) {
                a.setContraseña(newPwrd);
            }

        }
        for (Cliente a : listClientes) {
            if (a.getLogin() == login) {
                a.setContraseña(newPwrd);
            }
        }
    }

    public void agregarACarrito(int tipoItem, int itemElegido, int cantidad) {
        //Var tipoItem determina si se esta ingresando un 
        // Producto, una Promo o un Combo.
        // 1 - Producto, 2 - Promo, 3 - Combo. 

        switch (tipoItem) {
            case 1://Agrega un producto.
                Producto producto = listProductos.get(itemElegido - 1);

                cliLogged.getCarrito().getItems().add(
                        new Item(
                                cantidad,
                                producto.getNombre(),
                                producto.getPrecio())
                );
                break;
            case 2://Agrega una Promocion.
                Promocion promo = listPromociones.get(itemElegido - 1);

                cliLogged.getCarrito().getItems().add(
                        new Item(
                                cantidad,
                                promo.getNombrePromocion(),
                                promo.getPrecio())
                );
                break;
            case 3://Agrega un Combo.
                Combo combo = listCombos.get(itemElegido - 1);
                cliLogged.getCarrito().getItems().add(
                        new Item(
                                cantidad,
                                combo.getNombreDeCombo(),
                                combo.getPrecioDeCombo())
                );

                break;
        }
    }
    public void EliminarACarrito(Carrito carritoCliente, String itemElegido, int cantidad) {
        Item aux=null;
        //Inicia recorriendo la lista del carrito.

        if (cantidad>0) {
            for (Item i : carritoCliente.getItems()) {
                
                if (i.nombre.compareTo(itemElegido)==0) {
                    if (i.cantidad == cantidad) {
                        
                       aux=i;
                        this.recuperar.addMemento(aux);
                        carritoCliente.getItems().remove(i);
                        System.out.println("Se a eliminado el producto.");
                    }else if(i.cantidad>cantidad){
                        for (Producto p : listProductos) {
                            if(p.nombre.compareTo(itemElegido)==0){
                                i.subtotal=i.subtotal-(p.precio*cantidad);
                                aux=new Item(cantidad, i.nombre, (p.precio*cantidad));
                                try
                                {
                                    this.recuperar.addMemento(aux);
                                }
                                catch(Exception e)
                                {
                                    System.out.println("error< "+ e);
                                }
                            }
                        }
                        i.cantidad = i.cantidad - cantidad;
                        
                        System.out.println("Se le a restado "+ cantidad + " al item "+i.nombre);
                    }else if(cantidad>i.cantidad){
                        System.out.println("La cantidad ingresada es mayor a la que tenias, intentalo de nuevo.");
                    }
                }
            }
        }else if(cantidad<=0){
            System.out.println("No es posible remover con numeros negativos o igual a cero.");
        }

    }
    public void RecuperarACarrito(Carrito carritoCliente, int movimiento) {
        movimiento=movimiento-1;
        carritoCliente.getItems().add(recuperar.getMemento(movimiento));
        System.out.println("Se recupero:\nMovimiento #"+(movimiento+1)+":\n"+recuperar.getMemento(movimiento));
        

    }

    // GETS & SETS.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliLogged() {
        return cliLogged;
    }

    public void setCliLogged(Cliente cliLogged) {
        this.cliLogged = cliLogged;
    }

    public Admin getAdmLogged() {
        return admLogged;
    }

    public void setAdmLogged(Admin admLogged) {
        this.admLogged = admLogged;
    }

    public List<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public List<Admin> getListAdmins() {
        return listAdmins;
    }

    public void setListAdmins(List<Admin> listAdmins) {
        this.listAdmins = listAdmins;
    }

    public List<Orden> getListOrdenes() {
        return listOrdenes;
    }

    public void setListOrdenes(List<Orden> listOrdenes) {
        this.listOrdenes = listOrdenes;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<Promocion> getListPromociones() {
        return listPromociones;
    }

    public void setListPromociones(List<Promocion> listPromociones) {
        this.listPromociones = listPromociones;
    }

    public List<Combo> getListCombos() {
        return listCombos;
    }

    public void setListCombos(List<Combo> listCombos) {
        this.listCombos = listCombos;
    }

    public void menuAdmin() {

        System.out.println(
                "1. Opciones de Producto" + "\n"
                + "2. Opciones de Proveedor" + "\n"
                + "3. Opciones de Promocion" + "\n"
                + "4. Opciones de Combo" + "\n"
                + "" + "\n"
                + "Elija la opción: ");
        Scanner leer = new Scanner(System.in);
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                menuProducto();
                break;
            case 2:
                menuProveedor();
                break;
            case 3:
                menuPromocion();
                break;
            case 4:
                menuCombo();
                break;
        }

    }

    public void menuProducto() {
        System.out.print("OPCIONES DE PRODUCTO" + "\n"
                + "1. Agregar Producto" + "\n"
                + "2. Editar Producto" + "\n"
                + "3. Eliminar Producto" + "\n"
                + "4. Ver inventario mínimo" + "\n"
                + "5. Ver Productos" + "\n"
                + "6. Regresar" + "\n"
                + "Elija una opción:"
        );
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                AdminAgregaProducto();
                break;
            case 2:
                AdminEditaProducto();
                break;
            case 3:
                AdminEliminaProducto();
                break;
            case 4:
                verInventarioProducto();
                break;
            case 5:
                verProductos();
                break;
            case 6:
                menuAdmin();
        }
    }

    public void verProductos() {
        System.out.println("===LISTA DE PRODUCTOS===" + "\n");
        for (Producto a : listProductos) {
            System.out.println(a.toString() + "\n");
        }
        menuProducto();
    }

    public void AdminAgregaProducto() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Nombre de Producto: ");
        String nombrePro = leer.nextLine();
        System.out.println("Precio de Producto: ");
        int precio = leer.nextInt();
        System.out.println("Cantidad inicial en bodega: ");
        int cantidad = leer.nextInt();
        System.out.println("Cantidad mínima en bodega: ");
        int cantidadMin = leer.nextInt();
        System.out.println("¿Cuál es la categoría?");
        int b;
        for (b = 0; b < listCategorias.size(); b++) {
            System.out.println((b + 1) + ". " + listCategorias.get(b));
        }
        System.out.println("Seleccione la categoría");
        int categoria = leer.nextInt();
        System.out.println("¿Cuál de estos es el proveedor?");
        int i = 0;
        for (Proveedor a : listProveedores) {
            i++;
            System.out.print(i + ". " + a.toString());
        }
        System.out.println(i + 1 + ". Agregar nuevo Proveedor");
        int proveedor = leer.nextInt();

        if (proveedor == i + 1) {
            Scanner leer2 = new Scanner(System.in);
            System.out.println("¿Cual es el nombre de la empresa: ");
            String empresa = leer2.nextLine();
            System.out.println("¿Cual es el nombre del representante: ");
            String representante = leer2.nextLine();
            System.out.println("Cual es el correo");
            String correo = leer2.nextLine();
            System.out.println("Cual es el telefono: ");
            int telefono = leer2.nextInt();

            System.out.println(empresa + " es un nuevo proveedor y " + nombrePro + " es un nuevo producto de DiarioFacil!");
            listProveedores.add(new Proveedor(empresa, representante, correo, telefono));
            listProductos.add(new Producto(nombrePro, precio,
                    nombrePro.substring(0, nombrePro.length() - (nombrePro.length() / 2)),
                    cantidad, cantidadMin, listProveedores.get(listProveedores.size() - 1), listCategorias.get(categoria - 1)));
            menuProducto();
        }
        if (proveedor <= i) {
            //(String nombre, int precio, String codigo, int cantidad, int inventarioMinimo, Proveedor proveedor, String miCategoria)
            listProductos.add(new Producto(nombrePro, precio,
                    nombrePro.substring(0, nombrePro.length() - (nombrePro.length() / 2)),
                    cantidad, cantidadMin, listProveedores.get(proveedor - 1), listCategorias.get(categoria - 1)));

            System.out.println(nombrePro + " es un nuevo producto!" + "\n");
            menuProducto();

        }

    }

    public void AdminEditaProducto() {
        System.out.println("===LISTA DE PRODUCTO===" + "\n");
        int i = 0;
        for (Producto a : listProductos) {
            i++;
            System.out.println(i + ". " + a.toString());
        }
        System.out.println("\n" + "Cuál Producto quiere editar?" + "\n"
                + "Digite el índice del producto: ");

        int producto = sc.nextInt();

        System.out.println("¿Qué gusta modificar de " + listProductos.get(producto - 1).getNombre() + "?" + "\n"
                + "1. Nombre " + "\n"
                + "2. Precio " + "\n"
                + "3. Inventario Minimo" + "\n"
                + "4. Proveedor");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Digite nuevo nombre para " + listProductos.get(producto - 1).getNombre());
                String nuevoNombre = sc.next();
                listProductos.get(producto - 1).setNombre(nuevoNombre);
                System.out.println("El nombre ha sido exitosamente cambiado a " + nuevoNombre);
                menuProducto();
                break;
            case 2:
                System.out.print("Digite nuevo precio para " + listProductos.get(producto - 1).getNombre());
                int precio = sc.nextInt();
                listProductos.get(producto - 1).setPrecio(precio);
                System.out.println("El Precio ha sido exitosamente cambiado a " + precio);
                menuProducto();
                break;
            case 3:
                System.out.print("¿Cuánto debe ser el inventario mínimo?");
                int inventarioMin = sc.nextInt();
                System.out.println("El inventario mínimo ahora será " + inventarioMin);
                listProductos.get(producto - 1).setInventarioMinimo(inventarioMin);
                menuProducto();
                break;
            case 4:
                System.out.println("¿Cuál de estos debería ser el proveedor?");
                i = 0;
                for (Proveedor a : listProveedores) {
                    i++;
                    System.out.println(i + ". " + a.toString());

                }
                System.out.println(i + 1 + ". " + "Agregar nuevo proveedor:__________" + "\n");
                System.out.println("Digite el indice del proveedor correspondiente: " + "\n");
                int proveedor = sc.nextInt();
                if (proveedor <= listProveedores.size()) {
                    listProductos.get(producto - 1).setProveedor(listProveedores.get(proveedor - 1));
                    System.out.println("El proveedor ha sido actualizado a "
                            + listProveedores.get(proveedor - 1).getNombreEmpresa());
                    menuProducto();
                } else if (proveedor == i + 1) {
                    Scanner leer2 = new Scanner(System.in);
                    System.out.println("¿Cual es el nombre de la empresa: ");
                    String empresa = leer2.nextLine();
                    System.out.println("¿Cual es el nombre del representante: ");
                    String representante = leer2.nextLine();
                    System.out.println("Cual es el correo");
                    String correo = leer2.nextLine();
                    System.out.println("Cual es el telefono: ");
                    int telefono = leer2.nextInt();

                    System.out.println(empresa + " es un nuevo proveedor y ha sido actualizado en " + listProductos.get(producto - 1).getNombre());
                    listProveedores.add(new Proveedor(empresa, representante, correo, telefono));
                    listProductos.get(producto - 1).setProveedor(listProveedores.get(listProveedores.size() - 1));
                    menuProducto();
                }
        }

    }

    public void AdminEliminaProducto() {
        System.out.println("====ELIMINAR PRODUCTO===" + "\n"
                + "¿Cuál de estos productos quieres eliminar?");
        int i = 0;
        for (Producto a : listProductos) {
            i++;
            System.out.println(i + ". " + a.toString());
        }
        System.out.println("Digite el indice del producto: ");
        int producto = sc.nextInt();
        System.out.println(listProductos.get(producto - 1).nombre + " ha sido eliminado exitosamente!");
        listProductos.remove(producto - 1);

        menuProducto();
    }

    public void verInventarioProducto() {
        System.out.println("===INVENTARIO DE PRODUCTOS===" + "\n");
        for (Producto a : listProductos) {
            System.out.print("++++" + a.getNombre() + "(" + a.getCantidad() + "/" + a.getInventarioMinimo() + ")" + "++++");
            if (a.cantidad < a.getInventarioMinimo()) {
                System.out.print("[FALTA DE MERCADERIA]");
            }
            System.out.println("\n");
        }
        menuProducto();
    }

    public void menuPromocion() {
        System.out.println("OPCIONES DE PROMOCION" + "\n"
                + "1.Agregar Promoción" + "\n"
                + "2.Eliminar Promoción" + "\n"
                + "3.Ver Promociones" + "\n"
                + "4. Regresar" + "\n"
                + "Digite una opcion: " + "\n"
        );
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                agregarPromocion();
                break;
            case 2:
                eliminarPromocion();
                break;
            case 3:
                verPromociones();
                break;
            case 4:
                menuAdmin();
                break;

        }

    }

    public void menuCombo() {
        System.out.print("OPCIONES DE COMBO" + "\n"
                + "1. Agregar Combo" + "\n"
                + "2. Eliminar Combo" + "\n"
                + "3. Ver Combos" + "\n"
                + "4. Regresar" + "\n"
                + "Elija una opción:");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                agregarCombo();
                break;
            case 2:
                eliminarCombo();
                break;
            case 3:
                verCombos();
            case 4:
                menuAdmin();

        }
    }

    public void menuProveedor() {
        System.out.print("OPCIONES DE PROVEEDORES" + "\n"
                + "1. Agregar Proveedor" + "\n"
                + "2. Editar Proveedor" + "\n"
                + "3. Eliminar Proveedor" + "\n"
                + "4. Solicitar pedido" + "\n"
                + "5. Ver Proveedores" + "\n"
                + "6. Ver Pedidos" + "\n"
                + "7.Regresar" + "\n"
                + "Digite una opcion: " + "\n");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                agregarProveedor();
                break;
            case 2:
                editarProveedor();
                break;
            case 3:
                eliminarProveedor();
                break;
            case 4:
                solicitarPedido();
                break;
            case 5:
                verProveedores();
            case 6:
                verPedidos();
            case 7:
                menuAdmin();

        }

    }

    public void verProveedores() {
        System.out.println("===LISTA DE PROVEEDORES===" + "\n");
        for (Proveedor a : listProveedores) {
            System.out.print(a.toString());
        }
        menuProveedor();
    }

    public void verPedidos() {
        System.out.println("===LISTA DE PEDIDOS===" + "\n");
        for (Pedido_Proveedor a : listPedidos) {
            System.out.print(a.toString());
        }
        menuProveedor();
    }

    public void agregarProveedor() {
        //Proveedor(String nombreEmpresa, String personaEncargada, String correo, int telefono)
        Scanner leer = new Scanner(System.in);
        System.out.println("¿Cual es el nombre de la empresa: ");
        String empresa = leer.nextLine();
        System.out.println("¿Cual es el nombre del representante: ");
        String representante = leer.nextLine();
        System.out.println("Cual es el correo");
        String correo = leer.nextLine();
        System.out.println("Cual es el telefono: ");
        int telefono = leer.nextInt();

        System.out.println(empresa + " es un nuevo proveedor de DiarioFacil!" + "\n");
        listProveedores.add(new Proveedor(empresa, representante, correo, telefono));
        menuProveedor();
    }

    public void editarProveedor() {
        int i = 0;
        System.out.print("===EDITAR PROVEEDOR===" + "\n"
                + "¿Cuál proveedor quieres editar?" + "\n");
        for (Proveedor a : listProveedores) {
            i++;
            System.out.print(i + ". " + a.toString());
        }
        System.out.println("Digita el indice del proveedor deseado: " + "\n");
        int proveedor = sc.nextInt();
        System.out.println("¿Qué quieres editar de " + listProveedores.get(proveedor - 1).getNombreEmpresa() + "? " + "\n"
                + "1. Nombre de empresa" + "\n"
                + "2. Nombre de representante" + "\n"
                + "3. Correo de la empresa" + "\n"
                + "4. Teléfono de la empresa" + "\n"
                + "Digite una opcion: " + "\n");
        int opcion = sc.nextInt();
        Scanner leer = new Scanner(System.in);
        switch (opcion) {

            case 1:
                System.out.println("¿Cuál sería el nuevo nombre?");
                String nuevoNombre = leer.nextLine();
                System.out.println("El nombre de " + listProveedores.get(proveedor - 1).getNombreEmpresa()
                        + " ha sido cambiado a " + nuevoNombre);
                listProveedores.get(proveedor - 1).setNombreEmpresa(nuevoNombre);
                break;
            case 2:
                System.out.println("¿Cuál sería el nuevo representante?");
                String nuevoRepresentante = leer.nextLine();
                System.out.println("El representante de " + listProveedores.get(proveedor - 1).getNombreEmpresa()
                        + " ha sido actualizado a " + nuevoRepresentante);
                listProveedores.get(proveedor - 1).setPersonaEncargada(nuevoRepresentante);
                break;
            case 3:
                System.out.println("¿Cuál sería el nuevo correo?");
                String correo = leer.nextLine();
                System.out.println("El correo de " + listProveedores.get(proveedor - 1).getNombreEmpresa()
                        + " ha sido actualizado a " + correo);
                listProveedores.get(proveedor - 1).setCorreo(correo);
                break;

            case 4:
                System.out.println("¿Cuál sería el nuevo teléfono?");
                int telefono = sc.nextInt();
                System.out.println("El número de " + listProveedores.get(proveedor - 1).getNombreEmpresa()
                        + " ha sido actualizado a " + telefono);
                listProveedores.get(proveedor - 1).setTelefono(telefono);
                break;
        }
        menuProveedor();
    }

    public void eliminarProveedor() {
        System.out.print("===ELIMINAR PROVEEDOR===");
        int i = 0;
        for (Proveedor a : listProveedores) {
            i++;
            System.out.println(i + ". " + a.toString());
        }
        System.out.println("¿Cuál Proveedor desea eliminar? " + "\n"
                + "Digite el indice del deseado: ");
        int opcion = sc.nextInt();
        System.out.println(listProveedores.get(opcion - 1).getNombreEmpresa() + "Ha sido eiminado exitosamente!");
        listProveedores.remove(opcion - 1);
    }

    public void agregarPromocion() {
        System.out.println("===AGREGAR PROMOCION===" + "\n"
                + "¿Qué producto va a estar en promoción? ");
        int i = 0;
        for (Producto a : listProductos) {
            i++;
            System.out.println(i + ". " + a.toString());
        }
        System.out.println("\n" + "Digite el indice del producto"
                + "quiere seleccionar ");

        int opcion = sc.nextInt();

        System.out.println("¿Cuánto será el descuento? " + "\n");
        int descuento = sc.nextInt();

        listPromociones.add(new Promocion("Promo de " + listProductos.get(opcion - 1).getNombre(),
                listProductos.get(opcion - 1).getPrecio(), descuento));

        System.out.println("La promo de " + listProductos.get(opcion - 1).getNombre() + "ha sido añadida!" + "\n");
        menuPromocion();
    }

    public void eliminarPromocion() {
        System.out.println("===ELIMINAR PROMOCION===" + "\n");
        int i = 0;
        System.out.println("¿Cuál promoción quieres eliminar?" + "\n");

        for (Promocion a : listPromociones) {
            i++;
            System.out.println(i + ". " + a.toString());
        }
        System.out.println("Digita el indice de la promo por eliminar: " + "\n");
        int promo = sc.nextInt();
        System.out.println("La " + listPromociones.get(promo - 1).getNombrePromocion() + " ha sido eliminada"
                + " exitosamente");
        listPromociones.remove(promo - 1);

        menuPromocion();
    }

    public void agregarCombo() {
        System.out.println("===AGREGAR COMBO===" + "\n");
        Scanner leer = new Scanner(System.in);
        System.out.println("Digite el nombre del nuevo combo: " + "\n");
        String nombreCombo = leer.nextLine();
        System.out.println("Digite la descripcion del producto: " + "\n");
        String descripcion = leer.nextLine();
        System.out.println("Digite el precio del producto: " + "\n");
        int precio = leer.nextInt();

        listCombos.add(new Combo(nombreCombo, descripcion, precio));
        System.out.println(nombreCombo + " ha sido agregado exitosamente!" + "\n");

        menuCombo();
    }

    public void eliminarCombo() {
        System.out.println("===ELIMINAR COMBO===" + "\n"
                + "Cuál combo deseas remover?");
        int i = 0;
        for (Combo a : listCombos) {
            i++;
            System.out.println(i + ". " + a.toString());
        }
        System.out.println("\n" + "Digita el indice del combo que deseas eliminar");
        int option = sc.nextInt();
        System.out.println(listCombos.get(option - 1).getNombreDeCombo() + " ha sido eliminado");
        listCombos.remove(option - 1);

        menuCombo();

    }

    //public Pedido_Proveedor(Proveedor proveedor, Date fecha, int cantidad, String producto)
    public void solicitarPedido() {
        System.out.println("===SOLICITAR PEDIDO===" + "\n");
        System.out.println("¿Cuál producto desea solicitar?" + "\n");
        int i = 0;
        for (Producto a : listProductos) {
            i++;
            System.out.println(i + ". " + a.toString() + "\n");
        }
        System.out.print("Digite el índice del producto por solicitar!" + "\n");
        int producto = sc.nextInt();
        System.out.println("¿Cuántas unidades necesita?" + "\n");
        int cantidad = sc.nextInt();
        Date fecha;
        System.out.println("\n" + "==El pedido de " + listProductos.get(producto - 1).getNombre() + " ha sido solicitado a "
                + listProductos.get(producto - 1).getProveedor().getNombreEmpresa() + "===");
        //public Pedido_Proveedor(Proveedor proveedor, Date fecha, int cantidad, String producto)
        listPedidos.add(new Pedido_Proveedor(listProductos.get(producto - 1).getProveedor(), new Date(), cantidad,
                listProductos.get(producto - 1).getNombre()));
        listProductos.get(producto - 1).setCantidad(listProductos.get(producto - 1).getCantidad() + cantidad);

        menuProveedor();

    }

    public void verPromociones() {
        int i = 0;
        for (Promocion a : listPromociones) {
            i++;
            System.out.println(i + ". " + a.toString() + "\n");
        }
        menuPromocion();
    }

    public void verCombos() {
        int i = 0;
        for (Combo a : listCombos) {
            i++;
            System.out.println(i + ". " + a.toString() + "\n");
        }
        menuCombo();
    }

    public void bienvenidoAdmin() {
        System.out.println("===*Bienvenido, " + admLogged.getNombre() + "*===" + "\n");
    }
}
