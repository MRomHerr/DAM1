package primitiva;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class primitivaficheros {
    public static void main(String[] args) {
        int opcion;
        primitivaficherosobjetos primitiva = new primitivaficherosobjetos();

        while (true) {
            // Mostrar el menú
            JOptionPane.showMessageDialog(null, "¡Bienvenido a la Primitiva!\n" +
                    "1. Jugar\n" +
                    "2. Salir");

            // Leer la opción del usuario
            String mensaje = "Elige una opción: ";
            String respuesta = JOptionPane.showInputDialog(null, mensaje);
            opcion = Integer.parseInt(respuesta);

            // Procesar la opción del usuario
            switch (opcion) {
                case 1:
                    // Jugar
                    int[] combinacionUsuario = new int[6];
                    for (int i = 0; i < 6; i++) {
                        String mensaje1 = "Número " + (i + 1) + ": ";
                        String respuesta1 = JOptionPane.showInputDialog(null, mensaje1);
                        combinacionUsuario[i] = Integer.parseInt(respuesta1);
                    }
                    primitiva.setCombinacionUsuario(combinacionUsuario);
                    primitiva.contarAciertos();
                    String mensaje2 = "Combinación ganadora: " + Arrays.toString(primitiva.getCombinacionGanadora());
                    JOptionPane.showMessageDialog(null, mensaje2);
                    mensaje2 = "Tu combinación: " + Arrays.toString(primitiva.getCombinacionUsuario());
                    JOptionPane.showMessageDialog(null, mensaje2);
                    mensaje2 = "Número de aciertos: " + primitiva.getAciertos();
                    JOptionPane.showMessageDialog(null, mensaje2);
                    primitiva.guardarResultados(".//src//main//java//primitiva//primitiva1.txt");
                    break;
                case 2:
                    // Salir
                    JOptionPane.showMessageDialog(null, "Adiós!");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, elige una opción válida.");
            }
        }
    }
}