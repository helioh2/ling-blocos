/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Bloco que agrupa outros blocos para um intuito definido.
 * Ex: repita, se, ...
 * @author Helio
 */
public abstract class BlocoEnvolvedor extends BlocoInvolucro {
    
    
    protected JButton cabecalho;

    public BlocoEnvolvedor(TelaBlocos tela, String label, Color cor) {
        super(tela);
                
        cabecalho = new JButton(label);
        //campos = new ArrayList<>();
      
        cabecalho.setBorder(new LineBorder(cor, 3));
        cabecalho.setBounds(0, 0, 100, 40);
        cabecalho.setOpaque(true);
        cabecalho.setText(label);
        cabecalho.setVerticalAlignment(SwingConstants.TOP);
        
        setupInvolucro(cabecalho);
    
    }
    
    private void setupInvolucro(JButton bloco){
        involucro.setSize(bloco.getWidth() + 5, bloco.getHeight() + 15);       
        involucro.add(cabecalho);
    }

    
    @Override
    public Iterator<BlocoArrastavel> iterator() {
        return new Iterator<BlocoArrastavel>() {
            boolean hasNext = true;
            
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public BlocoArrastavel next() {
                hasNext = false;
                return BlocoEnvolvedor.this;
            }
        };
    
    }
}
