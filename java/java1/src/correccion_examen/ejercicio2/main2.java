/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correccion_examen.ejercicio2;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class main2 {
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    
    static int[] introducirNegaticos (int[] negativos){
        boolean repetir;
        int indice=0;
        do{
        for (int i=0; i<negativos.length;i++){
            int positivo=negativos[i];
            negativos[i]=sc.nextInt();
            sc.nextLine();
        }
    }
    
    static int[] introducirPositivos (int[] positivos){
        for (int i=0; i<positivos.length;i++){
            int positivo=positivos[i];
            positivos[i]=sc.nextInt();
            sc.nextLine();
        }
    }
    
    static int[] sumarArray (int[] sumandos){
        int suma=0;
        for (int i=0; i<sumandos.length;i++){
            suma+=sumandos[i];       
        }
        return suma;
    }
    
    
    
    static void menu (int[] numeros){
        int opcion=1;
        boolean repetir;
        do{
        System.out.println("Opciones:\n1- \n2- \n3- \n4- ");
            while (opcion!=0){
                System.out.println("Introduzca su eleccion:");
                opcion=sc.nextInt();
                switch (opcion){
                    case 1:
                        introducirNgeativos(numeros[0]);
                        introducirPositivos(numneros[1]);
                      break;
                    case 2:
                        System.out.println("Media de array de negativos: "+(double) sumarArray(numeros[0])/numeros[0].length);
                        System.out.println("Media de array de positivos: "+(double) sumarArray(numeros[1])/numeros[1].length);
                        System.out.println("Media de ambos array: "+(double) sumarArray(numeros[0])/numeros[0].length);
                      break;
                    case 3:
                        System.out.println("suma del array de negativos: "+sumarArray(numeros[0]));
                        System.out.println("suma del array de positivos: "+sumarArray(numeros[1]));
                        System.out.println("suma del ambos array: "+sumarArray(numeros[0])+ sumarArray(numeros[1]));
                      break;
                    case 4:
                      Arrays.sort(numeros[0]);
                      Arrays.sort(numeros[1]);
                        System.out.println("Array bidimensional de numeros negatvos y positivos: "+sumarArray(numeros[0])+ sumarArray(numeros[1]));
                      break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir=false;
                      break;
                    default:
                        throw new IllegalArgumentException("Opcion no valida");
                }//fin switch
        
            }catch (InputMismatchException e1){
                    System.out.println("ERROR: debe introducir un numero entero");
                    sc.nextLine();
                    }
             }catch (InputMismatchException e2){
                    System.out.println("ERROR: " +e.2toString());
                    sc.nextLine();
                    }
              }catch (InputMismatchException e3){
                    System.out.println("ERROR: " +e.3toString());
                    sc.nextLine();
                    }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        menu(inicializarArray());
    }
    
}