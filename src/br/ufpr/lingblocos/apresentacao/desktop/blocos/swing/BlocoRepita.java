/*
 * To change oBloco license header, choose License Headers in Project Properties.
 * To change oBloco template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import br.ufpr.lingblocos.logicablocos.Bloco;
import br.ufpr.lingblocos.util.DoubleTransformer;
import br.ufpr.lingblocos.util.IntegerTransformer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Helio
 */
public class BlocoRepita extends BlocoEnvolvedor implements BlocoComCampos{

    private Campos campos = new Campos(this);
   
    
    public BlocoRepita(TelaBlocos tela, Bloco blocoLogica) {
        super(tela,"Repita", Color.YELLOW, blocoLogica);
        addCampos();
        
    }
    
     @Override
     public void addCampos() {
        BlocoCaixaTexto<Integer> caixa = new BlocoCaixaTexto("vezes", "100", new IntegerTransformer());
        getBloco().remove(cabecalho);
        campos.addOriginal(caixa);
        getBloco().add(cabecalho);
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
    public Iterator<Encaixavel> getCamposIterator() {
        return campos.getCamposIterator();
    }
    
    public Campos getCampos() {
        return campos;
    }
}
