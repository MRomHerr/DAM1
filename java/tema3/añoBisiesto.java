package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class a�oBisiesto {
    public static void main(String[] args) {
             Scanner sc= new Scanner(System.in);
             
             int a�o;
             do{
             System.out.print("Introduzca un a�o: ");
             a�o=sc.nextInt();
             if(a�o%4==0&&a�o%100!=0){
                 System.out.println("El a�o "+a�o+" es bisiesto");
             }
             }while(a�o>1);
    }
    
}
 