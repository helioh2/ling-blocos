/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import br.ufpr.lingblocos.logicablocos.Bloco;
import br.ufpr.lingblocos.logicablocos.BlocoComposto;
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
    private int maiorWidth;
    protected Bloco blocoLogica;

    
    public BlocoInvolucro(TelaBlocos tela, Bloco blocoLogica) {

        involucro = new JPanel(null){
            @Override
            public boolean isOptimizedDrawingEnabled() {
                return false;
            }
            
            
        };
        //involucro.setOpaque(false);
        involucro.setBackground(Color.darkGray);
        blocos = new ArrayList<>();
        setMouseAdapter(new ArrastavelGrudavelAdapter(this,tela));
        this.blocoLogica = blocoLogica;
    }
    
    @Override
    public Bloco getBlocoLogica() {
        return blocoLogica;
    }
    
    public BlocoInvolucro(TelaBlocos tela, BlocoArrastavel bloco, BlocoComposto blocoLogica) {
        this(tela, blocoLogica);
        involucro.setBounds(bloco.getBloco().getX(),
                bloco.getBloco().getY(),
                bloco.getWidth(), 
                            bloco.getHeight()+5);
        blocos.add(bloco);
        involucro.add(bloco.getBloco());
        bloco.setPai(this);
        bloco.getBloco().setBounds(5, 5,
                bloco.getWidth(), bloco.getHeight());
        maiorWidth = bloco.getWidth();
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
        atualizaMaiorWidth(bloco.getWidth());
        involucro.setSize(maiorWidth, 
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
        if(blocos.indexOf(bloco) != blocos.size() - 1){
            for (int i = blocos.indexOf(bloco); i<blocos.size(); i++){
                blocos.get(i).getBloco().setLocation(
                        blocos.get(i).getBloco().getX(), 
                        blocos.get(i).getBloco().getY() - bloco.getHeight());
            }
        }
        
        
        
        blocos.remove(bloco);
        bloco.getBloco().setLocation(bloco.getLocationTela());
        bloco.setPai(null);
        involucro.remove(bloco.getBloco());
        
        ajustaWidth(bloco.getWidth());
        
        involucro.setSize(
                    maiorWidth,
                    involucro.getHeight() - bloco.getHeight());
        
        
        
        
    }

    public List<BlocoArrastavel> getBlocos() {
        return blocos;
    }

    private void atualizaMaiorWidth(int width) {
        maiorWidth = width > maiorWidth ? width : maiorWidth;
    }
    
    @Override
    public void ajustaWidth(int width){
        if (width <= maiorWidth) {
            maiorWidth = 0;
            for (BlocoArrastavel b: blocos){
                atualizaMaiorWidth(b.getWidth());
            }
        } else {
            atualizaMaiorWidth(width);
        }
        involucro.setSize(
                    maiorWidth,
                    involucro.getHeight());
    }
 

}
