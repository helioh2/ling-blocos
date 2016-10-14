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
        for (BlocoArrastavel p : blocos) {
            if (p instanceof BlocoComCampos){
                BlocoComCampos b = (BlocoComCampos) p;
                
                Iterator<Encaixavel> it = b.getCampos();
                while (it.hasNext()){                    
                    if (sobrepondo(bloco,it.next())){
                        b.trocaCampo(it.next(), bloco);
                        
                    }
                }    
                
            }
        }
        
    }

    private boolean sobrepondo(Encaixavel bloco, Encaixavel next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

   
    
    
}
