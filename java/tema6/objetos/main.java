package tema6.objetos;

/**
 *
 * @author alumno
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Biblioteca[] listaLibros = new Biblioteca [3];//array1
        listaLibros[0] = new Biblioteca("Programacion C");
        listaLibros[1] = new Biblioteca("Java");
        listaLibros[2] = new Biblioteca("Linux");
        
        //Biblioteca[] listaLibros = {new Biblioteca("Programacion C"), new Biblioteca("Programacion Java"), new Biblioteca("Programacion Python")};
        
        for(Biblioteca i:listaLibros){
            System.out.println(i.getLibro());
        }
        
        Biblioteca[] listaLibros2 = new Biblioteca[3];//array2
        listaLibros2[0] = new Biblioteca("Programacion C","Oscar Colmenarejo");
        listaLibros2[1] = new Biblioteca("Java","Juan");
        listaLibros2[2] = new Biblioteca("Linux","Pepe");
        
        //imprime el override
        for (Biblioteca j:listaLibros2){
            System.out.println(j);
        }//fin for
    }//fin del metodo main
    
}//fin de la clas main
