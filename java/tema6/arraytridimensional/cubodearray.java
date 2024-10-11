/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema6.arraytridimensional;

/**
 *
 * @author alumno
 */
public class cubodearray {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
        int[][][] array1={{{1,-9,3},{2,7,4}},{{-45,5,6,75},{88}},{{29,30}}};  
        
        for (int[][] arr1:array1){
            for (int[] a:arr1){
                for(int finalArray1:a){
                    System.out.println(finalArray1);
                }
                System.out.println("");
            }//fin 2º for
        }//fin 3º for
           System.out.println("Elemento 0-0-0: "+array1[0][0][0]);
    }
    
}

    

