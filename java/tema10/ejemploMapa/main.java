/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10.ejemploMapa;
import java.util.Map;

/**
 *
 * @author alumno
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer,String> mapaDAM1=Map.of(1, "Teclado", 2, "Monitor", 3, "CPU");
         mapaDAM1.forEach((clave,valor) -> System.out.println((clave+":"+valor)));

    }
    
}
