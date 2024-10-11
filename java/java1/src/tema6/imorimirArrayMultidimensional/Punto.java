/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.imorimirArrayMultidimensional;

/**
 *
 * @author alumno
 */
public class Punto {
    int x=0;
    int y=0;
    public Punto(int x,int y){
        this.x=x;
        this.y=y;
    }//Fin metodo contructor

    @Override
    public String toString(){
        return "["+x+","+y+"]";
    }
}