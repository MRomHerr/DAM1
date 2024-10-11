package tareaobligatoriatema11;

import java.time.LocalDate;


/**
 * @Actividad obligatoria tema 11
 * @author Marcos Romero Herrero
 * @version 1.0
 * @since 2024-04-19
 */
public class Empleados {
    private String nombre, apellidos, puesto;
    private double salario;
    private LocalDate fechaNacimiento, fechaIngreso;

    /**
     * Constructor por defecto de la clase Empleados.
     * Crea un objeto Empleados sin inicializar sus atributos.
     */
    public Empleados() {

    }

    /**
     * Constructor de la clase Empleados que inicializa los atributos del empleado.
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
    public Empleados(String nombre, String apellidos, int añoNacimiento, int mesNacimiento, int diaNacimiento, 
                     int añoIngreso, int mesIngreso, int diaIngreso, String puesto, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = LocalDate.of(añoNacimiento, mesNacimiento, diaNacimiento);
        this.fechaIngreso = LocalDate.of(añoIngreso, mesIngreso, diaIngreso);
        this.puesto = puesto;
        this.salario = salario;
    }

    // Métodos get y set

    /**
     * Establece el nombre del empleado.
     * 
     * @param nombre El nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece los apellidos del empleado.
     * 
     * @param apellidos Los apellidos del empleado.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Establece la fecha de nacimiento del empleado.
     * 
     * @param año Año de nacimiento del empleado.
     * @param mes Mes de nacimiento del empleado.
     * @param dia Día de nacimiento del empleado.
     */
    public void setFechaNacimiento(int año, int mes, int dia) {
        this.fechaNacimiento = LocalDate.of(año, mes, dia);
    }

    /**
     * Establece la fecha de ingreso del empleado en la empresa.
     * 
     * @param año Año de ingreso del empleado.
     * @param mes Mes de ingreso del empleado.
     * @param dia Día de ingreso del empleado.
     */
    public void setFechaIngreso(int año, int mes, int dia) {
        this.fechaIngreso = LocalDate.of(año, mes, dia);
    }

    /**
     * Establece el puesto del empleado en la empresa.
     * 
     * @param puesto El puesto del empleado.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Establece el salario del empleado.
     * 
     * @param salario El salario del empleado.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Obtiene el nombre del empleado.
     * 
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los apellidos del empleado.
     * 
     * @return Los apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Obtiene la fecha de nacimiento del empleado.
     * 
     * @return La fecha de nacimiento del empleado.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene la fecha de ingreso del empleado en la empresa.
     * 
     * @return La fecha de ingreso del empleado.
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Obtiene el salario del empleado.
     * 
     * @return El salario del empleado.
     */
    public double getSalario() {
        return salario;
    }
    
    /**
     * Obtiene el puesto del empleado en la empresa.
     * 
     * @return El puesto del empleado.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Devuelve una representación en formato de cadena de caracteres del objeto Empleados.
     * 
     * @return Una cadena de caracteres que representa al empleado.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nApellidos: ");
        sb.append(apellidos);
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nFecha de nacimiento: ");
        sb.append(fechaNacimiento);
        sb.append("\nFecha de ingreso: ");
        sb.append(fechaIngreso);
        sb.append("\nPuesto: ");
        sb.append(puesto);
        sb.append("\nSalario: ");
        sb.append(salario);
        return sb.toString();
    }
    
    /**
     * Devuelve una representación en formato de cadena de caracteres del objeto Empleados para ver los empleados que han sido eliminados.
     * 
     * @return Una cadena de caracteres que representa al empleado eliminado.
     */
    public String toString2() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nApellidos: ");
        sb.append(apellidos);
        sb.append("\nFecha de nacimiento: ");
        sb.append(fechaNacimiento);
        sb.append("\nFecha de ingreso: ");
        sb.append(fechaIngreso);
        sb.append("\nFecha de finalizacion: ");
        sb.append(LocalDate.now());
        return sb.toString();
    }
}//fin de la clase empleados