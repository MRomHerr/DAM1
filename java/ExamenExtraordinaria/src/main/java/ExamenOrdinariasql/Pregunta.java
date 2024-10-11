package ExamenOrdinariasql;

public class Pregunta {
    String pregunta;
    String[] opciones;
    int respuestaCorrecta;

    public Pregunta(String pregunta, String[] opciones, int respuestaCorrecta) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }
}
