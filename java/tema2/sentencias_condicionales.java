package tema2;

import java.util.Scanner;

/**
*
* Ejemplos de utilización de diferentes estructuras
* condicionales simples, completas y anidamiento de éstas.
*/
public class sentencias_condicionales {

 /*Vamos a realizar el cálculo de la nota de un examen
 * de tipo test. Para ello, tendremos en cuenta el número
 * total de preguntas, los aciertos y los errores. Dos errores
 * anulan una respuesta correcta.
 *
 * La nota que vamos a obtener será un número entero.
 *
 * Finalmente, se muestra por pantalla la nota obtenida, así
 * como su calificación no numérica.
 *
 * La obtención de la calificación no numérica se ha realizado
 * utilizando la estructura condicional múltiple o switch.
 *
 */
        public static void main(String[] args) {
              Scanner sc = new Scanner(System.in);
        // Declaración e inicialización de variables
            int num_aciertos;
            int num_errores;
            int num_preguntas;
            int nota;
            String calificacion="";
            
             System.out.println("Introduce el número de aciertos: ");
             num_aciertos=sc.nextInt();
             System.out.println("Introduce el número de errores: ");
             num_errores=sc.nextInt();
             System.out.println("Introduce el número de preguntas: ");
             num_preguntas=sc.nextInt();
           
           //Procesamiento de datos
            nota = ((num_aciertos - (num_errores/2))*10)/num_preguntas;

        switch (nota) {
            case 5: calificacion="SUFICIENTE";
            break;
            case 6: calificacion="BIEN";
            break;
            case 7: calificacion="NOTABLE";
            break;
            case 8: calificacion="NOTABLE";
            break;
            case 9: calificacion="SOBRESALIENTE";
            break;
            case 10: calificacion="SOBRESALIENTE";
            break;
            default: calificacion="INSUFICIENTE";
    }
 //Salida de información
 nota=(num_aciertos-(num_errores/2))*10/num_preguntas;
 System.out.println ("La nota obtenida es: " + nota);
 System.out.println ("y la calificación obtenida es: " + calificacion);
 }
}


