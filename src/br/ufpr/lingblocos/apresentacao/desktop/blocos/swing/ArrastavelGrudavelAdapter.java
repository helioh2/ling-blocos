/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;

/**
 * Para permitir que blocos "grudem" quando movidos um sobre o outro.
 * @author helio
 */
public class ArrastavelGrudavelAdapter extends ArrastavelAdapter {

    private BlocoArrastavel bloco;
    private List<BlocoArrastavel> blocos;
    private TelaBlocos tela;

    public ArrastavelGrudavelAdapter(BlocoArrastavel bloco, TelaBlocos tela) {
        super(bloco.getBloco());
        this.bloco = bloco;
        this.tela = tela;
        this.blocos = tela.getBlocos();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseDragged(e);
        for (BlocoArrastavel p : blocos) {
            if (p.getBloco() == bloco.getBloco() 
                    || bloco.getPai() != null  //isto impede, por segurança, que blocos dentro de um nível possam ser adicionados a outros. Deveria ser encontrada uma maneira para que isto não desse problema.
                    || p.getPai() != null
                    || p == bloco.getPai()) {
                continue;
            }
            if (sobrepondo(bloco.getBloco(), p.getBloco())) {
                if (!(p instanceof BlocoInvolucro)) {
                    p = tela.embrulha(p);
                }
                trocaPainel(bloco, (BlocoInvolucro) p);
                break;
            }
        }

        if (bloco.saindo()) {
            removerDoPainel(bloco, (BlocoInvolucro) bloco.getPai());           
        }
        //tela.getTela().repaint();

    }


    private void removerDoPainel(BlocoArrastavel bloco, BlocoInvolucro pai) {
        pai.remove(bloco);
        tela.getTela().add(bloco.getBloco());
        
        if (pai.getBlocos().size() == 1) {
            //tela.getTela().remove(pai.getBloco());
            tela.desembrulha(pai);
        } 

    }

    private boolean sobrepondo(Component c1, Component c2) {

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
        tela.getTela().remove(bloco.getBloco());
        blocos.remove(bloco);
        while (it.hasNext()) {
            painel.addBloco(it.next());
        }
    }

}
