package tema2;

/**
 *
 * @author alumno
 */
public class Ejemplo01 {
    //Codigo de la funcion
    //se debe de poner static para poderla utilizar en el main
    public static int sumar (int numero1, int numero2){
        int resultado =numero1+numero2;
        return resultado;
    }
    
    
    public static void main(String[] args) {
     //Todo code aplication logic here
        int variable1=sumar(2,3);
        System.out.println("La suma de dos números es: "+variable1);
             
		 
                 
    }       
    
}