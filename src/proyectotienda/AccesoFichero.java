/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotienda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class AccesoFichero {
    private static String separador=",";
    private static String carpeta="tienda_proyecto";
    private static String nombre_fichero="tienda.csv";
    public static void grabarTienda(Tienda t)
    {
        File f=new File("C:\\"+carpeta);
        if (!f.exists())
        {
            f.mkdir();
        }
        try {
            FileWriter fw=new FileWriter("C:\\"+carpeta+"\\"+nombre_fichero);
            String cif=t.getCif();
            String direccion=t.getDireccion();
            String primera_linea=cif+separador+direccion;
            ArrayList<Producto> lista_productos=t.getLista_productos();
            fw.write(primera_linea);
            fw.write("\n");
        for(int i=0; i<lista_productos.size(); i++)
        {
           Producto p= lista_productos.get(i);
            //System.out.println("Pintando p:"+p);
            fw.write(p.getDescripcion()+","+p.getPrecio());
            fw.write("\n");
        }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static Tienda leerTienda() 
    {
        Tienda t=null;
        try {
            FileReader fr=new FileReader("C:\\"+carpeta+"\\"+nombre_fichero);
            BufferedReader br=new BufferedReader(fr);
            String linea=br.readLine();
            String[] campos_tienda=linea.split(separador);
            String cif=campos_tienda[0];
            String direccion=campos_tienda[1];
            linea=br.readLine();//Ya empiezan los productos
            ArrayList<Producto> lista_productos=new ArrayList<>();
            while(linea!=null)
            {
                String[] campos_producto=linea.split(separador);
                String descripcion=campos_producto[0];
                String precio=campos_producto[1];
                Producto p=new Producto(descripcion, Integer.parseInt(precio));
                lista_productos.add(p);
                linea=br.readLine();
            }
             t=new Tienda(cif, direccion, lista_productos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
}
