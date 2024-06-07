/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**Clase Diccionario
 * 
 * 
 *
 * @author samue
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
    public boolean Agregar(String valor){
        Palabra Valor = new Palabra(valor);
        if (this.first == null){
        this.first = Valor;
        this.Last = Valor;
        return true;
        }
        
        else {
            Palabra aux = this.first.getNxt();
            if (Valor.getValor().length()<=this.first.getValor().length()){
                Valor.setNxt(this.first);
                this.first = Valor;
                return true;
            }
            for(int i = 1; i< Size-1; i++){
                if (Valor.getValor().length()>=aux.getValor().length() &&  Valor.getValor().length()<=aux.getValor().length()){
                    Valor.setNxt(aux.getNxt());
                    aux.setNxt(Valor);
                    return true;
                }
            aux = aux.getNxt();
            
            }
            this.Last.setNxt(Valor);
            this.Last = Valor;
            return true;
            
            
            
        }
        
        
            
        
        }
/**EsVacio
 * Metodo para saber si el diccionario esta vacio
 * 
 * @return true si el diccionario esta vacio
 */
    
    public boolean EsVacio(){
        return first==null;
        
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
 * Obtiene la segunda palabra del diccionario 
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
