package ACTIVIDAD03_OrdenarDatos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
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
            try {
                String nombre = JOptionPane.showInputDialog("Introduce el nombre del alumno");
                //comprueba si el nombre solo contiene letras
                if (!nombre.matches("[a-zA-Z]+")) {
                    //si no es así, lanza una excepción
                    throw new InputMismatchException("El nombre solo puede contener letras");
                }
                String notaStr = JOptionPane.showInputDialog("Introduce la nota del alumno");
                //convierte la nota a un número decimal 8=8.00
                double nota = Double.parseDouble(notaStr);
                //comprueba si la nota está entre 0 y 10
                if (nota < 0 || nota > 10) {
                    //si no, lanza una excepción
                    throw new InputMismatchException("La nota debe ser un número decimal entre 0 y 10");
                }
                Alumno nuevoAlumno = new Alumno(nombre, nota);
                Alumno[] nuevoArray = Arrays.copyOf(alumnos, alumnos.length + 1);
                nuevoArray[nuevoArray.length - 1] = nuevoAlumno;
                alumnos = nuevoArray;
            } catch (NumberFormatException e) {
                //si la nota no es un número, muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "La nota debe ser un número");
            } catch (InputMismatchException e) {
                //si el nombre no contiene solo letras o la nota no está entre 0 y 10, muestra el mensaje de error de la excepción
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
} 