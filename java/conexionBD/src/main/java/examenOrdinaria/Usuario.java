/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenOrdinaria;

import java.util.List;

class Usuario {
    private String nombre;
    private String apellidos;
    private List<String> respuestasUsuario;
    private List<Integer> respuestasCorrectas;
    private int aciertos;

    public Usuario(String nombre, String apellidos, List<String> respuestasUsuario, List<Integer> respuestasCorrectas, int aciertos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.respuestasUsuario = respuestasUsuario;
        this.respuestasCorrectas = respuestasCorrectas;
        this.aciertos = aciertos;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", aciertos=" + aciertos +
                '}';
    }
}