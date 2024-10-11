/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitiva;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class primitivaficherosobjetos {
    private int[] combinacionGanadora;
    private int[] combinacionUsuario;
    private int aciertos;

    public primitivaficherosobjetos() {
        combinacionGanadora = generarCombinacionGanadora();
        combinacionUsuario = new int[6];
        aciertos = 0;
    }

    // Método para generar una combinación ganadora aleatoria
    private int[] generarCombinacionGanadora() {
        Random random = new Random();
        int[] combinacion = new int[6];
        for (int i = 0; i < 6; i++) {
            combinacion[i] = random.nextInt(49) + 1; // Números del 1 al 49
        }
        return combinacion;
    }

    // Método para establecer la combinación del usuario
    public void setCombinacionUsuario(int[] combinacionUsuario) {
        this.combinacionUsuario = combinacionUsuario;
    }

    // Método para contar el número de aciertos entre la combinación ganadora y la del usuario
    public void contarAciertos() {
        aciertos = 0;
        for (int i = 0; i < 6; i++) {
            if (combinacionGanadora[i] == combinacionUsuario[i]) {
                aciertos++;
            }
        }
    }

    // Método para obtener la combinación ganadora
    public int[] getCombinacionGanadora() {
        return combinacionGanadora;
    }

    // Método para obtener la combinación del usuario
    public int[] getCombinacionUsuario() {
        return combinacionUsuario;
    }

    // Método para obtener el número de aciertos
    public int getAciertos() {
        return aciertos;
    }

    // Método para guardar los resultados en un archivo
    public void guardarResultados(String rutaArchivo) {
        try (BufferedWriter escritura = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            escritura.write("Combinación ganadora: " + Arrays.toString(combinacionGanadora) + "\n");
            escritura.write("Tu combinación: " + Arrays.toString(combinacionUsuario) + "\n");
            escritura.write("Número de aciertos: " + aciertos + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


