/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author alumno
 */
public class main {
    
    static Collection rellenar(Collection c){
        c.add("perro");
        c.add("gato");
        c.add("perro");
        //c.clear(); elimina el array
        System.out.println(c.size());//muesrae tamaño dl arrylist
        return c;
    }
    
    static Map rellenar(Map m){
        m.put("perro","san bernardo");
        m.put("gato","montes");
        m.put("perro","presa canario");
        System.out.println(m.size());//muesrae tamaño dl arrylist
        return m;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("ArrayList: "+rellenar(new ArrayList())); //va en orden de insercion
        System.out.println("HashSet: "+rellenar(new HashSet()));// va en orden de ibntroduccion y no admite repeticiones
        System.out.println("HashMap: "+rellenar(new HashMap()));// empieza por el ultimo y no admite repeticiones
    }//fin metodo main
    
}//fin clase main

//HashSet contien un conjunto de objrtos que le permite determinar mas facil y7 rapidamente sui un objeto eta en el conjunto o no
//HashMap se imprime ente llacves con el simbolo = clave= valoir
//ArrayList se pueden crar elemnetos duplicados.