/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotienda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class EntradaSalida {
    private static Scanner sc=new Scanner(System.in);
    public static String pedirCIF()
    {
        System.out.println("Introduce el CIF de la empresa");
        String cif=sc.nextLine();
        return cif;
        
    }

    public static String pedirDireccion()
    {
        System.out.println("Introduce la dirección");
        String direccion=sc.nextLine();
        return direccion;
    }

    static int mostrarMenu() {
        System.out.println("Seleccione:");
        System.out.println("1-Insertar producto");
        System.out.println("2-Salir");
        int n=sc.nextInt();
        sc.nextLine();
        return n;
    }

    static Producto annadirProducto() {
        System.out.println("Descripcion:");
        String descripcion=sc.nextLine();
        System.out.println("Precio:");
        int precio=sc.nextInt();
        Producto p=new Producto(descripcion, precio);
        return p;
    }

    static void mostrarTienda(Tienda t2) {
        String direccion=t2.getDireccion();
        String cif=t2.getCif();
        System.out.println("La tienda tiene CIF: "+cif+" y dirección:"+direccion);
        ArrayList<Producto> lista=t2.getLista_productos();
        for (int i=0; i<lista.size(); i++)
        {
            Producto p=lista.get(i);
            System.out.println("PRODUCTO: "+p.getDescripcion()+
                    " PRECIO: "+p.getPrecio());
            
            System.out.println("PRODUCTO: "+lista.get(i).getDescripcion()+
                    " PRECIO: "+lista.get(i).getPrecio());
        }
    }
}
