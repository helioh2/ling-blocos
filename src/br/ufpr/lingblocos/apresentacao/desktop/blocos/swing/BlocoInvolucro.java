/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import br.ufpr.lingblocos.util.WrapLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Helio
 */
public class BlocoInvolucro implements BlocoArrastavel<JPanel> {

    protected JPanel involucro;  //componente principal
    protected List<BlocoArrastavel> blocos;
    protected BlocoArrastavel pai = null;
    private TelaBlocos tela;

    public BlocoInvolucro(TelaBlocos tela) {

        involucro = new JPanel(null);
        //involucro.setOpaque(false);
        involucro.setBackground(Color.GRAY);
        blocos = new ArrayList<>();
        setMouseAdapter(new ArrastavelGrudavelAdapter(this,tela));

    }

    public BlocoInvolucro(TelaBlocos tela, BlocoArrastavel bloco) {
        this(tela);
        involucro.setBounds(bloco.getBloco().getX(),
                bloco.getBloco().getY(),
                bloco.getWidth(), 
                            bloco.getHeight()+5);
        blocos.add(bloco);
        involucro.add(bloco.getBloco());
        bloco.setPai(this);
        bloco.getBloco().setBounds(5, 5,
                bloco.getWidth(), bloco.getHeight());
        
        System.out.println(bloco+" "+bloco.getHeight());
        
    }
    
    

    @Override
    public int getWidth() {
        return involucro.getWidth();
    }

    @Override
    public int getHeight() {
        return involucro.getHeight();
    }

    @Override
    public JPanel getBloco() {
        return involucro;
    }

    @Override
    public final void setMouseAdapter(ArrastavelAdapter adapter) {
        involucro.addMouseListener(adapter);
        involucro.addMouseMotionListener(adapter);
    }
    
    public void addBloco(BlocoArrastavel bloco) {
        int alturaAnterior = involucro.getHeight();
        involucro.setSize(involucro.getWidth(), 
                            involucro.getHeight()+bloco.getBloco().getHeight());
        blocos.add(bloco);
        involucro.add(bloco.getBloco());
        bloco.setPai(this);
        bloco.getBloco().setBounds(5, alturaAnterior, 
                bloco.getBloco().getWidth(), 
                bloco.getBloco().getHeight());
        System.out.println(blocos.get(0)+" "+blocos.get(0).getHeight());
        System.out.println(bloco+" "+bloco.getHeight());
    }

    @Override
    public Iterator<BlocoArrastavel> iterator() {
        return blocos.iterator();
    }

    @Override
    public BlocoArrastavel getPai() {
        return pai;
    }

    @Override
    public void setPai(BlocoArrastavel pai) {
        this.pai = pai;
    }

    public void remove(BlocoArrastavel bloco) {
        blocos.remove(bloco);
        bloco.setPai(null);
        involucro.remove(bloco.getBloco());
        bloco.getBloco().setBounds(getBloco().getX()+bloco.getBloco().getX(), 
                    getBloco().getY()+bloco.getBloco().getY(), 
                    bloco.getBloco().getWidth(), bloco.getBloco().getHeight());
        
        
    }

    public List<BlocoArrastavel> getBlocos() {
        return blocos;
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height) {
        involucro.setBounds(x, y, width, height);
    }
    

}
