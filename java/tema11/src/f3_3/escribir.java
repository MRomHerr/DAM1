/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f3_3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para la escritura de archivos de texto.
 */
public class escribir {
    public void escribirArchivo() {
       Scanner sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();

        File Fichero = new File(".//src//f3_3//coso1.txt");

       if (Fichero.exists()){
           System.out.println("Nombre del fichero: "+Fichero.getName());
           System.out.println("Ruta: "+Fichero.getPath());
           System.out.println("Ruta absoluta: "+Fichero.getAbsolutePath());
           System.out.println("Se puede lee: "+Fichero.canRead());
           System.out.println("Se puede escribir: "+Fichero.canWrite());
           System.out.println("Tamaño del fichero: "+Fichero.length());
       }
       Fichero.delete();//borra el fichero
        
    }//fin del metodo escribirArchivo
    
}//fin de la clase escribir