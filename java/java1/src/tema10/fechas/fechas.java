/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10.fechas;
import java.util.Calendar;
import java.sql.Date;
import java.time.*;
/**
 *
 * @author alumno
 */
public class fechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calendar today = Calendar.getInstance();
        System.out.println("fecha actual: "+today.getTime());
        
        LocalDate fechaNacimiento = LocalDate.parse("2009-03-01");
        System.out.println("Formato de fecha en java.time: "+fechaNacimiento);
    }
    
}
