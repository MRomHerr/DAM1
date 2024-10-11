/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class algoritmoArrays {
    
    public static int[] bubblesort(int[] numbers){
        boolean swapped=true;
        int temp;
        for(int i=numbers.length-1;i>0&&swapped;i--){
            swapped=false;
            for(int j=0;j<i;j++){
                if(numbers[j]<numbers[j+1]){
                    temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                    swapped=true;
                }
            }
        }
        return numbers;
        
    }
    
    static void imprimirArrayUni (int a[],int length){
        System.out.print("El resultado del array es:[");
        for(int i=0;i<length;i++){
            System.out.print(a[i]+",");
        }
        System.out.print("]");
    }
    
    
    public static int[] bubblesortDesc(int[] numbers){
        boolean swapped=true;
        int temp;
        for(int i=numbers.length-1;i>0&&swapped;i--){
            swapped=false;
            for(int j=0;j<i;j++){
                if(numbers[j]>numbers[j+1]){
                    temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                    swapped=true;
                }
            }
        }
        return numbers;
        
    }
    
    public static int[] bubbleSort2(int[] numbers){
        boolean swapped=true;
        int temp;
        int i=0;
        int j=numbers.length-1;
        
        while(i<j&&swapped){
            swapped=false;
            for(int k=i;k<j;k++){
                if(numbers[k]>numbers[k+1]){
                    temp=numbers[k];
                    numbers[k]=numbers[k+1];
                    numbers[k+1]=temp;
                    swapped=true;
                }
            }
            j--;
            if(swapped){
                swapped=false;
                for(int k=j;k>i;k--){
                    if(numbers[k]<numbers[k-1]){
                
                temp=numbers[k];
                numbers[k]=numbers[k-1];
                numbers[k-1]=temp;
                swapped=true;
                    }
            }
                i++;
        }
        }
        return numbers;
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] array={10, 1, 5, 40, 12, 34, 44, 12, 11, 9};
        int[] array2={10, 1, 5, 40, 12, 34, 44, 12, 11, 9};
        int longitud=array.length;
        int longitud2=array2.length;
        bubblesort(array);
        imprimirArrayUni (array, longitud);
        System.out.println("");
        bubblesortDesc(array);
        imprimirArrayUni (array, longitud);
        System.out.println("version mejorada:");
        bubbleSort2(array2);
       imprimirArrayUni (array2, longitud2);
    } 
    
}

