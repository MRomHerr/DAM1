/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class caracterentreIM {
               public static void orden (char letra1) { //subproceso
                     if (letra1>='i'&&letra1<='m'|| letra1>='I'&&letra1<='M') {
                     System.out.println("Está entre la i y la m");  
                     } else {
                     System.out.println("No está entre la i y la m");
        }
    }
       
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        char letra1;
        
        System.out.println("Introduzca una letra ");
        letra1=sc.next().charAt(0);
        
        orden(letra1);
        
        
    }
        
}

    

