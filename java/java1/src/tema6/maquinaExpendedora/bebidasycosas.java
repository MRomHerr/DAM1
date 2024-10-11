package tema6.maquinaExpendedora;

/**
 *
 * @author alumno
 */
public class bebidasycosas {
    private String nombre;
    private int cantidad;
    private double precio;
    
    //metodos constructores
    public bebidasycosas(String nombre,double precio, int cantidad){
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;
    };
    
    //metodos getter y setter
    public void setNombre(String nombre){
      this.nombre=nombre;
    }
    
    public String getNombre(){
      return nombre;
    }
    
    public void setPrecio(double precio){
      this.precio=precio;
    }
    
    public double getPrecio(){
      return precio;
    }
    
    public void setCantidad(int cantidad){
      this.cantidad=cantidad;
    }
    
    public int getCantidad(){
      return cantidad;
    }
    
}

