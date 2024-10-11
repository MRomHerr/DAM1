package f2_objetos;

/**
 * @Actividad  
 * @author Marcos Romero Herrero
 * @version 1.0
 * @since 2024-04-04
 */
public class Alumos {
    private String nombre, apellidos;
    private int numero;

    // Métodos constructores
    public Alumos() {

    }

    public Alumos(String nombre, String apellidos, int numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numero = numero;
    }

    // Métodos get y set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getNumero() {
        return numero;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nApellidos: ");
        sb.append(apellidos);
        sb.append("\nNumero: ");
        sb.append(numero);
        return sb.toString();
    }
}//fin de la clase alumnos