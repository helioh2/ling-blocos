/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import java.awt.Color;

/**
 * Bloco que encaixa dentro de outro. Geralmente serve para retornar um valor.
 * Ex: bloco ">" que retorna boolean, bloco '+' que retorna numero
 * @author helio
 */
public class BlocoEncaixavel extends BlocoSimples {

    public BlocoEncaixavel(String label, Color cor) {
        super(label, cor);
    }
    
    
    
}
