
package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class reagrupacionEjercicios {
    public static Scanner sc = new Scanner(System.in);
    //a�o bisiesto
    public static int bisiesto() {
             int a�o;
             System.out.print("Introduzca un a�o: ");
             a�o=sc.nextInt();
             if(a�o%4==0&&a�o%100!=0){
                 System.out.println("El a�o "+a�o+" es bisiesto");
             }
             return a�o;
    }
     
    //factorial
    public static int factorial() {
        int num;
        int factorial=1;

        System.out.println("Introduzca el n�mero del que quiere el factorial: ");
        num = sc.nextInt();

        // Calcula el factorial del n�mero
        while (num > 1) {
            factorial =factorial* num; //factorial0factorial*num
            num--;
        }

        System.out.println("El factorial es: " + factorial);
        return factorial;
    }
    
    //numero primo
    public static int primo(){
    int num;
    System.out.println("Introduzca un n�mero: ");
    num=sc.nextInt();
    
    if (num==5 || num==2 || num==3){
        System.out.println(num+" es un n�mero primo");
    }
    else if(num%2==0 || num%3==0 || num%5==0){
        System.out.println(num+" no es un n�mero primo");
    }
    else
        System.out.println(num+" es un n�mero primo");
    return num;
    }
    
    
    public static void men�(){
        int x;
        do{
            System.out.println("presione 1 para calcular a�o bisisesto, 2 para el n�mero primo, 3 para el factorial y el 0 para salir");
            x=sc.nextInt();
            switch (x) {
                case 1:
                    bisiesto();
                    break;
                case 2:
                    primo();
                    break;
                case 3:
                    factorial();
                break; }      
        }while(x!=0);
    }
    
    public static void main(String[] args){
        men�();
     }
        
}

