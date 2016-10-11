/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

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
 *
 * @author Helio
 */
public class BlocoSimples implements BlocoArrastavel<JButton> {
    
    private List<JTextField> campos;
    private JButton bloco;
    private BlocoArrastavel pai = null;

    public BlocoSimples(String label, Color cor) {
        super();
        
        campos = new ArrayList<>();
        bloco = new JButton();
      
        bloco.setBorder(new LineBorder(cor, 3));
        bloco.setBounds(0, 0, 100, 40);
        bloco.setOpaque(true);
        bloco.setText(label);
        bloco.setVerticalAlignment(SwingConstants.TOP);
        
        setMouseAdapter(new ArrastavelAdapter(bloco));
     
    }
    
    
     protected final void addCampo(String label, String defaultValue){
        JTextField campo = new JTextField(defaultValue);
        campo.setName(label);
        campos.add(campo);
        bloco.add(campo);
        campo.setBounds(70+campos.indexOf(campo)*22, 10, 20, 20);
    }
     
    @Override
    public final void setMouseAdapter(ArrastavelAdapter adapter) {
        bloco.addMouseListener(adapter);
        bloco.addMouseMotionListener(adapter);
    }

    @Override
    public int getWidth() {
        return bloco.getWidth();
    }

    @Override
    public int getHeight() {
        return bloco.getWidth();

    }

    @Override
    public JButton getBloco() {
        return bloco;
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
                return BlocoSimples.this;
            }
        };
        
              
    }
    
    @Override
    public BlocoArrastavel getPai() {
        return pai;
    }

    @Override
    public void setPai(BlocoArrastavel pai) {
        this.pai = pai;
    }
    
}
