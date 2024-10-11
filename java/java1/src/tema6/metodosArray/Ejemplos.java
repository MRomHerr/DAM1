/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema6.metodosArray;

import java.util.Arrays;

/**
 *
 * @author alumno
 */
public class Ejemplos {
    /*
    Creo un metodo que da la vuelta al array
     */
    static void arrayReverse(int[] array){
        for (int i=0;i< array.length/2;i++){
            int temp=array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=temp;
        }//Fin for
    }//Fin arrayReverse
    public static void main(String[] args) {
        int [] primes={1,2,3,4,6,9,11};
        int [] copia= new int[primes.length];
        /*
        Copiamos el array primes a el array copia y luego le cambiamos el valor de la posicion 3
         */
        System.arraycopy(primes,0,copia,0,primes.length);
        copia[2]=16;
        System.out.println("Array origen"+ Arrays.toString(primes));
        System.out.println("Array copiado"+Arrays.toString(copia));
        /*
        Con la libreria java.util.Arrays  utilizamos otra manera de copiar un array
         */
        int[] copia2;
        copia2=Arrays.copyOf(primes,primes.length);
        System.out.println("Segunda forma de copiar"+Arrays.toString(copia2));
        /*
        Con una funcion de la librería java.util.arrays copiamos unas detrminadas posiciones del array primes
        (Hay otro modo de copiar un array con el metodo .clone() que es el metodo más facil)
         */
        int[]copiaRango;
        copiaRango=Arrays.copyOfRange(primes,1,4);
        System.out.println("Unos numeros copiados del array"+Arrays.toString(copiaRango));
        /*
        Copiamos un array bidimensional
         */
        int[][] origen=new int[][]{{1,3,5,7,9},{2,4,6},{1,2,3}};
        int[][] copiaBi=new int[origen.length][];
        for (int i=0;i< origen.length;i++){
            copiaBi[i]=Arrays.copyOf(origen[i],origen.length);//Otra manera serìa copiaBi[i]=origen[i].clone() es el más sencillo
        }//Fin for
        copiaBi[1][1]=20;
        System.out.println("Copia del array bidimensional"+ Arrays.deepToString(copiaBi));
        /*
        Ordeno el array de forma ascendente y descendente
         */
        Arrays.sort(copia);
        System.out.println("Array ordenado ascendiente"+Arrays.toString(copia));
        arrayReverse(copia);
        System.out.println("Array ordenado descendente"+Arrays.toString(copia));
          /*
          Utilizamos el metodo fill para rellenar un array
           */
        int[] numero= new int[5];
        Arrays.fill(numero,50);
        System.out.println("Matriz Rellena:"+Arrays.toString(numero));
        /*
        Utilizamos un metodo para buscar un numero en un array
         */
        int target=49;
        int index=Arrays.binarySearch(numero,target);
        if (index>=0){
            System.out.println("Elemento "+target+"encontrado en el indice"+index);
        }else {
            System.out.println("Elemento "+target+" No encontrado ");
        }
        /*
        Utilizamos el metodo .deepEquals para comparar matrices multidimensionales
         */
        int[][]matriz1={{1,1},{2,2}};
        int[][]matriz2={{1,1},{2,2}};
        boolean sonIguales=Arrays.deepEquals(matriz1,matriz2);
        System.out.println("¿Las matrices son iguales?"+sonIguales);
        /*
        Para concatenar un array necsitariamos tener un proyecto java con Maven y utilizar la libreria de apache
         */
    }
}//Fin de la clase