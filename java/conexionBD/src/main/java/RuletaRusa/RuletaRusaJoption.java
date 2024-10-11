
package RuletaRusa;


import java.sql.*;
import javax.swing.JOptionPane;

public class RuletaRusaJoption {

    private static String jugador1;
    private static String jugador2;
    private static int parti = 1;
    private static int resPerdi = 1;
    private static int resTotal = 0;

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://192.168.1.99:3306/Empresa", "marcos1", "MRomHerr170514!");

            JOptionPane.showMessageDialog(null, "| RULETA RUSA |");

            jugador1 = JOptionPane.showInputDialog("Ingrese el nombre del jugador 1: ");
            jugador2 = JOptionPane.showInputDialog("Ingrese el nombre del jugador 2: ");

            // Insertar jugadores en la base de datos
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Jugadores (nombre) VALUES (?), (?)");
            pstmt.setString(1, jugador1);
            pstmt.setString(2, jugador2);
            pstmt.executeUpdate();

            int opc;
            do {
                opc = Integer.parseInt(JOptionPane.showInputDialog("           Orden del Juego\n1. inicia primer partida del jugador 1\n2. inicia primer partida del segundo 2\n3. inicio segunda partida del jugador 1\n4. inicio segunda partida del jugador 2"));

                switch (opc) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "  PRIMER JUEGO DEL PRIMER JUGADOR  ");

                        JOptionPane.showMessageDialog(null, "|   Jugador   " + jugador1 + "  |");
                        disparo(jugador1, conn);
                        break;
                    // Aquí puedes agregar los casos para 2, 3, 4 si lo necesitas
                }
            } while (resPerdi != 0);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    private static void disparo(String jugador, Connection conn) {
        JOptionPane.showMessageDialog(null, "Partida número # " + parti);
        parti++;

        for (int part = 1; part <= 8; part++) {
            JOptionPane.showMessageDialog(null, "\nIntento # " + part + "\n");
            int num = (int) (Math.random() * 8) + 1;
            int numVerificar = (int) (Math.random() * 4) + 1;
            JOptionPane.showMessageDialog(null, "Posición " + num);

            if (num != numVerificar) {
                int nAzar = (int) (Math.random() * 10) + 1;
                JOptionPane.showMessageDialog(null, "Puntos obtenidos: " + nAzar);
                resTotal += nAzar;
            }

            if (num == numVerificar) {
                resPerdi = 0;
                JOptionPane.showMessageDialog(null, " ========================================\n |              Perdiste                |\n |         Posición de la bala: " + numVerificar + " |\n ========================================");

                JOptionPane.showMessageDialog(null, "Puntos: " + resPerdi + "\n");

                // Insertar resultados en la base de datos
                try {
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Partidas (jugador_id, puntos, perdio) VALUES ((SELECT id FROM Jugadores WHERE nombre = ?), ?, ?)");
                    pstmt.setString(1, jugador);
                    pstmt.setInt(2, resTotal);
                    pstmt.setBoolean(3, true);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                break;
            }
        }

        JOptionPane.showMessageDialog(null, "");
    }
}
