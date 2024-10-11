/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TresEnRaya;


import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class conBase {
    private static char[][] tablero = new char[3][3];
    private static char jugadorActual = 'X';

    // Constantes para la conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/tres_en_raya_db";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(null, "Menú:\n1. Jugar\n2. Ver Puntuación\n3. Salir\nElige una opción:");

            switch (opcion) {
                case "1":
                    jugar();
                    break;
                case "2":
                    verPuntuacion();
                    break;
                case "3":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtalo de nuevo.");
            }
        }
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

    private static void guardarMovimientoEnDB(int fila, int columna, char jugador) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO movimientos (fila, columna, jugador) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setInt(1, fila);
                statement.setInt(2, columna);
                statement.setString(3, String.valueOf(jugador));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void guardarResultadoEnDB(char ganador) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO resultados (ganador, fecha_hora) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setString(1, String.valueOf(ganador));
                statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void jugar() {
        inicializarTablero();
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            mostrarTablero();
            int fila = obtenerFila();
            int columna = obtenerColumna();

            if (validarMovimiento(fila, columna)) {
                realizarMovimiento(fila, columna);
                guardarMovimientoEnDB(fila, columna, jugadorActual);
                juegoTerminado = verificarGanador() || tableroLleno();
                if (juegoTerminado) {
                    guardarResultadoEnDB(jugadorActual);
                }
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
    }

    private static void verPuntuacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultados de partidas:\n");
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM resultados";
            try (PreparedStatement statement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    sb.append("Partida ID: ").append(resultSet.getInt("id")).append(", Ganador: ")
                      .append(resultSet.getString("ganador")).append(", Fecha y Hora: ")
                      .append(resultSet.getTimestamp("fecha_hora")).append("\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
