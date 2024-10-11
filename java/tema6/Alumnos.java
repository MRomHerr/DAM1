package tema6;

import java.util.Scanner;

public class Alumnos {
    private final String[][] asignaturas;
    private static final String[] alumnos = {"Juan ", "Sara Gonzalez", "Pepe Gomez"};
    private static final String[] todasAsignaturas = {"Programación", "Bases de datos", "FOL", "Lenguaje de marcas", "Entornos de desarrllo", "Sistemas informáticos"};

    public Alumnos() {
        asignaturas = new String[30][todasAsignaturas.length];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < todasAsignaturas.length; j++) {
                if (i == 0 || (i == 1 && !todasAsignaturas[j].equals("FOL")) || (i == 2 && (todasAsignaturas[j].equals("Programación") || todasAsignaturas[j].equals("Bases de datos")))) {
                    asignaturas[i][j] = todasAsignaturas[j];
                }
            }
        }
    }

    //metodo asignaturas
    public void mostrarAsignaturas() {
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println(alumnos[i] + " está matriculado en: ");
            for (int j = 0; j < todasAsignaturas.length; j++) {
                if (asignaturas[i][j] != null) {
                    System.out.println(asignaturas[i][j]);
                }
            }
            System.out.println();
        }
    }//fin metodo

    //metodo alumnos en concreto
    public void mostrarAsignaturasAlumno(String nombre) {
        for (int i = 0; i < alumnos.length; i++) {
        if (alumnos[i].equals(nombre)) {
            System.out.println(alumnos[i] + " está matriculado en: ");
            for (int j = 0; j < todasAsignaturas.length; j++) {
                if (asignaturas[i][j] != null) {
                    System.out.println(asignaturas[i][j]);
                }
            }
            System.out.println();
            return;
        }
    }
    System.out.println("No se encontró al alumno " + nombre);
    }//fin metodo


    
    //metodo repetidores
    public void mostrarAsignaturasRepetidores() {
    for (int i = 0; i < alumnos.length; i++) {
        int count = 0;
        for (int j = 0; j < todasAsignaturas.length; j++) {
            if (asignaturas[i][j] != null) {
                count++;
            }
        }
        if (count < todasAsignaturas.length) {
            System.out.println(alumnos[i] + " está matriculado en: ");
            for (int j = 0; j < todasAsignaturas.length; j++) {
                if (asignaturas[i][j] != null) {
                    System.out.println(asignaturas[i][j]);
                }
            }
            System.out.println();
        }
        }
    }//fin metodo repetidores

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Alumnos alumnos = new Alumnos();

        while (true) {
            System.out.println("1- Asignaturas matriculadas por los alumnos.\n2- Asignaturas de un alumno concreto. \n3- Asignaturas de los alumnos repetidores.\n4- Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    alumnos.mostrarAsignaturas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre del alumno: ");
                    String nombre = sc.next();
                    alumnos.mostrarAsignaturasAlumno(nombre);
                    break;
                case 3:
                    alumnos.mostrarAsignaturasRepetidores();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }//fin switch
        }//fin while
    }
}
