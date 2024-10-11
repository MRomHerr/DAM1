package Programas_hecho_para_practicar.Otras_Posibles_Opciones_a_actividades_de_Clase.ejercicio_3_Maquina_Expendedora;
import java.util.Scanner;
/**
 * Maquina expendedora de forma eficiente
 * @author Mparr
 * @version 2.0
 * @date 09/02/2024
 */
public class Maquina_Expendedora {
        public static void menu() {
            // Zona de declaracion de variables
            int eleccion;
            boolean salir = false;

            Producto[][] productos = new Producto[3][];
            productos[0] = new Producto[5]; // Bebidas
            productos[1] = new Producto[2]; // Sandwichs
            productos[2] = new Producto[3]; // Dulces

            // Inicialización de productos
            productos[0][0] = new Producto("Cocacola", 1.00, 5);
            productos[0][1] = new Producto("Zumo de naranja", 0.75, 5);
            productos[0][2] = new Producto("Zumo de pina", 0.70, 5);
            productos[0][3] = new Producto("agua mineral con gas", 0.60, 5);
            productos[0][4] = new Producto("agua mineral sin gas", 0.60, 5);

            productos[1][0] = new Producto("Vegetal", 2.10, 5);
            productos[1][1] = new Producto("De pollo", 2.30, 5);

            productos[2][0] = new Producto("cookie de chocolate", 0.35, 5);
            productos[2][1] = new Producto("croissant", 0.80, 5);
            productos[2][2] = new Producto("napolitana", 1.25, 5);

            // Zona de inicializacion
            Scanner scanner = new Scanner(System.in);

            // Zona de salida
            do {
                System.out.println("""
                    Elije una opcion:
                    1- Mostrar los productos y sus precios.
                    2- Mostrar  productos y cantidades que quedan.
                    3- Comprar un producto.
                    4- Reponer un producto.
                    Pulsa 0 para salir
                                """);
                eleccion = scanner.nextInt();
                scanner.nextLine();
                switch (eleccion) {
                    case 1:
                        System.out.println("Los productos son los siguientes: ");
                        for (Producto[] productoArray : productos) {
                            for (Producto producto : productoArray) {
                                System.out.println(producto.getNombre() + ": " + producto.getPrecio() + " euros ");
                            }//Fin primer for
                        }//Fin segundo for
                        break;
                    case 2:
                        System.out.println("Estos son los productos que hay ");
                        for (Producto[] productoArray : productos) {
                            for (Producto producto : productoArray) {
                                System.out.println(producto.getNombre() + ": " + producto.getCantidad());
                            }//Fin primer for
                        }//Fin segundo for
                        break;
                    case 3:
                        System.out.println("Productos disponibles y sus cantidades actuales:");
                        for (Producto[] productoArray : productos) {
                            for (Producto producto : productoArray) {
                                System.out.println(producto.getNombre() + ": " + producto.getPrecio() + " euros");
                            }//Fin primer for
                        }//Fin segundo for
                        System.out.println("Elige producto que comprar:");
                        String productoQueElige = scanner.nextLine();
                        System.out.println("Inserte el dinero con el que va ha pagar");
                        double cantidadDepositada = scanner.nextDouble();
                        double cantidadFinal = 0;
                        for (Producto[] productoArray : productos) {
                            for (Producto producto : productoArray) {
                                if (productoQueElige.equalsIgnoreCase(producto.getNombre())) {
                                    cantidadFinal = cantidadDepositada - producto.getPrecio();
                                    producto.setCantidad(producto.getCantidad() - 1);
                                }//Fin if
                            }//Fin primer for
                        }//Fin segundo for
                        System.out.println("La vuelta es: " + cantidadFinal);
                        break;
                    case 4:
                        System.out.println("Productos disponibles y sus cantidades actuales:");
                        for (Producto[] productoArray : productos) {
                            for (Producto producto : productoArray) {
                                System.out.println(producto.getNombre() + ": " + producto.getCantidad() + " disponibles");
                            }//Fin primer for
                        }//Fin segundo for
                        System.out.println("Elige producto reponer:");
                        String productoQueRepone = scanner.nextLine();
                        for (Producto[] productoArray : productos) {
                            for (Producto producto : productoArray) {
                                if (productoQueRepone.equalsIgnoreCase(producto.getNombre())) {
                                    producto.setCantidad(5);
                                }//Fin if
                            }//Fin primer for
                        }//Fin segundo for
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }//Fin switch
            } while (!salir);
        }//Fin de menu
        public static void main(String[] args) {
            menu();
        }//Fin main
    }//Fin Maquina Expendedora