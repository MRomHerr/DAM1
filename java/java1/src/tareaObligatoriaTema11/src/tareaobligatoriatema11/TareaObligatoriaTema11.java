package tareaobligatoriatema11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;


/**
 * @Actividad obligatoria tema 11
 * @author Marcos Romero Herrero
 * @version 1.0
 * @since 2024-04-19
 */
public class TareaObligatoriaTema11 {
     
    // ArrayList para almacenar los empleados de la empresa
    static ArrayList<Empleados> Empresa = new ArrayList<>();
    
    // ArrayList para almacenar los exempleados de la empresa
    static ArrayList<Empleados> empleadosEliminados = new ArrayList<>();
    

    /**
     * Muestra un menú de opciones en una ventana emergente.
     */
    private static void menu() {
        JOptionPane.showMessageDialog(null, "\n  1- Añadir empleado.\n  2- Eliminar empleado."
                + "\n  3- Buscar empleo.\n  4- Imprimir empleados ordenados."
                + "\n         a- Por antiguedad.\n         b- Por salario.\n         c- Por apellido."
                + "\n  5- Calcular el gasto de los empleados.\n  6- Salir.");
    }

    /**
     * Agrega algunos datos iniciales de empleados a la lista de la empresa.
     */
    private static void datos() {
        Empleados empleado1= new Empleados("Juan","Torres", 1960, 1, 1, 1980, 5, 24, "Jefe", 60000 );
        Empresa.add(empleado1);  
        
        Empleados empleado2= new Empleados("Sara","Gonzalez", 1980, 5, 2, 1999, 6, 3, "Secretaria", 25000);
        Empresa.add(empleado2);
        
        Empleados empleado3= new Empleados("Elena","Sanchez", 1990, 9, 3, 2010, 11, 2, "TecnicoFP", 30000 );
        Empresa.add(empleado3);
        
        Empleados empleado4= new Empleados("Pepe","Uriel", 1991, 10, 4, 2015, 10, 1, "Administrativo", 24000);
        Empresa.add(empleado4);
        
        Empleados empleado5= new Empleados("Marcos", "Romero", 2004, 11, 29, 2018, 7, 3, "Administrativo", 22000);
        Empresa.add(empleado5);
    }

    /**
     * Añade un nuevo empleado a la lista de la empresa.
     * 
     * @param nombre Nombre del empleado.
     * @param apellidos Apellidos del empleado.
     * @param añoNacimiento Año de nacimiento del empleado.
     * @param mesNacimiento Mes de nacimiento del empleado.
     * @param diaNacimiento Día de nacimiento del empleado.
     * @param añoIngreso Año de ingreso del empleado en la empresa.
     * @param mesIngreso Mes de ingreso del empleado en la empresa.
     * @param diaIngreso Día de ingreso del empleado en la empresa.
     * @param puesto Puesto del empleado en la empresa.
     * @param salario Salario del empleado.
     */
    private static void AñadirEmpleado(String nombre, String apellidos, int añoNacimiento, int mesNacimiento, int diaNacimiento, int añoIngreso, int mesIngreso, int diaIngreso, String puesto, double salario) {
        try {
            // Verificar que la fecha de ingreso sea posterior a la fecha de nacimiento
            LocalDate fechaNacimiento = LocalDate.of(añoNacimiento, mesNacimiento, diaNacimiento);
            LocalDate fechaIngreso = LocalDate.of(añoIngreso, mesIngreso, diaIngreso);
        
            if (fechaIngreso.isAfter(fechaNacimiento)) {
                Empleados nuevoEmpleado = new Empleados(nombre, apellidos, añoNacimiento, mesNacimiento, diaNacimiento, añoIngreso, mesIngreso, diaIngreso, puesto, salario);
                Empresa.add(nuevoEmpleado);
            } else {
                JOptionPane.showMessageDialog(null, "Error al añadir empleado: La fecha de ingreso debe ser posterior a la fecha de nacimiento.");
            }
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Error al añadir empleado: " + e.getMessage());
        }
    }

    /**
     * elimina un empleado de la lista de la empresa.
     * 
     * @param nombre Nombre del empleado.
     * @param apellido Apellidos del empleado.
     */
    private static void EliminarEmpleado(String nombre, String apellido) {
        try {
           Empresa.removeIf(empleado -> empleado.getNombre().equals(nombre) && empleado.getApellidos().equals(apellido));
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + e.getMessage());
       }
    }  
    
    /**
     * Busca un empleado de la lista de la empresa.
     * 
     * @param nombre Nombre del empleado.
     * @param apellidos Apellidos del empleado.
     */
    private static void BuscarEmpleado(String nombre, String apellidos) {
        boolean encontrado = false;
        try {
            StringBuilder sb = new StringBuilder();
            for (Empleados empleado : Empresa) {
                if (empleado.getNombre().equalsIgnoreCase(nombre) && empleado.getApellidos().equalsIgnoreCase(apellidos)) {
                    sb.append(empleado.toString());
                    sb.append("\n");
                    encontrado = true;
                }
            }
        
            if (encontrado) {
                JOptionPane.showMessageDialog(null, sb.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con el nombre y apellido proporcionados.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + e.getMessage());
        }
    }
    
    /**
     * Muestra la lista de empleados ordenada por antigUedad, salario o apellido.
     */
    private static void ImprimirEmpleado() {
        try {
            String orden = JOptionPane.showInputDialog("Introduce la opción de orden (a/b/c):");
            switch (orden) {
                case "a": 
                    OrdenAntiguedad();
                    break;
                case "b":
                    OrdenSalario();
                    break;
                case "c":
                    OrdenApellido();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir empleados: " + e.getMessage());
        }
    }

    /**
     * Ordena la lista de empleados por antiguedad y la muestra.
     */
    private static void OrdenAntiguedad() {
        try {
            Collections.sort(Empresa, new Comparator<Empleados>() {
                @Override
                public int compare(Empleados e1, Empleados e2) {
                    return e1.getFechaIngreso().compareTo(e2.getFechaIngreso());
                }
            });

            StringBuilder sb = new StringBuilder();
            sb.append("|  Número  |   Nombre  |   Apellidos  |   Fecha de nacimiento  |   Fecha de Ingreso  |   Salario  |   \n");
            sb.append("----------------------------------------------------------------------------------------------------------------------------\n");
            int contador = 1;
            for (Empleados empleado : Empresa) {
                sb.append(contador).append(" - ").append(empleado.getNombre()).append("              ").append(empleado.getApellidos()).append("              ").append(empleado.getFechaNacimiento()).append("                     ").append(empleado.getFechaIngreso()).append("                   ").append(empleado.getSalario()).append("\n");
                contador++;
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ordenar empleados por antigüedad: " + e.getMessage());
        }
    }

    /**
     * Ordena la lista de empleados por salario y la muestra.
     */
    private static void OrdenSalario() {
         try {
             Collections.sort(Empresa, new Comparator<Empleados>() {
                @Override
                public int compare(Empleados e1, Empleados e2) {
                    return Double.compare(e2.getSalario(), e1.getSalario());
                }
            });

            StringBuilder sb = new StringBuilder();
            sb.append("|  Número  |   Nombre  |   Apellidos  |   Fecha de nacimiento  |   Fecha de Ingreso  |   Salario  |   \n");
            sb.append("----------------------------------------------------------------------------------------------------------------------------\n");
            int contador = 1;
            for (Empleados empleado : Empresa) {
                sb.append(contador).append(" - ").append(empleado.getNombre()).append("              ").append(empleado.getApellidos()).append("              ").append(empleado.getFechaNacimiento()).append("                     ").append(empleado.getFechaIngreso()).append("                   ").append(empleado.getSalario()).append("\n");
                contador++;
            }
            JOptionPane.showMessageDialog(null, sb.toString());
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ordenar empleados por salario: " + e.getMessage());
        }
    }

    /**
     * Ordena la lista de empleados por apellido y la muestra.
     */
    private static void OrdenApellido() {
        try {
            Collections.sort(Empresa, new Comparator<Empleados>() {
                @Override
                public int compare(Empleados e1, Empleados e2) {
                    return e1.getApellidos().compareTo(e2.getApellidos());
                }
            });

            StringBuilder sb = new StringBuilder();
            sb.append("|  Número  |   Nombre  |   Apellidos  |   Fecha de nacimiento  |   Fecha de Ingreso  |   Salario  |   \n");
            sb.append("----------------------------------------------------------------------------------------------------------------------------\n");
            int contador = 1;
            for (Empleados empleado : Empresa) {
                sb.append(contador).append(" - ").append(empleado.getNombre()).append("              ").append(empleado.getApellidos()).append("              ").append(empleado.getFechaNacimiento()).append("                     ").append(empleado.getFechaIngreso()).append("                   ").append(empleado.getSalario()).append("\n");
                contador++;
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ordenar empleados por apellido: " + e.getMessage());
        }
    }

    /**
     * Calcula el gasto total en salarios de todos los empleados.
     * 
     * @return Gasto total en salarios.
     */
    private static double gasto() {
        double gasto = 0;
        try {
            for (Empleados empleado : Empresa) {
                gasto += empleado.getSalario();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al calcular gasto: " + e.getMessage());
        }
        return gasto;
    }
    
    
    /**
     * Escribe los datos de los empleados en un archivo
     */
    public static void escribirDatosEnArchivo() {
        File archivoEmpleados = new File(".//src/tareaobligatoriatema11//empleados.txt");

        // Comprobar si el archivo de empleados existe
        if (!archivoEmpleados.exists()) {
            JOptionPane.showMessageDialog(null, "El archivo de empleados no existe.");
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Quiere crear un nuevo archivo de empleados?", "Crear Nuevo Archivo", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    archivoEmpleados.createNewFile();
                    JOptionPane.showMessageDialog(null, "Archivo de empleados creado correctamente.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al crear el archivo de empleados: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "El programa se cerrará.");
            }
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEmpleados))) {
                // Escribir los datos de los empleados en el archivo
                for (Empleados empleado : Empresa) {
                    writer.write(empleado.toString());
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(null, "Datos de empleados escritos en el archivo 'empleados.txt'");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al escribir en el archivo de empleados: " + e.getMessage());
            }
        }
    }
    

    /**
     * Añade un nuevo empleado a una nueva lista de la empresa en la que se guardan los empleados que serán eliminados.
     * 
     * @param nombreEliminar Nombre del empleado.
     * @param apellidoEliminar Apellidos del empleado.
     */
    private static void EmpleadosAntiguos(String nombreEliminar, String apellidoEliminar) {
        try {
            // Crear un archivo de empleados antiguos si no existe
            File archivoExEmpleados = new File(".//src/tareaobligatoriatema11//empleadosAntiguos.txt");
            if (!archivoExEmpleados.exists()) {
                archivoExEmpleados.createNewFile();
            }

            // Crear un BufferedWriter para escribir en el archivo de empleados antiguos
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoExEmpleados, true))) {
                // Buscar y guardar el empleado en el ArrayList de empleados eliminados
                for (Empleados empleado : Empresa) {
                    if (empleado.getNombre().equalsIgnoreCase(nombreEliminar) && empleado.getApellidos().equalsIgnoreCase(apellidoEliminar)) {
                        // Guardar el empleado en el archivo de empleados antiguos
                        writer.write(empleado.toString2());
                        writer.newLine();
                        // Agregar el empleado al ArrayList de empleados eliminados
                        empleadosEliminados.add(empleado);
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Empleado eliminado y guardado en el archivo 'empleadosAntiguos.txt'");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado y guardar en el archivo: " + e.getMessage());
        }
    }
    
    

    /**
     * El punto de entrada del programa.
     * Muestra el menú y gestiona las opciones elegidas por el usuario.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        datos();
        while (true) {
            menu();
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción del menú:"));
                switch (opcion) {
                    case 1:
                        String nombreAñadir = JOptionPane.showInputDialog("Introduce el nombre del empleado a añadir:");
                        String apellidoAñadir = JOptionPane.showInputDialog("Introduce el apellido del empleado a añadir:");
                        int añoNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de nacimiento del empleado a añadir:"));
                        int mesNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de nacimiento del empleado a añadir:"));
                        int diaNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia de nacimiento del empleado a añadir:")); 
                        int añoIngreso = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de ingreso del empleado a añadir:"));                       
                        int mesIngreso = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de ingreso del empleado a añadir:")); 
                        int diaIngreso = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dia de ingreso del empleado a añadir:"));
                        double salario = Double.parseDouble(JOptionPane.showInputDialog("Introduce el salario del empleado a añadir:"));
                        String puesto = JOptionPane.showInputDialog("Introduce el puesto del empleado a añadir:");;
                        
                        AñadirEmpleado(nombreAñadir, apellidoAñadir, añoNacimiento, mesNacimiento, diaNacimiento, añoIngreso, mesIngreso, diaIngreso, puesto, salario);
                        break;
                    case 2:
                        String nombreEliminar = JOptionPane.showInputDialog("Introduce el nombre del empleado a eliminar:");
                        String apellidoEliminar = JOptionPane.showInputDialog("Introduce el apellido del empleado a eliminar:");
                        EmpleadosAntiguos(nombreEliminar, apellidoEliminar);
                        EliminarEmpleado(nombreEliminar, apellidoEliminar);
                        break;
                    case 3:
                        String nombreBuscar = JOptionPane.showInputDialog("Introduce el nombre del empleado a buscar:");
                        String apellidoBuscar = JOptionPane.showInputDialog("Introduce el apellido del empleado a buscar:");
                        BuscarEmpleado(nombreBuscar, apellidoBuscar);
                        break;
                    case 4:
                        ImprimirEmpleado();
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Gasto total de los empleados: " + gasto());
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida, introduzca un número entre el 1 y el 6");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor, introduzca un número válido para la opción del menú.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            escribirDatosEnArchivo();
        }//fin del switch
    }// fin del metodo main
}//fin de la clase