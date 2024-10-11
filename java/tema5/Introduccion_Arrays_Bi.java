package tema5;
/**
 * Es una introduccion a los ejercicios del Tema 6 parte 3
 * @author Mparr
 * @date 31/01/2024
 */

import javax.swing.*;

public class Introduccion_Arrays_Bi {
    public  static int[][]inicializarArray (int n,int m){
        int numero=0;
        int [][] ret= new int[n][m];
        for ( int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                ret[i][j]=numero;
                numero++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

        int[][] array2D = new int[][]{{0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}};//Array de dos dimensiones 4*5
        double promedio = 0;
        int suma = 0;
        int elementos=0;
        System.out.println("Valores de la matriz");
        for (int j=0;j<array2D.length;j++){
            for (int i=0;i<array2D[0].length;i++){
                System.out.print(array2D[j][i]+",");
                suma+=array2D[j][i];
                elementos++;
            }//Fin segundo for
            System.out.println(" ");
        }//Fin primer for
        //Imprimo la matriz de 4*5
        System.out.println("La suma de la matriz es: "+suma+"\nY contiene elementos: "+elementos);
        promedio=(double) suma/elementos;
        System.out.println("El promedio de la matriz es: "+promedio);

        int n=Integer.parseInt(JOptionPane.showInputDialog("Introduce de cuantas filas quieres el array"));
        int m=Integer.parseInt(JOptionPane.showInputDialog("Introduce de cuantas columnas quieres el array"));
         int [][] tabla2D=inicializarArray(n,n);
        System.out.println("Valores de la matriz creada: ");
        for (int j=0;j<tabla2D.length;j++){
            for (int i=0;i<tabla2D[0].length;i++){
                System.out.print(tabla2D[j][i]+",");
            }//Fin segundo for
            System.out.println(" ");
        }//Fin primer for
/*Imprimo la matriz personalizada*/
        int numero=0;
        int elementosi=0;
        double promedioI=0;
        int sumai=0;
        int [][] irregular=new int[4][];
        irregular[0]=new int[4];
        irregular[1]=new int[5];
        irregular[2]=new int[3];
        irregular[3]=new int[4];
        for (int j=0;j<irregular.length;j++){
            for (int i=0;i<irregular[j].length;i++){
                irregular[j][i]=elementosi;
                elementosi++;
            }//Fin segundo for
        }//Fin primer for
        System.out.println("Valores de la matriz irregular: ");
        for (int j=0;j<irregular.length;j++){
            for (int i=0;i<irregular[j].length;i++){
                System.out.print(array2D[j][i]+",");
                sumai+=irregular[j][i];
            }//Fin segundo for
            System.out.println(" ");
        }//Fin primer for
        System.out.println("La suma  de la matriz irregular: "+sumai+"\nNumero de elementos: "+elementosi);
        promedioI=(double) sumai/elementosi;
        System.out.println("El promedio de la matriz irregular es: "+promedioI);
        int tmp;
        for (int i= 0;i<irregular.length;i++){
            tmp=0;
            for (int j =0;j<irregular[i].length;j++){
                tmp+= irregular[i][j];

            }//Segundo for
            System.out.println("Y su promedio de fila"+(i+1)+" es:"+((double)tmp/irregular[i].length));
        }
    }//Fin de main

}//Fin de la introduccion a los arrays multidimensionales