/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f3_2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Clase para la escritura de archivos de texto.
 */
public class escribir {
    public void escribirArchivo() {
       Scanner sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();

        File rutaFichero = new File(".//src//f3_2//coso1.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            System.out.println("Contenido del archivo : ");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lista.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Introduzca el dato que desea introducir:");
        String dato = sc.nextLine();

        //añade una nueva linea al final de la lista
        lista.add(dato);
        //Ordena las lineas de menor a mayor y luego de a-z 
        Collections.sort(lista);
        
        //Imprime la lista ordenda
        System.out.println("Contenido del archivo ordenado");
        imprimirLista(lista);

        añadirALista(lista, rutaFichero, dato);
    }

    //2
    public static void imprimirLista(ArrayList<String> lista) {
        for (String linea : lista) {
            System.out.println(linea);
        }
    }//fin del metodo imprimirLista

    //3
    public static void añadirALista(ArrayList lista, File rutaFichero, String dato) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaFichero, true))) {
            pw.println(dato);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//fin del metodo añadirALista
    
}//fin de la clase