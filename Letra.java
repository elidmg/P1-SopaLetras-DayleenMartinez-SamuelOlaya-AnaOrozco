/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoo;

/**
 *
 * @author ani
 */
public class Letra {
    String nombre;
    int numLetra;
    
    public Letra(String letra){
        nombre = letra;
        numLetra = -1;
        
        
    }
    /** @return String Funcion que retorna la letra 
     * 
     * 
     */
    
    public String nombreLetra(){
        return nombre;
    }
    /** @return true Funcion que retorna si dos vertices son iguales 
     * 
     * @param v
     *  
     */
    //tarea: REVISAR JAVADOC
    public boolean equals(Letra v){
        return nombre.equals(v.nombre);    
    }
    
    /** @void Funcion que establece el numero de letras dentro de la matriz 
     * 
     * @param v 
     */
    public void asigLetra(int v){
        numLetra = v;
    }
    /** @return String Funcion auxiliar para mostrar Letra y su posicion
     * 
     * 
     */
    @Override
    public String toString(){
        return nombre + "("+numLetra+")";
        
    }
    
    
}    
            
    

    
    
        

    

