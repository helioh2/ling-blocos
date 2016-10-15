/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.blocos.swing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Helio
 */
public class Campos implements BlocoComCampos {

    private List<Encaixavel> campos = new ArrayList<>();
    private List<Encaixavel> camposOriginais = new ArrayList<>();
    private BlocoArrastavel pai;

    public Campos(BlocoArrastavel pai) {
        this.pai = pai;
    }
    
    @Override
    public void addCampos() {
    }

    @Override
    public void trocaCampo(Encaixavel antigo, Encaixavel novo) {
        campos.set(campos.indexOf(antigo), novo);
        novo.setPai(pai);       
        pai.getBloco().remove(antigo.getBloco());
        pai.getBloco().add(novo.getBloco());
        pai.ajustaWidth(pai.getBloco().getWidth()+ novo.getBloco().getWidth()-antigo.getBloco().getWidth());
        pai.getBloco().setSize(
                pai.getWidth(),
                pai.getBloco().getHeight()+ novo.getBloco().getHeight()-antigo.getBloco().getHeight());
        novo.getBloco().setLocation(
                antigo.getBloco().getX(),
                antigo.getBloco().getY());
    }

    @Override
    public void removeCampo(Encaixavel campo) {
        int index = campos.indexOf(campo);
        Encaixavel antigo = camposOriginais.get(index);
        campos.set(index, antigo);
        pai.getBloco().remove(campo.getBloco());
        pai.getBloco().add(antigo.getBloco());
        campo.getBloco().setLocation(
                campo.getLocationTela());
        campo.setPai(null);
        pai.ajustaWidth(pai.getBloco().getWidth()-campo.getBloco().getWidth()+antigo.getBloco().getWidth());
        pai.getBloco().setSize(
                pai.getWidth(),                
                pai.getHeight()-campo.getBloco().getHeight()+antigo.getBloco().getHeight());
        
    }

    @Override
    public Iterator<Encaixavel> getCampos() {
        return campos.iterator();
    }

    public void addOriginal(Encaixavel campo) {
        pai.getBloco().add(campo.getBloco());
        campos.add(campo);
        camposOriginais.add(campo);
        campo.setPai(pai);

    }
    
}
