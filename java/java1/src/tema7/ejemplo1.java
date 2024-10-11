/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alumno
 */
public class ejemplo1 {

    public static void main(String[] args){
        int numero=-1;
        int intentos=0;
        String linea;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in)); //Forma antigua de pedir valores al usuario

        do{
            try{
                System.out.print("Introduzca un número entre 0 y 100 ");
                linea = teclado.readLine();
                numero = Integer.parseInt(linea);

            }catch(IOException e){
                System.out.println("Error al leer del teclado.");

            }catch(NumberFormatException e){
                System.out.println("Debe introducir un número entre 0 y 100.");

            }finally{
                intentos++;
            }//Fin del try-catch-finally
        }while (numero < 0 || numero > 100);//Fin del do-while

        System.out.println("El número introducido es: " + numero);
        System.out.println("Número de intentos: " + intentos);
        

    }//Fin del main
}//Fin de Ejemplo_1_Programa_Introducir_numero_del_1_al_100