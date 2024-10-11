package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class diptongos {
    public static void main(String[] args){
    //TODO code aplicattion logic here
        Scanner sc = new Scanner(System.in);
        String n;
        System.out.println("Escriba una frase: ");
        n=sc.nextLine();
        int diptongos=0;
        for(int i=0;i<n.length();i++){
            if(n.indexOf("ai")>-1){
                diptongos++;
            }
            else if(n.indexOf("au")>-1){
                diptongos++;
            }
            else if(n.indexOf("ei")>-1){
                diptongos++;
            }
            else if(n.indexOf("eu")>-1){
                diptongos++;
            }
            else if(n.indexOf("oi")>-1){
                diptongos++;
            }
            else if(n.indexOf("ou")>-1){
                diptongos++;
            }
            else if(n.indexOf("ia")>-1){
                diptongos++;
            }
            else if(n.indexOf("ie")>-1){
                diptongos++;
            }
            else if(n.indexOf("io")>-1){
                diptongos++;
            }
            else if(n.indexOf("iu")>-1){
                diptongos++;
            }
            else if(n.indexOf("ua")>-1){
                diptongos++;
            }
            else if(n.indexOf("ue")>-1){
                diptongos++;
            }
            else if(n.indexOf("ui")>-1){
                diptongos++;
            }
            else if(n.indexOf("uo")>-1){
                diptongos++;
            }
            if (diptongos>0){
                System.out.println("La palabra: "+n+" es un diptongo.");
            }
            else{
                System.out.println("La palabra: "+n+" no es un diptongo.");
            }
        }//Fin del for
    }//fin del main
   

}

