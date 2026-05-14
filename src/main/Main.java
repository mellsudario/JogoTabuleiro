package main;


import javax.swing.JFrame;

import TabuleiroPanel;

public class Main {
    public static void main (String args[]){
        JFrame frame = new JFrame();
        frame.setTitle("Tabuleiro");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        TabuleiroPanel tabuleiro = new TabuleiroPanel();
        frame.add(tabuleiro);

        frame.setVisible(true);

        
    }
}