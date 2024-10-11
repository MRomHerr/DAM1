package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class ordenalfabetico {
    
           public static void orden (String letra1, String letra2) { //subproceso
                     if (letra1.compareTo(letra2) < 0) {
                     System.out.println("Están en orden alfabético");           //los podría haber llamado char y haber usado los < >
                     } else if (letra1.compareTo(letra2) > 0) {
                     System.out.println("No están en orden alfabético");
                     } else {
                     System.out.println("Las letras son iguales");
        }
    }
       
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        String letra1,letra2;
        
        System.out.println("Introduzca dos letras: ");
        letra1=sc.nextLine();
        letra2=sc.nextLine();
        
        orden(letra1, letra2);
        
        
    }
        
}

   

