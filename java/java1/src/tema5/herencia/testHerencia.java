package tema5.herencia;

import tema5.herencia.Profesor.especialidad;

/**
 *
 * @author alumno
 */
public class testHerencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno juan = new Alumno ("Juan","Torres",25,111111);
        System.out.println(juan.nombre+"   "+juan.apellido+"   "+juan.edad+"   "+juan.getNIA());
        System.out.println(juan.getNombre()+" "+juan.getApellido()+" "+juan.getEdad());
        
        juan.imprimirCabecera();
        juan.imprimirAlumno();
        
        
        Profesor pepe = new Profesor ("Pepe","Martin",40,especialidad.informatica);
        pepe.imprimirCabecera();
        pepe.imprimirProfesor();
        //String resultado=pepe.toString();
        System.out.println(pepe.toString());
    }
    
}
