/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicablocos;

import br.ufpr.lingblocos.logicapalco.Ator;

/**
 *
 * @author helio
 */
public interface Bloco {
    
    void setAtor(Ator ator);
    
    void atualizaCampo(String nome, Object valor);
            
    
}
