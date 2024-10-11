package com.mycompany.conexionbd.JuegoExamen;

import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class JuegoExamenPrepareJoption {
    static final String DB_URL = "jdbc:mysql://localhost/JuegoDB";
    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) {
        while (true) {
            try {
                String opcion = JOptionPane.showInputDialog("1. Jugar partida\n2. Mostrar records\n3. Salir\nElige una opción:");
                switch (opcion) {
                    case "1":
                        jugarPartida();
                        break;
                    case "2":
                        mostrarRecords();
                        break;
                    case "3":
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, introduzca un número válido para la opción del menú.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

    public static void jugarPartida() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement insertPartida = conn.prepareStatement("INSERT INTO Partidas (dni, fechaPartida, puntuacion, intentos) VALUES (?, CURDATE(), ?, ?)")) {
            Random random = new Random();
            int numeroAleatorio = random.nextInt(5001);
            double puntuacion = 10.0;
            int intentos = 0;

            String dni = JOptionPane.showInputDialog("Introduce tu DNI:");

            while (puntuacion > 0) {
                int numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog("Introduce un valor entre 0 y 5000:"));
                intentos++;

                if (numeroUsuario == numeroAleatorio) {
                    JOptionPane.showMessageDialog(null, "¡Has adivinado el número! Enhorabuena. Has obtenido una puntuación de " + puntuacion + " puntos.");
                    break;
                } else if (numeroUsuario < numeroAleatorio) {
                    JOptionPane.showMessageDialog(null, "El número es mayor.");
                } else {
                    JOptionPane.showMessageDialog(null, "El número es menor.");
                }

                if (intentos <= 5) {
                    puntuacion -= 2;
                } else {
                    puntuacion -= 0.1;
                }
            }

            if (puntuacion <= 0) {
                JOptionPane.showMessageDialog(null, "La puntuación ha llegado a cero. Fin de la partida.");
                puntuacion = 0;
            }

            insertPartida.setString(1, dni);
            insertPartida.setDouble(2, puntuacion);
            insertPartida.setInt(3, intentos);
            insertPartida.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void mostrarRecords() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Jugadores JOIN Partidas ON Jugadores.dni = Partidas.dni ORDER BY puntuacion DESC LIMIT 10")) {
            ResultSet rs = stmt.executeQuery();
            StringBuilder records = new StringBuilder();
            while (rs.next()) {
                String nombreCompleto = rs.getString("nombreCompleto");
                double puntuacion = rs.getDouble("puntuacion");
                records.append(nombreCompleto).append(" ").append(puntuacion).append(" puntos\n");
            }
            JOptionPane.showMessageDialog(null, records.toString());
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
