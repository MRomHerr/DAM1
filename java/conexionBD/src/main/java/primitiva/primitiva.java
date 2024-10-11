/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primitiva;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class primitiva {
    public static void main(String[] args) {
        // Crear una lista con números del 1 al 49
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            numeros.add(i);
        }

        // Mezclar la lista
        Collections.shuffle(numeros, new Random());

        // Obtener los primeros 7 números
        List<Integer> seleccionados = new ArrayList<>(numeros.subList(0, 7));

        // Separar los primeros 6 números y el complementario
        List<Integer> principales = seleccionados.subList(0, 6);
        int complementario = seleccionados.get(6);

        // Ordenar los números principales de menor a mayor
        Collections.sort(principales);

        // Mostrar los números principales ordenados
        System.out.println("Números principales: " + principales);

        // Mostrar el número complementario
        System.out.println("Número complementario: " + complementario);
    }
}
