/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;


import br.ufpr.lingblocos.apresentacao.desktop.blocos.generic.IBlocoArrastavel;
import br.ufpr.lingblocos.util.WrapLayout;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;import java.util.Arrays;

import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Helio
 */
public interface BlocoArrastavel<T extends JComponent> 
        extends Iterable<BlocoArrastavel> {
  
    void setMouseAdapter(ArrastavelAdapter adapter);

    int getWidth();

    int getHeight();

    T getBloco();
    
    BlocoArrastavel getPai();
    
    void setPai(BlocoArrastavel pai);

    public void setBounds(int x, int y, int width, int height);

    

}
    

