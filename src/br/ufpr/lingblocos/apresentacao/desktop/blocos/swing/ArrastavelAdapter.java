/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;

/**
 * Implementação básica de listener de mouse para blocos drag&drop
 * @author Helio
 */
public class ArrastavelAdapter implements MouseListener, MouseMotionListener {

    protected int screenX = 0;
    protected int screenY = 0;
    protected int myX = 0;
    protected int myY = 0;

    private JComponent pai;

    public ArrastavelAdapter(JComponent pai) {
        this.pai = pai;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        screenX = e.getXOnScreen();
        screenY = e.getYOnScreen();

        myX = pai.getX();
        myY = pai.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
        public void mouseDragged(MouseEvent e) {
        int deltaX = e.getXOnScreen() - screenX;
        int deltaY = e.getYOnScreen() - screenY;

        pai.setLocation(myX + deltaX, myY + deltaY);
        
      }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}

  
