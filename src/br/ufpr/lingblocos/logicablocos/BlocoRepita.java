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
public class BlocoRepita extends BlocoEnvolvedor {

    public BlocoRepita() {
        campos.put("vezes", new Campo(100));
    }

    @Override
    public void executar() {
        for (int i = 0; i < (int) campos.get("vezes").getValor(); i++) {
           //TODO... Insira o codigo pra executar os blocos de dentro
           
           //parte que faz nao repetir tão rapido:
           try {
                Thread.sleep(10);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
    }

}
