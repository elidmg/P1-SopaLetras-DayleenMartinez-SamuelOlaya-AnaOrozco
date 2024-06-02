/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoo;

/**
 *
 * @author ani
 */
public class GrafoSopa {
    int numLetras;
    int maxLetras;
    Letra [] letras;
    int [][] matAd;
    
    
    public GrafoSopa(){
        this.maxLetras = 16;
    } 
    
    //añadir letra
    public void nuevaLetra(String letra){
        boolean esta = numLetra(letra)>=0;
        if (!esta){
            Letra v= new Letra(letra);
            v.asigLetra(numLetras);
            letras[numLetras++]=v;
        }
        
    } 
    //busca el vertice en el array, si no lo encuentra retorna false, y si la encontra true
    public int numLetra(String vs){
        Letra v= new Letra(vs);
        boolean encontrado=false;
        int i = 0;
        for(;(i<numLetras)&& !encontrado;)
        {
            encontrado = letras[i].equals(v);
            if (!encontrado) i++;
          
        }
        return (i<numLetras)? i: -1;
               
    }
    
    /** Arconuevo
     * @param a
     * @param b 
     * @throws java.lang.Exception 
     * @param: String a, String b 
     * 
     */
    /*
    public void nuevoArco(String a,String b)throws Exception{
        int va,vb;
        va = numLetra(a);
        vb = numLetra(b);
        if (va<0 ||vb<0) throw new Exception ("La letra no existe");
        matAd [va][vb]=1;
        
        
    }
    */
    /**Arconuevo
     * 
     * @param va
     * @param vb
     * @throws Exception 
     */
    public void nuevoArco(int va,int vb)throws Exception{
        if (va<0||vb<0) throw new Exception("La letra no existe");
        matAd[va][vb]=1;
       
    }
    /** @return true Determina si dos letras forman un arco, es decir si el elemento de la matriz es 1 
     * 
     * @param a
     * @param b
     * @throws Exception 
     */
    public boolean adyacente(String a, String b)throws Exception{
        int va,vb;
        va = numLetra(a);
        vb = numLetra(b);
        if (va<0||vb<0)throw new Exception("La letra no existe");
        return matAd[va][vb] ==1;
        
    }
    public boolean adyacene(int va,int vb)throws Exception{
        if (va<0||vb<0) throw new Exception ("Vertice no existe");
        return matAd[va][vb]==1;
        
    }
            
    
    
    
    
    
    
    
    
     
    
    
        
   
    
   
    
}







