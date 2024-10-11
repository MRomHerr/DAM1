
package ACTIVIDAD02_Arrays_objetos;

import javax.swing.JOptionPane;

/**
 * @Actividad2
 * @author Marcos Romero Herrero
 * @version 1.0
 * @since 2024-02-20
 */

public class main {
        public static void main(String[] args) {
            //array con los nombres de los meses
            String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

            //array para almacenar los meses
            ArrayObjetos.Mes[] meses = new ArrayObjetos.Mes[12];
            for (int i = 0; i < 12; i++) {
                int numDias = (i == 1) ? 28 : ((i == 3 || i == 5 || i == 8 || i == 10) ? 30 : 31);
                meses[i] = new ArrayObjetos.Mes(nombresMeses[i], numDias);
            }

            //array con las temperaturas de enero
            int[][] temperaturasEnero = {{10, 2}, {9, 2}, {12, 8}, {10, 8}, {9, 4}, {8, 3}, {9, -1}, {7, -3}, {7, 4}, {7, 4}, {8, 1}, {7, 0}, {9, 2}, {10, 5}, {13, 10}, {14, 11}, {12, 10}, {13, 10}, {10, 4}, {10, 1}, {11, 3}, {11, 1}, {16, 3}, {18, 6}, {18, 5}, {20, 6}, {18, 8}, {17, 5}, {14, 6}, {13, 5}, {11, 4}};
            for (int i = 0; i < 31; i++) {
                meses[0].dias[i] = new ArrayObjetos.Temperatura(temperaturasEnero[i][0], temperaturasEnero[i][1]);
            }
            
            while (true) {
                //este es el menu
                String opcion = JOptionPane.showInputDialog("Elige una opción:\n1. Elegir mes\n2. Salir");
                if (opcion.equals("1")) {
                    String mes = JOptionPane.showInputDialog("Introduce el número del mes (1-12):");
                    int numMes = Integer.parseInt(mes);
                    if (numMes < 1 || numMes > 12) {
                        JOptionPane.showMessageDialog(null, "Número de mes inválido. Introduce un número entre 1 y 12.");
                    } else {
                        meses[numMes-1].imprimirMes();
                    }
                } else if (opcion.equals("2")) {
                    break;
                }
            }
        }
    }

