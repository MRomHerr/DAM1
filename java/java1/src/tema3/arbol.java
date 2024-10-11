package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class arbol {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int anchoPantalla=80;
        
         System.out.println("introduzca el alto de la copa del arbol");
         int altura=sc.nextInt();
         
         int ancho=(2*altura-1);
         
         sc.nextLine();
         System.out.println("Introduzca el simbolo que quiere que forme el árbol");
         char simbolo=sc.nextLine().charAt(0);
         
         int anchoTronco=(int)Math.ceil ((double)ancho/3);
         int altoTronco=(int)Math.ceil ((double) altura/3);
         
        Copa(altura,anchoPantalla,simbolo);
        Tronco(altoTronco,anchoTronco,anchoPantalla,simbolo);
        
    }
    

    public static void Tronco(int altoTronco, int anchoTronco, int anchoPantalla, char simbolo) {
        
        for (int i = 0; i < altoTronco; i++) {
            for (int j = 0; j < (anchoPantalla-anchoTronco)/2; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < anchoTronco; k++) {
                System.out.print(simbolo);
            }
            System.out.println();
        }
    }
    
    public static void Copa(int altura, int anchoPantalla, char simbolo) {
        for (int i = 0; i < altura; i++) {
            // Imprimir espacios en blanco antes de los asteriscos
            for (int j = 0; j < (anchoPantalla-(2*i+1))/2; j++) {
                System.out.print(" ");
            }

            // Imprimir simbolo
            for (int k = 0; k < 2*i+1; k++) {
                System.out.print(simbolo);
            }

            // Cambiar de línea después de imprimir cada fila
            System.out.println();
        }
    }
        
}
    
    

