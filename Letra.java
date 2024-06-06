/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**Letra
 * Clase para representar el vertice letra
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
    /** nombreLetra
     * @return String Funcion que retorna la letra 
     * 
     * 
     */
    
    public String nombreLetra(){
        return nombre;
    }
    /** equals Funcion que ve si la letra y una cadena son iguales 
     * @return true si son iguales 
     * 
     * @param v
     *  
     */
    
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
    
    /**EsVacio Funcion que analiza si hay una letra
     * 
     * @return 
     */

    public boolean EsVacio(){
        return (this.equals(""));
        }
    
    }
