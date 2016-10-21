/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicapalco;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Palco {
    
    private List<Ator> atores = new LinkedList();
    
    public void selecionarAtor(int x, int y) {
        System.out.println(x +" " +y);
    }

    public void inserirAtor(Ator ator) {
        atores.add(ator);
        desenhar();
    }

    private void desenhar() {
        for (Ator a: atores) {
            a.desenhar();
        }
    }
    
}
