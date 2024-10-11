package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class notas {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nota = {5, 4, 1, 10, 8, 6, 3, 2, 1, 5, 6, 7, 0, 2, 5, 2, 6, 8, 9, 9, 3, 10, 3, 7, 7};

        // Encuentra el índice del alumno con la nota más alta
        int MejorNota = 0;
        int PeorNota=0;
        for (int i = 0; i < nota.length; i++) {
            if (nota[i] > nota[MejorNota]) {
                MejorNota = i;
            }else if(nota[i]<nota[PeorNota]){
                PeorNota = i;
            }
                
        }

        // Imprime el resultado
        System.out.println("La mejor nota es: " + nota[MejorNota]);
        System.out.println("La peor nota es: " + nota[PeorNota]);


    }
}
//programa que determine cuantos diptongos tiene una cadena convinacion entre 2 vocalesuna tiene que ser en la misma silaba