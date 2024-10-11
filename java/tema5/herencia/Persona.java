package tema5.herencia;

/**
 *
 * @author alumno
 */
public class Persona {
    protected String nombre;
    protected String apellido;
    protected int edad;
    
    //metodos constructores
    public Persona(){
    }
    
    public Persona(String nombre, String apellido, int edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }
    
    //metodos clase persona
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setApellido(String apelllido){
        this.apellido=apellido;
    }
    
    public void setEdad(int edad){
        this.edad=edad;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public int getEdad(){
        return edad;
    }
    
}//Fin clase persona
