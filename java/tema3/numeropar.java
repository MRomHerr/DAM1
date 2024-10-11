package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class numeropar {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);;
          int num;
          int resto;
          
          System.out.println("Introduzca un número: ");
          num=sc.nextInt();
          
          resto=num%2;
          if(resto==0){
              System.out.println("El número "+num+" es par.");
          } else{
              System.out.println("El número "+num+" no es par.");
          }
 
        }
    }


    


    

