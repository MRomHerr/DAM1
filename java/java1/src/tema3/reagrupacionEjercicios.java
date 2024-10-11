
package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class reagrupacionEjercicios {
    public static Scanner sc = new Scanner(System.in);
    //año bisiesto
    public static int bisiesto() {
             int año;
             System.out.print("Introduzca un año: ");
             año=sc.nextInt();
             if(año%4==0&&año%100!=0){
                 System.out.println("El año "+año+" es bisiesto");
             }
             return año;
    }
     
    //factorial
    public static int factorial() {
        int num;
        int factorial=1;

        System.out.println("Introduzca el número del que quiere el factorial: ");
        num = sc.nextInt();

        // Calcula el factorial del número
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
    System.out.println("Introduzca un número: ");
    num=sc.nextInt();
    
    if (num==5 || num==2 || num==3){
        System.out.println(num+" es un número primo");
    }
    else if(num%2==0 || num%3==0 || num%5==0){
        System.out.println(num+" no es un número primo");
    }
    else
        System.out.println(num+" es un número primo");
    return num;
    }
    
    
    public static void menú(){
        int x;
        do{
            System.out.println("presione 1 para calcular año bisisesto, 2 para el número primo, 3 para el factorial y el 0 para salir");
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
        menú();
     }
        
}

