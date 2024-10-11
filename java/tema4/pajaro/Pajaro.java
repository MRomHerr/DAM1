/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4.pajaro;

/**
 *
 * @author alumno
 */
public class Pajaro {
    String nombre;
    int posX, posY;
    public Pajaro() {}
    public Pajaro (String nombre, int posX, int posY){
        this.nombre=nombre;
        this.posX=posX;
        this.posY=posY;
    } //metodo Constructor 2
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setPosY(int posY){
        this.posY=posY;
    }
    
    public void setPosX(int posX){
        this.posX=posX;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public int getPosX(){
        return posX;
    }
    
    double volar(int posX, int posY){
        double desplazamiento;
        desplazamiento=Math.sqrt(Math.pow((posX - this.posX),2)+Math.pow((posY - this.posY),2));
        this.posX=posX;
        this.posY=posY;
        return desplazamiento;
    }//Fin del metodo
    
}
