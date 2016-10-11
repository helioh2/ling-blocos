/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.mouseadapters;

import br.ufpr.lingblocos.apresentacao.desktop.teladesenho.TelaDesenho;
import java.awt.event.MouseEvent;

/**
 * Apenas um exemplo de listener de mouse.
 * @author Helio
 */
public class MouseAdapterRetangulo extends MouseAdapterFigura {

    public MouseAdapterRetangulo(TelaDesenho telaDesenho) {
        super(telaDesenho);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (pressed) {
            pressed = false;
            //AQUI É ONDE VOCÊS DEVEM FAZER A LÓGICA SER CHAMADA,
            //ANTES DE DESENHAR NA TELA
            tela.desenhaRetangulo(x, y, e.getX() - x, e.getY() - y);
        }
    }
    

    
    

}
