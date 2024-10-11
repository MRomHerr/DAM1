package juegoexamen2;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        while (true) {
            String menu = "Menú:\n" +
                          "1. Jugar partida\n" +
                          "2. Mostrar records\n" +
                          "3. Salir\n" +
                          "Selecciona una opción:";
            String input = JOptionPane.showInputDialog(menu);
            if (input == null) {
                // Cancelar o cerrar el cuadro de diálogo se considera salir del juego
                JOptionPane.showMessageDialog(null, "Saliendo del juego...");
                return;
            }

            int opcion;
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, selecciona una opción válida.");
                continue;
            }

            switch (opcion) {
                case 1:
                    jugarPartida();
                    break;
                case 2:
                    mostrarRecords();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del juego...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }

    private static void jugarPartida() {
        String dni = JOptionPane.showInputDialog("Introduce tu DNI:");
        if (dni == null) return;

        String nombreCompleto = JOptionPane.showInputDialog("Introduce tu nombre completo:");
        if (nombreCompleto == null) return;

        Usuario usuario = new Usuario(dni, nombreCompleto);
        Partida partida = new Partida(usuario, new Date(), generarNumeroAleatorio());
        partida.jugar();
        guardarPartida(partida);
    }

    private static void mostrarRecords() {
        StringBuilder records = new StringBuilder();
        try (BufferedReader lector = new BufferedReader(new FileReader(".//src//main//java//juegoexamen2//partidas.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                records.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, records.toString(), "Records", JOptionPane.INFORMATION_MESSAGE);
    }

    private static int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(5001); // Números del 0 al 5000
    }

    private static void guardarPartida(Partida partida) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(".//src//main//java//juegoexamen2//partidas.txt", true))) {
            escritor.write(partida.toString());
            escritor.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
