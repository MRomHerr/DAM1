package tema3;

/**
 *
 * @author alumno
 */
public class ejemploBreak {
    public static void main(String[] args) {
    //Declarar las variables
    int numero=7;
    int contador;
    int resultado=0;
        System.out.println("Tabla de multiplicar del "+numero);
        System.out.println("--------------------------");
    
        for (contador=0;contador<=10;contador++){
            if (contador==7)//el bucle se par por completo
                break;
            resultado=numero*contador;
            System.out.println(numero+" x "+contador+" = "+resultado);
        }
    }
}

    

