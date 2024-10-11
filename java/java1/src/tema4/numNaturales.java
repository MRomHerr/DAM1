/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4;

/**
 *
 * @author alumno
 */
public class numNaturales {
       private int inicio,maximo;
       
    
       public numNaturales (){
            this.inicio=0;
        }
       
        public numNaturales (int inicio, int maximo){
            this.inicio=inicio;
        }
        
        public void setInicio(int inicio){
            this.inicio=inicio;
        }
    
        public void setMaximo(int maximo){
            this.maximo=maximo;
        }
    
        public int getInicio(){
            return inicio;
        }
    
        public int getMaximo(){
            return maximo;
        }

        public void reset(){
            this.inicio=0;
            this.maximo=0;
        }
        
        public void imprimirRango(){
            for(int i=this.inicio;i<=this.maximo;i++){
                System.out.println(i+" ");
            }
        }
        
        public void imprimirRangoInverso(){
            for(int i=this.maximo;i<=this.inicio;i--){
                System.out.println(i+" ");
            }
        }
    }
  



    

