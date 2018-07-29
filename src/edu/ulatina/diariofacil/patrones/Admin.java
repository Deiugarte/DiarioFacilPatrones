package edu.ulatina.diariofacil.patrones;

public class Admin extends Usuario{
    public Admin(String username) {
        super(username, new ComportamientoAdmin());
    }      
}
