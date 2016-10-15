/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 *
 * @author helio
 */
interface Encaixavel<T extends JComponent,V> {
    V getValor();
    Rectangle getBounds();
    void setBounds(Rectangle bounds);

    void setPai(BlocoArrastavel pai);
    BlocoArrastavel getPai();
    
    T getBloco();
}
