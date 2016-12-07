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
public class BlocoEspere extends BlocoSimples{

    public BlocoEspere(){
        campos.put("t",new Campo<>(0.0));
    }

    
    
    @Override
    public void executar() {
        try {
            Thread.sleep((long) campos.get("t").getValor()*1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
}
