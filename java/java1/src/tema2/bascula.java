package tema2;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class bascula {
    public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
             
		 double peso,precioT,pago,vuelta,precio_kg;
		 String codigo;
                 
                 
                 System.out.println("Escriba el código");
                  codigo=sc.nextLine();
                 System.out.println("Escriba el peso en gramos ");
                 peso=sc.nextInt();
                 System.out.println("Escriba el precio por kg ");
                 precio_kg=sc.nextDouble();
                 
                 precioT=(peso/1000)*precio_kg;
                 
                 System.out.println("Usted tiene que pagar "+precioT+" euros");
                 System.out.println("Introduzca el dinero");
                 pago=sc.nextDouble();
                 vuelta=pago-precioT;
                 System.out.println("Usted ha entregado "+pago+" euros");
                 System.out.println("La vuelta es de "+vuelta+" euros");
 
                 
    }       
    
}