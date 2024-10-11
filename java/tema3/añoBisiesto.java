package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class añoBisiesto {
    public static void main(String[] args) {
             Scanner sc= new Scanner(System.in);
             
             int año;
             do{
             System.out.print("Introduzca un año: ");
             año=sc.nextInt();
             if(año%4==0&&año%100!=0){
                 System.out.println("El año "+año+" es bisiesto");
             }
             }while(año>1);
    }
    
}
 