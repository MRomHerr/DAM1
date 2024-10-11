  package com.mycompany.conexionbd;

import java.sql.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 * Clase que maneja la conexión a una base de datos MySQL y proporciona métodos para interactuar con ella.
 */
public class conexionJoption {
    /**
     * Variable que almacena la conexión a la base de datos.
     */
    private static Connection conexion;

    /**
     * Muestra un menú de opciones en una ventana emergente.
     */
    private static void menu() {
        JOptionPane.showMessageDialog(null, "\n 1- Añadir empleado.\n 2- Eliminar empleado." +
                "\n 3- Buscar empleo.\n 4- Imprimir empleados ordenados." +
                "\n     a- Por antiguedad.\n     b- Por salario.\n     c- Por apellido." +
                "\n 5- Calcular el gasto de los empleados.\n 6-Mostrar los datos de la base de datos.\n 7- Salir.");
    }

    /**
     * Añade un nuevo empleado a la base de datos.
     *
     * @param nombre  El nombre del empleado a añadir.
     * @param apellidos  El apellido del empleado a añadir.
     * @param añoNacimiento  El año de nacimiento del empleado a añadir.
     * @param mesNacimiento  El mes de nacimiento del empleado a añadir.
     * @param diaNacimiento  El día de nacimiento del empleado a añadir.
     * @param añoIngreso  El año de ingreso del empleado a añadir.
     * @param mesIngreso  El mes de ingreso del empleado a añadir.
     * @param diaIngreso  El día de ingreso del empleado a añadir.
     * @param puesto  El puesto del empleado a añadir.
     * @param salario  El salario del empleado a añadir.
     */
    private static void AñadirEmpleado(String nombre, String apellidos, int añoNacimiento, int mesNacimiento, int diaNacimiento, int añoIngreso, int mesIngreso, int diaIngreso, String puesto, double salario) {
        try {
            String sql = "INSERT INTO Empleados (nombre, apellidos, fechaNacimiento, fechaIngreso, puesto, salario) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setDate(3, Date.valueOf(LocalDate.of(añoNacimiento, mesNacimiento, diaNacimiento)));
            pstmt.setDate(4, Date.valueOf(LocalDate.of(añoIngreso, mesIngreso, diaIngreso)));
            pstmt.setString(5, puesto);
            pstmt.setDouble(6, salario);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al añadir empleado: " + e.getMessage());
        }
    }

    /**
     * Elimina un empleado de la base de datos.
     *
     * @param nombre  El nombre del empleado a eliminar.
     * @param apellidos  El apellido del empleado a eliminar.
     */
    private static void EliminarEmpleado(String nombre, String apellidos) {
        try {
            // Añadir el empleado eliminado a la tabla EmpleadosAntiguos
            String sql = "INSERT INTO EmpleadosAntiguos (nombre2, apellidos2, fechaNacimiento2, fechaIngreso2, fechaFinalizacion) " +
                    "SELECT nombre, apellidos, fechaNacimiento, fechaIngreso, CURDATE() FROM Empleados WHERE nombre = ? AND apellidos = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.executeUpdate();

            // Eliminar al empleado de la tabla Empleados
            sql = "DELETE FROM Empleados WHERE nombre = ? AND apellidos = ?";
            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + e.getMessage());
        }
    }

    /**
     * Busca un empleado en la base de datos.
     *
     * @param nombre  El nombre del empleado a buscar.
     * @param apellidos  El apellido del empleado a buscar.
     */
    private static void BuscarEmpleado(String nombre, String apellidos) {
        try {
            String sql = "SELECT * FROM Empleados WHERE nombre = ? AND apellidos = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // Imprime los detalles del empleado
                JOptionPane.showMessageDialog(null, "Nombre: " + rs.getString("nombre") +
                        "\n" + "Apellidos: " + rs.getString("apellidos") +
                        "\n" + "Fecha de Nacimiento: " + rs.getDate("fechaNacimiento") +
                        "\n" + "Fecha de Ingreso: " + rs.getDate("fechaIngreso") +
                        "\n" + "Puesto: " + rs.getString("puesto") +
                        "\n" + "Salario: " + rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + e.getMessage());
        }
    }

    /**
     * Imprime los empleados ordenados por apellido.
     */
    private static void ImprimirEmpleadoApellido() {
        try {
            String sql = "SELECT * FROM Empleados ORDER BY apellidos";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // Imprime los detalles del empleado
                JOptionPane.showMessageDialog(null, "Nombre: " + rs.getString("nombre") +
                        "\n" + "Apellidos: " + rs.getString("apellidos") +
                        "\n" + "Fecha de Nacimiento: " + rs.getDate("fechaNacimiento") +
                        "\n" + "Fecha de Ingreso: " + rs.getDate("fechaIngreso") +
                        "\n" + "Puesto: " + rs.getString("puesto") +
                        "\n" + "Salario: " + rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir empleados: " + e.getMessage());
        }
    }

    /**
     * Imprime los empleados ordenados por salario.
     */
    private static void ImprimirEmpleadoSalario() {
        try {
            String sql = "SELECT * FROM Empleados ORDER BY salario";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // Imprime los detalles del empleado
                JOptionPane.showMessageDialog(null, "Nombre: " + rs.getString("nombre") +
                        "\n" + "Apellidos: " + rs.getString("apellidos") +
                        "\n" + "Fecha de Nacimiento: " + rs.getDate("fechaNacimiento") +
                        "\n" + "Fecha de Ingreso: " + rs.getDate("fechaIngreso") +
                        "\n" + "Puesto: " + rs.getString("puesto") +
                        "\n" + "Salario: " + rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir empleados: " + e.getMessage());
        }
    }

    /**
     * Imprime los empleados ordenados por antiguedad.
     */
    private static void ImprimirEmpleadoAntiguedad() {
        try {
            String sql = "SELECT * FROM Empleados ORDER BY fechaIngreso";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // Imprime los detalles del empleado
                JOptionPane.showMessageDialog(null, "Nombre: " + rs.getString("nombre") +
                        "\n" + "Apellidos: " + rs.getString("apellidos") +
                        "\n" + "Fecha de Nacimiento: " + rs.getDate("fechaNacimiento") +
                        "\n" + "Fecha de Ingreso: " + rs.getDate("fechaIngreso") +
                        "\n" + "Puesto: " + rs.getString("puesto") +
                        "\n" + "Salario: " + rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir empleados: " + e.getMessage());
        }
    }

    /**
     * Muestra los detalles de los empleados actuales y antiguos.
     */
    private static void Datos() {
        try {
            // Consulta para la tabla Empleados
            String sqlEmpleados = "SELECT * FROM Empleados ORDER BY fechaIngreso";
            PreparedStatement pstmtEmpleados = conexion.prepareStatement(sqlEmpleados);
            ResultSet rsEmpleados = pstmtEmpleados.executeQuery();

            // Consulta para la tabla EmpleadosAntiguos
            String sqlEmpleadosAntiguos = "SELECT * FROM EmpleadosAntiguos ORDER BY fechaIngreso2";
            PreparedStatement pstmtEmpleadosAntiguos = conexion.prepareStatement(sqlEmpleadosAntiguos);
            ResultSet rsEmpleadosAntiguos = pstmtEmpleadosAntiguos.executeQuery();

            // Mostrar los detalles de los empleados actuales
            JOptionPane.showMessageDialog(null, "Empleados Actuales:");
            while (rsEmpleados.next()) {
                JOptionPane.showMessageDialog(null, "Nombre: " + rsEmpleados.getString("nombre") +
                        "\n" + "Apellidos: " + rsEmpleados.getString("apellidos") +
                        "\n" + "Fecha de Nacimiento: " + rsEmpleados.getDate("fechaNacimiento") +
                        "\n" + "Fecha de Ingreso: " + rsEmpleados.getDate("fechaIngreso") +
                        "\n" + "Puesto: " + rsEmpleados.getString("puesto") +
                        "\n" + "Salario: " + rsEmpleados.getDouble("salario"));
            }

            // Mostrar los detalles de los empleados antiguos
            JOptionPane.showMessageDialog(null, "Empleados Antiguos:");
            while (rsEmpleadosAntiguos.next()) {
                JOptionPane.showMessageDialog(null, "Nombre: " + rsEmpleadosAntiguos.getString("nombre2") +
                        "\n" + "Apellidos: " + rsEmpleadosAntiguos.getString("apellidos2") +
                        "\n" + "Fecha de Nacimiento: " + rsEmpleadosAntiguos.getDate("fechaNacimiento2") +
                        "\n" + "Fecha de Ingreso: " + rsEmpleadosAntiguos.getDate("fechaIngreso2") +
                        "\n" + "Fecha de Finalización: " + rsEmpleadosAntiguos.getDate("fechaFinalizacion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir empleados: " + e.getMessage());
        }
    }

    /**
     * Imprime los empleados ordenados según la opción seleccionada.
     */
    private static void ImprimirEmpleado() {
        try {
            String orden = JOptionPane.showInputDialog("Introduce la opción de orden (a/b/c):");
            switch (orden) {
                case "a":
                    ImprimirEmpleadoAntiguedad();
                    break;
                case "b":
                    ImprimirEmpleadoSalario();
                    break;
                case "c":
                    ImprimirEmpleadoApellido();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al imprimir empleados: " + e.getMessage());
        }
    }

    /**
     * Calcula el gasto total de los empleados.
     *
     * @return El gasto total de los empleados.
     */
    private static double gasto() {
        double gastoTotal = 0;
        try {
            String sql = "SELECT SUM(salario) as GastoTotal FROM Empleados";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                gastoTotal = rs.getDouble("GastoTotal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al calcular gasto: " + e.getMessage());
        }
        return gastoTotal;
    }

    /**
     * Método principal que maneja la conexión a la base de datos y proporciona un menú de opciones.
     *
     * @param args  Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        try {
            // Establecer la conexión a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.99:3306/Empresa", "marcos1", "MRomHerr170514!");

            // Establecer la conexión a la base de datos
            while (true) {
                menu();
                try {
                    int opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción del menú:"));
                    switch (opcion) {
                        case 1:
                            // Añadir empleado
                            String nombreAñadir = JOptionPane.showInputDialog("Introduce el nombre del empleado a añadir:");
                            String apellidoAñadir = JOptionPane.showInputDialog("Introduce el apellido del empleado a añadir:");
                            int añoNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de nacimiento del empleado a añadir:"));
                            int mesNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de nacimiento del empleado a añadir:"));
                            int diaNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Introduce el día de nacimiento del empleado a añadir:"));
                            int añoIngreso = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de ingreso del empleado a añadir:"));
                            int mesIngreso = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de ingreso del empleado a añadir:"));
                            int diaIngreso = Integer.parseInt(JOptionPane.showInputDialog("Introduce el día de ingreso del empleado a añadir:"));
                            double salario = Double.parseDouble(JOptionPane.showInputDialog("Introduce el salario del empleado a añadir:"));
                            String puesto = JOptionPane.showInputDialog("Introduce el puesto del empleado a añadir:");
                            AñadirEmpleado(nombreAñadir, apellidoAñadir, añoNacimiento, mesNacimiento, diaNacimiento, añoIngreso, mesIngreso, diaIngreso, puesto, salario);
                            break;
                        case 2:
                            // Eliminar empleado
                            String nombreEliminar = JOptionPane.showInputDialog("Introduce el nombre del empleado a eliminar:");
                            String apellidoEliminar = JOptionPane.showInputDialog("Introduce el apellido del empleado a eliminar:");
                            EliminarEmpleado(nombreEliminar, apellidoEliminar);
                            break;
                        case 3:
                            // Buscar empleado
                            String nombreBuscar = JOptionPane.showInputDialog("Introduce el nombre del empleado a buscar:");
                            String apellidoBuscar = JOptionPane.showInputDialog("Introduce el apellido del empleado a buscar:");
                            BuscarEmpleado(nombreBuscar, apellidoBuscar);
                            break;
                        case 4:
                            // Imprimir empleados ordenados
                            ImprimirEmpleado();
                            break;
                        case 5:
                            // Calcular gasto
                            JOptionPane.showMessageDialog(null, "Gasto total de los empleados: " + gasto());
                            break;
                        case 6:
                            // Mostrar datos de la base de datos
                            Datos();
                            break;
                        case 7:
                            // Salir
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
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión con la base de datos: " + e.getMessage());
                }
            }
        }
    }
}