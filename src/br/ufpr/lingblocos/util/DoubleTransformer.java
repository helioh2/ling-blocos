/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.util;

/**
 *
 * @author helio
 */
public class DoubleTransformer implements Transformer<String, Double> {

    @Override
    public Double transform(String input) {
        try {
            return Double.valueOf(input);
        } catch (NumberFormatException e){
            return 0.0;
        }    
    }
    
}
