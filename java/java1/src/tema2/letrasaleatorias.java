package tema2;
import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class letrasaleatorias {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    char c=(char)(Math.random()*26+'a');
   
    System.out.println("La letra es: "+c );
    switch (c){
        case 'a':
        case 'i':
        case 'o':
        case 'u':
        case 'e':
            System.out.println(" Es una vocal");
            break;
        default:
            System.out.println(" Es una consonante");
            
    }

    }
    
}
