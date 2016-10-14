/*
 * To change oBloco license header, choose License Headers in Project Properties.
 * To change oBloco template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
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

    private List<Encaixavel> campos = new ArrayList<>(); 
    
   
    
    public BlocoRepita(TelaBlocos tela) {
        super(tela,"Repita", Color.YELLOW);
        addCampos();
        
    }
    
     @Override
     public void addCampos() {
        BlocoCaixaTexto<Integer> caixa = new BlocoCaixaTexto("vezes", "100", new IntegerTransformer());
        cabecalho.add(caixa.getCaixa());
        campos.add(caixa);
        caixa.setBounds(70+campos.indexOf(caixa)*22, 10, 20, 20);
    }

    @Override
    public void trocaCampo(Encaixavel antigo, Encaixavel novo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public Iterator<Encaixavel> getCampos() {
        return campos.iterator();
    }
}
