/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.mouseadapters;

import br.ufpr.lingblocos.apresentacao.desktop.blocos.swing.BlocoMova;
import br.ufpr.lingblocos.apresentacao.desktop.blocos.swing.BlocoSoma;
import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import br.ufpr.lingblocos.logicablocos.Bloco;
import java.awt.event.MouseEvent;

/**
 *
 * @author Helio
 */
public class MouseAdapterSoma extends MouseAdapterBlocos {

    public MouseAdapterSoma(TelaBlocos telaBlocos) {
        super(telaBlocos);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Bloco blocoLogico = new br.ufpr.lingblocos.logicablocos.BlocoSoma();
        getPainel().inserirBloco(blocoLogico);
      
        
        tela.addBloco(new BlocoSoma(tela, blocoLogico) , e.getX(), e.getY());
    }
    
}
