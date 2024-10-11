/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JuegoExamen2b;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.Random;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/juegoexamen2";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    

    private static void jugarPartida() {
        String dni = JOptionPane.showInputDialog("Introduce tu DNI:");
        if (dni == null) return;

        String nombreCompleto = JOptionPane.showInputDialog("Introduce tu nombre completo:");
        if (nombreCompleto == null) return;

        Usuario usuario = new Usuario(dni, nombreCompleto);
        Partida partida = new Partida(usuario, new Timestamp(new Date().getTime()), generarNumeroAleatorio());
        partida.jugar();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            partida.guardarEnBaseDeDatos(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarRecords() {
        StringBuilder records = new StringBuilder();
        String query = "SELECT p.dni, u.nombre_completo, p.fecha, p.puntuacion, p.numero_adivinar " +
                       "FROM partidas p JOIN usuarios u ON p.dni = u.dni";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                records.append("DNI: ").append(rs.getString("dni")).append("\n");
                records.append("Nombre: ").append(rs.getString("nombre_completo")).append("\n");
                records.append("Fecha: ").append(rs.getTimestamp("fecha")).append("\n");
                records.append("Puntuación: ").append(rs.getDouble("puntuacion")).append("\n");
                records.append("Número a adivinar: ").append(rs.getInt("numero_adivinar")).append("\n");
                records.append("----------------------------\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, records.toString(), "Records", JOptionPane.INFORMATION_MESSAGE);
    }

    private static int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(5001); // Números del 0 al 5000
    }
    
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
}