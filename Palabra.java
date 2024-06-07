/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**Clase Palabra
 * Representa una palabra 
 *
 * @author samue
 */
public class Palabra {
    protected String Valor;
    protected Palabra nxt;

    public Palabra(String valor) {
        this.Valor = valor;
        this.nxt = null;
        
   
    
    }
/**getValor
 * Obtiene el valor de la palabra 
 * 
 * @return el valor de la palabra
 */

    public String getValor() {
        return Valor;
    }
    
/**getNxt
 *Obtiene la referencia al siguiente nodo Palabra
 * 
 * @return la referencia al siguiente nodo palabra
 */

    public Palabra getNxt() {
        return nxt;
    }
/**setValor
 * Establece el valor de la palabra
 * 
 * @param Valor 
 */


    public void setValor(String Valor) {
        this.Valor = Valor;
    }
/**setNxt
 * Establece la referencia al siguiente nodo Palabra
 * 
 * @param nxt 
 */

    public void setNxt(Palabra nxt) {
       
        this.nxt = nxt;
    }

    
    
    
    
}

