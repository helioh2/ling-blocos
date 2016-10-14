/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import java.awt.Rectangle;

/**
 *
 * @author helio
 */
interface Encaixavel<T> {
    T getValor();
    Rectangle getBounds();
    void setBounds(Rectangle bounds);
}
