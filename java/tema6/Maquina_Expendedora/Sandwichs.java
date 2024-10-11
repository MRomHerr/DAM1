/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.Maquina_Expendedora;

/**
 *
 * @author alumno
 */
public class Sandwichs {
    private String nombre;
    private double precio;
    private int cantidad;
    public Sandwichs(String nombre,double precio,int cantidad){
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    //Fin setters
    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    //Fin getters
}