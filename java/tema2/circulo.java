package tema2;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class circulo {
     public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
               
                 Double radio, area,PI;
                 PI=3.1415;
                 
                 System.out.println("Introduzca el radio del círculo en centímetros: ");
                 radio=sc.nextDouble();
                 
                 area=PI*(radio*radio);
                 
                 System.out.printf("El área del círculo es : %.2fcm^2",area);
                 
    }
}