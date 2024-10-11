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
public class triangulo {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int anchoPantalla = 80;
        
        System.out.println("Introduzca el alto de la copa del arbol");
        int altura = sc.nextInt();
        
        int ancho = (2 * altura - 1);
        
        sc.nextLine();
        System.out.println("Introduzca el s�mbolo que quiere que forme el �rbol");
        char simbolo = sc.nextLine().charAt(0);
        
        int anchoTronco = ancho / 3;
        int altoTronco = altura / 3;
        
        Copa(altura, anchoPantalla, simbolo);
        Tronco(altoTronco, anchoTronco, anchoPantalla, simbolo);
    }

    public static void Tronco(int altoTronco, int anchoTronco, int anchoPantalla, char simbolo) {
        for (int i = 0; i < altoTronco; i++) {
            // Imprimir espacios en blanco antes del tronco
            for (int j = 0; j < (anchoPantalla - anchoTronco) / 2; j++) {
                System.out.print(" ");
            }

            // Imprimir el tronco
            for (int k = 0; k < anchoTronco; k++) {
                System.out.print(simbolo);
            }
            System.out.println();
        }
    }

    public static void Copa(int altura, int anchoPantalla, char simbolo) {
        for (int i = 0; i < altura; i++) {
            // Imprimir espacios en blanco antes de los asteriscos
            for (int j = 0; j < (anchoPantalla - (2 * i + 1)) / 2; j++) {
                System.out.print(" ");
            }

            // Imprimir s�mbolo
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print(simbolo);
            }

            // Cambiar de l�nea despu�s de imprimir cada fila
            System.out.println();
        }
    }
}