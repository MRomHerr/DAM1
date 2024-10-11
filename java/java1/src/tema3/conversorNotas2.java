package tema3;

import java.io.*;
public class conversorNotas2 {
     public static void main(String[] args) throws IOException{
         //Declaracion de variables
         int nota=0;
         char calificacion;
         boolean notValida;
         
         
         System.out.println("Introuce la calificación (I,F,B,N,S):");
         calificacion = Character.toUpperCase((char) System.in.read());
         
         switch (calificacion) {
            case 'I':
                nota= 4;
                break;
            case 'F':
                nota= 5;
                break;
            case 'B':
                nota= 6;
                break;
            case 'N':
                nota= 8;
                break;
            case 'S':
                nota= 9;
                break;
        }
         System.out.println(calificacion+" en número es un "+nota);
     }
    
    
}
