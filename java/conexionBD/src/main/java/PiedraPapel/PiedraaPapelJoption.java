package PiedraPapel;

import java.sql.*;
import javax.swing.JOptionPane;

public class PiedraaPapelJoption {
    private static final String URL = "jdbc:mysql://192.168.1.99:3306/Empresa";
    private static final String USER = "marcos1";
    private static final String PASSWORD = "MRomHerr170514!";

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

    private static void jugar() {
        String[] elecciones = {"piedra", "papel", "tijera"};

        String eleccionUsuario = JOptionPane.showInputDialog(null, "Juego de Piedra, Papel o Tijera\nElige (piedra, papel, tijera): ").toLowerCase();

        int indiceEleccionComputadora = (int) (Math.random() * 3);
        String eleccionComputadora = elecciones[indiceEleccionComputadora];

        JOptionPane.showMessageDialog(null, "Computadora eligió: " + eleccionComputadora);

        String resultado;
        String ganador;
        String perdedor = "Usuario";

        if (eleccionUsuario.equals(eleccionComputadora)) {
            resultado = "Empate.";
            ganador = "Nadie";
        } else if ((eleccionUsuario.equals("piedra") && eleccionComputadora.equals("tijera")) ||
                   (eleccionUsuario.equals("papel") && eleccionComputadora.equals("piedra")) ||
                   (eleccionUsuario.equals("tijera") && eleccionComputadora.equals("papel"))) {
            resultado = "¡Ganaste!";
            ganador = "Usuario";
            perdedor = "Computadora";
        } else {
            resultado = "Perdiste.";
            ganador = "Computadora";
        }
        JOptionPane.showMessageDialog(null, resultado);

        // Conexión a la base de datos
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Insertar el resultado en la base de datos
            String query = "INSERT INTO Partidas (jugador_id, eleccion, resultado, fecha_hora) VALUES ((SELECT id FROM Jugadores WHERE nombre = ?), ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "Usuario");  // Asumiendo que el nombre del jugador es "Usuario"
            pstmt.setString(2, eleccionUsuario);
            pstmt.setString(3, resultado);
            pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void verPuntuacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Puntuación de partidas:\n");
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT p.id, j.nombre, p.eleccion, p.resultado, p.fecha_hora FROM Partidas p JOIN Jugadores j ON p.jugador_id = j.id";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                sb.append("Partida ID: ").append(rs.getInt("id"))
                  .append(", Jugador: ").append(rs.getString("nombre"))
                  .append(", Elección: ").append(rs.getString("eleccion"))
                  .append(", Resultado: ").append(rs.getString("resultado"))
                  .append(", Fecha y Hora: ").append(rs.getTimestamp("fecha_hora"))
                  .append("\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
