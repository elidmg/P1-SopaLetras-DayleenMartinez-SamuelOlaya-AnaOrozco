/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Indatech
 */

import java.util.LinkedList;
import java.util.Queue;

/**GrafoSopa
 * Clase para representar el grafo utilizado para la sopa de letras
 *
 * @author samue
 */
public class GrafoSopa {
    private int max; //max del graafo
    private int MatrizAdy[][]; //aristas
    private int indice; //total de elementos en el grafo
    private Letra datos[][]; //vertices 
    private int NumMatriz;//la construccion de la sopa de letras posicion de la letra 
    
    
    public GrafoSopa(int maximo){
        this.max = maximo;
        this.MatrizAdy = new int[maximo][maximo];
        this.indice = 0;
        if (((Math.sqrt(max)*10) % 10) == 0){
            this.NumMatriz = (int) Math.sqrt(max);
            datos = new Letra[this.NumMatriz][this.NumMatriz];
        
        }
    
    
    }

    public int getMax() {
        return max;
    }

    public int[][] getMatrizAdy() {
        return MatrizAdy;
    }

    public int getIndice() {
        return indice;
    }

    public Letra[][] getDatos() {
        return datos;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMatrizAdy(int[][] MatrizAdy) {
        this.MatrizAdy = MatrizAdy;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setDatos(Letra[][] datos) {
        this.datos = datos;
    }

    public void setNumMatriz(int NumMatriz) {
        this.NumMatriz = NumMatriz;
    }

    /**Adyacencia
     * Metodo que analiza las conexiones que posee una letra en un puesto en particular
     * 
     * @param x
     * @param y 
     */
    
    public void Adyacencia(int x, int y){
        for(int i = 0; i < this.NumMatriz; i++){
            for(int j = 0; j < this.NumMatriz; j++){
                if(x != i && y != j){
                    int aux1 = Math.abs(x-i) + Math.abs(y-j);
                    if (aux1 == 2&&!this.datos[i][j].EsVacio()){
                        this.MatrizAdy[this.getIndice()][this.datos[i][j].numLetra] = this.MatrizAdy[this.datos[i][j].numLetra][this.getIndice()] = 1;
                                }
                }
                else{
                int aux1 = Math.abs(x-i) + Math.abs(y-j);
                    if (aux1 ==1&& !this.datos[i][j].EsVacio()){ this.MatrizAdy[this.getIndice()][this.datos[i][j].numLetra] = this.MatrizAdy[this.datos[i][j].numLetra][this.getIndice()] = 1;
                                }
                
                }
        }
        
        }
    
    
    }
    /**AgregarLetra
     * Metodo para agregar una nueva letra a la sopa de letras
     * 
     * @param Letra
     */
    public void AgregarLetra(String Letra){
        
            for (int i = 0; i < this.NumMatriz-1; i++){
                for (int j = 0; j < this.NumMatriz-1; j++){
                    if (this.datos[i][j].EsVacio()){
                        this.datos[i][j].setNombre(Letra, indice);
                        indice++;
                        this.Adyacencia(i, j);
                        
                    
                    }
                
                }
            
            
            }
        
    
    }
    
    
    
}
    
    
    
