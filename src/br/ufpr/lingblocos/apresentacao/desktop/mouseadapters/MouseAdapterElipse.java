/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.mouseadapters;

import br.ufpr.lingblocos.apresentacao.desktop.teladesenho.TelaDesenho;
import br.ufpr.lingblocos.logicapalco.Elipse;
import br.ufpr.lingblocos.logicapalco.Palco;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Helio
 */
public class MouseAdapterElipse extends MouseAdapterFigura {

    public MouseAdapterElipse(TelaDesenho telaDesenho, Palco palco) {
        super(telaDesenho, palco);
    }

 
    @Override
    public void mouseReleased(MouseEvent e) {
        if (pressed) {
            pressed = false;          
            //AQUI É ONDE VOCÊS DEVEM FAZER A LÓGICA SER CHAMADA,
            //ANTES DE DESENHAR NA TELA
            palco.inserirAtor(new Elipse(x, y, e.getX() - x, e.getY() - y));
            //tela.desenhaElipse(x, y, e.getX() - x, e.getY() - y);
        }}
    
}
