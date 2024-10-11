/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema4.fecha;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una fecha en formato dd/mm/aaaa:");
        String fechaString = scanner.nextLine();
        String[] fechaArray = fechaString.split("/");
        int dia = Integer.parseInt(fechaArray[0]);
        int mes = Integer.parseInt(fechaArray[1]);
        int año = Integer.parseInt(fechaArray[2]);
        Fecha fecha = new Fecha(año, mes, dia);
        System.out.println("Fecha actual: " + fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
        fecha.diasiguiente();
        System.out.println("Fecha siguiente: " + fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
    }
}