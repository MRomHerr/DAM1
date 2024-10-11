package cadena;

import javax.swing.JOptionPane;
/**
 * @Actividad1
 * @author Marcos Romero Herrero
 * @version 1.0
 * @since 2024-02-18
 */

public class cadena {
    // Atributos de la clase
    private String cadena;
    private int numConsonantes;

    // Constructor de la clase
    public cadena() {
        // Solicita al usuario una cadena de al menos 100 caracteres
        do {
            this.cadena = JOptionPane.showInputDialog("Introduce una cadena de caracteres de al menos 100 caracteres:");
        } while (this.cadena.length() < 100);
        // Calcula el número de consonantes en la cadena
        this.numConsonantes = numeroConsonantes();
    }

    // Método para imprimir la cadena
    public void escribirCadena() {
        System.out.println(this.cadena);
    }

    // Método para obtener la longitud de la cadena
    public int longitud() {
        return this.cadena.length();
    }

    // Método para copiar la cadena
    public String copiar() {
        String copia = this.cadena;
        return copia;
    }

    // Método para contar el número de vocales en la cadena
    public int numeroVocales() {
        int cont = 0;
        String vocales = "aeioAEIOU";
        for (char c : this.cadena.toCharArray()) {   
            if (vocales.indexOf(c) != -1) {
                cont++;
            }
        }
        return cont;
    }

    // Método para verificar si la cadena contiene una vocal específica
    public boolean contieneVocal(char vocal) {
        return this.cadena.indexOf(vocal) != -1;
    }

    // Método para verificar si la cadena contiene una subcadena específica
    public boolean contieneCadena(String subcadena) {
        return this.cadena.contains(subcadena);
    }

    // Método para convertir la cadena a mayúsculas
    public void convertirMayusculas() {
        this.cadena = this.cadena.toUpperCase();
    }

    // Método para eliminar las vocales de la cadena
    public void eliminarVocales() {
        this.cadena = this.cadena.replaceAll("[aeiouAEIOU]", "");
        // Actualiza el número de consonantes después de eliminar las vocales
        this.numConsonantes = numeroConsonantes();
    }

    // Método para contar el número de consonantes en la cadena
    public int numeroConsonantes() {
        int cont = 0;
        String consonantes = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        for (char c : this.cadena.toCharArray()) {
            if (consonantes.indexOf(c) != -1) {
                cont++;
            }
        }
        return cont;
    }
}
 