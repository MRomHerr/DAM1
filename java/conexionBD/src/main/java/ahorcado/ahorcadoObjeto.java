
package ahorcado;

import java.util.Scanner;

public class ahorcadoObjeto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        objeto juego = new objeto();

        try {
            while (juego.getIntentosRestantes() > 0 && !juego.estaAdivinada()) {
                System.out.println("Palabra: " + juego.getPalabraOculta());
                System.out.println("Intentos restantes: " + juego.getIntentosRestantes());
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

                try {
                    juego.adivinarLetra(letra);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (juego.estaAdivinada()) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + juego.getPalabra());
            } else {
                System.out.println("¡Has perdido! La palabra era: " + juego.getPalabra());
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
