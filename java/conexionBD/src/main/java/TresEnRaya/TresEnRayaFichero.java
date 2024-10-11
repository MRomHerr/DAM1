/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TresEnRaya;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;

public class TresEnRayaFichero {
    private static char[][] tablero = new char[3][3];
    private static char jugadorActual = 'X';

    public static void main(String[] args) {
        inicializarTablero();

        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            mostrarTablero();
            int fila = obtenerFila();
            int columna = obtenerColumna();

            if (validarMovimiento(fila, columna)) {
                realizarMovimiento(fila, columna);
                juegoTerminado = verificarGanador() || tableroLleno();
                cambiarJugador();
            } else {
                JOptionPane.showMessageDialog(null, "Movimiento no válido. Inténtalo de nuevo.");
            }
        }

        mostrarTablero();
        if (verificarGanador()) {
            JOptionPane.showMessageDialog(null, "¡Felicidades! El jugador " + jugadorActual + " ha ganado.");
        } else {
            JOptionPane.showMessageDialog(null, "¡Empate! No hay ganador.");
        }

        guardarTableroEnArchivo();
    }

    private static void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    private static void mostrarTablero() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tablero[i][j]).append(" ");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static int obtenerFila() {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila (0, 1 o 2): "));
    }

    private static int obtenerColumna() {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna (0, 1 o 2): "));
    }

    private static boolean validarMovimiento(int fila, int columna) {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == '-';
    }

    private static void realizarMovimiento(int fila, int columna) {
        tablero[fila][columna] = jugadorActual;
    }

    private static void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }

    private static boolean verificarGanador() {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != '-' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] != '-' && tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] != '-' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true;
        }
        if (tablero[0][2] != '-' && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true;
        }

        return false;
    }

    private static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void guardarTableroEnArchivo() {
        try (FileWriter writer = new FileWriter("tablero.txt")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    writer.write(tablero[i][j]);
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
