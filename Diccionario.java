/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**Clase Diccionario
 *
 * @author Samuel, Dayleen y Ana
 */

public class Diccionario {
    public Palabra first;
    public Palabra Last;
    public int Size;
    
/**Constructor de Diccionario
 * 
 */
    public Diccionario() {
        this.first = null;
        this.Last = null;
        this.Size = 0;
        
    }
  /**Agregar 
  * Metodo para agregar palabras al diccionario
  * 
  * @param valor
  * @return True si se agrega la palabra 
  */
    
    public boolean Agregar(String valor) {
    Palabra nuevaPalabra = new Palabra(valor);

    
    if (this.first == null) {
        this.first = nuevaPalabra;
        this.Last = nuevaPalabra;
        this.Size++;
        return true;
    }

    
    if (nuevaPalabra.getValor().length() <= this.first.getValor().length()) {
       
        if (nuevaPalabra.getValor().equals(this.first.getValor())) {
            return false;
        }
        nuevaPalabra.setNxt(this.first);
        this.first = nuevaPalabra;
        this.Size++;
        return true;
    }

   
    Palabra actual = this.first;
    while (actual.getNxt() != null && nuevaPalabra.getValor().length() > actual.getNxt().getValor().length()) {
        actual = actual.getNxt();
    }

    
    if (actual.getNxt() != null && nuevaPalabra.getValor().equals(actual.getNxt().getValor())) {
        return false;
    }

   
    nuevaPalabra.setNxt(actual.getNxt());
    actual.setNxt(nuevaPalabra);
    if (nuevaPalabra.getNxt() == null) {
        this.Last = nuevaPalabra;
    }

    this.Size++;
    return true;
} 
    
/**print 
 * Retornar las palabras del diccionario 
 * 
 * @return cadena de string de las palabras del diccionario
 */

    
        public String print(){
        String Matrix = "";
        System.out.println("La sopa tiene " +  getSize() + " palabras \n");
        Palabra aux = this.first;
        for (int i = 0; i <  getSize(); i++) {
            
                Matrix += "-" + aux.getValor();
            
            Matrix = Matrix + "\n";
            if(aux.getNxt()!=null){
                aux = aux.getNxt();
            }
            
            }
            return Matrix;
        }
/**EsVacio
 * Metodo para saber si el diccionario esta vacio
 * 
 * @return true si el diccionario esta vacio
 */
 
   
        public boolean EsVacio(){
        return first == null;
    }
    
/**getFirst 
 * Obtiene la primera palabra del diccionario 
 * 
 * @return first  
 */
    public Palabra getFirst() {
        return first;
    }
/**getLast 
 * Obtiene la ultima palabra del diccionario 
 * 
 * @return Last
 */
    public Palabra getLast() {
        return Last;
    }
    
/**getsize
 * Obtine el size del diccionario
 * 
 * @return Size
 */


    public int getSize() {
        return Size;
    }
/**setFirst
 * Establece la primera palabra del diccionario
 * 
 * @param first 
 */


    public void setFirst(Palabra first) {
        this.first = first;
    }
/**setLast
 * Establece la ultima palabra del diccionario 
 * 
 * @param Last 
 */


    public void setLast(Palabra Last) {
        this.Last = Last;
    }
    
/**setSize
 * Establece el size del diccionario
 * 
 * @param Size 
 */

    public void setSize(int Size) {
        this.Size = Size;
}
}
