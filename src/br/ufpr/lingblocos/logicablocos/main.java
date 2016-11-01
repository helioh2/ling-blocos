/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.logicablocos;


import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterBlocos;
import br.ufpr.lingblocos.apresentacao.desktop.teladesenho.TelaDesenho;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterElipse;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterEspere;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterFigura;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterGire;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterMova;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterRepita;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterRetangulo;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterSoma;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterTriangulo;
import br.ufpr.lingblocos.apresentacao.desktop.principal.JanelaPrincipal;
import br.ufpr.lingblocos.apresentacao.desktop.principal.OpcaoBloco;
import br.ufpr.lingblocos.apresentacao.desktop.principal.OpcaoFigura;
import br.ufpr.lingblocos.apresentacao.desktop.telablocos.swing.TelaBlocos;
import br.ufpr.lingblocos.logicapalco.Ator;
import br.ufpr.lingblocos.logicapalco.Palco;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.Map;


public class main {

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       TelaDesenho telaDesenho = new TelaDesenho(400, 500);
       TelaBlocos telaBlocos = new TelaBlocos(500, 700);
       //TelaDesenhoController telaController = new TelaDesenhoController(telaDesenho);
       JanelaPrincipal janela = new JanelaPrincipal(telaDesenho, 
               telaBlocos, 800, 600);
        Ator ator = new Ator(10,10){
           @Override
           public void desenhar() {
               System.out.println(".desenhar"+ x + " " + y );
                       
           }
            
        };
        Painel painel = new Painel(ator);
        painel.inserirBloco(new BlocoSimples());
        Palco palco = new Palco();
       
       //Adicionando relação de opções de figuras com mouse listeners:
       // (vocês terão que ir adicionando à medida que novas figuras 
       // são possíveis de serem desenhadas)
       Map<OpcaoFigura,MouseAdapterFigura> relacaoOpcaoFiguraMouse = new HashMap<>();
       relacaoOpcaoFiguraMouse.put(OpcaoFigura.RETANGULO, new MouseAdapterRetangulo(telaDesenho, palco));
       relacaoOpcaoFiguraMouse.put(OpcaoFigura.ELIPSE, new MouseAdapterElipse(telaDesenho, palco));
       relacaoOpcaoFiguraMouse.put(OpcaoFigura.TRIANGULO, new MouseAdapterTriangulo(telaDesenho, palco));
       janela.setupMouseAdaptersFigura(relacaoOpcaoFiguraMouse);
       
       //Adicionando relação de opções de blocos com mouse listeners:
       // (vocês terão que ir adicionando à medida que novos blocos 
       // são possíveis de serem adicionados)
       Map<OpcaoBloco,MouseAdapterBlocos> relacaoOpcaoBlocoMouse = new HashMap<>();
       relacaoOpcaoBlocoMouse.put(OpcaoBloco.MOVA, new MouseAdapterMova(telaBlocos));
       relacaoOpcaoBlocoMouse.put(OpcaoBloco.GIRE, new MouseAdapterGire(telaBlocos));
       relacaoOpcaoBlocoMouse.put(OpcaoBloco.REPITA, new MouseAdapterRepita(telaBlocos));
       relacaoOpcaoBlocoMouse.put(OpcaoBloco.ESPERE, new MouseAdapterEspere(telaBlocos));       
       relacaoOpcaoBlocoMouse.put(OpcaoBloco.SOMA, new MouseAdapterSoma(telaBlocos));
       
       
       janela.setupMouseAdaptersBlocos(relacaoOpcaoBlocoMouse);
       
    
    }

  
   
    
}

