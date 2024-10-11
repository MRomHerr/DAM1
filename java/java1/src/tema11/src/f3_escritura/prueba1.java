/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package f3_escritura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class prueba1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File fichero1 = new File(".//src/f3_escritura//prueba1.txt");
        
        //compruebo si el fihero existe
        if(!fichero1.exists()){
            System.out.println("El archivo no existe");
            System.out.println("¿Quiere crear un nuevo fichero de texto? Pulse Y para aceptar o N para negar");
            String respuesta = sc.nextLine();
            
            if(respuesta.equalsIgnoreCase("Y")){
                System.out.println("Nombre del nuevo fichero: ");
                String nombreFichero = sc.nextLine();
                //crea un nuevo ficghero
                File ficheroUser = new File(".//src/f3_escritura//"+nombreFichero);
              try{
                ficheroUser.createNewFile();
                ficheroUser.getAbsoluteFile();
              }catch(Exception e1){
                  e1.printStackTrace();
              }
                System.out.println("El archivo se ha creado correctamente");
            }//fin if
            else{
                System.out.println("El programa se cerrara");
        }//fin if-else 2º
        }//fin primer if creacion del fichero
        else{
            try{
                BufferedReader br = new BufferedReader(new FileReader(".//src/f3_escritura//prueba2.txt"));
                BufferedWriter  bw = new BufferedWriter(new FileWriter(".//src/f3_escritura//prueba2.txt"));
                
                //escribimos en el fichero
                bw.write("LINEA 1:");
                System.out.println("ESCRIBA SU LINEA 1: ");
                String escritura = sc.nextLine();
                bw.write(escritura);
                
            }catch(IOException e){
                
            }
        }
    }//fin metodo main
    
}//fin clase prueba1
