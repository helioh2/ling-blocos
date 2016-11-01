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
public class Retangulo extends Ator {
    private int largura;
    private int altura;
    public Retangulo(int x, int y, int largura, int altura) {
        super(x, y);
        this.largura=largura;
        this.altura=altura;
    }

    @Override
    public void desenhar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
