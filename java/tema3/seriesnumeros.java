package tema3;

import java.util.Scanner;
public class seriesnumeros {
         public static void main(String[] args) {
             Scanner sc= new Scanner(System.in);
        int a;
        int b=3;
        int c=3;
        int num1, num2, num3;
         for ( a=3; a<101;a+=3){
            System.out.print(a+", ");
    }
         System.out.println(" ");
         while(b<=100){
             System.out.print(b+", ");
             b+=3;
         }
         System.out.println(" ");
         do{
             System.out.print(c+", ");
             c+=3;
         } while(c<=100);
         System.out.println("");
          System.out.println("Introduce el rango de números del que quiera la suma de la srie del 3:");
            num1=sc.nextInt();
            num2=sc.nextInt();
         
         int resultado=suma(num1,num2);
         System.out.println("El resultado de la suma de la serie del 3 entre los rangos "+num1+" y "+num2+" es: "+resultado);
         
         
         System.out.println("Introduce el rango de números del que quiera la suma ");
         num1=sc.nextInt();
         num2=sc.nextInt();
         System.out.println("Introduce el como quiere que sea la serie si de 3 en 3 o de 4 en 4, etc ");
         num3=sc.nextInt();
         int resultado2=cosoc(num1,num2,num3);
         System.out.println("El resultado de la suma de la serie del "+num3+" entre los rangos "+num1+" y "+num2+" es: "+resultado2);
   
    }   
         
        public static int suma(int num1,int num2) {
            int d=0;
            for (int i=num1; i<=num2;i+=3){
            d+=i;
            }
            return d;
    }
        public static int cosoc(int num1, int num2, int num3) {
            int x = 0;
            for (int i = num1; i <= num2; i += num3) {
            x += i;
        }
            return x;
    }
        
        
    
}
