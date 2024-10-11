/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JuegoAdivinanzas;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JuegoAdivinanzas {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_basededatos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static void main(String[] args) {
        int intentos = 0;
        int intentoUsuario = 0;

        JOptionPane.showMessageDialog(null, "Bienvenido al juego de adivinanzas. Adivina el número secreto entre 1 y 100.");

        // Generar número secreto
        int numeroSecreto = (int) (Math.random() * 100) + 1;

        while (intentoUsuario != numeroSecreto) {
            String intentoUsuarioStr = JOptionPane.showInputDialog(null, "Introduce tu intento:");
            intentoUsuario = Integer.parseInt(intentoUsuarioStr);
            intentos++;

            if (intentoUsuario < numeroSecreto) {
                JOptionPane.showMessageDialog(null, "El número secreto es mayor.");
            } else if (intentoUsuario > numeroSecreto) {
                JOptionPane.showMessageDialog(null, "El número secreto es menor.");
            }
        }

        JOptionPane.showMessageDialog(null, "¡Felicidades! Has adivinado el número secreto en " + intentos + " intentos.");

        // Actualizar la base de datos con el nuevo puntaje
        actualizarPuntaje(intentos);
    }

    private static void actualizarPuntaje(int intentos) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Obtener el puntaje actual
            int puntajeActual = obtenerPuntaje(connection);

            // Actualizar el puntaje
            puntajeActual++; // Sumar un punto por adivinar el número
            actualizarPuntajeEnDB(connection, puntajeActual);

            JOptionPane.showMessageDialog(null, "Puntaje actualizado en la base de datos: " + puntajeActual);
        } catch (SQLException e) {
            System.err.println("Error al actualizar el puntaje en la base de datos: " + e.getMessage());
        }
    }

    private static int obtenerPuntaje(Connection connection) throws SQLException {
        int puntajeActual = 0;
        String obtenerPuntajeQuery = "SELECT puntaje FROM jugador WHERE id = 1";
        try (PreparedStatement obtenerPuntajeStatement = connection.prepareStatement(obtenerPuntajeQuery);
             ResultSet resultSet = obtenerPuntajeStatement.executeQuery()) {
            if (resultSet.next()) {
                puntajeActual = resultSet.getInt("puntaje");
            }
        }
        return puntajeActual;
    }

    private static void actualizarPuntajeEnDB(Connection connection, int puntajeActual) throws SQLException {
        String actualizarPuntajeQuery = "UPDATE jugador SET puntaje = ? WHERE id = 1";
        try (PreparedStatement actualizarPuntajeStatement = connection.prepareStatement(actualizarPuntajeQuery)) {
            actualizarPuntajeStatement.setInt(1, puntajeActual);
            actualizarPuntajeStatement.executeUpdate();
        }
    }
}
