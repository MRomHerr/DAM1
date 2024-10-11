package tema4.radio_digital;

/**
 * Programa de radio
 * @author Marcos Romero
 * @version 1.0
 * @date 19/01/2024
 */
public class RadioDigital {
    public static radio[] emisoras = new radio[6];//array donde están las 6 emisoras
    public static void main(String[] args) {
        emisoras[0] =(new radio("Cadena COPE", 106.3));
        emisoras[1] =(new radio("EsRadio", 99.1));
        emisoras[2] =(new radio("Onda Cero Madrid", 98.0));
        emisoras[3] =(new radio("Los 40 Principales", 93.9));
        emisoras[4] =(new radio("Cadena SER", 105.4));
        emisoras[5] =(new radio("Cadena 100", 99.5));
        
        System.out.println("Emisora favorita: " + RadioDigital.emisoras[0].getEmisora() + ", Frecuencia: " + RadioDigital.emisoras[radio.indiceActual].getFrecuencia()+" MHz");


        while (true) {
            System.out.println("Emisora actual: " + emisoras[radio.indiceActual].getEmisora() + ", Frecuencia: " + emisoras[radio.indiceActual].getFrecuencia()+" MHz");
            menu.menu(args);//llamo al menú que está en otra clase
            radio opciones = new radio();//llamo a la clase radio y le pongo otro nombre en el main para luego poder utilizarla
            opciones.indice(); 
        }
    }
}

