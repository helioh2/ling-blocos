/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import br.ufpr.lingblocos.util.DoubleTransformer;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingConstants;

/**
 *
 * @author helio
 */
public class BlocoSoma extends BlocoEncaixavel<Double> implements BlocoComCampos {

    private List<Encaixavel> campos = new ArrayList<>();
    private List<Encaixavel> camposOriginais = new ArrayList<>();
    
    public BlocoSoma(TelaBlocos tela) {
        super(tela,"+", Color.CYAN);
        addCampos();
        
    }

    @Override
    public void addCampos() {
        BlocoCaixaTexto<Double> caixa1 = new BlocoCaixaTexto("n1", "0.0", new DoubleTransformer());
        getBloco().add(caixa1.getCaixa());
        campos.add(caixa1);
        camposOriginais.add(caixa1);
        caixa1.setBounds(5, 5, 20, 20);
        
        BlocoCaixaTexto<Double> caixa2 = new BlocoCaixaTexto("n2", "0.0", new DoubleTransformer());
        getBloco().add(caixa2.getCaixa());
        campos.add(caixa2);
        camposOriginais.add(caixa2);
        caixa2.setBounds(getBloco().getWidth()-25, 5, 20, 20);
        
        
    }

    @Override
    public Double getValor() {
        //TO-DO (PARTE DA LÓGICA)
        return 0.0;
    }

    @Override
    public void trocaCampo(Encaixavel antigo, Encaixavel novo) {
        
    }
    

    public void setBounds(int i, int i0, int i1, int i2) {
        setBounds(new Rectangle(i, i0, i1, i2));
    }
    
    @Override
    public Rectangle getBounds() {
        return getBloco().getBounds();
    }

    @Override
    public void setBounds(Rectangle bounds) {
        getBloco().setBounds(bounds);
    }

    @Override
    public Iterator<Encaixavel> getCampos() {
        return campos.iterator();
    }
    
    
    
}
