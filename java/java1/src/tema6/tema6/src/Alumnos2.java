
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author alumno
 */
public class Alumnos2 {
public static void menu() {
        //Zona de declaracion de variables
        String[] alumno = new String[29];
        alumno[0]="Fran";
        alumno[1]="Borja";
        alumno[2]="Bryan";
        String[][] asignaturas={{"Programacion","Bases de Datos","Lenguaje de marcas","Entornos de Desarollo","Sistemas informaticos","Fol"},{"Programacion","Bases de Datos","Lenguaje de marcas","Entornos de Desarollo","Sistemas informaticos"},{"Programacion","Bases de Datos"}};
        boolean[]repetidores= new boolean[29];
        repetidores[0]=false;
        repetidores[1]=false;
        repetidores[2]=true;
        int eleccion;
        boolean salir =false;
        //Zona de inicializacion , añadir más cosas si es necesario
        Scanner scanner = new Scanner(System.in);
        //Zona de salida
        do {
            System.out.println("""
                    Elije una de las opciones
                    1->Asignaturas matriculadas por los alumnos
                    2->Asignaturas de un alumno concreto
                    3->Asignaturas de los alumnos repetidores
                    Para salir pulse 0""");
            eleccion = scanner.nextInt();
            scanner.nextLine();
            switch (eleccion) {
                case 1:
                    int maxAsignaturas = 0;
                    for (int i = 0; i < asignaturas.length; i++) {
                        if (asignaturas[i].length > maxAsignaturas) {
                            maxAsignaturas = asignaturas[i].length;
                        }//Fin primer if
                    }//Fin primer for
                    for (int i = alumno.length - 1; i >= 0; i--) {
                        System.out.println("Nombre del alumno: " + alumno[i]);
                        if (i < asignaturas.length) {  // Asegurar que haya filas en asignaturas
                            for (int j = 0; j < maxAsignaturas; j++) {
                                if (j < asignaturas[i].length) {
                                    System.out.print(asignaturas[i][j] + ",");
                                }//Fin segundo if
                            }//Fin segundo for
                        }//Fin tercer  if
                        System.out.println(" ");
                    }//Fin tercer for
                    break;
                case 2:
                    System.out.println("Introduce el alumno  que quieres ver ");
                    String alumnoElegido = scanner.nextLine();
                    for (int i = 0; i < alumno.length; i++) {
                        if(alumnoElegido.equalsIgnoreCase(alumno[i])){
                            System.out.print(alumno[i]);
                            for (int j= 0;j< asignaturas[i].length;j++){
                                System.out.println(" ");
                                System.out.println(asignaturas[i][j]);
                            }//Fin segundo for
                            break;
                        }//Fin if
                    }//Fin primer for
                    break;
                case 3:
                    System.out.println("Asignaturas de los alumnos repetidores:");
                    for (int i = 0; i < alumno.length; i++) {
                        if (repetidores[i]) {
                            System.out.println("Nombre del alumno (Repetidor): " + alumno[i]);

                            if (i < asignaturas.length) {
                                for (int j = 0; j < asignaturas[i].length; j++) {
                                    System.out.print(asignaturas[i][j] + ",");
                                }//Fin primer for
                                System.out.println(" ");
                            }//Fin primer if
                        }//Fin segundo if
                    }//Fin segundo for
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    salir=true;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }//Fin switch
        } while (!salir);
    }//Fin de menu

    public static void main(String[] args) {
        menu();
    }
}