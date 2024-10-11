package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class pesetasyeuros {
     public static void menu(Scanner sc) {
        double cantidad, conversion;
        String dinero;
        
        do {
            System.out.println("Introduzca que moneda quiere convertir, pesetas o euros (o EXIT para salir): ");
            dinero = sc.nextLine();
            
            if (dinero.equals("pesetas")) {
                System.out.println("Introduzca la cantidad de pesetas que quiere convertir a euros: ");
                cantidad = sc.nextDouble();
                conversion = pesetasAEuros(cantidad);
                System.out.print(" " + cantidad + " pesetas son ");
                System.out.printf("%.2f euros\n", conversion);
            } else if (dinero.equals("euros")) {
                System.out.println("Introduzca la cantidad de euros que quiere convertir a pesetas: ");
                cantidad = sc.nextDouble();
                conversion = eurosAPesetas(cantidad);
                System.out.print(" " + cantidad + " euros son ");
                System.out.printf("%.2f pesetas\n", conversion);
            }
            
            sc.nextLine(); // Limpiar el búfer del teclado, sirve para que el primer system no se me repita 2 veces.
        } while (!dinero.equals("EXIT"));
        
        sc.close(); // Cerrar el scanner al final para evitar pérdidas de recursos.
    }
    
    public static double pesetasAEuros(double cantidad) {
        return cantidad / 166.386;
    }
    
    public static double eurosAPesetas(double cantidad) {
        return cantidad * 166.386;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
    }       
}
 