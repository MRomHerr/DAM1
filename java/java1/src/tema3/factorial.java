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
public class factorial {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int factorial=1;

        System.out.println("Introduzca el número del que quiere el factorial: ");
        num = sc.nextInt();

        // Calcula el factorial del número
        while (num > 1) {
            factorial =factorial* num; //factorial0factorial*num
            num--;
        }

        System.out.println("El factorial es: " + factorial);

    }
}
    

