/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.lingblocos.apresentacao.desktop.teladesenho;

import br.ufpr.lingblocos.apresentacao.desktop.principal.JanelaPrincipal;
import br.ufpr.lingblocos.apresentacao.desktop.mouseadapters.MouseAdapterFigura;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import br.ufpr.lingblocos.util.Observer;

/**
 *
 * @author Helio
 */
public class TelaDesenho implements Observer<MouseAdapterFigura>{
    
    private JPanel tela;  //usando composição em vez de herança
    private BufferedImage imagemAtual;
    private JanelaPrincipal pai;
    private MouseAdapter mouseAdapter;

    public TelaDesenho(int largura, int altura) {
        
        tela = new JPanel(){
            @Override
            public void paint(Graphics g) {
                g.drawImage(imagemAtual, 0, 0, null); // Redesenha o que já foi desenhado
            }}; //exemplo de como sobrescrever métodos sem usar a herança
                //usando definição de classe anônima

        tela.setSize(largura, altura);
        tela.setLayout(null);
        tela.setBackground(SystemColor.text);
        tela.setBounds(0, 0, tela.getWidth(), 
                tela.getHeight());
        imagemAtual = new BufferedImage(largura, 
                altura, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = imagemAtual.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, tela.getWidth(), tela.getHeight());
    }

    public void setPai(JanelaPrincipal pai) {
        this.pai = pai;
    }
    
    public void setLocation(int x, int y){
        tela.setLocation(x, y);
    }
    
    public JPanel getTela() {
        return tela;
    }

    public void setMouseAdapter(MouseAdapter mouseAdapter) {
        tela.removeMouseListener(this.mouseAdapter);
        this.mouseAdapter = mouseAdapter;
        tela.addMouseListener(this.mouseAdapter);
    }
    
     /**
     * Método chamado pela entidade observada (JanelaPrincipal).
     * Quando há mudança de opção, necessariamente deve haver mudança
     * de mouse adapter.
     * @param o
     * @param m
     */
    @Override
    public void update(MouseAdapterFigura m) {
        setMouseAdapter(m);
    }
    
    /**
     * Exemplo de função de desenho.
     * @param x
     * @param y
     * @param largura
     * @param altura 
     */
    public void desenhaRetangulo(int x, int y, int largura, int altura) {
        Graphics2D g = imagemAtual.createGraphics();
        g.setColor(Color.BLACK);
        g.drawRect(x, y, largura, altura);
        tela.repaint();
    }

    public void desenhaElipse(int x, int y, int largura, int altura) {
        Graphics2D g = imagemAtual.createGraphics();
        g.setColor(Color.BLACK);
        g.drawOval(x, y, largura, altura);
        tela.repaint();
    }

    public int getHeight() {
        return tela.getHeight();
    }

    public int getWidth() {
        return tela.getWidth();
    }
}
    
    
    
    
    

