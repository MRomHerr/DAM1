/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ahorcado;
import javax.swing.JOptionPane;
import java.sql.*;

public class ahorcadoConexion {
    private static String url = "jdbc:mysql://localhost:3306/nombre_basedatos";
    private static String usuario = "tu_usuario";
    private static String contraseña = "tu_contraseña";
    private static Connection con;

    public static void main(String[] args) {
        try {
            con = DriverManager.getConnection(url, usuario, contraseña);
            boolean salir = false;

            while (!salir) {
                String opcion = JOptionPane.showInputDialog(null, "Menú:\n1. Jugar\n2. Ver Puntaje\n3. Salir\nElige una opción:");

                switch (opcion) {
                    case "1":
                        jugar();
                        break;
                    case "2":
                        verPuntaje();
                        break;
                    case "3":
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Inténtalo de nuevo.");
                }
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void jugar() {
        try {
            String palabraSecreta = obtenerPalabraAleatoria(con);
            if (palabraSecreta != null) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido al juego del ahorcado!\nLa palabra tiene " + palabraSecreta.length() + " letras.");

                int intentosRestantes = 6; // Número de intentos permitidos
                StringBuilder letrasCorrectas = new StringBuilder(); // Letras adivinadas correctamente
                boolean juegoTerminado = false;

                while (intentosRestantes > 0 && !juegoTerminado) {
                    String letrasMostradas = "";
                    for (int i = 0; i < palabraSecreta.length(); i++) {
                        char letra = palabraSecreta.charAt(i);
                        letrasMostradas += letrasCorrectas.indexOf(String.valueOf(letra)) != -1 ? letra : "-";
                    }

                    String mensaje = "Intentos restantes: " + intentosRestantes + "\nLetras adivinadas: " + letrasMostradas;
                    String intento = JOptionPane.showInputDialog(null, mensaje + "\nIntroduce una letra:").trim().toLowerCase();

                    if (esLetra(intento)) {
                        if (palabraSecreta.contains(intento)) {
                            letrasCorrectas.append(intento);
                            JOptionPane.showMessageDialog(null, "¡Correcto! La letra '" + intento + "' está en la palabra.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrecto. La letra '" + intento + "' no está en la palabra.");
                            intentosRestantes--;
                        }

                        // Verificar si se han adivinado todas las letras de la palabra
                        boolean todasAdivinadas = true;
                        for (int i = 0; i < palabraSecreta.length(); i++) {
                            if (letrasCorrectas.indexOf(String.valueOf(palabraSecreta.charAt(i))) == -1) {
                                todasAdivinadas = false;
                                break;
                            }
                        }

                        if (todasAdivinadas) {
                            JOptionPane.showMessageDialog(null, "¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
                            juegoTerminado = true;
                            actualizarPuntaje(usuario, palabraSecreta, intentosRestantes, letrasCorrectas.toString());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, introduce una letra del alfabeto.");
                    }
                }

                if (intentosRestantes == 0) {
                    JOptionPane.showMessageDialog(null, "¡Oh no! Has agotado tus intentos. La palabra era: " + palabraSecreta);
                    actualizarPuntaje(usuario, palabraSecreta, intentosRestantes, letrasCorrectas.toString());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener una palabra del juego. Verifica la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void verPuntaje() {
        try {
            StringBuilder sb = new StringBuilder();
            String query = "SELECT * FROM Puntajes";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                sb.append("Usuario: ").append(rs.getString("Usuario")).append("\n")
                        .append("Intentos Restantes: ").append(rs.getInt("IntentosRestantes")).append("\n")
                        .append("Letras Acertadas: ").append(rs.getString("LetrasAcertadas")).append("\n")
                        .append("Palabra: ").append(rs.getString("Palabra")).append("\n\n");
            }

            rs.close();
            pstmt.close();

            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String obtenerPalabraAleatoria(Connection con) throws SQLException {
        String palabra = null;
        String query = "SELECT Palabra FROM Palabras ORDER BY RAND() LIMIT 1";
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            palabra = rs.getString("Palabra");
        }
        rs.close();
        pstmt.close();
        return palabra;
    }

    private static boolean esLetra(String entrada) {
        return entrada.length() == 1 && entrada.matches("[a-zA-Z]");
    }

    private static void actualizarPuntaje(String usuario, String palabra, int intentosRestantes, String letrasAcertadas) {
        try {
            String query = "INSERT INTO Puntajes (Usuario, Palabra, IntentosRestantes, LetrasAcertadas) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, usuario);
            pstmt.setString(2, palabra);
            pstmt.setInt(3, intentosRestantes);
            pstmt.setString(4, letrasAcertadas);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}