package tema5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Es una introduccion a los ejercicios del Tema 6 parte 1
 * @author Mparr
 * @date 30/01/2024
 */
public class Introduccion_Cadenas_de_Caracteres {
    public static void main(String[] args) {
        int il=123;
        System.out.println("Numero: "+il);//il.toString()

        System.out.println(String.format("%3f",4.2f));


        String cadena1= "z";
        String cadena2 ="a";
        System.out.println(cadena1.compareTo(cadena2));//Si es mayor la cadena imprime un numero positivo, si es menor imprime negativo y si es igual imprime 0

        System.out.println(cadena1.equalsIgnoreCase(cadena2));//Si son iguales imprime true y si no imprime false

        String  numero ="1234.5678q";//En el siguiente tema trataremos las excepciones con try-catch
                   try { //Gestionar la posble excepcion Number Exception
                       double numero1 = Double.parseDouble(numero);//De cadena de caracteres a double
                       System.out.println(" numero1: "+numero1);
                       String numero2 = String.valueOf(numero1);//De numero a cadena de caracteres
                       System.out.println("numero2: "+numero2);
                       float numero4 = Float.parseFloat(numero2);//De cadena de caracteres a float
                       System.out.println("numero float --->"+numero4);
                       numero2=Float.toString(numero4);//De float a cadena de carcteres
                       System.out.println("numero2: "+numero2);
                   }catch (NumberFormatException e){
                       System.out.println("Introduce el valor correcto");
                   }//Fin de try-catch
//[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9] =[0-9] {1,8}
        Pattern p =Pattern.compile("([XY]?)([0-9]{1,8})([A-Z])");
                   /*Define un patron,si esta entre corchetes es que contiene ese numero
                    y si es entre parentesis estamos indicando contadores de repeticion*/

        Matcher m = p.matcher("X12345678Z 99999999T Y010110011M");//Comprueba un patron
        if ((m.matches())){ //Devuelve si contiene la cadena
            System.out.println("Contiene el patron");
        } else{
            System.out.println("No contiene el patron");
        }//Fin del if
        while (m.find()){
            System.out.println("--------------"+"\nLetra Inicial (opcional): "+m.group(1)+"\nNumeros: "+m.group(2)+"\nLetra NIF: "+m.group(3)+"\n----------------");
        }
    }
}
