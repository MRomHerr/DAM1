package tema10.Ejemplo1Iterador;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //iterador en una lista
        // se aplica polimorfismo
        Iterable<String> AlumnosDAM1 = List.of("Alejandro", "David", "Lucia", "Marina");
        AlumnosDAM1.forEach(System.out::println);

        //crear el objeto a aprtir de la clase concreta
        // a la izquierda el tipo de lisrta arraylist
        ArrayList<Integer> Lista02 = new ArrayList<>();

        //ver tipos de lista .getClass()
        System.out.println("Tipo e lista: " + AlumnosDAM1.getClass());
        System.out.println("Tipo e lista: " + Lista02.getClass());

        //definir el tamaño inicial de la lista
        //le pongo un limite de 2 al arraylist 
        ArrayList<String> Lista03 = new ArrayList<>(2);
        Lista03.add("SARA");
        Lista03.add("JUAN");
        System.out.println(Lista03 + ", ");
        Lista03.add("Elena"); //al poner un tercer elemneto dupilca el limite de la lista con lo cual hay un cuarto elemneto vacio
        System.out.println(Lista03 + ", ");

        Lista03.set(0, "Sara Gonzalez");
        Lista03.set(1, "Juan Torres");
        Lista03.set(2, "Elemea Sanchez");
        Lista03.set(3, "David Meca");//dara error porque este elemnto bno existe, antes tengo que añadirño con un add
        System.out.println("Lista  modificada" + Lista03 + ", ");

        System.out.println("Elemento 2 de la lista: " + Lista03.get(1));//devulve la posicion 1 que es juan torres

        //eliminar un elemnto de la lista
        Lista03.remove(1);
        System.out.println("Lista03 con un elemento menos: " + Lista03);

        Lista03.remove("David Meca");

        Lista03.removeAll(Lista03);//borra todos los elemntos de la lista
        System.out.println("Lista03vacia: " + Lista03);
        System.out.println("Lista03vacia: " + Lista03.size());//muestra el numero de elemtnos de la lista
        //.add añadir
        //.set modificar
        //.get devuelve valor o elemnto de la lisrta

        //Metodo contains
        boolean contiene = false;
        contiene = Lista03.contains("Sara Gonzalez");
        System.out.println("valor booleano " + contiene);

        //ORDENAR COLECCIONES
        Collections.sort(Lista03);
        System.out.println("Lista 3 ordenada: " + Lista03);

        /*ESTO 
        ES 
        LO 
        NUEVO*/
        
        ArrayList<Integer> lista4 = new ArrayList<Integer>();
        lista4.add(5);
        lista4.add(7);
        lista4.add(3);
        Collections.sort (lista4, Integer::compareTo);
        System.out.println("Lista4 ordenada: " + lista4);
        
        
        Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort (lista4, comparador);
        System.out.println("Lista 4 invertida" + lista4);
        
        ArrayList<Integer> lista4b = new ArrayList<>(List.of(7, 7, 3, -1, -5));
         lista4b.sort(comparador);
         System.out.println("Lista4b descendente: " + lista4b);
         
         lista4b.sort(Integer::compareTo);
         System.out.println("Lista4b ascendente: " + lista4b);

         
         //Copiar valores de una lista 
         List<String> lista5 = Collections.nCopies (5, "Hola");
         System.out.println("Lista repetida: "+ lista5);
                 
               
                 
                 }

}
