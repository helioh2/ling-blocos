/*
 * To change oBloco license header, choose License Headers in Project Properties.
 * To change oBloco template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import br.ufpr.lingblocos.logicablocos.Bloco;
import br.ufpr.lingblocos.util.DoubleTransformer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.TOP;
import javax.swing.border.LineBorder;

/**
 *
 * @author Helio
 */
public class BlocoMova extends BlocoSimples implements BlocoComCampos{

    private Campos campos = new Campos(this);

    public BlocoMova(TelaBlocos tela, Bloco blocoLogica) {
        super(tela,"Mova", Color.BLUE, blocoLogica );
        
        addCampos();
        
    }
    
     @Override
    public void addCampos() {
        BlocoCaixaTexto<Double> caixa = new BlocoCaixaTexto("passos", "0", new DoubleTransformer());      
        campos.addOriginal(caixa);
        caixa.setBounds(70, 10, 20, 20);

    }

    @Override
    public void removeCampo(Encaixavel campo) {
        campos.removeCampo(campo);
    }

    @Override
    public void trocaCampo(Encaixavel antigo, Encaixavel novo) {
        campos.trocaCampo(antigo, novo);
        
    }
    
     @Override
    public Iterator<Encaixavel> getCampos() {
        return campos.getCampos();
    }
    
    
}
