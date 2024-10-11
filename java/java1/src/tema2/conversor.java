package tema2;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class conversor {
    
    public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
             
		 double cantidad, conversion;
		 String dinero;
                 
                 do {
                     System.out.println("Introduzca que moneda quiere convertir, pesetas o euros: ");
                     dinero=sc.nextLine();
                     
                     if ( dinero.equals ("pesetas")){
                         System.out.println("Introduzca la cantidad de pesetas que quiere convertir a euros: ");
                         cantidad=sc.nextDouble();
                         conversion=cantidad/166.386;
                         System.out.println(" "+cantidad+"  pesetas son "+conversion+" euros");
                         
                     } else if ( dinero.equals ("euros")){
                         System.out.println("Introduzca la cantidad de euros que quiera convertir a pesetas: ");
                         cantidad=sc.nextDouble();
                          conversion=cantidad*166.386;
                          System.out.println(" "+cantidad+" euros son "+conversion+" pesetas");

                     }  
             
                 } while (!dinero.equals("EXIT"));
            
    }       
    
}