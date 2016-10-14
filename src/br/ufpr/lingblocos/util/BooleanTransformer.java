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
public class BooleanTransformer implements Transformer<String, Boolean> {

    @Override
    public Boolean transform(String input) {
        return Boolean.valueOf(input);
    }
}
