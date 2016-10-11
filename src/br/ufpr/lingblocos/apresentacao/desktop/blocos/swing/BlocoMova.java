/*
 * To change oBloco license header, choose License Headers in Project Properties.
 * To change oBloco template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import java.awt.Color;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.TOP;
import javax.swing.border.LineBorder;

/**
 *
 * @author Helio
 */
public class BlocoMova extends BlocoSimples {

    public BlocoMova() {
        super("Mova", Color.BLUE);
        addCampo("passos", "0");
    }
    
    
    
}
