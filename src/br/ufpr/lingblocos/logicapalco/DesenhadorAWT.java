/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicapalco;

import br.ufpr.lingblocos.apresentacao.desktop.teladesenho.TelaDesenho;


public class DesenhadorAWT implements Desenhador{

    TelaDesenho telaDesenho;
        
    @Override
    public void desenhaElipse(int x, int y, int largura, int altura) {
        telaDesenho.desenhaElipse(x, y, largura, altura);
    }

    @Override
    public void desenhaEstrela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desenhaImagem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desenhaLinhaLivre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desenhaLinhaReta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desenhaPoligono() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desenhaRetangulo() {
        
    }

    @Override
    public void desenhaTriangulo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
