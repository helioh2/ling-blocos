/*
 * To change oBotao license header, choose License Headers in Project Properties.
 * To change oBotao template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import java.awt.Color;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Helio
 */
public class BlocoGire extends BlocoSimples{

    public BlocoGire() {
        super("Gire", Color.GREEN);       
        addCampo("graus", "90");
 
    }
}
