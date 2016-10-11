/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.blocos.swing.ArrastavelAdapter;
import br.ufpr.lingblocos.apresentacao.desktop.blocos.swing.BlocoArrastavel;
import br.ufpr.lingblocos.apresentacao.desktop.blocos.swing.BlocoInvolucro;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterBlocos;
import br.ufpr.lingblocos.apresentacao.desktop.principal.JanelaPrincipal;
import br.ufpr.lingblocos.apresentacao.desktop.telablocos.generic.ITelaBlocos;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import br.ufpr.lingblocos.util.Observer;
import br.ufpr.lingblocos.util.WrapLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;

/**
 *
 * @author Helio
 */
public class TelaBlocos implements Observer<MouseAdapterBlocos>{

    private JPanel tela;
    private List<BlocoArrastavel> blocos = new ArrayList<>();
    private JanelaPrincipal pai;
    private MouseAdapter mouseAdapter;

    public TelaBlocos(int largura, int altura) {
        tela = new JPanel();
        tela.setSize(largura, altura);
        tela.setLayout(null);
        tela.setBackground(SystemColor.text);
        tela.setBounds(0, 0, tela.getWidth(),
                tela.getHeight());

    }

    public void addBloco(BlocoArrastavel bloco, int x, int y) {
        BlocoComponentListener mouseListener = new BlocoComponentListener(bloco);
        bloco.getBloco().addMouseMotionListener(mouseListener);
        bloco.getBloco().addMouseListener(mouseListener);
        blocos.add(bloco);
        tela.add(bloco.getBloco());
        bloco.getBloco().setLocation(x, y);
    }

    @Override
    public void update(MouseAdapterBlocos m) {
        setMouseAdapter(m);
    }

    public JPanel getTela() {
        return tela;
    }

    public void setLocation(int x, int y) {
        tela.setLocation(x, y);
    }

    public void setPai(JanelaPrincipal pai) {
        this.pai = pai;
    }

    public void setMouseAdapter(MouseAdapter mouseAdapter) {
        tela.removeMouseListener(this.mouseAdapter);
        this.mouseAdapter = mouseAdapter;
        tela.addMouseListener(this.mouseAdapter);
    }
    
    
    /**
     * Classe que implementa o listener par os blocos que permite que eles
     * "grudem" um no outro
     */
    private class BlocoComponentListener extends ArrastavelAdapter {
        
        private BlocoArrastavel bloco;
        private static final int DELAY = 2; 
        
        public BlocoComponentListener(BlocoArrastavel bloco) {
            super(bloco.getBloco());
            this.bloco = bloco;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseDragged(e);
            for (BlocoArrastavel p: blocos){
                if (p.getBloco() == bloco.getBloco() || bloco.getPai() != null ||
                        p.getPai() != null
                        || p == bloco.getPai()) {
                    continue;
                }                
                if (sobrepondo(bloco.getBloco(), p.getBloco())) {   
                    if (! (p instanceof BlocoInvolucro) ){
                        int index = blocos.indexOf(p);
                        tela.remove(p.getBloco());
                        p = new BlocoInvolucro(p);
                        blocos.set(index, p);
                        tela.add(p.getBloco());
                    }
                    trocaPainel(bloco, (BlocoInvolucro) p); 
                }
            }
            
            if (bloco.getPai()!=null && 
                    bloco.getBloco().getY() > 
                    bloco.getPai().getBloco().getHeight()){
                removerDoPainel(bloco, (BlocoInvolucro) bloco.getPai());
            }
            //            JPanel pAntes = (JPanel) bloco.getBloco().getParent();
//            if (saindo(bloco.getBloco(), pAntes)) {                      
//                
//
//            }
        }

        private void removerDoPainel(BlocoArrastavel bloco, BlocoInvolucro pai) {           
            pai.remove(bloco);
            tela.add(bloco.getBloco());
    
            if (!pai.iterator().hasNext()){
                tela.remove(pai.getBloco());
            } else {            
                pai.getBloco().setBounds(pai.getBloco().getX(),
                                    pai.getBloco().getY(),
                                    pai.getBloco().getWidth(),
                                    pai.getBloco().getHeight() - bloco.getHeight());
            }
            
            

        }

        private boolean sobrepondo(Component c1, Component c2) {
//            return (distancia(c1.getX() + c1.getWidth() / 2, c1.getY() + c1.getHeight() / 2,
//                    c2.getX() + c2.getWidth() / 2, c2.getY() + c2.getHeight() / 2)
//                    < c1.getHeight() / 2 + c2.getHeight() / 2);
              
            int baixoC1 = c1.getY() + c1.getHeight();
            int cimaC1 = c1.getY();
            int direitaC1 = c1.getX() + c1.getWidth();
            int esquerdaC1 = c1.getX();
            int baixoC2 = c2.getY() + c2.getHeight();
            int cimaC2 = c2.getY();
            int direitaC2 = c2.getX() + c2.getWidth();
            int esquerdaC2 = c2.getX();

              boolean colisaoBaixo = baixoC1 >= cimaC2;
              boolean colisaoCima = cimaC1 <= baixoC2;
              boolean colisaoDireita = direitaC1 >= esquerdaC2;
              boolean colisaoEsquerda = esquerdaC1 <= direitaC2;
              return colisaoBaixo && colisaoCima && colisaoDireita && colisaoEsquerda;
        }

        private void trocaPainel(BlocoArrastavel bloco, BlocoInvolucro painel) {
            Iterator<BlocoArrastavel> it = bloco.iterator();
            tela.remove(bloco.getBloco());
            while (it.hasNext()){
                painel.addBloco(it.next());
            }
        }
 
    }


}
