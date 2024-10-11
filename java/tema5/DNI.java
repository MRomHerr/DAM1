package tema5;

/**
 *
 * @author alumno
 */
public class DNI {
    //Atributos estaticos:todas las letras del DNI
    static final String LETRAS_DNI="TRWAGMYFPDXBNJZSQVHLCKE";
    //Atributos objeto
    private int numDNI;

    //METODOS PUBLICOS
      public void establecer(String nif) throws Exception{
          if (DNI.validarNIF(nif)){//Valido y se  almacena
              this.numDNI=DNI.extraerNumeroNIF(nif);
          }
          else {
            throw new Exception("NIF invalido: "+nif);
          }
      }//Fin del metodo establecer

    public void establecer(int dni) throws Exception{
          //Compruebo rango
        if ((dni>9999999&&dni<99999999)) {
            this.numDNI = dni;//Valor valido y se almacena

        } else {
            throw new Exception("Numero DNI invalido: "+dni);//Da un erro
        }
    }//Fin del metodo establecer
    public String obtenerNIF(){
          String cadenaNIF;
          char letraNIF;
          letraNIF=calculaLetraNIF(numDNI);
          //Construir la cadena
        cadenaNIF= Integer.toString(numDNI)+String.valueOf(letraNIF);
      return cadenaNIF;
    }//Devuelve el NIF Completo
    public int obtenerDNI(){
          return numDNI;
    }
    //METODOS PRIVADOS
    private static char extraerLetraNIF(String nif){
        char letra = nif.charAt(nif.length()-1);
        return letra;
    }//Fin del metodo extraerLetraNIF
    private static int extraerNumeroNIF(String nif){
        int numero=Integer.parseInt(nif.substring(0,nif.length()-1));
        return numero;
    }//Fin del metodo extraerNumeroNIF
    private static char calculaLetraNIF(int numDNI){
        char letra;
        letra=LETRAS_DNI.charAt(numDNI%23);
        return letra;
    }//Fin del metodo calcularLetraNIF
    private static boolean validarNIF(String nif){
        boolean valido=true;//Suponemos que el NIF es valido
        int numeroDNI;
        char letraCalculada;
        char letraLeida;

        if (nif==null){
            valido=false;
        }
        else if (nif.length()>9 || nif.length()<8){
            valido=false;
        }else {
            numeroDNI = DNI.extraerNumeroNIF(nif);
            letraLeida = DNI.extraerLetraNIF(nif);
            letraCalculada = DNI.calculaLetraNIF(numeroDNI);
            if (letraCalculada == letraLeida) {
                valido = true;
            }else {
                valido=false;
            }

        }
        return valido;
    }
}
