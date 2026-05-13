package jogotabuleiro.interfacegrafica;


import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import jogotabuleiro.classes.Casa;

public class TabuleiroPanel extends JPanel{
    private class Peca{
        int posicao;
    }

    ArrayList <CasaTabuleiro> trilha = new ArrayList<>();
    ImageIcon [] imagens = new ImageIcon[6];

    public TabuleiroPanel() {
		carregarImagens();
        criarTrilha();

	}

    private void carregarImagens(){
        //imagens dos jogadores
    }

    private void criarTrilha(){
        trilha.add(new Casa(50, 500));
        trilha.add(new Casa(120, 500));
        trilha.add(new Casa(190, 470));
        trilha.add(new Casa(250, 430));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        desenharTrilha(g);
        desenharPecas(g);
    }

    private void desenharTrilha(Graphics g){
        Color fundo = new Color(200, 235, 200);
        g.setColor(fundo);
        g.fillRect(0,0,getWidth(),getHeight());

        for (int i = 0; i < trilha.size(); i++) {

            Casa c = trilha.get(i);

            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(c.x, c.y, 50, 50);

            g.setColor(Color.GREEN);
            g.drawOval(c.x, c.y, 50, 50);

            g.drawString("" + i, c.x + 18, c.y + 28);

        }

    }

    private void desenharPecas(Graphics g){
        
    }



}
