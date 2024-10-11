/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RuletaRusa;

import java.sql.*;
import java.util.Scanner;

public class RulrtaRusa {

    private static String jugador1;
    private static String jugador2;
    private static Scanner teclado = new Scanner(System.in);
    private static int parti = 1;
    private static int resPerdi = 1;
    private static int resTotal = 0;

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://192.168.1.99:3306/Empresa", "marcos1", "MRomHerr170514!");

            System.out.println("======================================");
            System.out.println("|             RULETA RUSA            |");
            System.out.println("======================================");
            System.out.println("");

            System.out.print("Ingrese el nombre del jugador 1: ");
            jugador1 = teclado.nextLine();
            System.out.print("Ingrese el nombre del jugador 2: ");
            jugador2 = teclado.nextLine();

            // Insertar jugadores en la base de datos
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Jugadores (nombre) VALUES (?), (?)");
            pstmt.setString(1, jugador1);
            pstmt.setString(2, jugador2);
            pstmt.executeUpdate();

            int opc;
            do {
                System.out.println("           Orden del Juego");
                System.out.println("1. inicia primer partida del jugador 1");
                System.out.println("2. inicia primer partida del segundo 2");
                System.out.println("3. inicio segunda partida del jugador 1");
                System.out.println("4. inicio segunda partida del jugador 2");
                opc = teclado.nextInt();

                switch (opc) {
                    case 1:
                        System.out.println("***********************************************");
                        System.out.println("        PRIMER JUEGO DEL PRIMER JUGADOR");
                        System.out.println("***********************************************");
                        System.out.println("");

                        System.out.println("   ************************");
                        System.out.println("   |   Jugador   " + jugador1 + "  |");
                        System.out.println("   ************************");
                        System.out.println("");
                        disparo(jugador1, conn);
                        break;
                    // Aquí puedes agregar los casos para 2, 3, 4 si lo necesitas
                }
            } while (resPerdi != 0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void disparo(String jugador, Connection conn) {
        System.out.println("Partida número # " + parti);
        parti++;

        for (int part = 1; part <= 8; part++) {
            System.out.println("");
            System.out.println("Intento # " + part);
            System.out.println("");
            int num = (int) (Math.random() * 8) + 1;
            int numVerificar = (int) (Math.random() * 4) + 1;
            System.out.println("Posición " + num);

            if (num != numVerificar) {
                int nAzar = (int) (Math.random() * 10) + 1;
                System.out.println("Puntos obtenidos: " + nAzar);
                resTotal += nAzar;
            }

            if (num == numVerificar) {
                resPerdi = 0;
                System.out.println(" ========================================");
                System.out.println(" |              Perdiste                |");
                System.out.println(" |         Posición de la bala: " + numVerificar + " |");
                System.out.println(" ========================================");

                System.out.println("Puntos: " + resPerdi);
                System.out.println("");
                teclado.nextLine(); // Espera a que el usuario presione una tecla

                // Insertar resultados en la base de datos
                try {
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Partidas (jugador_id, puntos, perdio) VALUES ((SELECT id FROM Jugadores WHERE nombre = ?), ?, ?)");
                    pstmt.setString(1, jugador);
                    pstmt.setInt(2, resTotal);
                    pstmt.setBoolean(3, true);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

                break;
            }
        }

        System.out.println("");
    }
}
