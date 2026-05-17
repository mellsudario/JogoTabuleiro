package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Casa20 extends Casa {

	public Casa20(int numCasa) {
		super(numCasa);
	}

	@Override
	public void entrarNaCasa(Jogador jogador, ArrayList<Jogador> jogadores) {
		/*
		 * Casas mágicas: troca de lugar com o jogador mais atrás no jogo.
		 */
		
		jogador.setPosicao(this.numCasa);
		if (!this.jogadores.contains(jogador)) {
			this.jogadores.add(jogador);
		}

		Jogador ultimo = jogador;
		for (Jogador j : jogadores) {
			if (j.getPosicao() < ultimo.getPosicao()) {
				ultimo = j;
			}
		}

		if (ultimo == jogador) {
			JOptionPane.showMessageDialog(null, jogador.getCor() + " já está em último!");

		} else {
			int posicaoAtual = jogador.getPosicao();
			jogador.setPosicao(ultimo.getPosicao());
			ultimo.setPosicao(posicaoAtual);
			JOptionPane.showMessageDialog(null, jogador.getCor() + " trocou de lugar com " + ultimo.getCor());
		}
	}
}