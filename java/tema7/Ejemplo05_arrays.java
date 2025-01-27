package tema7;

import java.util.Scanner;
import java.util.InputMismatchException;



/**
 *
 * @author alumno
 */
public class Ejemplo05_arrays {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        double n;
        int posicion;
        String cadena;
        double [] valores = {8.83, 9.75, -11.3, 0.06, 10, 1.60};

        //Pt. 1
        System.out.println("Valores del array antes de modificar: ");
        for (int i = 0; i < valores.length; i++) {
            System.out.printf("%.2f, ", valores[i]);
        }//Fin for

        boolean repetir;
        //Pt. 2
        do {
            repetir = false;
            try {
                System.out.println("\nIntroduzca la posicion del array a modificar: ");
                cadena = sc.nextLine();
                posicion = Integer.parseInt(cadena);
                System.out.println("Introduzca el nuevo valor de la posición: " + posicion);
                n = sc.nextDouble();
                valores[posicion] = n;
            } catch (NumberFormatException e) {
                System.err.println("Valor no valido");
                repetir = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Valor no valido");
                repetir = true;
                sc.nextLine();
            }catch (Exception e){
                System.err.println(e.toString());
                repetir=true;
            }//Fin del try-catch
        } while (repetir);//Fin do-while

        //Pt. 3
        System.out.println("Valores del array tras modificar: ");
        for (int i = 0; i < valores.length; i++) {
            System.out.printf("%.2f, ", valores[i]);
        }//Fin for
    }//Fin del main
}//Fin Ejercicio_5