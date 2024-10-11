package ExamenOrdinariasql;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class menu {
    private List<Usuario> usuarios;

    public menu() {
        usuarios = new ArrayList<>();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            String[] opciones = {"Jugar", "Ver Puntuación", "Salir"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    jugar();
                    break;
                case 1:
                    verPuntuacion();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 2);
    }

    private void jugar() {
        int[] aciertos = {0};
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del usuario a añadir:");
        String apellidos = JOptionPane.showInputDialog("Introduce el apellido del usuario a añadir:");

        List<Pregunta> preguntas = obtenerPreguntas();
        Collections.shuffle(preguntas); // Barajar las preguntas para que el orden sea aleatorio

        List<String> respuestasUsuario = new ArrayList<>();
        List<Integer> respuestasCorrectas = new ArrayList<>();

        for (Pregunta pregunta : preguntas) {
            String respuestaUsuario = hacerPregunta(pregunta, aciertos);
            respuestasUsuario.add(respuestaUsuario);
            respuestasCorrectas.add(pregunta.respuestaCorrecta);
        }

        anadirUsuario(nombre, apellidos, aciertos[0], respuestasUsuario, respuestasCorrectas);
    }

    private List<Pregunta> obtenerPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta("¿Cuánto es 15*2?", new String[]{"30", "26", "17"}, 30));
        preguntas.add(new Pregunta("¿Cuánto es 20*2?", new String[]{"40", "26", "10"}, 40));
        preguntas.add(new Pregunta("¿Cuánto es 48/2?", new String[]{"24", "26", "12"}, 24));
        preguntas.add(new Pregunta("¿Cuánto es 8*7?", new String[]{"56", "18", "9"}, 56));
        preguntas.add(new Pregunta("¿Cuánto es 56-12?", new String[]{"44", "18", "35"}, 44));
        return preguntas;
    }

    private String hacerPregunta(Pregunta pregunta, int[] aciertos) {
        StringBuilder preguntaConOpciones = new StringBuilder(pregunta.pregunta + "\n");
        char[] letras = {'a', 'b', 'c'};
        String respuestaUsuario = null;

        for (int i = 0; i < pregunta.opciones.length; i++) {
            preguntaConOpciones.append(letras[i]).append(". ").append(pregunta.opciones[i]).append("\n");
        }

        try {
            String respuestaStr = JOptionPane.showInputDialog(preguntaConOpciones.toString());
            char respuestaChar = respuestaStr.toLowerCase().charAt(0);
            int respuesta = -1;

            switch (respuestaChar) {
                case 'a':
                    respuesta = Integer.parseInt(pregunta.opciones[0]);
                    respuestaUsuario = pregunta.opciones[0];
                    break;
                case 'b':
                    respuesta = Integer.parseInt(pregunta.opciones[1]);
                    respuestaUsuario = pregunta.opciones[1];
                    break;
                case 'c':
                    respuesta = Integer.parseInt(pregunta.opciones[2]);
                    respuestaUsuario = pregunta.opciones[2];
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    return null;
            }

            if (respuesta == pregunta.respuestaCorrecta) {
                aciertos[0]++;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Por favor, introduzca una de las 3 soluciones.");
        }
        return respuestaUsuario;
    }

    private void anadirUsuario(String nombre, String apellidos, int aciertos, List<String> respuestasUsuario, List<Integer> respuestasCorrectas) {
        try {
            Usuario nuevoUsuario = new Usuario(nombre, apellidos, respuestasUsuario, respuestasCorrectas, aciertos);
            usuarios.add(nuevoUsuario);
            guardarEnBaseDeDatos(nuevoUsuario);
            JOptionPane.showMessageDialog(null, "Usuario agregado y guardado en la base de datos.");
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Error al añadir usuario: " + e.getMessage());
        }
    }

    private void guardarEnBaseDeDatos(Usuario usuario) {
        String query = "INSERT INTO usuarios (nombre, apellidos, aciertos, respuestas_usuario, respuestas_correctas, fecha_hora) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellidos());
            pstmt.setInt(3, usuario.getAciertos());
            pstmt.setString(4, String.join(", ", usuario.getRespuestasUsuario()));
            pstmt.setString(5, String.join(", ", usuario.getRespuestasCorrectas().stream().map(String::valueOf).toArray(String[]::new)));
            pstmt.setString(6, LocalDateTime.now().toString());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en la base de datos: " + e.getMessage());
        }
    }

    private void verPuntuacion() {
        StringBuilder sb = new StringBuilder("Puntuación de los jugadores:\n\n");

        for (Usuario usuario : usuarios) {
            sb.append("Nombre: ").append(usuario.getNombre()).append(" ").append(usuario.getApellidos()).append("\n");
            sb.append("Aciertos: ").append(usuario.getAciertos()).append("\n");
            sb.append("Respuestas del usuario: ").append(usuario.getRespuestasUsuario()).append("\n");
            sb.append("Respuestas correctas: ").append(usuario.getRespuestasCorrectas()).append("\n");
            sb.append("Fecha y hora: ").append(usuario.getFechaHora()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
