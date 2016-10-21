/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicapalco;

/**
 *
 * @author Lenovo
 */
public abstract class Ator {
    private int x;
    private int y;

    public Ator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract void desenhar();
    
}
