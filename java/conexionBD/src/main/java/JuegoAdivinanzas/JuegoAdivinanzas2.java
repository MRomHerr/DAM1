package JuegoAdivinanzas;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JuegoAdivinanzas2 {
    private static final String URL = "jdbc:mysql://localhost:3306/juego_adivinanzas_db";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    jugarPartida();
                    break;
                case 2:
                    verPuntuacion();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Gracias por jugar. ¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 3);
    }

    private static int menu() {
        String[] opciones = {"Jugar", "Ver Puntuación", "Salir"};
        String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Elige una opción:", "Menú",
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        switch (opcionSeleccionada) {
            case "Jugar":
                return 1;
            case "Ver Puntuación":
                return 2;
            case "Salir":
                return 3;
            default:
                return 0;
        }
    }

    private static void jugarPartida() {
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

        // Registrar la partida en la base de datos
        registrarPartida(intentos, numeroSecreto);
    }

    private static void registrarPartida(int intentos, int numeroSecreto) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Obtener el ID del jugador (asumimos que siempre es el jugador con ID 1)
            int jugadorId = 1;

            // Insertar la partida
            String insertarPartidaQuery = "INSERT INTO partida (jugador_id, intentos, numero_secreto) VALUES (?, ?, ?)";
            PreparedStatement insertarPartidaStatement = connection.prepareStatement(insertarPartidaQuery);
            insertarPartidaStatement.setInt(1, jugadorId);
            insertarPartidaStatement.setInt(2, intentos);
            insertarPartidaStatement.setInt(3, numeroSecreto);
            insertarPartidaStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Partida registrada en la base de datos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la partida en la base de datos: " + e.getMessage());
        }
    }

    private static void verPuntuacion() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Consultar puntaje actual del jugador
            String consultarPuntajeQuery = "SELECT puntaje FROM jugador WHERE id = 1";
            PreparedStatement consultarPuntajeStatement = connection.prepareStatement(consultarPuntajeQuery);
            ResultSet resultSet = consultarPuntajeStatement.executeQuery();

            int puntajeActual = 0;
            if (resultSet.next()) {
                puntajeActual = resultSet.getInt("puntaje");
            }

            // Mostrar puntaje actual
            JOptionPane.showMessageDialog(null, "Puntaje actual: " + puntajeActual);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el puntaje en la base de datos: " + e.getMessage());
        }
    }
}
