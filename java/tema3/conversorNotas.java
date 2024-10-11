package tema3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class conversorNotas {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Introduce la calificación (I, F, B, N, S): ");
            String calificacion = br.readLine().toUpperCase();

            int nota = convertirCalificacionANumero(calificacion);
            System.out.println("La calificación equivalente en número es: " + nota);
        } catch (IOException e) {
            System.err.println("Error al leer la entrada del usuario: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato: La calificación no es válida");
        }
    }

    private static int convertirCalificacionANumero(String calificacion) throws NumberFormatException {
        switch (calificacion) {
            case "I":
                return 4;
            case "F":
                return 5;
            case "B":
                return 6;
            case "N":
                return 8;
            case "S":
                return 9;
            default:
                throw new NumberFormatException();
        }
    }
}
    

