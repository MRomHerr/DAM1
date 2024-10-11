/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

import java.io.*;
import java.util.*;

public class ficheroobjetos {
    private String palabraSecreta;
    private int intentosRestantes;
    private int puntos;
    private Set<Character> letrasCorrectas;

    public ficheroobjetos(String rutaArchivoPalabras) {
        palabraSecreta = obtenerPalabraAleatoria(rutaArchivoPalabras);
        intentosRestantes = 6;
        puntos = 6;
        letrasCorrectas = new HashSet<>();
    }

    private String obtenerPalabraAleatoria(String rutaArchivo) {
        List<String> palabras = cargarPalabras(rutaArchivo);
        if (!palabras.isEmpty()) {
            Random random = new Random();
            return palabras.get(random.nextInt(palabras.size()));
        } else {
            return null;
        }
    }

    private List<String> cargarPalabras(String rutaArchivo) {
        List<String> palabras = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            // Si el archivo no existe, crearlo con palabras predeterminadas
            try (PrintWriter writer = new PrintWriter(archivo)) {
                writer.println("programacion");
                writer.println("java");
                writer.println("ahorcado");
                writer.println("desarrollo");
                writer.println("codigo");
                writer.println("tecnologia");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // Cargar las palabras desde el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                palabras.add(linea.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return palabras;
    }

    public void jugar() {
        if (palabraSecreta != null) {
            StringBuilder palabraAdivinada = new StringBuilder(); // Representación de la palabra adivinada
            for (int i = 0; i < palabraSecreta.length(); i++) {
                char letra = palabraSecreta.charAt(i);
                if (letra == ' ') {
                    palabraAdivinada.append('*'); // Reemplazar espacios por asteriscos
                } else {
                    palabraAdivinada.append('_'); // Mostrar guiones bajos para letras no adivinadas
                }
            }

            Scanner scanner = new Scanner(System.in);
            boolean juegoTerminado = false;

            while (intentosRestantes > 0 && !juegoTerminado) {
                System.out.println("Intentos restantes: " + intentosRestantes);
                System.out.println("Puntos: " + puntos);
                System.out.println("Palabra: " + palabraAdivinada.toString());

                System.out.print("Introduce una letra: ");
                String intento = scanner.nextLine().trim().toLowerCase();

                if (esLetra(intento)) {
                    char letra = intento.charAt(0);
                    if (palabraSecreta.contains(intento) && !letrasCorrectas.contains(letra)) {
                        letrasCorrectas.add(letra);
                        for (int i = 0; i < palabraSecreta.length(); i++) {
                            if (palabraSecreta.charAt(i) == letra) {
                                palabraAdivinada.setCharAt(i, letra);
                            }
                        }
                        System.out.println("¡Correcto! La letra '" + letra + "' está en la palabra.");
                    } else {
                        System.out.println("Incorrecto. La letra '" + letra + "' no está en la palabra.");
                        intentosRestantes--;
                        puntos--;
                    }

                    // Verificar si se han adivinado todas las letras de la palabra
                    if (palabraAdivinada.indexOf("_") == -1) {
                        System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
                        juegoTerminado = true;
                    }
                } else {
                    System.out.println("Por favor, introduce una letra del alfabeto.");
                }
            }

            if (intentosRestantes == 0 && !juegoTerminado) {
                System.out.println("¡Oh no! Has agotado tus intentos. La palabra era: " + palabraSecreta);
            }

            // Guardar los intentos y la palabra correcta en el archivo
            try (BufferedWriter escritura = new BufferedWriter(new FileWriter(".//src//main//java//ahorcado//resultados.txt", true))) {
                escritura.write(toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo obtener una palabra del archivo. Verifica la ruta del archivo.");
        }
    }

    private boolean esLetra(String entrada) {
        // Verificar si la entrada tiene longitud 1 y es una letra del alfabeto (mayúscula o minúscula)
        return entrada.length() == 1 && Character.isLetter(entrada.charAt(0));
    }

    @Override
    public String toString() {
        return "Intentos restantes: " + intentosRestantes + ", Puntos ganados: " + puntos + ", Palabra correcta: " + palabraSecreta;
    }

    public static void main(String[] args) {
        String rutaArchivoPalabras = ".//src//main//java//ahorcado//palabras.txt";
        ficheroobjetos juego = new ficheroobjetos(rutaArchivoPalabras);
        juego.jugar();
    }
}
