package tema6.maquinaExpendedora;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class mainMaquina {
    private static bebidasycosas[] listaMercancia = {new bebidasycosas("cocacola",1.00, 8), new bebidasycosas("zumo de naranja",0.75, 6), 
        new bebidasycosas("zumo de piña",0.70, 12), new bebidasycosas("agua con gas",0.60, 5), 
        new bebidasycosas("aga mineral sin gas",0.60, 5), new bebidasycosas("sandwich vegetal",2.10, 4), 
        new bebidasycosas("sandwich de pollo",2.30, 6), new bebidasycosas("cookies de chocolate",0.35, 3), 
        new bebidasycosas("croissant",0.80, 3), new bebidasycosas("napolitana",1.25, 3)};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("");//espacio para que no quede todo 
            System.out.println("  1- Mostrar los productos y sus precios.\n  2- Mostrar los productos y cantidad.\n  3- Comprar un producto.\n  4- Reponer producto\n  5-Salir");
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

    //metodo de mostrra producto y precio
    private static void mostrarProductosYPrecios() {
        for(bebidasycosas i : listaMercancia){
            System.out.println("-"+i.getNombre()+" -> "+i.getPrecio()+" euros");
        }
    }

    //metodo de mostrar producto y cantidad
    private static void mostrarProductosYCantidades() {
        for(bebidasycosas i : listaMercancia){
            System.out.println("-"+i.getNombre()+" -> "+i.getCantidad()+" unidades");
        }
    }

    //metodo de comprar
    private static void comprarProducto(Scanner sc) {
        System.out.print("Introduce el nombre del producto que quieres comprar: ");
        String producto = sc.next();
        for (int i = 0; i < listaMercancia.length; i++) {
            if (listaMercancia[i].getNombre().equalsIgnoreCase(producto)) {
                if (listaMercancia[i].getCantidad() > 0) {
                    listaMercancia[i].setCantidad(listaMercancia[i].getCantidad() - 1);
                    System.out.println("Has comprado un " + producto + ". Quedan " + listaMercancia[i].getCantidad() + " unidades.");
                } else {
                    System.out.println("Lo siento, no quedan unidades de " + producto + ".");
                }
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    //metodo de reponer
    private static void reponerProducto(Scanner sc) {
        System.out.print("Introduce el nombre del producto que quieres reponer: ");
        String producto = sc.next();
        for (int i = 0; i < listaMercancia.length; i++) {
            if (listaMercancia[i].getNombre().equalsIgnoreCase(producto)) {
                listaMercancia[i].setCantidad(listaMercancia[i].getCantidad() + 1);
                System.out.println("Has repuesto un " + producto + ". Ahora hay " + listaMercancia[i].getCantidad() + " unidades.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }
}
