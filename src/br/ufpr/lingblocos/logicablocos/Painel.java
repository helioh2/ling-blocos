/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicablocos;

import br.ufpr.lingblocos.logicapalco.Ator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author helio
 */
public class Painel {
    private Ator ator;
    private List<Bloco> blocos = new LinkedList<>();
    
    public Painel(Ator ator) {
        this.ator = ator;
    }
    public void inserirBloco(Bloco bloco){
       blocos.add(bloco);
    }
    
    
}
