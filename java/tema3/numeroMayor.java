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
public class numeroMayor {
    
        public static void numeromayor (int num1, int num2, int num3) { //subproceso
             if(num1>num2&&num1>num3){
              System.out.println("El número mayor es "+num1);
          } if(num3>num1&&num3>num2){
              System.out.println("El número mayor es "+num3);
          }if(num2>num1&&num2>num3){
              System.out.println("El número mayor es "+num2);
          }
      
    }
    
   
         public static void main(String[] args) {  //proceso principal
          Scanner sc = new Scanner(System.in);
          int num1, num2, num3;
    
          System.out.println("Introduzca tres números: ");
          num1=sc.nextInt();
          num2=sc.nextInt();
          num3=sc.nextInt();
          
          numeromayor(num1, num2, num3); //llamo al subproceso
          

         
 
        }
    }


    

