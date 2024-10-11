/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author alumno
 */
public class ejemploContinue {
        public static void main(String[] args) {
    //Declarar las variables
    int numero=7;
    int contador;
    int resultado=0;
        System.out.println("Tabla de multiplicar del "+numero);
        System.out.println("--------------------------");
    
        for (contador=0;contador<=10;contador++){
            if (contador==7)
                continue;//el bucle sigue pero no muestra cuando el contador=7
            resultado=numero*contador;
            System.out.println(numero+" x "+contador+" = "+resultado);
        }
    }
}

    

