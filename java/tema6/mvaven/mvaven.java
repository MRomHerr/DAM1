/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema6.mvaven;
import java.util.Arrays;

/**
 *
 * @author alumno
 */
public class mvaven {

    /**
     * @param args the command line arguments
     */
    
    static void arrayReverse(int[] array){
        for (int i=0; i<array.length/2;i++){
            int temp=array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=temp;
        }
    }
    
    
    
    public static void main(String[] args) {
        int [] numeros={5,2,8,4,12};
        Arrays.sort(numeros);
        arrayReverse(numeros);
    }
}
