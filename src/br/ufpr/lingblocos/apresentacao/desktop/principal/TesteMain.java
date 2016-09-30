package br.ufpr.lingblocos.apresentacao.desktop.principal;

import br.ufpr.lingblocos.apresentacao.desktop.telablocos.TelaBlocos;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterBlocos;
import br.ufpr.lingblocos.apresentacao.desktop.teladesenho.TelaDesenho;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterElipse;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterFigura;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterGire;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterMova;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterRetangulo;
import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.Map;


public class TesteMain {

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       TelaDesenho telaDesenho = new TelaDesenho(700, 500);
       TelaBlocos telaBlocos = new TelaBlocos(300, 400);
       //TelaDesenhoController telaController = new TelaDesenhoController(telaDesenho);
       JanelaPrincipal janela = new JanelaPrincipal(telaDesenho, 
               telaBlocos, 800, 600);

       //Adicionando relação de opções de figuras com mouse listeners:
       // (vocês terão que ir adicionando à medida que novas figuras 
       // são possíveis de serem desenhadas)
       Map<OpcaoFigura,MouseAdapterFigura> relacaoOpcaoFiguraMouse = new HashMap<>();
       relacaoOpcaoFiguraMouse.put(OpcaoFigura.RETANGULO, new MouseAdapterRetangulo(telaDesenho));
       relacaoOpcaoFiguraMouse.put(OpcaoFigura.ELIPSE, new MouseAdapterElipse(telaDesenho));
       janela.setupMouseAdaptersFigura(relacaoOpcaoFiguraMouse);
       
       //Adicionando relação de opções de blocos com mouse listeners:
       // (vocês terão que ir adicionando à medida que novos blocos 
       // são possíveis de serem adicionados)
       Map<OpcaoBloco,MouseAdapterBlocos> relacaoOpcaoBlocoMouse = new HashMap<>();
       relacaoOpcaoBlocoMouse.put(OpcaoBloco.MOVA, new MouseAdapterMova(telaBlocos));
       relacaoOpcaoBlocoMouse.put(OpcaoBloco.GIRE, new MouseAdapterGire(telaBlocos));
       janela.setupMouseAdaptersBlocos(relacaoOpcaoBlocoMouse);
       
    
    }

  
   
    
}
