/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotienda;

import java.util.ArrayList;



/**
 *
 * @author luis
 */
public class Tienda {
    private String cif, direccion;
    private ArrayList<Producto> lista_productos;

    public Tienda(String cif, String direccion, ArrayList<Producto> lista_productos) {
        this.cif = cif;
        this.direccion = direccion;
        this.lista_productos = lista_productos;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Producto> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(ArrayList<Producto> lista_productos) {
        this.lista_productos = lista_productos;
    }
    
}
