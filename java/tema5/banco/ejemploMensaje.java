package tema5.banco;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author alumno
 */
public class ejemploMensaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Component frame= null;
        JOptionPane.showMessageDialog(frame,"Examen de Programaci�n el 4 de marzo");
        JOptionPane.showMessageDialog(frame,"Examen de Programaci�n el 4 de marzo","Illo, es un nicarag�ense",2);
        JOptionPane.showMessageDialog(frame,"Examen de Programaci�n el 4 de marzo","Texto de pobre chileno",3);
    }
}