package tema5.herencia;

/**
 *
 * @author alumno
 */
public class Profesor extends Persona{
    //Atributos propios de alumno
    enum especialidad{informatica, administrativo, finanzas}
    private especialidad e1;
    
    
    //Metodos constructores
    public Profesor(String nombre, String apellido, int edad, especialidad e1 ){
       this.nombre=nombre;
       this.apellido=apellido;
       this.edad=edad;
       this.e1=e1;
    }
    
    public void setEspecialidad(especialidad e1){
      this.e1=e1;
    }
    
    public especialidad getEspecialidad(){
      return e1;
    }
    
    public void imprimirCabecera(){
        System.out.println("-----------------------------");
        System.out.println("|   PROFESOR   | EDAD |   NIA   |");
        System.out.println("-----------------------------");
    }
    
    public void imprimirProfesor(){
        System.out.println("| "+super.getNombre()+" "+super.getApellido()+"   "+super.getEdad()+"   "+this.e1+"   |");
    }
    
    @Override
    public String toString(){
        return "Informacion del profesor:\nnombre y apellidos: "+super.getNombre()+" "+super.getApellido()+"\nEdad: "+super.getEdad()+"\nEspecialidad: "+e1 ;
    }
    
}
    
