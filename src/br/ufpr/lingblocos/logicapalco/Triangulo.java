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
public class Triangulo extends Ator {
    
    private Desenhador desenhador;

    public Triangulo(int x, int y) {
        super(x, y);
    }

    @Override
    public void desenhar() {
        desenhador.desenhaTriangulo();
    }

    @Override
    public void dentro(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
