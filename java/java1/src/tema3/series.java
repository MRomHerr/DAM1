package tema3;

/**
 *
 * @author alumno
 */
public class series {
     public static void main(String[] args) {
        int a=0;
        int b=3;
        int c=3;
         for ( a=3; a<100;a+=3){
            System.out.print(a+", ");
    }
         System.out.println(" ");
         while(b<=100){
             System.out.print(b+", ");
             b+=3;
         }
        System.out.println(" ");
         do{
             System.out.print(c+", ");
             c+=3;
         } while(c<=99);
        
   
}
}