/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Samuel, Dayleen y Ana
 */
public class GrafoSopa {
    private int max;
    private int MatrizAdy[][]; 
    private int indice; 
    private Letra datos[][]; 
    private int NumMatriz;  
    
    
    
    public GrafoSopa(int maximo){
        this.max = maximo;
        this.MatrizAdy = new int[maximo][maximo];
        this.indice = 0;
        if (((Math.sqrt(max)*10) % 10) == 0){
            this.NumMatriz = (int) Math.sqrt(max);
            datos = new Letra[this.NumMatriz][this.NumMatriz];
        
        }
    }
    
    public String print(){
        String Matrix = "";
        System.out.println("La matriz tiene " +  getIndice() + " vertices \n");
        for (int i = 0; i <  NumMatriz; i++) {
            for (int j = 0; j <  NumMatriz; j++) {
                Matrix += "[" + datos[i][j].getNombre() + "]" + " ";
            }
            Matrix = Matrix + "\n";
        }
        return Matrix;
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

    
    public void Adyacencia(int x, int y){
        for(int i = 0; i < this.NumMatriz; i++){
            for(int j = 0; j < this.NumMatriz; j++){
                if(x != i && y != j){
                    int aux1 = Math.abs(x-i) + Math.abs(y-j);
                    if (aux1 == 2 && this.datos[i][j] != null){
                        this.MatrizAdy[this.getIndice() -1][this.datos[i][j].numLetra] = this.MatrizAdy[this.datos[i][j].numLetra][this.getIndice()-1] = 1;
                                }
                }
                else{
                int aux1 = Math.abs(x-i) + Math.abs(y-j);
                    if (aux1 ==1&& this.datos[i][j]!= null){ this.MatrizAdy[this.getIndice()-1][this.datos[i][j].numLetra] = this.MatrizAdy[this.datos[i][j].numLetra][this.getIndice()-1] = 1;
                                }
                
                }
        }
        
        }
    
    
    }
    
    public boolean AgregarLetra(String[] Letras){
        int aux = 0;
            for (int i = 0; i < this.NumMatriz; i++){
                for (int j = 0; j < this.NumMatriz; j++){
                    if (this.datos[i][j] == null){
                        this.datos[i][j] = new Letra(Letras[aux], indice);
                        aux ++;
                        indice++;
                        this.Adyacencia(i, j);
                        
                    }
                
                }
            
            }
        
    return false;
    }
    
    
    
}
    
    
    
    
    
