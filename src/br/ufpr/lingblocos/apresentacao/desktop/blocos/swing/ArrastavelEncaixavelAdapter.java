/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import java.awt.Component;
import java.awt.Point;
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

    private BlocoArrastavel bloco;
    private List<BlocoArrastavel> blocos;
    private TelaBlocos tela;

    public ArrastavelEncaixavelAdapter(BlocoArrastavel bloco, TelaBlocos tela) {
        super(bloco.getBloco());
        this.bloco = bloco;
        this.tela = tela;
        this.blocos = tela.getBlocos();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        super.mouseDragged(e);
        
        if (bloco.saindo()){
            BlocoComCampos pai = (BlocoComCampos) bloco.getPai();
            pai.removeCampo((Encaixavel) bloco);
            tela.getTela().add(bloco.getBloco());            
        }
        
        outerloop:
        for (BlocoArrastavel p : blocos) {
            if (p == bloco) continue;
            if (processaBloco(p)) break;
            if (p instanceof BlocoInvolucro){
                BlocoInvolucro inv = (BlocoInvolucro) p;
                for (BlocoArrastavel b : inv.getBlocos()){
                    if (processaBloco(b)) break outerloop;
                }
            }
        }
        
        //tela.getTela().repaint();
    }

    private boolean processaBloco(BlocoArrastavel p){
        if (p instanceof BlocoComCampos){
            BlocoComCampos b = (BlocoComCampos) p;

            Iterator<Encaixavel> it = b.getCamposIterator();
            while (it.hasNext()){      
                Encaixavel atual = it.next();
                if (sobrepondo(bloco,atual)){
                    b.trocaCampo(atual, (Encaixavel) bloco);
                    tela.getTela().remove(bloco.getBloco());
                    return true;
                }
            }    
                
            }
        return false;
    }
    
    private boolean sobrepondo(int c1x, int c1y, int c2x, int c2y,
            int c1Width, int c1Height, int c2Width, int c2Height){
        
        double baixoC1 = c1y + c1Height;
        double cimaC1 = c1y;
        double direitaC1 = c1x + c1Width;
        double esquerdaC1 = c1x;
        double baixoC2 = c2y + c2Height;
        double cimaC2 = c2y;
        double direitaC2 = c2x + c2Width;
        double esquerdaC2 = c2x;

        boolean colisaoBaixo = baixoC1 >= cimaC2;
        boolean colisaoCima = cimaC1 <= baixoC2;
        boolean colisaoDireita = direitaC1 >= esquerdaC2;
        boolean colisaoEsquerda = esquerdaC1 <= direitaC2;
        return colisaoBaixo && colisaoCima && colisaoDireita && colisaoEsquerda;
    }
    
    private boolean sobrepondo(BlocoArrastavel bloco, Encaixavel next) {
        
        Rectangle c1 = bloco.getBounds();
        Rectangle c2 = next.getBounds();
        Point pc1 = bloco.getLocationTela();
        Point pc2 = next.getLocationTela();
        //int c2x = (int) c2.getX()+next.getPai().getBloco().getX();
        //int c2y = (int) c2.getY()+next.getPai().getBloco().getY();
        
        return sobrepondo((int)pc1.getX(),(int)pc1.getY(), (int)pc2.getX(), (int)pc2.getY(),
                (int)c1.getWidth(),(int)c1.getHeight(),(int)c2.getWidth(),(int)c2.getHeight());
        
    }



    }

  

  

   
    
    

