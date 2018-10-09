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
public class ProyectoTienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Necesito rellenatr un objeto tienda
        
        String cif=EntradaSalida.pedirCIF();
        String direccion=EntradaSalida.pedirDireccion();
       // ArrayList<Producto> lista=EntradaSalida.pedirProductos();
       int opcion=EntradaSalida.mostrarMenu();//1-Añadir producto
                                                //2-Terminar
       ArrayList<Producto> lista=new ArrayList();
       while(opcion!=2)
       {
           
           Producto p=EntradaSalida.annadirProducto();
           lista.add(p);
           opcion=EntradaSalida.mostrarMenu();
           
       }
        System.out.println("Hay "+lista.size()+" productos");
       //cif, direccion, lista
       Tienda t=new Tienda(cif, direccion, lista);
        AccesoFichero.grabarTienda(t);
        Tienda t2=AccesoFichero.leerTienda();
        EntradaSalida.mostrarTienda(t2);
    }
    
}
