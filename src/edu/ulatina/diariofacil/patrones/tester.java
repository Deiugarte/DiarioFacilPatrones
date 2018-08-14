package edu.ulatina.diariofacil.patrones;

import edu.ulatina.diariofacil.dao.ProvedorDAO;
import edu.ulatina.diariofacil.model.Admin;
import edu.ulatina.diariofacil.model.Provedor;

public class tester {
    public static void main(String[] args) {
        Admin admin0 = new Admin(1, "Daniel", "Segura",
                "daniel@gmail.com", "pass", 1);
        admin0.menuPrincipal();
    }

}
