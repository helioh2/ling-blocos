/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import java.awt.Color;

/**
 *
 * @author Lenovo
 */
public class BlocoEspere extends BlocoSimples{
    
    public BlocoEspere() {
        super("Espere", Color.ORANGE);
        addCampo("tempo", "0");
    }
    
}
