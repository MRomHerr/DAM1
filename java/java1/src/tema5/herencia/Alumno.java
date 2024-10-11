package tema5.herencia;

/**
 *
 * @author alumno
 */
public class Alumno extends Persona{
    //Atributos propios de alumno
    private int NIA;
    
    //Metodos constructores
    public Alumno(String nombre, String apellido, int edad, int NIA){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.NIA=NIA;
    }
    
    public void setNIA(int NIA){
      this.NIA=NIA;
    }
    
    public int getNIA(){
      return NIA;
    }
    
    public void imprimirCabecera(){
        System.out.println("-----------------------------");
        System.out.println("|   ALUMNO   | EDAD |   NIA   |");
        System.out.println("-----------------------------");
    }
    
    public void imprimirAlumno(){
        System.out.println("| "+Alumno.super.getNombre()+" "+Alumno.super.getApellido()+"   "+Alumno.super.getEdad()+"   "+this.NIA+"   |");
    }
    
    @Override
    public String toString(){
        return "Informacion del alumno:\nnombre y apellidos: "+super.getNombre()+" "+super.getApellido()+"\nEdad: "+super.getApellido()+"\nNIA: "+NIA;
    }
    
}
