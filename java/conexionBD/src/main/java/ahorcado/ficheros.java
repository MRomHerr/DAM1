
package ahorcado;

public class ficheros {
    public static void main(String[] args) {
        String rutaArchivoPalabras = ".//src//main//java//ahorcado//palabras.txt";
        ficheroobjetos juego = new ficheroobjetos(rutaArchivoPalabras);
        juego.jugar();
    }
}
