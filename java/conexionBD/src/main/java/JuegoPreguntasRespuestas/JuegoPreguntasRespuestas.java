/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JuegoPreguntasRespuestas;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JuegoPreguntasRespuestas {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_basededatos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static void main(String[] args) {
        int puntaje = 0;

        JOptionPane.showMessageDialog(null, "Bienvenido al juego de preguntas y respuestas.");

        for (String[] preguntaRespuesta : obtenerPreguntasRespuestas()) {
            String respuestaUsuario = JOptionPane.showInputDialog(null, preguntaRespuesta[0]);

            if (respuestaUsuario != null && respuestaUsuario.equalsIgnoreCase(preguntaRespuesta[1])) {
                JOptionPane.showMessageDialog(null, "¡Respuesta correcta!");
                puntaje++;
            } else {
                JOptionPane.showMessageDialog(null, "Respuesta incorrecta. La respuesta correcta es: " + preguntaRespuesta[1]);
            }
        }

        JOptionPane.showMessageDialog(null, "Tu puntaje final es: " + puntaje);

        // Actualizar la base de datos con el nuevo puntaje
        actualizarPuntaje(puntaje);
    }

    private static String[][] obtenerPreguntasRespuestas() {
        String[][] preguntasRespuestas = new String[3][2];

        // Consulta a la base de datos para obtener las preguntas y respuestas
        String obtenerPreguntasQuery = "SELECT pregunta, respuesta FROM preguntas_respuestas";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(obtenerPreguntasQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            int index = 0;
            while (resultSet.next()) {
                preguntasRespuestas[index][0] = resultSet.getString("pregunta");
                preguntasRespuestas[index][1] = resultSet.getString("respuesta");
                index++;
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las preguntas y respuestas: " + e.getMessage());
        }

        return preguntasRespuestas;
    }

    private static void actualizarPuntaje(int puntaje) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Actualizar el puntaje
            String actualizarPuntajeQuery = "UPDATE jugador SET puntaje = ? WHERE id = 1";
            PreparedStatement actualizarPuntajeStatement = connection.prepareStatement(actualizarPuntajeQuery);
            actualizarPuntajeStatement.setInt(1, puntaje);
            actualizarPuntajeStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Puntaje actualizado en la base de datos: " + puntaje);
        } catch (SQLException e) {
            System.err.println("Error al actualizar el puntaje en la base de datos: " + e.getMessage());
        }
    }
}
