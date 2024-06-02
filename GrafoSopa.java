/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JOptionPane;

/** Clase grafo Sopa, que representa la matriz completa
 *
 * @author ani y Dayleen
 */
public class GrafoSopa { //Estoy implementando grafo dentro de la matriz
    private int numLetras;  //Numero de vertices del grafo
    private int maxLetras; // Tamano maximo de la tabla
    private Letra [] letras; 
    private int [][] matrizAdy;  //Matriz de adyacencia de los vectores 
    
    //Constructor de inicializacion que se le pas apor argumentos numero de vertices
    public GrafoSopa(int v){
        numLetras = 16; //numero de vertices
        maxLetras = v; //max de la tabla
        matrizAdy = new int[v][v]; //Boleano de adyacencia entre vertices        
    } 
        
    /**Insertar un Vertice en mi matriz, este evalua la capacidad de 
     * los vertices, si no hay disponibilidad lanza un mensaje,
     * Si hay disponibilidad lo inserta
     * @param v
     *
     */
    //USO GET A SET PORQUE ES PRIVADO
    public void InsertarLetra(int v){
        if(v > getMaxLetras() - getNumLetras()){
            JOptionPane.showMessageDialog(null, "Error, se supera el numero de vertices","Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            for(int i= 0; i <getNumLetras() +v; i++){
                for(int j= getNumLetras(); j < getNumLetras() + v; j++){
                    getMatrizAdy() [i][j] = getMatrizAdy() [i][j] = 0;
                }
            }
        }
        setNumLetras(getNumLetras() + v);
    } 
    //OJO ESTO CAMBIA EL INDICE DE LOS VERTICES
    
    /**Eliminar Vertice, evalua que este dentro del rango
     * Si no esta manda errror
     * Si lo esta, Recorre la matriz hasta llegar a su direccion lo elimina 
     * colocando -1 
     * y cambia las adyacencias al siguiente vertice para quitar el que se buscaba
     * @param v
     */    
    public void EliminarLetra(int v){
        if(v >= getNumLetras()){
            JOptionPane.showMessageDialog(null, "Error, se supera el numero de vertices","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            for (int i = v; i < getNumLetras(); i++) {
                for (int j = 0; j < getNumLetras(); j++){
                   if(i == getNumLetras() -1 || j == getNumLetras() -1){
                        getMatrizAdy()[i][j] = getMatrizAdy()[j][i] = 0;
                   }else{
                        getMatrizAdy()[i][j] = getMatrizAdy()[i+1][j];
                        getMatrizAdy()[j][i] = getMatrizAdy()[i][j];
                       
                   }
                }
            }
             setNumLetras(getNumLetras()- 1);
        }
        
    }
    
    
    /** Insertar una arista dentro de la matriz
     * @param i
     * @param j 
     * @param: String a, String b 
     * 
     */
    //En caso de que
    //se trate de un grafo no dirigido, debe recordarse que 
    //la arista (i, j) es igual a la arista (j, i) para que 
    //la matriz mantenga la propiedad de la simetría.
    
    public void InsertarArista(int i, int j){
        //Evalua la existencia de ambos vertices
        if (i < 0||j <0) {
            JOptionPane.showMessageDialog(null, "Error, No existe","Error",JOptionPane.ERROR_MESSAGE);
        }
        //Si existe ambos son adyacentes por tanto comparten una arista como 1
        //Colocamos 1 porque nosotros no tenemos un peso 
        getMatrizAdy()[i][j] = getMatrizAdy()[j][i] = 1;
    }    
    
    
    /** Eliminar Aristas, Si se quiere eliminar aristas entre dos 
     * vertices se coloca 0, para decir que no hay una conexion entre ellas.
     * @param i
     * @param j
     */
    public void EliminarArista(int i, int j) {
        if (i < 0||j <0){JOptionPane.showMessageDialog(null, "Error, No existe","Error",JOptionPane.ERROR_MESSAGE);
        }
        getMatrizAdy()[i][j] = getMatrizAdy()[j][i] = 0;
    }
    
    /**
     * Imprimir Matriz,a tarvez de consola para saber como va quedando
     * @return 
     */
    public String print(){
        String matrix = "";
        System.out.println("Nuestra matriz tiene " + getNumLetras() + " vertices \n");
        for (int i = 0; i < getNumLetras(); i++) {
            for (int j = 0; j < getNumLetras(); j++) {
                matrix += "[" + getMatrizAdy()[i][j] + "]" + " ";
            }
            matrix = matrix + "\n";
        }
        return matrix;
    }
    
    
    /**true Determina si dos letras forman un arco, 
     * es decir si el elemento de la matriz es 1,
     * si hay adyacencia entre ellos     
     * @param i
     * @param j
     * @return
     * @throws Exception 
     */
    
    //Trows Exception Funciona como un JOptions 
    //hrows declara qué excepción puede lanzar un 
    //método en caso de error.
    public boolean adyacene(int i,int j)throws Exception{
        if (i<0||j<0) throw new Exception ("Vertice no existe");
        return matrizAdy[i][j]==1;
    }

    
    
    public int getNumLetras() {
        return numLetras;
    }

    public void setNumLetras(int numLetras) {
        this.numLetras = numLetras;
    }

    public int getMaxLetras() {
        return maxLetras;
    }

    public void setMaxLetras(int maxLetras) {
        this.maxLetras = maxLetras;
    }

    public Letra[] getLetras() {
        return letras;
    }

    public void setLetras(Letra[] letras) {
        this.letras = letras;
    }

    public int[][] getMatrizAdy() {
        return matrizAdy;
    }

    public void setMatrizAdy(int[][] matrizAdy) {
        this.matrizAdy = matrizAdy;
    }
            
    
    
    
    
    
    
    
    
     
    
    
        
   
    
   
    
}







