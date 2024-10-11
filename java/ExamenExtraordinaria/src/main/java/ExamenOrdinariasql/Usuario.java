package ExamenOrdinariasql;

import java.time.LocalDateTime;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellidos;
    private List<String> respuestasUsuario;
    private List<Integer> respuestasCorrectas;
    private int aciertos;
    private LocalDateTime fechaHora;

    public Usuario(String nombre, String apellidos, List<String> respuestasUsuario, List<Integer> respuestasCorrectas, int aciertos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.respuestasUsuario = respuestasUsuario;
        this.respuestasCorrectas = respuestasCorrectas;
        this.aciertos = aciertos;
        this.fechaHora = LocalDateTime.now();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public List<String> getRespuestasUsuario() {
        return respuestasUsuario;
    }

    public List<Integer> getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public int getAciertos() {
        return aciertos;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
