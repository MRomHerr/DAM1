/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase para la escritura de archivos de texto.
 */
public class escribir {
    public void escribirArchivo() {
       Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del archivo (incluyendo la extensión .txt):");
        String nombreFichero = sc.nextLine();

        File ficheroUser = new File(".//src/f3//"+nombreFichero);

        try {
            FileWriter fw = new FileWriter(ficheroUser);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("Escribe el texto que desees agregar al archivo:");
            String texto = sc.nextLine();
            bw.write(texto);

            bw.close();
            fw.close();
            System.out.println("Archivo '" + nombreFichero + "' creado exitosamente");

            // Leer el archivo
            FileReader fr = new FileReader(ficheroUser);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            System.out.println("Contenido del archivo '" + nombreFichero + "':");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        

        sc.close();
    }
}