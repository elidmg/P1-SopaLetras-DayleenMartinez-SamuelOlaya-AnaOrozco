/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author samue
 */
public class Funciones {
    
    private static final int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
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
    
    public void buscarPalabraEspecifico(Palabra palabra, int metodo, Letra[][] datos){
        if (metodo == 1){
            buscarPalabraBFS(datos, palabra.getValor());
        }
        else if (metodo == 2){
            buscarPalabra(datos, palabra.getValor());
        
        }
    }
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
                
	}
    }
        return Cadena;
    }
    
    
    
    
    
    
    public Diccionario TomarPalabras() throws IOException{
        String cadena = ReadDoc();
        String [] aux = cadena.split("\n");
        Diccionario dicc = new Diccionario();
        int contador = 0;
        if (aux[contador].equals("dic")){
            contador ++;
            while(!aux[contador].equals("/dic")){
                dicc.Agregar(aux[contador]);
                contador++;
            }
}
        return dicc;
            }
    
    public void CargarLetras(GrafoSopa sopita) throws IOException{
        String cadena = ReadDoc();
        String [] aux = cadena.split("\n");
        int contador = 0;
        if (aux[contador].equals("tab")){
            contador ++;
            while(!aux[contador].equals("/tab")){
                int contador2 = contador-1;
                String[] letras = aux[contador].split(",");
                sopita.AgregarLetra(letras[contador2]);
            }
}
    
    }
    
    
}
