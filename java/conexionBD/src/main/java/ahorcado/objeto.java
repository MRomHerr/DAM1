/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class objeto {
    private static final String[] PALABRAS = {
        "programacion", "java", "ahorcado", "desarrollo", "codigo", "tecnologia"
    };

    private String palabra;
    private char[] palabraOculta;
    private List<Character> letrasAdivinadas;
    private int intentos;

    public objeto() {
        Random random = new Random();
        this.palabra = PALABRAS[random.nextInt(PALABRAS.length)];
        this.palabraOculta = new char[palabra.length()];
        this.letrasAdivinadas = new ArrayList<>();
        this.intentos = 6;

        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '*';
        }
    }

    public boolean estaAdivinada() {
        return !String.valueOf(palabraOculta).contains("*");
    }

    public boolean adivinarLetra(char letra) {
        if (!Character.isLetter(letra) || !Character.UnicodeBlock.of(letra).equals(Character.UnicodeBlock.BASIC_LATIN)) {
            throw new IllegalArgumentException("Debe ingresar una letra del alfabeto español.");
        }

        if (letrasAdivinadas.contains(letra)) {
            throw new IllegalArgumentException("Ya has adivinado esa letra. Intenta con otra.");
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

        return letraCorrecta;
    }

    public String getPalabraOculta() {
        return String.valueOf(palabraOculta);
    }

    public int getIntentosRestantes() {
        return intentos;
    }

    public String getPalabra() {
        return palabra;
    }
}
