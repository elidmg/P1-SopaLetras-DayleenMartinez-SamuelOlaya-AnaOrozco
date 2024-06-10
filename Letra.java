/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**Letra
 * clase que representa una letra en la sopa de letras
 *
 * @author Samuel, Dayleen y Ana
 */
public class Letra {
    String nombre;
    int numLetra;
    
/**Contructor de la clase letra
 * 
 */    
    public Letra(String letrica, int num){
        nombre = letrica;
        numLetra = num;
        
    }
    /** nombreLetra
     * Obtiene el nombre de la letra
     * 
     * @return String del nombre de la letra
     */
    
    public String nombreLetra(){
        return nombre;
    }
    
    /** equals
     * Compara si el nombre de una letra es igual al nombre de otra
     * @return true si dos nombres de letras son iguales 
     * 
     * @param v
     **/
    public boolean equals(String v){
        return nombre.equals(v);    
    }
    
/**getNombre
 * Obtiene el nombre de la letra 
 * 
 * @return el nombre de la letra
 */
    public String getNombre() {
        return nombre;
    }
/**setNombre
 * Establece el nombre de la letra y su numero de letra asociado
 * 
 * @param nombre
 * @param indice 
 */

    public void setNombre(String nombre, int indice) {
        this.nombre = nombre;
        this.numLetra = indice;
    }
/**getNumLetra
 * Obtiene el numero de la letra
 * 
 * @return el numero de la letra
 */


    public int getNumLetra() {
        return numLetra;
    }
/**EsVacio
 * verifica si el nodo esta vacio
 * 
 * @return true si el nodo es vacio
 */

    public boolean EsVacio(){
        return (this.equals(""));
        }
    
    }