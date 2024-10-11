/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema7;

/**
 *
 * @author alumno
 */
public class ejemplo2Solucion {
static final int CONSTANTE=5;

    public static int divide (int dividendo, int divisor) {
        if (divisor==0) {
            throw new IllegalArgumentException("División incorrecta");
        }
        else {
            return (dividendo/divisor);
        }
    }//Fin metodo divide
    public static void main(String[] args) {
        try{
            int c,d;
            c=0;
            d=divide(CONSTANTE,c);
            System.out.println("Valor división: "+d);
        }catch(IllegalArgumentException e3)  {
            e3.printStackTrace();
            System.out.println("Error: "+e3.getMessage());
        }//Fin del try-catch
    }//Fin del main
}//Fin del codigo

