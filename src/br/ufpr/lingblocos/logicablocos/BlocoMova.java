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
public class BlocoMova extends BlocoSimples{

    public BlocoMova(){
        campos.put("dx",new Campo<>(0));
        campos.put("dy",new Campo<>(0));
    }

    
    
    @Override
    public void executar() {
        //TODO, alguma coisa( com ...( Integer) campos.get("dx").getValor(),
        //        (Integer) campos.get("dy").getValor());
    }
    
    
    
}
