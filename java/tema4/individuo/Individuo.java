
package tema4.individuo;

/**
 *
 * @author Marcos Romero
 * @version 1.0
 * 
 */
public class Individuo {
    private String nombre, dni;
    private int fechaNacimiento;
    private static int poblacion;
    private double altura;
    private static int fechaActual=2024;
    private int edad;
    
    //metodo constructor1
    public Individuo (String nombre, String dni, int fechaNacimiento){
        super(); //Primera linea del mtodo constructor, que invoque a la clase superior que comparta el mismo tipo
        this.dni=dni;
        this.nombre=nombre;
        this.fechaNacimiento=fechaNacimiento;
        poblacion++; //se asume que parte de cero
    } //Fin1
    //metodo constructor2
    public Individuo (String nombre, String dni, int fechaNacimiento, double altura){
        super(); //Primera linea del mtodo constructor, que invoque a la clase superior que comparta el mismo tipo
        this.dni=dni;
        this.nombre=nombre;
        this.fechaNacimiento=fechaNacimiento;
        poblacion++; //se asume que parte de cero
        this.altura=altura;
        edad=fechaActual-fechaNacimiento;
    } //Fin2
    
    //metodos get y set
    public String getDni(){
        return dni;
    }
    
    public void setDni(String dni){
        this.dni=dni;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public static int getPoblacion(){
        return poblacion;
    }
    
    public int getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public static void setPoblacion(int poblacion){
        Individuo.poblacion=poblacion;
    }
    
    public void setFechaNacimiento(int fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad=edad;
    }
    
    public void setAltura(double altura){
        this.altura=altura;
    }
    
    public double getAltura(){
        return altura;
    }
    
    public int getFechaActual(){
        return fechaActual;
    }
    
    public void setFechaActual(int fechaActual){
        this.fechaActual=fechaActual;
    }
    //metodos propios/especificos
    public void incrementarAltura(){
        altura=altura+0.01;
    }
    
    public void saludar(){
        System.out.println("Hola, mi nombre es: "+ nombre);
        System.out.println("Encantado de saludarte. Tengo "+edad+"años y mido "+altura+"metros");
    }

    
}

    

