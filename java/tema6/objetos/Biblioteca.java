package tema6.objetos;

/**
 *
 * @author alumno
 */
public class Biblioteca {
    
    private String libro;
    private String autor;
    
    //metodos constructores
    public Biblioteca(String libro){
        this.libro=libro;
    }
    
    public Biblioteca(String libro, String autor){
        this.libro=libro;
        this.autor=autor;
    }
    
    //metodos getter y setter
    public void setLibro(String libro){
      this.libro=libro;
    }
    
    public String getLibro(){
      return libro;
    }
    
    public void setAutor(String autor){
      this.autor=autor;
    }
    
    public String getAutor(){
      return autor;
    }
    
    //metodo para sobreescribir un metodo ya creado
    @Override
    public String toString(){
        return("Libro: "+" ,"+this.libro+" ,Autor: "+this.autor);
    }
    
}
