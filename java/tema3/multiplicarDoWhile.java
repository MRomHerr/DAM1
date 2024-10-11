/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author alumno
 */
public class multiplicarDoWhile {
         public static void main(String[] args) {
          int cont=1;
          int num=7;
          int result;
          
          System.out.println("Tabla de multiplicar del "+num);
          
          do{
            result=cont*num;
            System.out.println(num+" x "+cont+" = "+result);
            cont++;
        }while (cont<=10);
    }
}

    

