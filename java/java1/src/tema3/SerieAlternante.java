
package tema3;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class SerieAlternante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario el número de elementos
        System.out.print("Introduce el numero de elementos: ");
        int numElementos = sc.nextInt();
        
        serie(numElementos);
        
        }

        
public static void serie(int numElementos){
        // Crear la serie alternante
        for (int i = 0; i < numElementos; i++) {
            int valor = (i % 2 == 0) ? -1 : 1;
            System.out.print(valor);

            // Agregar coma después de cada elemento, excepto el último
            if (i < numElementos - 1) {
                System.out.print(",");
            }
        }
    }
    
}
    

