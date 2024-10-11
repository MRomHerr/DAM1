
package ACTIVIDAD03_OrdenarDatos;
import javax.swing.JOptionPane;

/**
 * @Actividad3
 * @author Marcos Romero Herrero
 * @version 1.0
 * @since 2024-02-19
 */

public class main {
    public static void main(String[] args) {
        //creo un array de alumnos
        OrdenarDatos.Alumno[] alumnos = {
            new OrdenarDatos.Alumno("Juan", 6.0),
            new OrdenarDatos.Alumno("Pepe", 3.0),
            new OrdenarDatos.Alumno("Sara", 8.0),
            new OrdenarDatos.Alumno("Elena", 4.0),
            new OrdenarDatos.Alumno("Alejandro", 9.0)
        };
        //hago esto para ahorrarme escribir tantas veces OrdenarDatos.Escuela
        OrdenarDatos.Escuela escuela = new OrdenarDatos.Escuela(alumnos);

        //el menú de opciones
        while (true) {
            String opcion = JOptionPane.showInputDialog("1- Listado de alumnos ordenados alfabéticamente.\n2- Listado de alumnos con su nota de programación ordenados por mayor nota.\n3- Añadir un nuevo alumno a la nueva lista.\n4- Salir");
            switch (opcion) {
                case "1":
                    escuela.mostrarNombresOrdenados(); //llamo al metodo mostrarNombresOrdenados()
                    break;
                case "2":
                    escuela.mostrarAlumnosPorNota();  //llamo al metodo mostrarAlumnosPorNota()
                    break;
                case "3":
                    //codigo para anadir un nuevo alumno
                    escuela.anadirAlumno(); // CORRECCIÓN: llamo al metodo anadirAlumno() en la instancia escuela
                    break;
                case "4":
                    //pone fin al programa
                    System.exit(0);
                    break;
                default:
                    //opción no válida
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }
}
