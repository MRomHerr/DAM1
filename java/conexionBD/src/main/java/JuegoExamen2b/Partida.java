/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JuegoExamen2b;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Partida {
    private static final int MAX_INTENTOS = 5;
    private static final double PUNTOS_INICIALES = 10.0;
    private static final double DESCUENTO_POR_INTENTO = 2.0;
    private static final double DESCUENTO_POR_INTENTO_POSTERIOR = 0.1;

    private Usuario usuario;
    private Timestamp fecha;
    private double puntuacion;
    private List<Integer> intentos;
    private int numeroAdivinar;

    public Partida(Usuario usuario, Timestamp fecha, int numeroAdivinar) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.numeroAdivinar = numeroAdivinar;
        this.puntuacion = PUNTOS_INICIALES;
        this.intentos = new ArrayList<>();
    }

    public void jugar() {
        int intento = 0;

        JOptionPane.showMessageDialog(null, "¡Bienvenido a la Primitiva!");
        while (intento < MAX_INTENTOS) {
            String input = JOptionPane.showInputDialog("Introduce un valor entre 0 y 5000:");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Juego cancelado.");
                return;
            }

            int numeroUsuario;
            try {
                numeroUsuario = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número no válido. Por favor, introduce un número válido.");
                continue;
            }

            intentos.add(numeroUsuario);

            if (numeroUsuario == numeroAdivinar) {
                JOptionPane.showMessageDialog(null, "¡Has adivinado el número! Enhorabuena, " + usuario.getNombreCompleto() + ".");
                break;
            } else if (numeroUsuario < numeroAdivinar) {
                JOptionPane.showMessageDialog(null, "El número a adivinar es mayor.");
            } else {
                JOptionPane.showMessageDialog(null, "El número a adivinar es menor.");
            }

            intento++;
            actualizarPuntuacion();
        }

        if (intento == MAX_INTENTOS) {
            JOptionPane.showMessageDialog(null, "¡Se han agotado los intentos! El número a adivinar era: " + numeroAdivinar);
        }
    }

    private void actualizarPuntuacion() {
        if (puntuacion > 0) {
            if (intentos.size() > MAX_INTENTOS) {
                puntuacion -= DESCUENTO_POR_INTENTO_POSTERIOR;
            } else {
                puntuacion -= DESCUENTO_POR_INTENTO;
            }
            if (puntuacion < 0) {
                puntuacion = 0;
            }
        }
    }

    public void guardarEnBaseDeDatos(Connection conn) throws SQLException {
        // Guardar usuario si no existe
        String insertUsuarioSQL = "INSERT IGNORE INTO usuarios (dni, nombre_completo) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertUsuarioSQL)) {
            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getNombreCompleto());
            ps.executeUpdate();
        }

        // Guardar partida
        String insertPartidaSQL = "INSERT INTO partidas (dni, fecha, puntuacion, numero_adivinar) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertPartidaSQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, usuario.getDni());
            ps.setTimestamp(2, fecha);
            ps.setDouble(3, puntuacion);
            ps.setInt(4, numeroAdivinar);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int partidaId = rs.getInt(1);

                    // Guardar intentos
                    String insertIntentoSQL = "INSERT INTO intentos (partida_id, intento) VALUES (?, ?)";
                    try (PreparedStatement psIntento = conn.prepareStatement(insertIntentoSQL)) {
                        for (int intento : intentos) {
                            psIntento.setInt(1, partidaId);
                            psIntento.setInt(2, intento);
                            psIntento.addBatch();
                        }
                        psIntento.executeBatch();
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DNI: ").append(usuario.getDni()).append("\n");
        stringBuilder.append("Nombre: ").append(usuario.getNombreCompleto()).append("\n");
        stringBuilder.append("Fecha partida: ").append(fecha).append("\n");
        stringBuilder.append("Puntuación: ").append(puntuacion).append("\n");
        stringBuilder.append("N° intentos: ").append(intentos.size()).append("\n");
        stringBuilder.append("Intentos: ").append(Arrays.toString(intentos.toArray())).append("\n");
        return stringBuilder.toString();
    }
}