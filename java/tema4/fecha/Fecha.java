
package tema4.fecha;

/**
 *
 * @author alumno
 */
public class Fecha {
    private int año;
    private int mes;
    private int dia;
    
    //Constructor por defecto
    public Fecha() {
    }

    //Constructor con parametros
    public Fecha(int año, int mes, int dia) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }
    
    //metodos get y set

    public int getAño() {
        return año;
    }
    
    public void setAño(int año) {
        this.año=año;
    }

    public int getMes() {
        return mes;
    }
    
    public void setMes(int mes) {
        this.mes=mes;
    }

    public int getDia() {
        return dia;
    }
    
    public void setDia(int dia) {
        this.dia=dia;
    }
    //fin get y set
    
    //Metodo para comprobar si la fecha es correcta
    public boolean fechaCorrecta(){
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto=año>0;
        mesCorrecto=mes>=1 && mes<=12;
        
        switch(mes){
            case 2:
                if (esBisiesto()){
                    diaCorrecto=dia>=1 && dia<=29;
                }
                else{
                    diaCorrecto=dia>=1 && dia<=28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto=dia>=1 && dia<=30;
                break;
            default:
                diaCorrecto=dia>=1 && dia<=31;
        } //Fin del switch
        return diaCorrecto&&mesCorrecto&&añoCorrecto;
    }//Fin del metodo
    
    //metodo que comprueba si es bisieto
    private boolean esBisiesto(){
        return (año % 4 == 0 && año % 100 != 0 && año % 400 == 0);
    }//Fin del metodo
    
    //metodo que modifica la fecha actual y la ca,bia por el dia siguiente
    public void diasiguiente(){
        dia++;
        if (!fechaCorrecta()){
            dia=1;
            mes++;
            if(!fechaCorrecta()){
                mes=1;
                año++;
            }
        }
    }//Fin del metodo
}
    

