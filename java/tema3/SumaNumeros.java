/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class SumaNumeros {
    public static void main(String[] args) {
             Scanner sc= new Scanner(System.in);
             
             int num;
             int suma=0;
             String letra;
             
             do{
                    System.out.print("Introduce un número o 's' para salir: ");
                // Lee la entrada del usuario como una cadena
                letra = sc.next();

                // Verifica si el usuario ingresó 's' para salir
                if (!letra.equalsIgnoreCase("s")) {
                // Convierte la cadena a un número entero
                    num = Integer.parseInt(letra);
                    suma += num;
                }
            }while(!letra.equalsIgnoreCase("s"));
             
             System.out.print("La suma de los anteriores números da: "+suma);
             

    }
    
}
