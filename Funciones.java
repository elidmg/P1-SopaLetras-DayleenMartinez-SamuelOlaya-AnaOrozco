/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.LinkedList;
import java.util.Queue;

/**Funciones
 * Clase con funciones para encontrar las palabras en la sopa 
 *
 * @author samue
 */
public class Funciones {
    
    /**Constantes que representan las direcciones horizontales y verticales 
     * para buscar
     * 
     */
    
   
    private static final int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    /**dfs
     * Busca si la palabra existe mediante Depth First Search 
     * 
     * @param datos
     * @param palabra
     * @param x
     * @param y
     * @param idx
     * @return True si la palabra es encontrada
     */
    public boolean dfs(Letra[][] datos, String palabra, int x, int y, int idx) {
        if (idx == palabra.length()) {
            return true;
        }

        if (x < 0 || x >= datos.length || y < 0 || y >= datos[0].length || datos[x][y].getNombre().charAt(0) != palabra.charAt(idx)) {
            return false;
        }

        char temp = datos[x][y].getNombre().charAt(0);
        int aux = datos[x][y].getNumLetra();
        datos[x][y] = new Letra();
        datos[x][y].setNombre("#", aux);// Marcar como visitada

        for (int k = 0; k < 8; k++) {
            if (dfs(datos, palabra, x + dx[k], y + dy[k], idx + 1)) {
                return true;
            }
        }

        datos[x][y].setNombre(Character.toString(temp), datos[x][y].getNumLetra());  // Restaurar la letra original
        return false;
    }
    
    /**buscarPalabra
     * Busca las palabras en la sopa mediante Depth First Search  
     * 
     * @param datos
     * @param palabra
     * @return True si alguna palabra es encontrada
     */
    
    public boolean buscarPalabra(Letra[][] datos, String palabra) {
        int n = datos.length;
        int m = datos[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(datos, palabra, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**buscarPalabraBFS
     * Busca si la palabra dada existe mediante Breadth First Search 
     * 
     * @param datos
     * @param palabra
     * @return True si alguna de las palabras 
     */
    
    
    public boolean buscarPalabraBFS(Letra[][] datos, String palabra) {
        int n = datos.length;
        int m = datos[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Movimientos arriba, abajo, izquierda, derecha

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];

                        if (datos[x][y].getNombre().equals(palabra)) {
                            return true;
                        }

                        for (int[] dir : directions) {
                            int newX = x + dir[0];
                            int newY = y + dir[1];

                            if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                                queue.offer(new int[]{newX, newY});
                                visited[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    /**buscarPalabraEspecifico
     * Funcion para buscar la palabra pedida 
     * @param palabra
     * @param metodo
     * @param datos 
     */
    
    public void buscarPalabraEspecifico(Palabra palabra, int metodo, Letra[][] datos){
        if (metodo == 1){
            buscarPalabraBFS(datos, palabra.getValor());
        }
        else if (metodo == 2){
            buscarPalabra(datos, palabra.getValor());
        
        }
    }
    
    /**RetornarPalabrasEncontradas
     * 
     * @param palabras
     * @param datos
     * @param metodo
     * @return Retorna las palabras encontradas
     */
    public String [] RetornarPalabrasEncontradas(String[] palabras, Letra[][] datos, int metodo){
        String [] encontradas = new String[palabras.length];
         if (metodo == 1){
             for (int i = 0; i<palabras.length; i++) {
                 
                 String palabra = palabras[i];
                 if (buscarPalabraBFS(datos, palabra)){
                     encontradas[i] = palabra;
                 }
             }
}
        else {
             for (int i = 0; i<palabras.length; i++) {
                 
                 String palabra = palabras[i];
            if(buscarPalabra(datos, palabra)){
                encontradas[i] = palabra;
            }             }
            
        
        }
    
    
    return encontradas;
    }
}
