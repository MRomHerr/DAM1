package tema3;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class alumnosnotas {
              public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
                 DecimalFormat df= new DecimalFormat("#");
                 String [] nombre = new String[3]; //Declarar el array 
                 double [] nota = new double[3];
                 int i, aprobado;
                 int suspenso=0;
 
                 
                 for (i=0; i<3; i++){
                      System.out.println("Introduce un nombre: ");
                      nombre[i]=sc.nextLine();
                      
                    do{
                      System.out.println("Escribe tu nota: ");
                      nota[i]=sc.nextDouble(); 
                      sc.nextLine();
                       if(nota[i]<5){
                        suspenso++;
                       }else if (nota[i]<5&&nota[i]>4){
                           nota[i]=Math.floor(nota[i]);
                       }else{
                           nota[i]=Math.round(nota[i]);
                       }
                       
                    }while (nota[i]<0 || nota[i]>10);
                 }
                 
                 aprobado=3-suspenso;
                 System.out.println("Nota de "+nombre[0]+" = "+df.format(nota[0]));
                 System.out.println("Nota de "+nombre[1]+" = "+df.format(nota[1]));
                 System.out.println("Nota de  "+nombre[2]+" = "+df.format(nota[2]));
                 
                 double media= (nota[0]+nota[1]+nota[2])/3;
                 System.out.printf("\nMedia de la clase: %.2f\n",media);
                 System.out.println("Alumnos suspensos: "+suspenso);
                 System.out.println("Alumnos aprobados: "+aprobado);
                 
                  if(nota[0]>nota[1]&&nota[0]>nota[2]){
                     System.out.println("El alumno con la nota más alta es "+nombre[0]+" con un "+df.format(nota[0]));
                      }else if(nota[1]>nota[0]&&nota[1]>nota[2]){
                     System.out.println("El alumno con la nota más alta es "+nombre[1]+" con un "+df.format(nota[1]));
                      }else {
                     System.out.println("El alumno con la nota más alta es "+nombre[1]+" con un "+df.format(nota[2]));
                      }
                               
             
    }
}
