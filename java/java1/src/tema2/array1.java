package tema2;

import java.util.Scanner;

public class array1 {
     public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
                 String [] asignatura = new String[6]; //Declarar el array 
                 int [] nota = new int[6];;
                 int i;
                 
                 for (i=0; i<6; i++){
                      System.out.println("Nombre de la asignatura: ");
                      asignatura[i]=sc.nextLine();
                      System.out.println("Escribe tu nota: ");
                      nota[i]=sc.nextInt();  
                      sc.nextLine();
                 }
                 
                 for (i=0; i<6; i++){
                     System.out.println(asignatura[i]+" -> "+nota[i]);
                     sc.nextLine();
                 }
             
    }
}