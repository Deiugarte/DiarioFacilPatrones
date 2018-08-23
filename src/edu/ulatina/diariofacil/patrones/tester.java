package edu.ulatina.diariofacil.patrones;
import edu.ulatina.diariofacil.dao.ItemDAO;
import edu.ulatina.diariofacil.dao.OrdenDAO;
import edu.ulatina.diariofacil.dao.ProductoDAO;
import edu.ulatina.diariofacil.dao.UsuarioDAO;
import edu.ulatina.diariofacil.model.Cliente;
import edu.ulatina.diariofacil.model.DiarioFacil;
import edu.ulatina.diariofacil.model.Item;
import edu.ulatina.diariofacil.model.Orden;
import edu.ulatina.diariofacil.model.Producto;
import edu.ulatina.diariofacil.model.Usuario;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class tester {
    

    public static void main(String[] args) {
        DiarioFacil df = new DiarioFacil();
        //df.menuInicio();
        Cliente u = new Cliente(1,"","","","",1);
       // u.menuPrincipal();
       
       Orden o = new Orden(0,u, 0,Time.valueOf(LocalTime.now()));
        
        ItemDAO i = new ItemDAO();
        ProductoDAO p = new ProductoDAO();
        o.addItems(new Item(1,p.obtener(10),10,12.0));
        OrdenDAO oD = new OrdenDAO();
        oD.crear(o);
       // i.crear();
    }

}
