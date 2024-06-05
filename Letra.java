/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ani
 */
public class Letra {
    String nombre;
    int numLetra;
    
    public Letra(){
        nombre = "";
        numLetra = 0;
        
        
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
    public boolean equals(String v){
        return nombre.equals(v);    
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre, int indice) {
        this.nombre = nombre;
        this.numLetra = indice;
    }

    public int getNumLetra() {
        return numLetra;
    }

    public boolean EsVacio(){
        return (this.equals(""));
        }
    
    }