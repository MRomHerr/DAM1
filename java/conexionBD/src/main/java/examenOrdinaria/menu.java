package examenOrdinaria;

import java.io.*;
import java.time.DateTimeException;
import java.util.*;
import javax.swing.JOptionPane;

public class menu {
    private List<Usuario> usuarios;
    private List<Integer> respuestasCorrectas;
    private String rutaArchivoTrivial = ".//src//main//java//examenOrdinaria//trivial.txt";

    public menu() {
        usuarios = new ArrayList<>();
        respuestasCorrectas = cargarRespuestasCorrectas();
    }

    private List<Integer> cargarRespuestasCorrectas() {
        List<Integer> respuestas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivoTrivial))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("::");
                if (partes.length >= 6) {
                    respuestas.add(Integer.parseInt(partes[5])); // Añade la respuesta correcta
                }
            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las respuestas correctas desde el fichero: " + e.getMessage());
        }
        return respuestas;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            String[] opciones = {"Jugar", "Salir"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    jugar();
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 1);
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
        actualizarFicheroPrincipal();
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
            guardarEnFichero(nuevoUsuario, rutaArchivoTrivial);
            JOptionPane.showMessageDialog(null, "Usuario agregado y guardado en el fichero.");
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Error al añadir usuario: " + e.getMessage());
        }
    }

    private void guardarEnFichero(Usuario usuario, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo, true)) {
            StringBuilder userData = new StringBuilder();
            userData.append(usuario.getNombre())
                    .append("::")
                    .append(usuario.getApellidos())
                    .append("::")
                    .append(usuario.getAciertos())
                    .append("::Respuestas del usuario: ");

            // Concatenar las respuestas del usuario
            for (int i = 0; i < usuario.getRespuestasUsuario().size(); i++) {
                userData.append(usuario.getRespuestasUsuario().get(i));
                if (i < usuario.getRespuestasUsuario().size() - 1) {
                    userData.append(", ");
                }
            }

            userData.append("::Respuestas correctas: ");

            // Concatenar las respuestas correctas
            for (int i = 0; i < usuario.getRespuestasCorrectas().size(); i++) {
                userData.append(usuario.getRespuestasCorrectas().get(i));
                if (i < usuario.getRespuestasCorrectas().size() - 1) {
                    userData.append(", ");
                }
            }

            writer.write(userData.toString());
            writer.write("\n");
            JOptionPane.showMessageDialog(null, "Datos guardados en el fichero: " + rutaArchivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en el fichero: " + e.getMessage());
        }
    }

    private void actualizarFicheroPrincipal() {
        try (FileWriter writer = new FileWriter(rutaArchivoTrivial, true)) {
            for (Usuario usuario : usuarios) {
                StringBuilder userData = new StringBuilder();
                userData.append(usuario.getNombre())
                        .append("::")
                        .append(usuario.getApellidos())
                        .append("::")
                        .append(usuario.getAciertos())
                        .append("::Respuestas del usuario: ");

                // Concatenar las respuestas del usuario
                for (int i = 0; i < usuario.getRespuestasUsuario().size(); i++) {
                    userData.append(usuario.getRespuestasUsuario().get(i));
                    if (i < usuario.getRespuestasUsuario().size() - 1) {
                        userData.append(", ");
                    }
                }

                userData.append("::Respuestas correctas: ");

                // Concatenar las respuestas correctas
                for (int i = 0; i < usuario.getRespuestasCorrectas().size(); i++) {
                    userData.append(usuario.getRespuestasCorrectas().get(i));
                    if (i < usuario.getRespuestasCorrectas().size() - 1) {
                        userData.append(", ");
                    }
                }

                writer.write(userData.toString());
                writer.write("\n");
            }
            JOptionPane.showMessageDialog(null, "Fichero principal actualizado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el fichero principal: " + e.getMessage());
        }
    }
}