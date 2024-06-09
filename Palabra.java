/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Samuel, Dayleen y Ana
 */

public class Palabra {
    protected String Valor;
    protected Palabra nxt;

    public Palabra(String valor) {
        this.Valor = valor;
        this.nxt = null;
    }

    public String getValor() {
        return Valor;
    }

    public Palabra getNxt() {
        return nxt;
    }


    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public void setNxt(Palabra nxt) {
       
        this.nxt = nxt;
    }
 
}

