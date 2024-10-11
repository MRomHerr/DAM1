package tema6;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class DietaSemanal {

    private final String[][] comidas;
    private static final String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    public DietaSemanal() {
        comidas = new String[5][3]; // 7 días de la semana, 3 comidas al día
    }

    public void establecerComida(int dia, int comida, String detalle) {
        comidas[dia][comida] = detalle;
    }

    public String obtenerComida(int dia, int comida) {
        return comidas[dia][comida];
    }

    public void buscarDiasConComida(String comidaBuscada) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (comidas[i][j].contains(comidaBuscada)) {
                    System.out.println("Comiste " + comidaBuscada + " el " + dias[i]);
                }
            }
        }
    } 

    public void diasSinCena() {
        int contador = 0;
        for (int i = 0; i < 5; i++) {
            if (comidas[i][2].equals("")) {
            contador++;
            System.out.println("No cenaste el " + dias[i]);
                }
        }
        System.out.println("No cenaste " + contador + " días");
    }

    public void resumenComidaSemanal() {
        for (int i = 0; i < 5; i++) {
            System.out.println(dias[i] + ": Desayuno - " + comidas[i][0] + ", Comida - " + comidas[i][1] + ", Cena - " + comidas[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DietaSemanal dieta = new DietaSemanal();
        // Establecer algunas comidas
        dieta.establecerComida(0, 0, "Tostadas");
        dieta.establecerComida(0, 1, "Ensalada");
        dieta.establecerComida(0, 2, "hamburguesa");
        
        dieta.establecerComida(1, 0, "Cereales");
        dieta.establecerComida(1, 1, "Ensalada");
        dieta.establecerComida(1, 2, "pescado");
        
        dieta.establecerComida(2, 0, "Tostadas");
        dieta.establecerComida(2, 1, "Ensalada");
        dieta.establecerComida(2, 2, "");
        
        dieta.establecerComida(3, 0, "un fukin cruasan");
        dieta.establecerComida(3, 1, "Ensalada");
        dieta.establecerComida(3, 2, "Pasta");
        
        dieta.establecerComida(4, 0, "Tostadas");
        dieta.establecerComida(4, 1, "Ensalada");
        dieta.establecerComida(4, 2, "pescado");
        
        System.out.println("  1- Imprimir el resumen de la comida semanal\n  2- Imprimir el resumen de la comida semanal\n  3- Buscar días con una comida específica\n  4- Imprimir los días sin cena\n  5-Salir");
        
        while (true) {
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                
                break;
            case 2:
                // Imprimir el resumen de la comida semanal
                dieta.resumenComidaSemanal();
                break;
            case 3:
                // Buscar días con una comida específica
                dieta.buscarDiasConComida("un fukin cruasan");
                break;
            case 4:
                // Imprimir los días sin cena
                dieta.diasSinCena();
                break;
            case 5:
                //acaba con la eejcución del programa, el 0 significa que no tiene errores si pusiera un número me pondría que hay errores
                    System.out.println("Saliendo...");
                    System.exit(0);
                break; 
            default://en caso de que se introduzca un carater que no sea 1,2,3,4 o 5
                    System.out.println("Opción no válida");
        }//fin switch
        }//fin while
    }
}

