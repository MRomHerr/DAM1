/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema4.individuo;

/**
 *
 * @author alumno
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Individuo alumno1= new Individuo( "Juan Torres", "00000000A", 1978);
        Individuo alumno2= new Individuo( "Sara Gonzalez", "11111111A", 1983);
        Individuo alumno3= new Individuo( "Pepe Blanco","22222222A", 1991);
        Individuo alumno4= new Individuo( "Elena Sanchez","33333333A", 1995);
        
        Individuo alumno5= new Individuo( "juan Maso","55555555A", 2001,1.8);
        
        System.out.println("POBLACION ACTUAL"+Individuo.getPoblacion()+"alumno");
        
        //Empleados
       Empleado Alejandro= new Empleado();
       Alejandro.setNombre("Alejandro");
       Alejandro.setSalario(25000.50);
       Empleado Lucia= new Empleado("Lucia", 26000.0);
       Alejandro.mostrarDatos();
       Alejandro.subirSalario(3.1);
       
       Empleado [] empleadoEmpresa = new Empleado[3];
       empleadoEmpresa[0] = Alejandro;
       empleadoEmpresa[1] = Lucia;
       empleadoEmpresa[2] = new Empleado ("Pablo", 30000.0);
       

    }
    
}
