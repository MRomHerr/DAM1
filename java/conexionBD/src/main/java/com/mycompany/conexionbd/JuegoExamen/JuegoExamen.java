/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.conexionbd.JuegoExamen;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class JuegoExamen {
    static final String DB_URL = "jdbc:mysql://localhost/JuegoDB";
    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Jugar partida");
            System.out.println("2. Mostrar records");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    jugarPartida();
                    break;
                case 2:
                    mostrarRecords();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void jugarPartida() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement insertPartida = conn.prepareStatement("INSERT INTO Partidas (dni, fechaPartida, puntuacion, intentos) VALUES (?, CURDATE(), ?, ?)")) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int numeroAleatorio = random.nextInt(5001);
            double puntuacion = 10.0;
            int intentos = 0;

            System.out.print("Introduce tu DNI: ");
            String dni = scanner.next();

            while (puntuacion > 0) {
                System.out.print("Introduce un valor entre 0 y 5000: ");
                int numeroUsuario = scanner.nextInt();
                intentos++;

                if (numeroUsuario == numeroAleatorio) {
                    System.out.println("¡Has adivinado el número! Enhorabuena. Has obtenido una puntuación de " + puntuacion + " puntos.");
                    break;
                } else if (numeroUsuario < numeroAleatorio) {
                    System.out.println("El número es mayor.");
                } else {
                    System.out.println("El número es menor.");
                }

                if (intentos <= 5) {
                    puntuacion -= 2;
                } else {
                    puntuacion -= 0.1;
                }
            }

            if (puntuacion <= 0) {
                System.out.println("La puntuación ha llegado a cero. Fin de la partida.");
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
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Jugadores JOIN Partidas ON Jugadores.dni = Partidas.dni ORDER BY puntuacion DESC LIMIT 10";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String nombreCompleto = rs.getString("nombreCompleto");
                double puntuacion = rs.getDouble("puntuacion");
                System.out.println(nombreCompleto + " " + puntuacion + " puntos");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
