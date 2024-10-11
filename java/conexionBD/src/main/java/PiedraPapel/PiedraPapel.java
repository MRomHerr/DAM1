/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PiedraPapel;

import java.sql.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PiedraPapel {
    public static void main(String[] args) {
        String[] elecciones = {"piedra", "papel", "tijera"};
        Scanner teclado = new Scanner(System.in);

        System.out.println("Juego de Piedra, Papel o Tijera");
        System.out.print("Elige (piedra, papel, tijera): ");
        String eleccionUsuario = teclado.nextLine().toLowerCase();

        int indiceEleccionComputadora = (int) (Math.random() * 3);
        String eleccionComputadora = elecciones[indiceEleccionComputadora];

        System.out.println("Computadora eligió: " + eleccionComputadora);

        String resultado;
        if (eleccionUsuario.equals(eleccionComputadora)) {
            resultado = "Empate.";
        } else if ((eleccionUsuario.equals("piedra") && eleccionComputadora.equals("tijera")) ||
                   (eleccionUsuario.equals("papel") && eleccionComputadora.equals("piedra")) ||
                   (eleccionUsuario.equals("tijera") && eleccionComputadora.equals("papel"))) {
            resultado = "¡Ganaste!";
        } else {
            resultado = "Perdiste.";
        }
        System.out.println(resultado);

        // Conexión a la base de datos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.99:3306/Empresa", "marcos1", "MRomHerr170514!")) {
            // Insertar el resultado en la base de datos
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Partidas (jugador_id, eleccion, resultado) VALUES ((SELECT id FROM Jugadores WHERE nombre = ?), ?, ?)");
            pstmt.setString(1, "Usuario");  // Asumiendo que el nombre del jugador es "Usuario"
            pstmt.setString(2, eleccionUsuario);
            pstmt.setString(3, resultado);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}