package tema3;
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class numeroPrimo {
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
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
    
    }
    
}
