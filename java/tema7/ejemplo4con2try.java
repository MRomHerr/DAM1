/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class ejemplo4con2try {
 public static void main(String[] args) {
        int intentos=0;
        int numero1;
        int numero2 = 0;
        double resultado=0;
        boolean operacion = false;
        Scanner scanner = new Scanner(System.in);
        while (!operacion) {
            try {
                System.out.println("Introduzca  el dividendo");
                numero1 = scanner.nextInt();
                System.out.println("Introduzca el divisor");
                numero2 = scanner.nextInt();
                resultado = (double) numero2 / numero1;
                operacion = true;
            } catch (InputMismatchException e) {;
                System.out.println("Debes introducir un numero entero");
                operacion = false;
                scanner.next();
            } catch (ArithmeticException e) {
                System.out.println("No se puede dividir entre 0");
                operacion = false;
            } finally {
                intentos++;
            }//Fin del try-catch-finally
        }//Fin de while
        operacion=false;
        while (!operacion){
            try {
                System.out.println("Introduce el divisor");
                numero1= scanner.nextInt();
                if (numero1==0){
                    throw  new ArithmeticException();
                }else{
                    resultado=(double) numero1/ (double)  numero2;
                    operacion=true;
                }//Fin del if-else
            }catch (InputMismatchException e) {
                System.out.println("Debe de ser entero");
                operacion=false;
            }catch (ArithmeticException e){
                System.out.println("No se puede dividir entre 0");
                operacion=false;
            }finally {
                {
                    intentos++;
                }//Fin del finally
            }//Fin del try-catch-finally
        }//Fin del while

        System.out.println("Este es el resultado " + resultado+"\nEl numero de intentos es"+intentos);
        scanner.close();
    }//Fin del main
}//Fin de Ejercicio_4B