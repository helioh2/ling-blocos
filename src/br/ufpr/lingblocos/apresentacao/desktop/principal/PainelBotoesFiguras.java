
package br.ufpr.lingblocos.apresentacao.desktop.principal;

import java.awt.event.ActionEvent;


class PainelBotoesFiguras extends PainelBotoes {
    

    public PainelBotoesFiguras(JanelaPrincipal pai) {

        super(pai);
        this.setSize(400, 100);
        
        addBotao("Elipse", OpcaoFigura.ELIPSE.toString());
        addBotao("Reta", OpcaoFigura.RETA.toString());
        addBotao("Retângulo", OpcaoFigura.RETANGULO.toString());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pai.setOpcaoFiguraAtual(OpcaoFigura.valueOf(e.getActionCommand()));
    }

  



}