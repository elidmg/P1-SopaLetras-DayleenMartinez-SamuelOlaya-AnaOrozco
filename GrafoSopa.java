/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**GrafoSopa
 * Representa un grafo para la sopa de letras
 *
 * @author samue
 */
public class GrafoSopa {
    private int max;
    private int MatrizAdy[][];
    private int indice;
    private Letra datos[][];
    private int NumMatriz;
    
    
/**Contructor de la clase GrafoSopa
 * 
 * @param maximo 
 */    
    public GrafoSopa(int maximo){
        this.max = maximo;
        this.MatrizAdy = new int[maximo][maximo];
        this.indice = 0;
        if (((Math.sqrt(max)*10) % 10) == 0){
            this.NumMatriz = (int) Math.sqrt(max);
            datos = new Letra[this.NumMatriz][this.NumMatriz];
        
        }
    
    
    }

/**getMax
 * Obtiene la magnitud maxima del grafo
 * 
 * @return la magnitud maxima del grafo 
 */
    public int getMax() {
        return max;
    }
/**getMatrizAdy
 * Obtiene la matriz de adyacencia del grafo
 * 
 * @return la matriz de adyacencia del grafo
 */

    public int[][] getMatrizAdy() {
        return MatrizAdy;
    }
/**getIndice
 * Obtiene el indice actual del grafo
 * 
 * @return el indice actual del grafo
 */

    public int getIndice() {
        return indice;
    }
/**getDatos
 * Obtiene los datos del grafo
 * 
 * @return los datos del grafo
 */

    public Letra[][] getDatos() {
        return datos;
    }
/**Adyacencia
 * Establece la adyacencia entre dos letras en el grafo
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
 * Agrega letras a la sopa de letras y establece la adyacencia correspondiente en el grafo
 * 
 * 
 * @param Letras
 * @return 
 */
    public boolean AgregarLetra(String[] Letras){
        int aux = 0;
            for (int i = 0; i < this.NumMatriz-1; i++){
                for (int j = 0; j < this.NumMatriz-1; j++){
                    if (this.datos[i][j].EsVacio()){
                        this.datos[i][j].setNombre(Letras[aux], indice);
                        aux ++;
                        indice++;
                        this.Adyacencia(i, j);
                        
                    
                    }
                
                }
            
            
            }
        
    return false;
    }
    
    
    
}
    
    
    
    
    
