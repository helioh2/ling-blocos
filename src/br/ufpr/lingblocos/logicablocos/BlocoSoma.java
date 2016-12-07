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
public class BlocoSoma extends BlocoEncaixavel<Double>{
    
    BlocoEncaixavel<Double> a;
    BlocoEncaixavel<Double> b;

    public BlocoSoma(Double valor) {
        super(valor);
    }

    public BlocoSoma() {
        super(0.0);
    }
    
    

    public void setA(BlocoEncaixavel<Double> a) {
        this.a = a;
    }

    public void setB(BlocoEncaixavel<Double> b) {
        this.b = b;
    }
    
    

    @Override
    public Double getValor() {
        return a.getValor() + b.getValor();
    }

 
  
    
}
