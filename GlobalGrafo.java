/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ani
 */
public class GlobalGrafo {
    private static GrafoSopa grafo = new GrafoSopa(16);
    
    public static GrafoSopa getGrafo(){
        return grafo;
        
    }
    
    public static void setGrafo(GrafoSopa aGrafo){
        grafo = aGrafo;
    }
}
