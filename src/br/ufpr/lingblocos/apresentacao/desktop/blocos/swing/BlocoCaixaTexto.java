/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.logicablocos.Bloco;
import br.ufpr.lingblocos.util.Transformer;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author helio
 */
public class BlocoCaixaTexto<T> implements Encaixavel<JTextField, T> {

    private JTextField caixa;
    private Transformer<String, T> transformer;
    private BlocoArrastavel pai;
    private String name;

    public BlocoCaixaTexto(String label, String init, Transformer<String, T> transformer) {
        caixa = new JTextField(init);
        caixa.setName(label);
        caixa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                pai.getBlocoLogica().atualizaCampo(caixa.getName(), getValor());

            }
        });
        this.transformer = transformer;
        this.name = label;

    }

    @Override
    public String getName() {
        return name;
    }
    
    

    @Override
    public T getValor() {
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

    @Override
    public BlocoArrastavel getPai() {
        return pai;
    }

    @Override
    public void setPai(BlocoArrastavel pai) {
        this.pai = pai;
    }

    @Override
    public JTextField getBloco() {
        return caixa;
    }

    @Override
    public Bloco getBlocoLogica() {
        return pai.getBlocoLogica();
    }

}
