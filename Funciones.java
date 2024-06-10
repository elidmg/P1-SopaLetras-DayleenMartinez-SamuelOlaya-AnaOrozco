/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**Funciones
 * Funciones para buscar las palabras en la sopa de letras
 * 

 *
 * @author Samuel, Dayleen y Ana
 */
public class Funciones {

/**Arrays de direcciones en x y en y
 * 
 */
    private static final int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private boolean[][] visited; 

    /**dfs
     * Metodo para buscar palabra mediante Depth First Search 
     * 
     * @param datos
     * @param palabra
     * @param x
     * @param y
     * @param idx
     * @param visited 
     * @return true si se encuenra la palabra
     */
    
    public boolean dfs(Letra[][] datos, String palabra, int x, int y, int idx, boolean[][] visited) { 
    if (idx == palabra.length()) {
        return true;
    }

    if (x < 0 || x >= datos.length || y < 0 || y >= datos[0].length || visited[x][y] || datos[x][y].getNombre().charAt(0) != palabra.charAt(idx)) { //new || visited[x][y] ||
        return false;
    }
    
    char temp = datos[x][y].getNombre().charAt(0);
    int aux = datos[x][y].getNumLetra();
    datos[x][y].setNombre("#", aux); 
    visited[x][y] = true; //new
     
    for (int k = 0; k < 8; k++) {
        int newX = x + dx[k];
        int newY = y + dy[k];

            if (dfs(datos, palabra, newX, newY, idx + 1, visited)) { 
                datos[x][y].setNombre(Character.toString(temp), aux);
                return true;
            }
        }
   

    datos[x][y].setNombre(Character.toString(temp), aux); 
    visited[x][y] = false;
    return false;
}
    
    /**buscarPalabra
     * Funcion que busca palabra en la sopa de letras utilizando DFS
     * 
     * @param datos
     * @param palabra
     * @return true si se encuentra la palabra en la sopa
     */
    

    public boolean buscarPalabra(Letra[][] datos, String palabra) {
        int n = datos.length;
        int m = datos[0].length;
        boolean[][] visited = new boolean[n][m]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(datos, palabra, i, j, 0, visited)) {
                    return true;
                }
                visited = new boolean[n][m];
            }
        }
        return false;
    }
/**buscarPalabraBFS
 * Buscar palabra mediante Breadth First Search
 * 
 * @param datos
 * @param palabra
 * @return true si se encuentra la palabra
 */  
    
    public boolean buscarPalabraBFS(Letra[][] datos, String palabra) {
    int n = datos.length;
    int m = datos[0].length;

    int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}, 
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1} 
    };

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (datos[i][j].getNombre().charAt(0) == palabra.charAt(0)) {
                
                if (bfsRecursivo(datos, palabra, i, j, 0, directions, n, m, new boolean[n][m])) {
                    return true;
                }
            }
        }
    }

    return false;
}
/**bfsRecursivo
 * Hace la busqueda de las letras que pueden formar una palabra  
 * 
 * @param datos
 * @param palabra
 * @param x
 * @param y
 * @param idx
 * @param directions
 * @param n
 * @param m
 * @param visited
 * @return true si encuentra la palabra 
 */

private boolean bfsRecursivo(Letra[][] datos, String palabra, int x, int y, int idx, int[][] directions, int n, int m, boolean[][] visited) {
    
    if (idx == palabra.length() - 1) {
        return true;
    }

    visited[x][y] = true; 

    
    for (int[] dir : directions) {
        int newX = x + dir[0];
        int newY = y + dir[1];

        
        if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] &&
            datos[newX][newY].getNombre().charAt(0) == palabra.charAt(idx + 1)) {
            
            
            if (bfsRecursivo(datos, palabra, newX, newY, idx + 1, directions, n, m, visited)) {
                return true;
            }
        }
    }

    visited[x][y] = false; 
    return false;
}

/**buscarPalabraEspecifico
 * Busca la palabra especifica en la sopa de letras utilizando DFS o BFS
 * 
 * @param palabra
 * @param metodo
 * @param datos
 * @return true si se encuentra la palabra
 */
    
    public boolean buscarPalabraEspecifico(Palabra palabra, int metodo, Letra[][] datos){
        if (metodo == 1){
            if(buscarPalabraBFS(datos, palabra.getValor())){
            return true;
            }
        }
        else if (metodo == 2){
            if(buscarPalabra(datos, palabra.getValor())){
            return true;
            }
        
        }
        return false;
    }
/**RetornarPalabrasEncontradas
 * Metodo para mostrar las palabras encontradas del diccionario
 * @param palabras
 * @param datos
 * @param metodo
 * @return array de strings con las palabras encontradas 
 */
    
    public Diccionario RetornarPalabrasEncontradas(Diccionario palabras, Letra[][] datos, int metodo){
    Palabra aux = palabras.getFirst();
    Diccionario retornado = new Diccionario();
        for (int i = 0; i< palabras.getSize();i++){
            if (buscarPalabraEspecifico(aux, metodo, datos)){
                retornado.Agregar(aux.getValor());
            }
            aux = aux.getNxt();
        
        }
    return retornado;
    }
    
/**ReadDoc
 * Funcion para leer el archivo de texto 
 * 
 * @return
 * @throws FileNotFoundException
 * @throws IOException 
 * @return Cadena String con todo lo que tiene el archivo
 */
    

    public String ReadDoc() throws FileNotFoundException, IOException{
        String line = "";
        String Cadena = "";
        
        javax.swing.JFileChooser jfc = new javax.swing.JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select txt");
	jfc.setAcceptAllFileFilterUsed(false);
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo texto", "txt");
	jfc.addChoosableFileFilter(filter);

	int Value = jfc.showOpenDialog(null);
		

	if (Value == javax.swing.JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();          
        
            BufferedReader in = new BufferedReader(new FileReader(file));
            while ((line = in.readLine()) != null) {
               Cadena += line;
               Cadena += "\n";
                
	}
    }
        return Cadena;
    }
/**TomarPalabras
 * Funcion que toma las palabras de la cadena formada por el archivo de texto 
 * 
 * @param cadena
 * @return Diccionario con las palabras tomadas
 */
    
    
    public Diccionario TomarPalabras(String cadena) {
        cadena = cadena.replace(" ", "");
        String [] aux = cadena.split("\n");
        Diccionario dicc = new Diccionario();
        int contador = 0;
        
        if (contador < aux.length && aux[contador].contains("dic")) { 
            contador ++;
            while (contador < aux.length && !aux[contador].contains("/dic")) { 
                dicc.Agregar(aux[contador]);
                contador++;
                
                }
            }

        return dicc;
    }
    
/**CargarLetras
 * Funcion que carga las letras de la cadena formada por el archivo de texto
 * 
 * @param cadena
 * @return Array de Strings con las letras y un array nulo en caso de que algo falle 
 */
    
    
    
    public String[] CargarLetras(String cadena) {
        cadena = cadena.replace(" ", "");
        String [] aux = cadena.split("\n");
        for (int i = 0; i < aux.length; i++) {
        if (aux[i].contains("tab")) {
            if (i + 1 < aux.length) { 
            String[] letras = aux[i + 1].split(","); 
            return letras;
            }
        }
        }
    return new String[0]; 
    }
    
}
