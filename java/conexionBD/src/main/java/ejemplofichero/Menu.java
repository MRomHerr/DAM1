package ejemplofichero;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu {  
    private List<Objeto> objetos;
    private String rutaArchivoPalabras = ".//src//main//java//ejemplofichero//fichero.txt";
    private String rutaArchivoBorrador = ".//src//main//java//ejemplofichero//borrador.txt";

    public Menu() {
        objetos = new ArrayList<>();
        cargarObjetosDesdeFichero();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            String[] opciones = {"Agregar objeto", "Borrar objeto", "Salir"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    agregarObjeto();
                    break;
                case 1:
                    borrarObjeto();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 2);
    }

    private void agregarObjeto() {
        String nombre = JOptionPane.showInputDialog("Ingrese nombre:");
        String edadStr = JOptionPane.showInputDialog("Ingrese edad:");
        int edad = Integer.parseInt(edadStr);
        String ciudad = JOptionPane.showInputDialog("Ingrese ciudad:");

        Objeto objeto = new Objeto(nombre, edad, ciudad);
        objetos.add(objeto);
        guardarEnFichero(objeto, rutaArchivoPalabras);
        JOptionPane.showMessageDialog(null, "Objeto agregado y guardado en el fichero.");
    }

    private void borrarObjeto() {
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del objeto a borrar:");
        String edadStr = JOptionPane.showInputDialog("Ingrese edad del objeto a borrar:");
        int edad = Integer.parseInt(edadStr);
        String ciudad = JOptionPane.showInputDialog("Ingrese ciudad del objeto a borrar:");

        Iterator<Objeto> iterator = objetos.iterator();
        boolean encontrado = false;
        
        while (iterator.hasNext()) {
            Objeto objeto = iterator.next();
            if (objeto.getNombre().equals(nombre) && objeto.getEdad() == edad && objeto.getCiudad().equals(ciudad)) {
                guardarEnFichero(objeto, rutaArchivoBorrador);
                iterator.remove();
                JOptionPane.showMessageDialog(null, "Objeto borrado y guardado en el fichero borrador.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Objeto no encontrado.");
        } else {
            actualizarFicheroPrincipal();
        }
    }

    private void guardarEnFichero(Objeto objeto, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo, true)) { // true para modo append
            writer.write(objeto.getNombre() + "::" + objeto.getEdad() + "::" + objeto.getCiudad() + "\n");
            JOptionPane.showMessageDialog(null, "Datos guardados en el fichero: " + rutaArchivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en el fichero: " + e.getMessage());
        }
    }

    private void actualizarFicheroPrincipal() {
        try (FileWriter writer = new FileWriter(rutaArchivoPalabras, false)) { // false para sobrescribir el fichero
            for (Objeto objeto : objetos) {
                writer.write(objeto.getNombre() + "::" + objeto.getEdad() + "::" + objeto.getCiudad() + "\n");
            }
            JOptionPane.showMessageDialog(null, "Fichero principal actualizado.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el fichero principal: " + e.getMessage());
        }
    }

    private void cargarObjetosDesdeFichero() {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivoPalabras))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("::");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    int edad = Integer.parseInt(partes[1]);
                    String ciudad = partes[2];
                    Objeto objeto = new Objeto(nombre, edad, ciudad);
                    objetos.add(objeto);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los objetos desde el fichero: " + e.getMessage());
        }
    }

}
