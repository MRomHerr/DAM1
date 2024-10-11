
package tema10.listabidimensional;

import java.util.ArrayList;
import java.util.List;
public class ListaBidimensionales {


    public static void main(String[] args) {
       //Me creo el array en 2 dimensiones
       ArrayList <ArrayList<Integer>> lista01 = new ArrayList <>();
        System.out.println("Lista 2D " + lista01);
        
        
        //Inicializar la lista
        int numberOfLists = 3;
        for (int i = 0; i < numberOfLists; i++) {
            lista01.add(new ArrayList <>());
        }
        
        System.out.println("Lista 2D actualizada " + lista01);
        
        //Añado elementos a la lista. El primeri a la primera lista 
        lista01.get(0).add(5);
        lista01.get(1).add(2);
        lista01.get(2).add(4);
        lista01.get(2).add(8);
        lista01.get(2).add(0, 3);
        
        System.out.println("Lista 2D: " + lista01);
        
        //Para imprimir son corchetes
        for (ArrayList <Integer> list: lista01) {
            for(Integer i1: list)
                System.out.printf("%s", i1);
        }
  
       
        
    }
    
}
