/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;


import br.ufpr.lingblocos.apresentacao.desktop.blocos.generic.IBlocoArrastavel;
import br.ufpr.lingblocos.util.WrapLayout;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Rectangle;
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

    default int getWidth(){
        return getBloco().getWidth();
    }

    default int getHeight(){
        return getBloco().getHeight();
    }

    T getBloco();
    
    BlocoArrastavel getPai();
    
    void setPai(BlocoArrastavel pai);

    default Rectangle getBounds(){
        return getBloco().getBounds();
    }
    default void setBounds(Rectangle bounds){
        getBloco().setBounds(bounds);
    }
    default Point getLocationTela(){
        if (getPai() == null){
            return getBloco().getLocation();
        } else {
            Point locationPai = getPai().getLocationTela();
            return new Point(
                    (int)getBloco().getLocation().getX() + (int)locationPai.getX(),
                    (int)getBloco().getLocation().getY() + (int)locationPai.getY());
        }
    }
    
    default void ajustaWidth(int width) {
        getBloco().setSize(width, getBloco().getHeight());
        if (getPai()!=null){
            getPai().ajustaWidth(width);
        }
    }
    
    default boolean saindo(){
        return getPai() != null
                && (getBloco().getY() > getPai().getBloco().getHeight()
                    || getBloco().getY() < 0
                    || getBloco().getX() > getPai().getBloco().getWidth()
                    || getBloco().getX() < 0);
    }
    

}
    

