/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author alumno
 */
public class clase {
    
    public static void main(String[] args){
        PUNTO punto1 = new PUNTO();
        PUNTO punto2 = new PUNTO();
        PUNTO punto3 = new PUNTO();
        PUNTO punto4 = new PUNTO(3,4);
        punto1 = punto4;
        punto2.setX(1);
        punto3.setY(3);
        
        //Obtener valores del objeto
       int valorX, valorY;
       valorX = punto4.getX();
       valorY = punto4.getY();
       
       //Aplicar metodos propios
       double moduloP4 = punto4.modulo();
       System.out.println("Punto 4: valor de x: "+valorX+" valor de y: "+valorY);
       System.out.println("Modulo: "+moduloP4);
       System.out.println("Fase: "+punto4.fase());
        System.out.println("Valor de PI"+PUNTO.PI);
    }
    
    
}
