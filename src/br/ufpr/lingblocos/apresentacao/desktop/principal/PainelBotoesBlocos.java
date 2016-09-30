
package br.ufpr.lingblocos.apresentacao.desktop.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


class PainelBotoesBlocos extends JPanel implements ActionListener {
    
    private JButton b1, b2, b3;
    private JanelaPrincipal pai;

    public PainelBotoesBlocos(JanelaPrincipal pai) {

        this.pai = pai;
        
        this.setSize(70, 400);
        b1 = new JButton("Mova");     
        b1.setActionCommand("mova");

        b2 = new JButton("Mude Tamanho");
        b2.setActionCommand("mudetamanho");

        b3 = new JButton("Gire");
        b3.setActionCommand("gire");

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
        add(b3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (null != e.getActionCommand()) switch (e.getActionCommand()) {
            case "mova":
                pai.setOpcaoBlocoAtual(OpcaoBloco.MOVA);
                break;
            case "gire":
                pai.setOpcaoBlocoAtual(OpcaoBloco.GIRE);
                break;
            case "mudetamanho":
                pai.setOpcaoBlocoAtual(OpcaoBloco.MUDETAMANHO);
                break;
            default:
                break;
        }
    }

  



}