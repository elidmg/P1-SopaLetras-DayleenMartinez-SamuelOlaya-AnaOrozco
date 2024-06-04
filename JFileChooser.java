/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author ani
 */
public class JFileChooser {
    private int numLetra = 0;
    private int numAri = 0;
    private String[] aristas = new String[84];
    GrafoSopa grafo = GlobalGrafo.getGrafo();
    
    /**
     * Método para leer el archivo txt
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void ReadDoc() throws FileNotFoundException, IOException{
        
        boolean letra = false; 
        int i = 0;

        javax.swing.JFileChooser jfc = new javax.swing.JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select txt");
	jfc.setAcceptAllFileFilterUsed(false);
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo texto", "txt");
	jfc.addChoosableFileFilter(filter);

	int Value = jfc.showOpenDialog(null);
		

	if (Value == javax.swing.JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
                        
            BufferedReader in;
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                if(line.equals("Letra")){
                    letra = true;
                    line = in.readLine();
                }
                if(line.equals("aristas")){
                    letra = false;
                    line = in.readLine();
                }
                if(letra == true){
                    numLetra++;
                }else{
                    aristas[i] = line;
                    numAri++;
                    i++;
                }
                    line = in.readLine();
            }            
	}
    }
    /**
     * Método para Guardar un txt
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void GuardarTxt()throws FileNotFoundException, IOException{
       
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
            
        
        fc.setDialogTitle("Guardar Grafo...");
        fc.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt"));

        int seleccion = fc.showSaveDialog(null);

        if (seleccion == javax.swing.JFileChooser.APPROVE_OPTION) {
            
            File fichero = fc.getSelectedFile();

            if (!fichero.getName().endsWith(".txt")) {
                
                fichero = new File(fichero.getAbsolutePath() + ".txt");
            } 
            FileWriter fw = null;
            
            fw = new FileWriter(fichero);
            
            
            fw.write("letra\n");
            for (int i = 1; i < grafo.getNumLetras()+1; i++) {
                fw.write(i+" ");
                fw.write("\n");
            }
            
            fw.write("aristas\n");
            for (int i = 0; i < grafo.getNumLetras(); i++) {
                for (int j = 0; j < grafo.getNumLetras(); j++) {
                    if (grafo.getMatrizAdy()[i][j] != 0) {
                        fw.write(String.valueOf(i+1)+","+ String.valueOf(j+1) +","+String.valueOf(grafo.getMatrizAdy()[i][j])+"");
                        fw.write("\n");
                    }
                }
            }
            fw.close();

        }
    }

    public int getNumLetra() {
        return numLetra;
    }

    public void setNumLetra(int numLetra) {
        this.numLetra = numLetra;
    }

    public String[] getAristas() {
        return aristas;
    }

    public void setAristas(String[] aristas) {
        this.aristas = aristas;
    }

    public GrafoSopa getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoSopa grafo) {
        this.grafo = grafo;
    }
    
    public int getNumAri() {
        return numAri;
    }

    public void setNumAri(int x) {
        this.numAri = x;
    }
}
    
    
   
    /**
     * Getters and Setters de los atributos.
     * @return 
     */
    /*
    public String[] getAri() {
        return aristas;
    }
    
    public void setAri(String[] aristas) {
        this.aristas = aristas;
    }

    public int getNumLetras() {
        return numLetras;
    }

    public void setNumLetras(int x) {
        this.numLetras = x;
    }

    public int getNumAri() {
        return numAri;
    }

    public void setNumAri(int x) {
        this.numAri = x;
    }
}
*/