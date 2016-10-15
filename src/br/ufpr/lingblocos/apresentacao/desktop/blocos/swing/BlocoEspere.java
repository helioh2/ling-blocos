/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import br.ufpr.lingblocos.util.DoubleTransformer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class BlocoEspere extends BlocoSimples implements BlocoComCampos{

    private List<Encaixavel> campos = new ArrayList<>();
    private List<Encaixavel> camposOriginais = new ArrayList<>();
    
    public BlocoEspere(TelaBlocos tela) {
        super(tela, "Espere", Color.ORANGE);
        addCampos();
    }

    @Override
    public void addCampos() {
        BlocoCaixaTexto<Double> caixa = new BlocoCaixaTexto("tempo", "0", new DoubleTransformer());
        getBloco().add(caixa.getCaixa());
        campos.add(caixa);
        caixa.setBounds(70+campos.indexOf(caixa)*22, 10, 20, 20);
        caixa.setPai(this);
        camposOriginais.addAll(campos);
        
    }

    

     @Override
    public Iterator<Encaixavel> getCampos() {
        return campos.iterator();
    }

    @Override
    public void removeCampo(Encaixavel campo) {
        int index = campos.indexOf(campo);
        Encaixavel antigo = camposOriginais.get(index);
        campos.set(index, antigo);
        getBloco().remove(campo.getBloco());
        getBloco().add(antigo.getBloco());
        campo.setPai(null);
    }

    @Override
    public void trocaCampo(Encaixavel antigo, Encaixavel novo) {
        campos.set(campos.indexOf(antigo), novo);
        novo.setPai(this);
        getBloco().add(novo.getBloco());
        getBloco().remove(antigo.getBloco());
    }
  
  
    
    
}
