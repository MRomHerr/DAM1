/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ahorcado;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ahorcadoExcepciones {

    // Lista de palabras para el juego
    private static final String[] PALABRAS = {
        "programacion", "java", "ahorcado", "desarrollo", "codigo", "tecnologia"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String palabra = PALABRAS[random.nextInt(PALABRAS.length)];
        char[] palabraOculta = new char[palabra.length()];
        List<Character> letrasAdivinadas = new ArrayList<>();

        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '*';
        }

        int intentos = 6;
        boolean adivinada = false;

        try {
            while (intentos > 0 && !adivinada) {
                System.out.println("Palabra: " + String.valueOf(palabraOculta));
                System.out.println("Intentos restantes: " + intentos);
                System.out.print("Adivina una letra: ");

                char letra;
                try {
                    String input = scanner.next();
                    if (input.length() != 1) {
                        throw new IllegalArgumentException("Debes ingresar una sola letra.");
                    }
                    letra = input.charAt(0);
                } catch (IllegalArgumentException e) {
                    System.out.println("Entrada no válida: " + e.getMessage());
                    continue;
                }

                if (letrasAdivinadas.contains(letra)) {
                    System.out.println("Ya has adivinado esa letra. Intenta con otra.");
                    continue;
                }

                letrasAdivinadas.add(letra);

                boolean letraCorrecta = false;
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == letra) {
                        palabraOculta[i] = letra;
                        letraCorrecta = true;
                    }
                }

                if (!letraCorrecta) {
                    intentos--;
                }

                adivinada = !String.valueOf(palabraOculta).contains("*");
            }

            if (adivinada) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabra);
            } else {
                System.out.println("¡Has perdido! La palabra era: " + palabra);
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
