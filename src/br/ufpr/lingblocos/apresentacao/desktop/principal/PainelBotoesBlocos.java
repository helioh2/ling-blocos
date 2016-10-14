
package br.ufpr.lingblocos.apresentacao.desktop.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


class PainelBotoesBlocos extends PainelBotoes {
    
    
    public PainelBotoesBlocos(JanelaPrincipal pai) {
        super(pai);
        this.setSize(70, 500);
        addBotao("Mova", OpcaoBloco.MOVA.toString());
        addBotao("Gire", OpcaoBloco.GIRE.toString());
        addBotao("Repita", OpcaoBloco.REPITA.toString());
        addBotao("Espere", OpcaoBloco.ESPERE.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        pai.setOpcaoBlocoAtual(OpcaoBloco.valueOf(e.getActionCommand()));
         
    }

  



}