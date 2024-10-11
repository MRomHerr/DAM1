package cadena;

import javax.swing.JOptionPane;
/**
 * @Actividad1
 * @author Marcos Romero Herrero
 * @version 1.0
 * @since 2024-02-18
 */

public class main {
    
    public static void main(String[] args) {
        
        //crea un objeto de la clase cadena
        cadena cadena = new cadena();
        
        //muestra el número de caracteres en la cadena
        JOptionPane.showMessageDialog(null,"Número de caracteres introducidos en la cadena:"+cadena.longitud());
        
        //pide al usuario que introduzca una palabra para buscar en la cadena
        String palabra = JOptionPane.showInputDialog("Introduce una palabra para buscar en la cadena:");
        
        //creo un nuevo atributo para que muestre el contado del metodo numeroVocales()
        int numVocales = cadena.numeroVocales();
        
        //creo un nuevo atrubuto para llamar al metodo contieneCadena(palabra)
        boolean contPalabra = cadena.contieneCadena(palabra);
        
        //llama al metodo convertirMayusculas()
        cadena.convertirMayusculas();
        
        //llama al metodo eliminarVocales()
        cadena.eliminarVocales();

        //muestra los resultados: número de vocales, número de consonantes, si la cadena contiene la palabra introducida y la cadena en mayúsculas sin las vocales
        JOptionPane.showMessageDialog(null,"Número de vocales: " + numVocales + 
            "\nNúmero de consonantes: " + cadena.numeroConsonantes() +
            "\n¿Contiene la palabra '" + palabra + "'?: " + contPalabra + 
            "\nLa cadena en mayúsculas sin las vocales: " + cadena.copiar());
    }
}