package edu.ulatina.diariofacil.patrones;
import edu.ulatina.diariofacil.dao.UsuarioDAO;
import edu.ulatina.diariofacil.model.Usuario;
import java.util.List;
import java.util.Scanner;



public class tester {

    public static void main(String[] args) {
        List<Usuario> lstUsuarios=new UsuarioDAO().obtenerUsuarios();
        Scanner sc=new Scanner(System.in);
        String nombre,contrasena;
        System.out.println("Ingrese su nombre:");
        nombre=sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        contrasena=sc.nextLine();
        for (Usuario U : lstUsuarios) {
            if(U.getNombre().equals(nombre) &&U.getContrasena().equals(contrasena)){
                U.menuPrincipal();
            }   
        }

        
                

    }

}
