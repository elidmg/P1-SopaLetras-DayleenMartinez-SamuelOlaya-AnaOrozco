/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**Diccionario
 * Esta clase representa el diccionario implementado en una lista enlazada
 * @author samue
 */
public class Diccionario {
    public Palabra first;
    public Palabra Last;
    public int Size;

    /**Constructor 
     * 
     */
    public Diccionario() {
        this.first = null;
        this.Last = null;
        this.Size = 0;
        
    }
    /**Agregar 
     * 
     * @param valor El valor a agregar
     * @return True si el valor puede ser agregado 
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
    
    //* 

    public Palabra getFirst() {
        return first;
    }

    public Palabra getLast() {
        return Last;
    }

    public int getSize() {
        return Size;
    }

    public void setFirst(Palabra first) {
        this.first = first;
    }

    public void setLast(Palabra Last) {
        this.Last = Last;
    }

    public void setSize(int Size) {
        this.Size = Size;
}
}
