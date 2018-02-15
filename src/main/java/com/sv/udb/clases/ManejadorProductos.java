/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
    
    public List<Productos> TopPro()
    {
        List<Productos> lstTemp = new ArrayList<>();
        try
        {
            pro.sort(Comparator.comparing(Productos::getPrecio).reversed());
            for(int i = 0; i < pro.size(); i++){
                if(i < 3)
                {
                    lstTemp.add(pro.get(i));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lstTemp;
    }
    
    public List<Productos> FechaVec()
    {
        List<Productos> lstTemp = new ArrayList<>();
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            lstTemp.add(pro.get(0));
            for(Productos p : this.pro){
                Date fecha1 = sdf.parse(lstTemp.get(0).getFecha());
                Date fecha2 = sdf.parse(p.getFecha());
                if(fecha2.before(fecha1))
                {
                    lstTemp.clear();
                    lstTemp.add(p);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lstTemp;
    }
    
    public List<Productos> MinExist()
    {
        
        List<Productos> lstTemp = new ArrayList<>();
        for(Productos cantidad : this.pro)
        {
            if(cantidad.getExist() == cantidad.getMin())
            {
                lstTemp.add(cantidad);
            }
        }
        return lstTemp;
    }
}
