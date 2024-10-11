/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema10.alumnos;

/**
 *
 * @author alumno
 */
public class Alumnos {
    private String nombre, apellido;
    private int numero;
    
    
    //metodos constructores
    //metodo vacio
    public Alumnos(){
        
    }
     public Alumnos( String nombre, String apellido, int numero){
        this.nombre=nombre;
        this.apellido=apellido;
        this.numero=numero;
    }
     
     //metodos get y set
     
     public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    
    public void setNumero(int numero){
        this.numero=numero;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public int getNumero(){
        return numero;
    }
    
    @Override public String toString(){
        StringBuilder sb = new StringBuilder();//imprime toda la lista
        sb.append("\nNombre");
        sb.append(nombre);
        sb.append("\nApellidos");
        sb.append(apellido);
        sb.append("\nNumero");
        sb.append(numero);
        return sb.toString();
        
    }
    
    
}
