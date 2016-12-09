/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicablocos;

import br.ufpr.lingblocos.logicapalco.Ator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BlocoEncaixavel<T> extends Campo<T> implements Bloco  {
    
    Ator ator;
    protected Map<String,Campo> campos = new HashMap<String, Campo>();

    public BlocoEncaixavel(T valor) {
        super(valor);
    }

    @Override
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
