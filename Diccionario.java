/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Samuel, Dayleen y Ana
 */

public class Diccionario {
    public Palabra first;
    public Palabra Last;
    public int Size;

    public Diccionario() {
        this.first = null;
        this.Last = null;
        this.Size = 0;
        
    }
    
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
   
        public boolean EsVacio(){
        return first == null;
    }
    

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
