/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Bloco que encaixa dentro de outro. Geralmente serve para retornar um valor do tipo T.
 * Ex: bloco ">" que retorna boolean, bloco '+' que retorna numero
 * @author helio
 */
public abstract class BlocoEncaixavel<T> implements BlocoArrastavel<JButton>,Encaixavel<JButton,T>{
    
    
    private JButton bloco;
    private BlocoArrastavel pai = null;
    private TelaBlocos tela;
    
    public BlocoEncaixavel(TelaBlocos tela, String label, Color cor) {
        
        this.tela = tela;
        bloco = new JButton();
      
        bloco.setBorder(new LineBorder(cor, 3));
        bloco.setBounds(0, 0, 100, 30);
        bloco.setOpaque(true);
        bloco.setText(label);
        bloco.setVerticalAlignment(SwingConstants.TOP);
        bloco.setHorizontalAlignment(SwingConstants.CENTER);
        
        setMouseAdapter(new ArrastavelEncaixavelAdapter(this,tela));
        
    }

  
    @Override
    public final void setMouseAdapter(ArrastavelAdapter adapter) {
        bloco.addMouseListener(adapter);
        bloco.addMouseMotionListener(adapter);
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
                return BlocoEncaixavel.this;
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

    @Override
    public Point getLocationTela() {
        return Encaixavel.super.getLocationTela(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rectangle getBounds() {
        return Encaixavel.super.getBounds(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBounds(Rectangle bounds) {
        Encaixavel.super.setBounds(bounds); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
   
    
  
    
    
    
    
    
    
}
