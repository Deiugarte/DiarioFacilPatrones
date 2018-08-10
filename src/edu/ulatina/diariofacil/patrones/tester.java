/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.diariofacil.patrones;


import edu.ulatina.diariofacil.dao.ProveedorDAO;
import edu.ulatina.diariofacil.model.Admin;
import edu.ulatina.diariofacil.model.Proveedor;


/**
 *
 * @author blaken
 */
public class tester {

    public static void main(String[] args) {

        Admin admin0 = new Admin(1, "Daniel", "Segura", "daniel@gmail.com",
                 "pass", 1);
        //admin0.menuPrincipal();

        Proveedor p = new Proveedor(1, "asd", "ASD");
        ProveedorDAO pDao = new ProveedorDAO();
        pDao.crear(p);
        pDao.crear(p);
        p.setCorreo("v2");
        pDao.actualizar(p);
        p.setId(3);
        System.out.println(pDao.obtener(p));
        pDao.borrar(p);
        System.out.println(pDao.obtener(p));


    }

}
