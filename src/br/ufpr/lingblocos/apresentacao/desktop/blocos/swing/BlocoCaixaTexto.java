/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.util.Transformer;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import javax.swing.JTextField;

/**
 *
 * @author helio
 */
public class BlocoCaixaTexto<T> implements Encaixavel<T>{
    
    
    private JTextField caixa;
    private Transformer<String, T> transformer;
    
    public BlocoCaixaTexto(String label, String init, Transformer<String, T> transformer) {
        caixa = new JTextField(init);
        caixa.setName(label);
        
    }
    
    public T getValor(){
        String valorStr = caixa.getText();
        return transformer.transform(valorStr);
                
    }

    

    public JTextField getCaixa() {
        return caixa;
    }

    public void setBounds(int i, int i0, int i1, int i2) {
        setBounds(new Rectangle(i, i0, i1, i2));
    }
    
    @Override
    public Rectangle getBounds() {
        return caixa.getBounds();
    }

    @Override
    public void setBounds(Rectangle bounds) {
        caixa.setBounds(bounds);
    }

    
}
