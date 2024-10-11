/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema6.imorimirArrayMultidimensional;

import java.util.Arrays;

/**
 *
 * @author alumno
 */
public class test {
    public static void main(String[] args) {
        Punto[][] array1={{new Punto(1,2),new Punto(4,5),new Punto(0,3)},
                {new Punto(8,4)}
        };
        Punto[]line1= {new Punto(1,1),new Punto(2,2),new Punto(3,3)};
        Punto[]line2={new Punto(0,0)};
        Punto[]line3={new Punto(-1,-1),new Punto(-2,-2)};

        Punto[][] lineas ={line1,line2,line3};

        System.out.println(Arrays.deepToString(array1));//imprimir arrays multidimensionales
        System.out.println(Arrays.toString(line1));
        System.out.println(Arrays.deepToString(lineas));
    }//Fin main
}//Fin test