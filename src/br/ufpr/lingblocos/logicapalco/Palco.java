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
        
     Desenhador desenhador;   
    
     
     
    private List<Ator> atores = new LinkedList();

    public Palco(Desenhador desenhador) {
        this.desenhador = desenhador;
    }
    
    
    
    public void selecionarAtor(int x, int y) {
        System.out.println(x +" " +y);
    }

    public void inserirAtor(Ator ator) {
        atores.add(ator);
        ator.setDesenhador(desenhador);
        desenhar();
    }

    private void desenhar() {
        for (Ator a: atores) {
            a.desenhar();
        }
        System.out.println(atores);
    }
    
}
