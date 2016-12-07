/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicablocos;

/**
 *
 * @author helio
 */
public class Campo<T> {

    private T valor;

    public Campo(T valor) {
        this.valor = valor;
    
    }
    
    
    public T getValor(){
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    
    
}
