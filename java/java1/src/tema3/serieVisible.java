/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class serieVisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario el número de elementos
        System.out.print("Indique cuantos números de la serie quiere ver: ");
        int numElementos = sc.nextInt();

        // Llamar al procedimiento para generar la serie y mostrarla
        generarYMostrarSerie(numElementos);

    }

    // Procedimiento para generar y mostrar la serie
    private static void generarYMostrarSerie(int numElementos) {
        StringBuilder serie = new StringBuilder();

        // Generar la serie numérica
        for (int i = 0; i < numElementos * 2; i += 2) {
            int primerNumero = i + 1;
            int segundoNumero = i + 5;

            // Agregar los números a la cadena de caracteres
            serie.append(primerNumero).append(" ").append(segundoNumero).append(" ");

            // Mostrar solo la cantidad de elementos solicitados
            if (i == (numElementos - 1)*2) {
                break;
            }
        }

        // Mostrar la serie generada
        System.out.println("Serie: " + serie.toString().trim());
    }
}
    

