package Programas_hecho_para_practicar.Otras_Posibles_Opciones_a_actividades_de_Clase.ejercicio_3_Maquina_Expendedora;

/**
 * Clase producto que sería la fusion de las clases dulces,bebidas y sandwichs
 * @author Mparr
 * @version 1.0
 * @date 09/02/2024
 */
public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
//Fin getters
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    //Fin setters
}
