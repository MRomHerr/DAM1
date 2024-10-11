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
public class ContadorGruposNumeros {
    public static void main(String[] args) {
             Scanner sc= new Scanner(System.in);
             int num;
             int cont=10;
             int menores=0;
             int mayores=0;
             int otros=0;
             do{
                 System.out.println("Introduzca un número");
                 num=sc.nextInt();
                 cont--;
                 if(num<18){
                     menores++;
                 }else if(num>65){
                     mayores++;
                 }else{
                     otros++;
                 }
                 
             }while(cont>0);
             
             System.out.println("números mayores de 65: "+mayores);
             System.out.println("números menores de 18: "+menores);
             System.out.println("números entre 18 y 65: "+otros);
    }
}
