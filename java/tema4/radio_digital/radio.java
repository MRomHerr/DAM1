package tema4.radio_digital;

import java.util.Scanner; //importo scanner para poder introducir numero spor el teclado durante la ejecución del programa

public class radio {
    Scanner sc = new Scanner(System.in);
    //inicializacion de las variables
    static int indiceActual=0;
    private String emisora;
    private double frecuencia;
    
    //Constructor por defecto
    public radio() {
    }

    //Constructor con parametros
    public radio(String emisora, double frecuencia) {
        this.emisora=emisora;
        this.frecuencia=frecuencia;
    }
    
    //metodos get y set
    public String getEmisora() {
        return emisora;
    }
    
    public void setEmisora(String emisora) {
        this.emisora=emisora;
    }

    public double getFrecuencia() {
        return frecuencia;
    }
    
    public void setFrecuencia(double frecuencia) {
        this.frecuencia=frecuencia;
    }
   
    //metodo indice
    public void indice(){
        int opcion = sc.nextInt();
        
        switch (opcion) {
                case 1://va a la emisora anterior, si está en la primera emisora pasará a la última
                    indiceActual = (indiceActual - 1 + RadioDigital.emisoras.length) % RadioDigital.emisoras.length;
                    break;
                case 2://va a la emisora siguiente, si está en la última emisora pasará a la primera
                    indiceActual = (indiceActual + 1) % RadioDigital.emisoras.length;
                    break;
                case 3://llamo al arrays en el que están todas las emisoras
                    System.out.println("");
                    System.out.println("Emisoras disponobles:");
                    for (int i = 0; i < RadioDigital.emisoras.length; i++) {
                        System.out.println(">"+RadioDigital.emisoras[i].getEmisora());
                        }  
                    System.out.println("");
                    break;
                case 4://acaba con la eejcución del programa, el 0 significa que no tiene errores si pusiera un número me pondría que hay errores
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default://en caso de que se introduzca un carater que no sea 1,2,3 o 4
                    System.out.println("Opción no válida");
            }//Fin del switch
        
    }//Fin del metodo
    
}
