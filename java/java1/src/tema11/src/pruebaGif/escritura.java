/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaGif;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class escritura {
    public void escribirArchivo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del archivo:");
        String nombreArchivo = sc.nextLine();

        String ruta = System.getProperty("user.dir") + File.separator + "src" + File.separator + "pruebaGif";
        File directorio = new File(ruta);

        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        System.out.println("Elija el tipo de archivo a crear:");
        System.out.println("1. Archivo de texto (.txt)");
        System.out.println("2. Imagen GIF (.gif)");
        System.out.println("3. Imagen PNG (.png)");
        int opcion = sc.nextInt();

        String extension = "";
        if (opcion == 1) {
            extension = ".txt";
        } else if (opcion == 2) {
            extension = ".gif";
        } else if (opcion == 3) {
            extension = ".png";
        } else {
            System.out.println("Opción inválida. Se creará un archivo de texto por defecto.");
            extension = ".txt";
        }

        File fichero = new File(directorio, nombreArchivo + extension);

        try {
            if (extension.equals(".txt")) {
                FileWriter fw = new FileWriter(fichero);
                BufferedWriter bw = new BufferedWriter(fw);

                System.out.println("Escribe el contenido que deseas agregar al archivo:");
                String texto = sc.next();
                bw.write(texto);

                bw.close();
                fw.close();
            } else {
                // Si el archivo es .gif o .png, puedes utilizar una librería gráfica como BufferedImage
                // para crear la imagen y escribirla en el archivo.
                // En este ejemplo, solo crearemos un archivo vacío.
                if (!fichero.createNewFile()) {
                    System.out.println("Error al crear el archivo.");
                }
            }

            System.out.println("Archivo '" + nombreArchivo + extension + "' creado exitosamente en la subcarpeta pruebaGif");

        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}