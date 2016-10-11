/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.telablocos.generic;

import br.ufpr.lingblocos.apresentacao.desktop.blocos.generic.IBlocoArrastavel;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterBlocos;
import br.ufpr.lingblocos.apresentacao.desktop.principal.JanelaPrincipal;
import java.awt.event.MouseAdapter;
import br.ufpr.lingblocos.util.Observer;
import javax.swing.JComponent;

/**
 *
 * @author Helio
 * @param <T>
 */
public interface ITelaBlocos<T extends IBlocoArrastavel> extends Observer<MouseAdapterBlocos> {
    

    void addBloco(T bloco, int x, int y);

    void setPai(JanelaPrincipal pai);

    void setMouseAdapter(MouseAdapter mouseAdapter);

    void setLocation(int x, int y);
    
    JComponent getTela();
    
    

    
    
    
}
