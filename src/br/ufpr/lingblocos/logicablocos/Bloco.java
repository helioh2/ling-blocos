/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicablocos;

import br.ufpr.lingblocos.logicapalco.Ator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author helio
 */
public interface Bloco {
    
    void setAtor(Ator ator);
    
    void atualizaCampo(String nome, Object valor);

    default Map<String,Campo> getCampos() {
        return new HashMap<>();
    }
    
    default void trocaCampo(String nome, Bloco blocoLogica) {
        getCampos().put(nome, (Campo) blocoLogica);
    }

    default void resetaCampo(String name){
        getCampos().put(name, new Campo<>(0));
    }
            
    
}
