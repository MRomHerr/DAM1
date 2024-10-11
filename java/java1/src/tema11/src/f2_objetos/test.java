package f2_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class test {
    
     static ArrayList<Alumos> alumnoDAM = new ArrayList<Alumos>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero = new File(".//src/f2_objetos//alumnos2.txt");
        Scanner s = null;
        
        try{
            System.out.println("Leer el contenido del fichero");
            s = new Scanner(fichero);
            //voy obtenieno los datos de cada alumno
            while(s.hasNextLine()){
                String registro = s.nextLine();//obtiene una fila de alumno
                String [] cortarString = registro.split("::");
                
                //objeto clase alumno
                Alumos alumno = new Alumos();
                //alumno.setNumero(cortarString[0]);// se tiene que transformar de String a entero
                alumno.setNumero(Integer.parseInt(cortarString[0]));
                alumno.setNombre(cortarString[1]);
                alumno.setApellidos(cortarString[2]);
                
                //Añadir el lumno a la lista
                alumnoDAM.add(alumno);
            }//fin del while
        }catch(FileNotFoundException e0){
            e0.printStackTrace();
        }catch(Exception e1){
            System.out.println("Error excpcional: ");
            e1.printStackTrace();
        }finally{
            try{
                if(s!=null)
                    s.close();
            }catch(Exception e2){
                System.out.println("Error al cerrar el fichero");
                e2.printStackTrace();
            }//fin del segundo try catch
        }//fin finally
        System.out.println("Alumnos de 1º de DAM: "+alumnoDAM.size());
        Iterator<Alumos> itAlumos = alumnoDAM.iterator();
        System.out.println("NUMERO  | "+"NOMBRE  |  "+"APELLIDOS ");
        System.out.println("---------------------------------");
        while(itAlumos.hasNext()){
            Alumos alumnos2 = itAlumos.next();
            System.out.println("  "+alumnos2.getNumero()+"       "+alumnos2.getNombre()+"       "+alumnos2.getApellidos());
        }

    }//fin del metoo main
    
}// fin de l clase test
