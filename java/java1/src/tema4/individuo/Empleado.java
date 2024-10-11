/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4.individuo;

/**
 *
 * @author alumno
 */
public class Empleado {
    private String nombre;
    private double salario;
    //metodo constructor1
    public void Empleado (){

    } //Fin1
    
    //metodo constructor2
    public Empleado (String nombre, double salario){
        super(); //Primera linea del mtodo constructor, que invoque a la clase superior que comparta el mismo tipo
        this.nombre=nombre;
        this.salario=salario;
    } //Fin2
    
    //metodos get y set
    
    public void setNombre(String nombe){
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
     public void setSalario(double salario){
        this.salario=salario;
    }
    
    public double getSalario(){
        return salario;
    }
    
    //metodos propios/especificos
    public void subirSalario(double porcentaje){
        salario=salario+(salario+(salario*porcentaje*0.01));
        System.out.println("Ha suido el sueldo un total de: "+salario*porcentaje);
    }
    
    public void mostrarDatos(double porcentaje){
        System.out.println("Nombre: "+nombre+" sueldo: "+salario);
    }
    
}
