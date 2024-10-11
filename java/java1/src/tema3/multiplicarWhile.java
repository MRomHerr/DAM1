package tema3;

/**
 *
 * @author alumno
 */
public class multiplicarWhile {
      public static void main(String[] args) {
          int cont=0;
          int num=7;
          int result=0;
          
          System.out.println("Tabla de multiplicar del "+num);
          
          while (cont<=10){
            result=cont*num;
            System.out.println(num+" x "+cont+" = "+result);
            cont++;
        }
    }
}
