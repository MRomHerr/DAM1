/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f3mejor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Clase para la escritura de archivos de texto.
 */
public class escribir {
    public void escribirArchivo() {
       Scanner sc = new Scanner(System.in);

        File rutaFichero = new File(".//src/f3mejor//coso1.txt");
        
        ArrayList<String> Lista = new ArrayList<>();

        try {

            //1- Leer el fichero y mostrarlo por pantalla
            FileReader fr = new FileReader(rutaFichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            System.out.println("Contenido del archivo : " );
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                Lista.add(linea);
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //2-pedir datos
        System.out.println("Introduzca el dato que desa introducir");
        String dato=sc.nextLine();
        
        añadirDato(Lista, dato);
        imprimirLista (Lista);
        añadiraLista(Lista, rutaFichero, dato);
    }
    
    public static void añadirDato (ArrayList Lista, String dato){
        Lista.add(dato);
        
    }//fin del metodo añadirDato
    
    public static void imprimirLista (ArrayList Lista){
        Iterator<String> imprimir = Lista.iterator();
        while(imprimir.hasNext()){
            imprimir.next();
        }
        System.out.println(Lista);
        
    }//fin del metodo imprimirLista
    
    
    //3- lo añade al final del fichero
    public static void añadiraLista (ArrayList Lista,File rutaFichero, String dato){
        FileWriter fw2 = null;
        PrintWriter pw = null;
        try{
           fw2 = new FileWriter(rutaFichero, true);
           pw = new PrintWriter(fw2);
           
           pw.println(Lista);
           pw.write(dato);
           pw.println();
           pw.flush();
           
        }catch (IOException e) {
            e.getMessage();
        } finally {
            try{
                if(fw2 != null){
                    fw2.close();
                }//fin if
            } catch (IOException e3){
                e3.getMessage();
            }//fin try catch
        }
        
    }//fin del metodo añadiraLista
    
}//fin de la clae