/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.principal;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.TelaBlocos;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterBlocos;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterFigura;
import br.ufpr.lingblocos.apresentacao.desktop.teladesenho.TelaDesenho;
import java.util.Map;
import javax.swing.JFrame;


/**
 *
 * @author Helio
 */
public class JanelaPrincipal  {

    private JFrame aJanela;  //usando composição em vez de herança
    
    private TelaDesenho telaDesenho;
    private TelaBlocos telaBlocos;
    private OpcaoFigura opcaoFiguraAtual = OpcaoFigura.RETANGULO;
    private OpcaoBloco opcaoBlocoAtual = OpcaoBloco.MOVA;
    private PainelBotoesFiguras painelBotoesFiguras;
    private PainelBotoesBlocos painelBotoesBlocos;
    private Map<OpcaoFigura, MouseAdapterFigura> mouseAdaptersFigura;
    private Map<OpcaoBloco, MouseAdapterBlocos> mouseAdaptersBlocos;
    
//    private List<Observer> observers = new ArrayList<Observer>();
  
    
    public JanelaPrincipal(TelaDesenho telaDesenho,
            TelaBlocos telaBlocos, int largura, int altura) {
        aJanela = new JFrame();
        aJanela.setSize(largura, altura) ;
        
        this.telaDesenho = telaDesenho;
//        addObserver(telaDesenho);
        telaDesenho.setPai(this);
        aJanela.add(telaDesenho.getTela());
        telaDesenho.setLocation(0, 0);       
        
        painelBotoesFiguras = new PainelBotoesFiguras(this);
        aJanela.add(painelBotoesFiguras);
        painelBotoesFiguras.setLocation(10, telaDesenho.getHeight() + 10);
        
        painelBotoesBlocos = new PainelBotoesBlocos(this);
        aJanela.add(painelBotoesBlocos);
        painelBotoesBlocos.setLocation(telaDesenho.getWidth() + 5, 10);
        
        this.telaBlocos = telaBlocos;
//        addObserver(telaBlocos);
        telaBlocos.setPai(this);
        aJanela.add(telaBlocos.getTela());
        telaBlocos.setLocation(telaDesenho.getWidth()+100, 0);

        aJanela.setLayout(null);
       
        aJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aJanela.setResizable(true);
        aJanela.pack();
        aJanela.setLocationRelativeTo(null);
        aJanela.setVisible(true);
        
        
    }

    void setOpcaoFiguraAtual(OpcaoFigura opcao) {
        opcaoFiguraAtual = opcao;
        notifyTelaDesenho();
        
    }

    public OpcaoFigura getOpcaoFiguraAtual() {
        return opcaoFiguraAtual;
    }

    public void setOpcaoBlocoAtual(OpcaoBloco opcaoBlocoAtual) {
        this.opcaoBlocoAtual = opcaoBlocoAtual;
        notifyTelaBlocos();
    }

    public OpcaoBloco getOpcaoBlocoAtual() {
        return opcaoBlocoAtual;
    }

   
    public void setupMouseAdaptersFigura(Map<OpcaoFigura, MouseAdapterFigura> relacao){
        mouseAdaptersFigura = relacao;
    }
    
    public void setupMouseAdaptersBlocos(Map<OpcaoBloco, MouseAdapterBlocos> relacao){
        mouseAdaptersBlocos = relacao;
    }

//    @Override
//    public void addObserver(Observer o) {
//        observers.add(o);
//    }
//
//    @Override
//    public void removeObserver(Observer o) {
//        observers.remove(o);
//    }

    
    private void notifyTelaDesenho(){
        telaDesenho.update(mouseAdaptersFigura.get(opcaoFiguraAtual));
    }
    
    private void notifyTelaBlocos(){
        telaBlocos.update(mouseAdaptersBlocos.get(opcaoBlocoAtual));
    }
    
    
    
    
    
}
