/*
 * To change oBotao license header, choose License Headers in Project Properties.
 * To change oBotao template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import br.ufpr.lingblocos.logicablocos.Bloco;
import br.ufpr.lingblocos.util.DoubleTransformer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Helio
 */
public class BlocoGire extends BlocoSimples implements BlocoComCampos{

    private Campos campos = new Campos(this);
    
    public BlocoGire(TelaBlocos tela, Bloco blocoLogica) {
        super(tela,"Gire", Color.GREEN, blocoLogica);
        addCampos();
 
    }

     @Override
    public void addCampos() {
        BlocoCaixaTexto<Double> caixa = new BlocoCaixaTexto("graus", "90", new DoubleTransformer());
        campos.addOriginal(caixa);
        caixa.setBounds(70, 10, 20, 20);
    }

    

     @Override
    public Iterator<Encaixavel> getCamposIterator() {
        return campos.getCamposIterator();
    }
    
    @Override
    public void removeCampo(Encaixavel campo) {
        campos.removeCampo(campo);
    }

    @Override
    public void trocaCampo(Encaixavel antigo, Encaixavel novo) {
        campos.trocaCampo(antigo, novo);
        this.getBlocoLogica().trocaCampo("graus",novo.getBlocoLogica());
    }
    
    public Campos getCampos() {
        return campos;
    }
}
