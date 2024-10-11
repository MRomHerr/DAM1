/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author alumno
 */
public class PUNTO {
    private int x,y;
    public static final double PI=3.1415;
    
    public PUNTO (int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public PUNTO (){
        
    }
        
    
    public void setX(int x){
        this.x=x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public double modulo(){
        return Math.sqrt(this.x*this.x+this.x+this.y*this.y);
    }
    
   public double fase(){
       double fase= (double) (this.y)/(this.x);
       return Math.atan(fase);
    }
   
    
}
