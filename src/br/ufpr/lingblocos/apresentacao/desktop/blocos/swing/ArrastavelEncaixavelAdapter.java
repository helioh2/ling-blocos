/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;

/**
 * Para permitir que blocos "grudem" quando movidos um sobre o outro.
 * @author helio
 */
public class ArrastavelEncaixavelAdapter extends ArrastavelAdapter {

    private Encaixavel bloco;
    private List<BlocoArrastavel> blocos;
    private TelaBlocos tela;

    public ArrastavelEncaixavelAdapter(BlocoArrastavel bloco, TelaBlocos tela) {
        super(bloco.getBloco());
        this.bloco = (Encaixavel) bloco;
        this.tela = tela;
        this.blocos = tela.getBlocos();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        super.mouseDragged(e);
        outerloop:
        for (BlocoArrastavel p : blocos) {
            if (p instanceof BlocoComCampos){
                BlocoComCampos b = (BlocoComCampos) p;
                
                Iterator<Encaixavel> it = b.getCampos();
                while (it.hasNext()){      
                    Encaixavel atual = it.next();
                    if (sobrepondo(bloco,atual)){
                        b.trocaCampo(atual, bloco);
                        tela.getTela().remove(((BlocoArrastavel) bloco).getBloco());
                        aumenta((BlocoArrastavel) b, bloco);
                        break outerloop;
                    }
                }    
                
            }
        }
        if (saindo(bloco)){
            BlocoComCampos pai = (BlocoComCampos) bloco.getPai();
            pai.removeCampo(bloco);
            bloco.getBloco().setLocation(e.getX(), e.getY());
        }
    }

    private boolean sobrepondo(Encaixavel bloco, Encaixavel next) {
        
        Rectangle c1 = bloco.getBounds();
        Rectangle c2 = next.getBounds();
        int c2x = (int) c2.getX()+next.getPai().getBloco().getX();
        int c2y = (int) c2.getY()+next.getPai().getBloco().getY();
        
        double baixoC1 = c1.getY() + c1.getHeight();
        double cimaC1 = c1.getY();
        double direitaC1 = c1.getX() + c1.getWidth();
        double esquerdaC1 = c1.getX();
        double baixoC2 = c2y + c2.getHeight();
        double cimaC2 = c2y;
        double direitaC2 = c2x + c2.getWidth();
        double esquerdaC2 = c2x;

        boolean colisaoBaixo = baixoC1 >= cimaC2;
        boolean colisaoCima = cimaC1 <= baixoC2;
        boolean colisaoDireita = direitaC1 >= esquerdaC2;
        boolean colisaoEsquerda = esquerdaC1 <= direitaC2;
        return colisaoBaixo && colisaoCima && colisaoDireita && colisaoEsquerda;
    
    }

    private void aumenta(BlocoArrastavel ba, Encaixavel be) {
        ba.getBloco().setSize((int) ((int) ba.getWidth()+be.getBounds().getWidth()),
                ba.getHeight());

    }

    private boolean saindo(Encaixavel bloco) {
        return bloco.getPai() != null
                && bloco.getBloco().getY() > bloco.getPai().getBloco().getHeight();
    }

    }

  

  

   
    
    

