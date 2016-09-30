/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.mouseadapters;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.TelaBlocos;
import br.ufpr.lingblocos.apresentacao.desktop.teladesenho.TelaDesenho;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Helio
 */
public abstract class MouseAdapterBlocos extends MouseAdapter {
    
    protected TelaBlocos tela;

    public MouseAdapterBlocos(TelaBlocos telaBlocos) {
        this.tela = telaBlocos;
    }

    @Override
    public abstract void mouseClicked(MouseEvent e);
    
    
    
}
