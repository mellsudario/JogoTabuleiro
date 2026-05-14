package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Casa20 extends Casa {

    public Casa20(int numCasa) {
        super(numCasa);
    }

    @Override
    public int entrarNaCasa(Jogador jogador, ArrayList<Jogador> jogadores) {

        if (!jogadores.contains(jogador)) {
            jogadores.add(jogador);
        }

        /*
         * Casas mágicas:
         * troca de lugar com o jogador
         * mais atrás no jogo.
         */

        Jogador ultimo = jogador;

        // procura o jogador mais atrás
        for (Jogador j : jogadores) {

            if (j.getPosicao() < ultimo.getPosicao()) {
                ultimo = j;
            }
        }

        // verifica se o próprio jogador já é o último
        if (ultimo == jogador) {

            JOptionPane.showMessageDialog(
                    null,
                    jogador.getCor() + " já está em último lugar!");

        } else {

            // guarda posição original
            int posicaoAtual = jogador.getPosicao();

            // troca posições
            jogador.setPosicao(ultimo.getPosicao());
            ultimo.setPosicao(posicaoAtual);

            JOptionPane.showMessageDialog(
                    null,
                    jogador.getCor() + " trocou de lugar com "
                            + ultimo.getCor() + "!");
        }

        return jogador.getPosicao();
    }
}