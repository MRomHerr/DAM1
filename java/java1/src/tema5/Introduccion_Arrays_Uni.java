package tema5;
/**
 * Es una introduccion a los ejercicios del Tema 6 parte 2
 * @author Mparr
 * @date 30/01/2024
 */
public class Introduccion_Arrays_Uni {
     static int  sumaArray(int [] j){
        int suma=0;
        for (int i=0;i<j.length;i++){
            suma =suma +j[i];
        }
        return suma;
    }
    public static void main(String[] args) {
        int[] m;//Declaro array
        m=new int[5];// Crear el array reservando en memoria

        int [] n = new int[5];//En uma sola linea
        n[0]=1;
        n[1]=2;
        n[2]=3;
        n[3]=4;
        n[4]=5;
        int suma=sumaArray(n);
        System.out.println("La suma es ---> "+suma);
    }
}
