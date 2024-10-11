package JuegoPreguntasRespuestas;

import javax.swing.JOptionPane;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JuegoPreguntasRespuestas2 {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_basededatos";
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

    private static void jugar() {
        int puntaje = 0;
        StringBuilder respuestasJugador = new StringBuilder();
        StringBuilder respuestasCorrectas = new StringBuilder();

        JOptionPane.showMessageDialog(null, "Bienvenido al juego de preguntas y respuestas.");

        String[][] preguntasRespuestas = {
            {"¿Cuál es la capital de Francia?", "París"},
            {"¿Quién escribió 'Don Quijote de la Mancha'?", "Miguel de Cervantes"},
            {"¿Cuántos planetas tiene el sistema solar?", "Ocho"}
        };

        for (String[] preguntaRespuesta : preguntasRespuestas) {
            String respuestaUsuario = JOptionPane.showInputDialog(null, preguntaRespuesta[0]);

            if (respuestaUsuario != null) {
                respuestasJugador.append(respuestaUsuario).append(";");
            } else {
                respuestasJugador.append("Sin respuesta").append(";");
            }

            respuestasCorrectas.append(preguntaRespuesta[1]).append(";");

            if (respuestaUsuario != null && respuestaUsuario.equalsIgnoreCase(preguntaRespuesta[1])) {
                JOptionPane.showMessageDialog(null, "¡Respuesta correcta!");
                puntaje++;
            } else {
                JOptionPane.showMessageDialog(null, "Respuesta incorrecta. La respuesta correcta es: " + preguntaRespuesta[1]);
            }
        }

        JOptionPane.showMessageDialog(null, "Tu puntaje final es: " + puntaje);

        // Actualizar la base de datos con el nuevo puntaje
        actualizarPuntaje(puntaje, respuestasJugador.toString(), respuestasCorrectas.toString());
    }

    private static void actualizarPuntaje(int puntaje, String respuestasJugador, String respuestasCorrectas) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Insertar nueva partida
            String insertarPartidaQuery = "INSERT INTO Partidas (jugador_id, puntaje, respuestas_jugador, respuestas_correctas, fecha_hora) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertarPartidaStatement = connection.prepareStatement(insertarPartidaQuery);
            insertarPartidaStatement.setInt(1, 1);  // Asumiendo que el id del jugador es 1
            insertarPartidaStatement.setInt(2, puntaje);
            insertarPartidaStatement.setString(3, respuestasJugador);
            insertarPartidaStatement.setString(4, respuestasCorrectas);
            insertarPartidaStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            insertarPartidaStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Puntaje actualizado en la base de datos: " + puntaje);
        } catch (SQLException e) {
            System.err.println("Error al actualizar el puntaje en la base de datos: " + e.getMessage());
        }
    }

    private static void verPuntuacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Puntuación de partidas:\n");
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT p.id, j.nombre, p.puntaje, p.respuestas_jugador, p.respuestas_correctas, p.fecha_hora FROM Partidas p JOIN jugador j ON p.jugador_id = j.id";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                sb.append("Partida ID: ").append(rs.getInt("id"))
                  .append(", Jugador: ").append(rs.getString("nombre"))
                  .append(", Puntaje: ").append(rs.getInt("puntaje"))
                  .append(", Respuestas Jugador: ").append(rs.getString("respuestas_jugador"))
                  .append(", Respuestas Correctas: ").append(rs.getString("respuestas_correctas"))
                  .append(", Fecha y Hora: ").append(rs.getTimestamp("fecha_hora"))
                  .append("\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
