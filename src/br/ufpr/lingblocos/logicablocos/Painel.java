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
       bloco.setAtor(ator);
       System.out.println(blocos);
    }

    /**
     * A ideia aqui é que o blocoLogica é um bloco composto,
     * esta função é chamada no método trocaPainel do TelaBlocos.
     * Vocês tem que fazer o blocoLogica0 ser inserido no blocoLogica (que é composto)
     * Não esqueçam também que deve-se remover o blocoLogica0 da lista de blocos do painel.
     * @param blocoLogica
     * @param blocoLogica0 
     */
    public void juntarBlocos(Bloco blocoLogica, Bloco blocoLogica0) {
       
        BlocoComposto blocoComposto = (BlocoComposto) blocoLogica;
      
        //TODO... Façam o resto
    }
    
    
    /**
     * Aqui vcs devem criar um bloco composto recebendo de antemão o primeiro
     * bloco que vai compôr o bloco. Esta função é chamada no metodo embrulhar()
     * do TelaBlocos.
     * @param blocoLogica
     * @return 
     */
    public BlocoComposto criaComposto(Bloco blocoLogica) {
        BlocoComposto blocoComposto = new BlocoComposto();
        
        //TODO...
        
        return blocoComposto;
        
    }
    
    
}
