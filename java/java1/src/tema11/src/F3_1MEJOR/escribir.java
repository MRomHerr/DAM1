
package F3_1MEJOR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class escribir {
    public void escribirArchivo() {
       Scanner sc = new Scanner(System.in);

        File rutaFichero = new File(".//src/f3_1mejor//coso1.txt");
        
        ArrayList<String> lista = new ArrayList<>();

        try {

            //1- Leer el fichero y mostrarlo por pantalla
            FileReader fr = new FileReader(rutaFichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            System.out.println("Contenido del archivo : " );
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                lista.add(linea);
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //2-pedir datos
        System.out.println("Introduzca el dato que desa introducir");
        String dato=sc.nextLine();
        
        añadirDato(lista, dato);
        imprimirLista(lista);
        añadiraLista(lista, rutaFichero, dato);
    }
    
    public static void añadirDato(ArrayList lista, String dato){
        lista.add(dato);
    }
    
    public static void imprimirLista(ArrayList lista){
        Iterator<String> imprimir = lista.iterator();
        while(imprimir.hasNext()){
            imprimir.next();
        }
        System.out.println(lista);
    }
    
    public static void añadiraLista(ArrayList lista, File rutaFichero, String dato) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(rutaFichero, true));
            bw.write(dato);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//fin del metodo
}// fin de la clase
