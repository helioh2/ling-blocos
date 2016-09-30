
package br.ufpr.lingblocos.apresentacao.desktop.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


class PainelBotoesFiguras extends JPanel implements ActionListener {
    
    private JButton b1, b2, b3;
    private JanelaPrincipal pai;

    public PainelBotoesFiguras(JanelaPrincipal pai) {

        this.pai = pai;
        
        this.setSize(400, 100);
        b1 = new JButton("Elipse");     
        b1.setActionCommand("elipse");

        b2 = new JButton("Reta");
        b2.setActionCommand("reta");

        b3 = new JButton("Retangulo");
        b3.setActionCommand("retangulo");

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
        add(b3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (null != e.getActionCommand()) switch (e.getActionCommand()) {
            case "elipse":
                pai.setOpcaoFiguraAtual(OpcaoFigura.ELIPSE);
                break;
            case "reta":
                pai.setOpcaoFiguraAtual(OpcaoFigura.RETA);
                break;
            case "retangulo":
                pai.setOpcaoFiguraAtual(OpcaoFigura.RETANGULO);
                break;
            default:
                break;
        }
    }

  



}