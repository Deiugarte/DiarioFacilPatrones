package edu.ulatina.diariofacil.patrones;
public class Cliente extends Usuario {
    public Cliente(String username) {
        super(username, new ComportamientoCliente());
    }   
}
