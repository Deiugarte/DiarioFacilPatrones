
package diariofacilpatrones;

import edu.ulatina.clases.Admin;
import edu.ulatina.clases.Cliente;
import edu.ulatina.clases.Combo;
import edu.ulatina.clases.DiarioFacil;
import edu.ulatina.clases.Pedido_Proveedor;
import edu.ulatina.clases.Producto;
import edu.ulatina.clases.Promocion;
import edu.ulatina.clases.Proveedor;
import java.util.Date;
import java.util.Scanner;

public class DiarioFacilPatrones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //DIARIO FACIL
        DiarioFacil df = new DiarioFacil("Diario Facil 1.0");

        //CATEGORIAS
        df.getListCategorias().add("Frescos");
        df.getListCategorias().add("Canasta básica");
        df.getListCategorias().add("bebidas alcohólicas");
        df.getListCategorias().add("Higiene y aseo personal");
        df.getListCategorias().add("Vestimenta");
        df.getListCategorias().add("Utensilios");
        df.getListCategorias().add("Galletas y reposteria");
        df.getListCategorias().add("Carnes");
        df.getListCategorias().add("Frutas y Vegetales");
        df.getListCategorias().add("Comida rápida");
        df.getListCategorias().add("Especies y aceites");
        df.getListCategorias().add("Miscelaneos");
        //USUARIOS
        
        //-- ADMINS
        Admin admin0 = new Admin(df, "Daniel", "Segura", "daniel@diariofacil.com",
                "madrizdm", "Password1!");        
        Admin admin1 = new Admin (df,"David", "Cordero","david@diariofacil.com","dacord","dacord");
        
         df.getListAdmins().add(admin0);
        df.getListAdmins().add(admin1);
        
        //-- CLIENTES
        Cliente cli0 = new Cliente(df, "115870456", "88723078", "Daniel", "Segura",
                "segura27@gmail.com", "segura", "pass");
        Cliente cli1 = new Cliente(df, "117530170", "71172627", "Josue", "Vega",
                "sgtxjosue@gmail.com", "sgtxjosue", "1shotykillhead"); 
        df.getListClientes().add(cli0);
        df.getListClientes().add(cli1);

     
        
        
        
        //PROMOCIONES        
        Promocion promo0 = new Promocion("Cafe Rey 500g", 1200,5);
        Promocion promo1 = new Promocion("Azucar TuMai 800g", 1600,10);
        
        df.getListPromociones().add(promo0);
        df.getListPromociones().add(promo1);
        
        
     
        
        
        
        
        //PROVEEDORES
        Proveedor Dos_Pinos = new Proveedor("Dos Pinos", "Lula", "lula@lula.com", 89658585);
        Proveedor El_Angel = new Proveedor("El Ángel ", "Lucy ", "lucy@lucy.com ", 89658585);
        Proveedor Mayca = new Proveedor("Mayca", "María", "maria@maria.com", 89658585);
        Proveedor Belca = new Proveedor("Belca", "Abel", "ab@el.com", 89658585);
        Proveedor Pipasa = new Proveedor("Pipasa", "Pablo", "pa@blo.com", 89658585);
        
        df.getListProveedores().add(Dos_Pinos);
        df.getListProveedores().add(El_Angel);
        df.getListProveedores().add(Mayca);
        df.getListProveedores().add(Belca);
        df.getListProveedores().add(Pipasa);
        
        
        
        //PRODUCTOS
        Producto productoA = new Producto("Leche", 965, "lch001 ", 550, 25, Dos_Pinos, "Lacteos");
        Producto productoB = new Producto("Cereal", 1630, "crn010", 10, 25, Mayca, "Cereales");
        Producto productoC = new Producto("Vaso", 350, "vso018", 999, 25, Belca, "Desechables");
        Producto productoD = new Producto("Atún", 1200, "tn023", 666, 25, Mayca, "Enlatados");
        Producto productoE = new Producto("Arroz", 1800, "rz091", 880, 25, Belca, "Granos");
        Producto productoF = new Producto("Pollo", 2250, "pps152", 145, 25, Pipasa, "Carnes");

        df.getListProductos().add(productoA);
        df.getListProductos().add(productoB);
        df.getListProductos().add(productoC);
        
        
        
        
        //PEDIDOS
        Pedido_Proveedor pedidoA = new Pedido_Proveedor(El_Angel, new Date(), 99, "Leche");
        Pedido_Proveedor pedidoB = new Pedido_Proveedor();

        pedidoA.agregarProductoPedido(productoF);  
        pedidoA.agregarProductoPedido(productoB);
        pedidoA.agregarProductoPedido(productoD);
        
        
        
        //COMBOS
        Combo combo1 = new Combo("Combo de Verano", "Atún,arroz,pollo", 8895);
        Combo combo2 = new Combo("Combo Mundial", "Bola,tacos,inflador", 14995);
        Combo combo3 = new Combo("Combo familiar", "Pollo,Vasos,arroz,atún", 1688);
        df.getListCombos().add(combo1);
        df.getListCombos().add(combo2);
        df.getListCombos().add(combo3);
        
                        
        //Boot up.       
        df.menuInicio();
    }
    
}
