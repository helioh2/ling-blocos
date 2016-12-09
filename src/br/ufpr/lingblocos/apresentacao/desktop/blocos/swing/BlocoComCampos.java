/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import br.ufpr.lingblocos.logicablocos.Bloco;
import java.util.Iterator;

/**
 *
 * @author helio
 */
public interface BlocoComCampos {
    
    
    void addCampos();
    void trocaCampo(Encaixavel antigo, Encaixavel novo);
    
    void removeCampo(Encaixavel campo);

    public Iterator<Encaixavel> getCamposIterator();
    
    Campos getCampos();
    
    Bloco getBlocoLogica();
}
