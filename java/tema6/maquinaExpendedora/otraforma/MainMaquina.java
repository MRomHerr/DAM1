package tema6.maquinaExpendedora.otraforma;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class MainMaquina {
    private static Object[][] listaMercancia = {{"cocacola",1.00, 5}, {"zumo de naranja",0.75, 5}, //Cuando declaras un array como Object[][], puedes almacenar cualquier tipo de objeto en él, incluyendo objetos de tipo String, Integer, Double, etc. Esto es porque todos estos tipos son subclases de Object.
        {"zumo de piña",0.70, 5}, {"agua con gas",0.60, 5}, 
        {"aga mineral sin gas",0.60, 5}, {"sandwich vegetal",2.10, 5}, 
        {"sandwich de pollo",2.30, 5}, {"cookies de chocolate",0.35, 5}, 
        {"croissant",0.80, 5}, {"napolitana",1.25, 5}};
    
    //System.out.println(Arrays.toString(listaMercancia[1]));   esto imprime {"zumo de naranja",0.75, 5}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n  1- Mostrar los productos y sus precios.\n  2- Mostrar los productos y cantidad.\n  3- Comprar un producto.\n  4- Reponer producto\n  5-Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: 
                    mostrarProductosYPrecios();
                    break;
                case 2:
                    mostrarProductosYCantidades();
                    break;
                case 3:
                    comprarProducto(sc);
                    break;
                case 4:
                    reponerProducto(sc);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break; 
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    //metodo mostrar producto y precio
    private static void mostrarProductosYPrecios() {
        for(Object[] i : listaMercancia){
            System.out.println("-"+i[0]+" -> "+i[1]+" euros");
        }
    } // fin metodo mostrar producto y precio

    //metodo mostrar productor y su cantidad
    private static void mostrarProductosYCantidades() {
        for(Object[] i : listaMercancia){
            System.out.println("-"+i[0]+" -> "+i[2]+" unidades");
        }
    } //fin metodo mostrar producto y precio

    //metodo comprarProducto
    private static void comprarProducto(Scanner sc) {
        System.out.print("Introduce el nombre del producto que quieres comprar: ");
        String producto = sc.nextLine();
        sc.nextLine();//para que no se superpongan los sout y para que me deje escribir nombre con separarciones
        System.out.print("Introduce el dinero: ");
        Double pago=sc.nextDouble();
        for (Object[] i : listaMercancia) {
            if (i[0].equals(producto)) {
                if ((int) i[2] > 0 && pago > (double) i[1]) {
                    i[2] = (int)i[2] - 1;
                    System.out.println("Has comprado un " + producto + ". Quedan " + i[2] + " unidades.");
                    System.out.println("Tu vuelta es de "+(pago-(double)i[1]));
                } else {
                    System.out.println("Lo siento, no quedan unidades de " + producto + ".");
                }
                return;
            }
        }
        System.out.println("Producto no encontrado."); 
    }//fin del metodo comprarProducto
    

    //metodo reponer producto
    private static void reponerProducto(Scanner sc) {
        System.out.print("Introduce el nombre del producto que quieres reponer: ");
        String producto = sc.nextLine();
         sc.nextLine();//para que no se superpongan los sout y para que me deje escribir nombre con separarciones
        for (Object[] i : listaMercancia) {
            if (i[0].equals(producto)) {
                i[2] = (int)i[2] + 1;
                System.out.println("Has repuesto un " + producto + ". Ahora hay " + i[2] + " unidades.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }//fin del metodo reponerProducto
    
}//fin de la clase main
