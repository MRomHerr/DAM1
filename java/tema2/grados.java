package tema2;

import java.util.Scanner;

public class grados {public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
               
                 Double Celsius, Farenheit;
                 String grados;
                 
                 System.out.print("Introduce celsius para pasrlos a fahrenheit o viceversa: ");
                 grados=sc.nextLine();
                 
                 switch (grados){
                     case "Celsius":
                 
                 System.out.print("Introduce la temperatura en grados Celsius: ");
                    Celsius = sc.nextDouble();
                    Farenheit = (Celsius * 9 / 5) + 32;

                 System.out.println("La temperatura en grados Fahrenheit es: " + Farenheit + " °F");
                         break;
                         
                         case "Farenheit":
                 
                 System.out.println("Introduce la temperatura en grados Farenheit: ");
                    Farenheit = sc.nextDouble();
                    Celsius=(Farenheit-32)/(9/5);
              

                 System.out.println("La temperatura en grados Celsius es: " + Celsius + " °C");
                         break;
                         
                         default:
                             System.out.println("Solo se aceptan Celsius o Farenheit");
                         break;
                             
                         
                 }

                
    }
}