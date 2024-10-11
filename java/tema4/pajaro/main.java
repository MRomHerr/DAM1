/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema4.pajaro;

/**
 *
 * @author alumno
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pajaro aguila= new Pajaro ("Juan",50,50);
        Pajaro loro= new Pajaro ("Lucy",10,10);
        double distancia = aguila.volar(10, 10);
        
        loro=null;
        System.gc();
        
        System.out.println("El desplazamiento del águila "+aguila.getNombre()+" para cazar al loro ha sido: "+distancia);
        
        Pajaro paloma= new Pajaro ();
        paloma.setNombre("Helen");
        paloma.setPosX(5);
        paloma.setPosY(1);
        
        double distancia2=aguila.volar(paloma.getPosX(), paloma.getPosY());
        System.out.println("El desplazamiento del águila "+aguila.getNombre()+" para cazar la paloma ha sido: "+distancia2);
        
        
        loro=null;
        System.gc();
    }
    
}
