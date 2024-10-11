/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

/**
 *
 * @author alumno
 */
public class ejemplo11_string {
    public static void main (String[] args){
        //TODO code aplicatin logic here
        String texto="Hola mundo";
        System.out.println("La longitud es : "+texto.length());
        
        //Cadenas de carcteres comienzan a contra desde el cero hasta longitud-1
        System.out.println(texto.charAt(1));
        
        //obtener una parte de la cadena
        char buffer[]=new char[5];
        texto.getChars(5, 9, buffer, 0);
        System.out.println("El buffer copiado es: "+buffer);
        
        //comparaciones con == o con .equals.IgnoreCase
        String nombre1="Juan";
        String nombre2="ana";
        
        if (nombre1==nombre2){
            System.out.println("Son iguales");
        }else
            System.out.println("Son diferentes"); 
        
        //comparacion con CompareTo
        //Devuelve 0 si a,mbas cadenas son iguales
        //DFevuelve cvalor negativo si la cadena string es menor
        //Devuelve un valor positivo si el strring es mayor
        
        if(nombre1.compareTo(nombre2)==0){
            System.out.println("Son iguales");
        }else if(nombre1.compareTo(nombre2)<0){
            System.out.println("Nombre1 sería menor que nombre2");
        }else {
            System.out.println("Nombre2 sería menor que nombre1");   
        }
        
        //Conversion de variables a string
        System.out.println(String.valueOf(Math.PI));
        
        //Buscar contenido
        String sTexto="palabra palabra2 palabra3";//Cadena donde se va a buscar
        String busqueda="palabra2";
        int contador=0;//contador de ocurrencias
        
        while (sTexto.indexOf(busqueda)>-1){
            sTexto=sTexto.substring(sTexto.indexOf(busqueda)+busqueda.length(),sTexto.length());
            contador++;
        }//fin del while
  
    }
    }
    

