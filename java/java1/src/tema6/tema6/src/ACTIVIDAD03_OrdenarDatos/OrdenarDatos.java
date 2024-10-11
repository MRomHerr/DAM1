package ACTIVIDAD03_OrdenarDatos;

import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 * @Actividad3
 * @author Marcos Romero Herrero
 * @version 1.0
 * @since 2024-02-19
 */
public class OrdenarDatos {
    static class Alumno {
        String nombre;
        double nota;

        //constructor de la clase Alumno
        Alumno(String nombre, double nota) {
            this.nombre = nombre;
            this.nota = nota;
        }
    }

    static class Escuela {
        Alumno[] alumnos;

        //constructor de la clase Escuela
        Escuela(Alumno[] alumnos) {
            this.alumnos = alumnos;
        }

        //metodo para ordenar alfabeticamente los nombres y mostrarlos
        void mostrarNombresOrdenados() {
            //ordena los alumnos alfabéticamente
            Arrays.sort(alumnos, Comparator.comparing(alumno -> alumno.nombre.toLowerCase()));

            //creo un String vacio para almacenar los nombres
            String nombres = "";

            //añado cada nombre al String
            for (Alumno alumno : alumnos) {
                nombres += alumno.nombre + "\n";
            }

            //muestra los nombres con JOptionPane
            JOptionPane.showMessageDialog(null, nombres);
        }

        //metodo que muestra los alumnos y notas ordenados de mayor a menor
        void mostrarAlumnosPorNota() {
            Arrays.sort(alumnos, Comparator.comparing(alumno -> -alumno.nota));
            String nombresNotas = "";
            for (Alumno alumno : alumnos) {
                nombresNotas += "Nombre: " + alumno.nombre + ", Nota: " + alumno.nota + "\n";
            }
            JOptionPane.showMessageDialog(null, nombresNotas);
        }

        //metodo para añadir un nuevo alumno al array de alumnos
        void anadirAlumno() {
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del alumno");
            double nota = Double.parseDouble(JOptionPane.showInputDialog("Introduce la nota del alumno"));
            Alumno nuevoAlumno = new Alumno(nombre, nota);
            Alumno[] nuevoArray = Arrays.copyOf(alumnos, alumnos.length + 1);
            nuevoArray[nuevoArray.length - 1] = nuevoAlumno;
            alumnos = nuevoArray;
        }
    }
}
