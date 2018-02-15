/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dante
 */
public class ManejadorProductos {
    List<Productos> pro;

    public ManejadorProductos() {
        this.pro = new ArrayList<>();
    }
    
    public boolean GuardarPro(String nomb, double precio, int exist, int min, String fecha)
    {
        boolean resp = false;
        try
        {
            this.pro.add(new Productos(nomb, precio, exist,min,fecha ));
            resp = true;
        }
        catch (Exception ex) {
            System.err.println("Error al guardar Producto: " + ex.getMessage());
        }
        return resp;
    }
    
//    public List<> TopPro()
//    {
//        List<Productos> lstTemp = new ArrayList<>();
//        
//        try
//        {
//            for(Productos precio: this.pro)
//            {
//              
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        return topn;
//    }
    
//    public List<Productos> consTodo()
//    {
//        return this.pro;
//    }
}
