/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10.alumnos;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author alumno
 */
public class ListaAlumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList <Alumnos> alumnoDAM = new ArrayList <Alumnos>();
        System.out.println("Lista de alumnos de 1º de DAM vacia " + alumnoDAM);
        
        Alumnos alumno1= new Alumnos("Juan","Torres", 678926489);
        alumnoDAM.add(alumno1);
        
        Alumnos alumno2= new Alumnos("Mario","Mario", 653757815);
        alumnoDAM.add(alumno2);
        
        Alumnos alumno3= new Alumnos("Luigi","Mario", 459618597);
        alumnoDAM.add(alumno3);
        
        Alumnos alumno4= new Alumnos("Johnny","Bravo", 156966784);
        alumnoDAM.add(alumno4);
        
        Alumnos alumno5= new Alumnos("Cristionel", "Messialdo",458999782);
        alumnoDAM.add(alumno5);
        
        //imprimir lista "alumnoDAM"
        System.out.println("Alumnos de 1º de DAM: "+alumnoDAM.size());
        Iterator<Alumnos> itAlumnos = alumnoDAM.iterator();
        System.out.println("nombre     "+"apellido     "+"numero     ");
        System.out.println("---------------------------------");
        while(itAlumnos.hasNext()){ //hasNext es un boolean true o false, coprueba si quedan elmentos en l iterador
            Alumnos alumnosTemp = itAlumnos.next();
            System.out.println(" "+alumnosTemp.getNombre()+"      "+alumnosTemp.getApellido()+"      "+alumnosTemp.getNumero());
        }//fin del while
        
    }//fin del metodo main
    
}//fn de la clase
