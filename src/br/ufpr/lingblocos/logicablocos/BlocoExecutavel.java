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
public abstract class BlocoExecutavel implements Bloco{
    
   protected Ator ator;
     protected Map<String,Campo> campos = new HashMap<String, Campo>();
   
    
   public abstract void executar();

    public void setAtor(Ator ator) {
        this.ator = ator;
    }
    
      @Override
    public void atualizaCampo(String nome, Object valor) {
        campos.get(nome).setValor(valor);
    }

   @Override
    public Map<String, Campo> getCampos() {
        return campos;
    }

    
   
}
