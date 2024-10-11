package tema2;

import java.util.Scanner;


public class salario {
  
     public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
                 
                 double IRPF, SS, salario, salariobruto;
                 int horas,extras;
                 String [] array1 = new String[4];;
                 double [] array2 = new double[4];;
                 
                 
                 System.out.print("Introduzca las horas que trabaja a la semana ");
                 horas=sc.nextInt();
                 
                 if ( horas==40){
                     salariobruto=horas*23.25;
                     IRPF=(salariobruto*15)/100;
                     SS=(salariobruto*4.70)/100;
                     salario=salariobruto-IRPF-SS;
                     System.out.printf("\nSu IRPF : %.2f euros",IRPF);
                     System.out.printf("\nSu cuota a la seguridad social : %.2f euros",SS);
                     System.out.printf("\nSu salario semanal: %.2f euros\n",salario);
                     
                      array1 [0]="Primera semana";
                      array1 [1]="Segunda semana";
                      array1 [2]="Tercera semana";
                      array1 [3]="Cuarta semana";
                      
                      array2 [0]=salario;
                      array2 [1]=salario*2;
                      array2 [2]=salario*3;
                      array2 [3]=salario*4;
                      
                      for (int i=0;i<array2.length; i++){
                          System.out.println(" "+array1[i]+"="+array2[i]);
                      }
         
          
                 
                 } else if ( horas>40){
                     extras=horas-40;
                     salariobruto=(horas*23.25)+(extras*50);
                     IRPF=(salariobruto*15)/100;
                     SS=(salariobruto*4.70)/100;
                     salario=salariobruto-IRPF-SS;
                     System.out.printf("\nSu IRPF : %.2f euros",IRPF);
                     System.out.printf("\nSu cuota a la seguridad social : %.2f euros",SS);
                     System.out.printf("\nSu salario semanal: %.2f euros\n",salario);
                     
                      array1 [0]="Primera semana";
                      array1 [1]="Segunda semana";
                      array1 [2]="Tercera semana";
                      array1 [3]="Cuarta semana";
                      
                      array2 [0]=salario;
                      array2 [1]=salario*2;
                      array2 [2]=salario*3;
                      array2 [3]=salario*4;
                       
                      
                      for (int i=0;i<array1.length; i++){
                          System.out.println(" "+array1[i]+"="+array2[i]+" euros");
                      }
              
    
     }
}

}
