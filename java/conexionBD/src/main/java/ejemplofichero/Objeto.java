package ejemplofichero;

public class Objeto {
    private String nombre;
    private int edad;
    private String ciudad;

    public Objeto(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return nombre + edad + ciudad;
    }
}