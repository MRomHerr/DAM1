package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class equipos {
     public static void edad(int edad) {
        if (edad<=18&&edad>0){
            System.out.println("Usted es una persona joven");
            
        }else if (edad>18){
            System.out.println("Usted es una persona adulta");
            
        }else{
            System.out.println("Solo acepto edad en años y que sea positivo");
        }
  
     }
     
     public static void equipos(String equipo) {
         
        switch (equipo) {
            case "Real Madrid":
                System.out.println("Está haciendo una mala temporada");
                break;
            case "Atletico de Madrid":
                System.out.println("Va primero en la liga 2020-21");
                break;
            default:
                System.out.println("No está a la altura del Atlético de Madrid");
                break;
                
        }
         
     }
        
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        String nombre, apellidos,equipo;
        
        System.out.println("Introduzca su nombre ");
            nombre = sc.nextLine();
        System.out.println("Introduzca sus dos apellidos ");
            apellidos = sc.nextLine();
        System.out.println("Introduzca su edad ");
            edad = sc.nextInt();
            sc.nextLine();
            
            edad(edad);
        System.out.println("Introduzca su equipo de fútbol ");
            equipo = sc.nextLine();
    
            equipos(equipo);

    }       
}
    

