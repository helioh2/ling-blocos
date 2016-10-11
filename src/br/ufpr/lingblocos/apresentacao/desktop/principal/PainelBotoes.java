/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import br.ufpr.lingblocos.util.WrapLayout;

/**
 *
 * @author Helio
 */
public abstract class PainelBotoes extends JPanel implements ActionListener {
    
    protected List<JButton> botoes;
    protected JanelaPrincipal pai;

    public PainelBotoes(JanelaPrincipal pai) {
        this.pai = pai;        
        this.setLayout(new WrapLayout(WrapLayout.CENTER));        
        this.botoes = new ArrayList<>();
        
    }
    
    public final void addBotao(String label, String opcao){
        JButton botao = new JButton(label);
        botao.setActionCommand(opcao);

        botoes.add(botao);
        botao.addActionListener(this);
        add(botao);
        
    }


    @Override
    public abstract void actionPerformed(ActionEvent e);

 
    
    
    
    
}
