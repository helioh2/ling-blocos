/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.logicablocos.Bloco;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 *
 * @author helio
 */
interface Encaixavel<T extends JComponent,V> {
    V getValor();
    default Rectangle getBounds(){
        return getBloco().getBounds();
    }
    default void setBounds(Rectangle bounds){
        getBloco().setBounds(bounds);
    }

    void setPai(BlocoArrastavel pai);
    BlocoArrastavel getPai();
    
    T getBloco();
    
    String getName();
    
    
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

    Bloco getBlocoLogica();
}
