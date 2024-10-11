package tema2;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Valor_absoluto {
    public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
             
		 int num1;
                 
                 System.out.println("Escriba un número que sea entero y que no sea 0");
                 num1=sc.nextInt();
                 
                 if (num1<0) {
                     System.out.println("El valor absoluto de "+num1+" es "+num1*(-1));
                 } else if (num1>0)
                     System.out.println("El valor absoluto de "+num1+" es "+num1);
                 
    }       
    
}