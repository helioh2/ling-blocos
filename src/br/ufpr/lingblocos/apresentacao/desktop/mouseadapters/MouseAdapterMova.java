/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.mouseadapters;

import br.ufpr.lingblocos.apresentacao.desktop.blocos.swing.BlocoMova;
import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import java.awt.event.MouseEvent;

/**
 *
 * @author Helio
 */
public class MouseAdapterMova extends MouseAdapterBlocos {

    public MouseAdapterMova(TelaBlocos telaBlocos) {
        super(telaBlocos);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tela.addBloco(new BlocoMova(), e.getX(), e.getY());
    }
    
}
