/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema6.metodoarrays;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author alumno
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] primes = {1,2,3,4,5,6,9,11};
        int[] copia = new int[primes.length];
        int[] copia2;
        int[] copiaRango;
        System.arraycopy(primes, 0, copia, 0, primes.length);
        
        copia[2]=16;
        System.out.println("Array orige: "+Arrays.toString(primes));
        System.out.println("Array copia: "+Arrays.toString(copia));
        
        Arrays.sort(copia);
        System.out.println("Array copia ordenado: "+Arrays.toString(copia));
        Arrays.sort(copia);
        System.out.println("Array ordenado descendente"+Arrays.toString(copia));
        
        //Collections.reverseOrder(Arrays.asList(copia));
        
        copia2 =Arrays.copyOf(primes, primes.length);
        copia2[2]=16;
        System.out.println("Array Copiado 2:"+Arrays.toString(copia2));
        copiaRango =Arrays.copyOfRange(primes, 1,4);
        System.out.println("Array parcial copiado:"+Arrays.toString(copiaRango));
        
        
        //copia de arrays bidimensional
        int [][] origen=new int[][]{
            {1,2,5,7,9},
            {2,4,6},
            {1,3,5}
        };//matriz irregular
        int[][] copiaBi=new int[origen.length][];
        for (int i=0;i<origen.length;i++){
            copiaBi[i] =origen[i].clone();
            copiaBi[i] = Arrays.copyOf(origen[i], origen[i].length);
        }
        System.out.println("MATRIZ ORIGINAL: "+Arrays.deepToString(origen));
        System.out.println("MATRIZ COPIA: "+Arrays.deepToString(copiaBi));
        
        int[] numeros=new int[5];
        Arrays.fill(numeros, 50);
        System.out.println("MATRIZ RELLENA"+Arrays.toString(numeros));
        
        int target=49;//encuentra el numero 49 en el arrray
        int index=Arrays.binarySearch(numeros,target);
        if(index>=0){//si el numeo está en el array index sera igual a 0 o a un numero positivo sino no esta
            System.out.println("Elemento "+target+" encontrado en el indice "+index);
        
        }else{
            System.out.println("Elemento "+target+" no encontrado");
        }//fin if
        
        int[][] matriz1={{1,1},{2,2}};
        int[][] matriz2={{1,1},{2,2}};
        boolean sonIguales=Arrays.deepEquals(matriz1,matriz2);
        System.out.println("Las matrices son iguales? "+sonIguales);
        
    }
}
