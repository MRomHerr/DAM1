package ACTIVIDAD02_Arrays_objetos;

import javax.swing.JOptionPane;

/**
 * @Actividad2
 * @author Marcos Romero Herrero
 * @version 1.0
 * @since 2024-02-20
 */

public class ArrayObjetos {

    //clase interna para representar la temperatura
    static class Temperatura {
        int maxima;
        int minima;

        //constructor de la clase Temperatura
        public Temperatura(int maxima, int minima) {
            this.maxima = maxima;
            this.minima = minima;
        }
    }

    //clase interna para representar un mes
    static class Mes {
        String nombre;
        Temperatura[] dias;

        //constructor de la clase Mes
        public Mes(String nombre, int numDias) {
            this.nombre = nombre;
            this.dias = new Temperatura[numDias];
            for (int i = 0; i < numDias; i++) {
                this.dias[i] = new Temperatura(0, 0);
            }
        }

        //metodo para imprimir el mes
        public void imprimirMes() {
            int minTemp = Integer.MAX_VALUE;
            int maxTemp = Integer.MIN_VALUE;
            for (Temperatura dia : dias) {
                if (dia.minima < minTemp) {
                    minTemp = dia.minima;
                }
                if (dia.maxima > maxTemp) {
                    maxTemp = dia.maxima;
                }
            }
            JOptionPane.showMessageDialog(null, "Mes de " + nombre + ": Temperatura mínima = " + minTemp + "º, Temperatura máxima = " + maxTemp + "º");
        }
    }
} 