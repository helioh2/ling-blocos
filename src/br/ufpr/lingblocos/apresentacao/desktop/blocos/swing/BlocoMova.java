/*
 * To change oBloco license header, choose License Headers in Project Properties.
 * To change oBloco template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
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

    private List<Encaixavel> campos = new ArrayList<>();    
    private List<Encaixavel> camposOriginais = new ArrayList<>();

    public BlocoMova(TelaBlocos tela) {
        super(tela,"Mova", Color.BLUE);
        addCampos();
        
    }
    
     @Override
    public void addCampos() {
        BlocoCaixaTexto<Double> caixa = new BlocoCaixaTexto("passos", "0", new DoubleTransformer());
        getBloco().add(caixa.getCaixa());
        campos.add(caixa);
        caixa.setBounds(70+campos.indexOf(caixa)*22, 10, 20, 20);
        caixa.setPai(this);
        camposOriginais.addAll(campos);
        
    }

    @Override
    public void removeCampo(Encaixavel campo) {
        int index = campos.indexOf(campo);
        Encaixavel antigo = camposOriginais.get(index);
        campos.set(index, antigo);
        getBloco().remove(campo.getBloco());
        getBloco().add(antigo.getBloco());
        campo.setPai(null);
        getBloco().setSize(getBloco().getWidth()-campo.getBloco().getWidth(),                
                getBloco().getHeight());
    }

    @Override
    public void trocaCampo(Encaixavel antigo, Encaixavel novo) {
        campos.set(campos.indexOf(antigo), novo);
        novo.setPai(this);
        getBloco().remove(antigo.getBloco());
        getBloco().add(novo.getBloco());   
        
        getBloco().setSize(getBloco().getWidth()+novo.getBloco().getWidth(),                
                getBloco().getHeight());
        novo.getBloco().setLocation(antigo.getBloco().getLocation());
        
    }
    
     @Override
    public Iterator<Encaixavel> getCampos() {
        return campos.iterator();
    }
    
    
}
