package tema2;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class gasolinera {
    public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
               
                 Double litros,precio,precioT;
                 
                 System.out.println("Introduzca el precio de la gasolina: ");
                 precio=sc.nextDouble();
                 System.out.println("Introduzca los litros: ");
                 litros=sc.nextDouble();
                 
                precioT=litros*precio;

                 System.out.printf("El precio total por "+litros+" es %.3f ",precioT," euros.");
                 
    }
}

//precioT = Math.round(precioT * 1000.0) / 1000.0;