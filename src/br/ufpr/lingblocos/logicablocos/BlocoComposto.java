/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicablocos;

import br.ufpr.lingblocos.logicapalco.Ator;
import java.util.ArrayList;
import java.util.List;


public class BlocoComposto extends BlocoExecutavel {
    
    protected List<BlocoExecutavel> blocoExe = new ArrayList<>();

    @Override
    public void executar() {
        //TODO
    }

    public void inserirBloco(Bloco blocoLogica) {
        blocoExe.add((BlocoExecutavel) blocoLogica);
    }

  
}
