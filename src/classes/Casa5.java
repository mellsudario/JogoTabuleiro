package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Casa5 extends Casa {

	public Casa5(int numCasa) {
		super(numCasa);
	}

	@Override
	public void entrarNaCasa(Jogador jogador, ArrayList<Jogador> jogadores) {
		/*
		 * casas da sorte: ande 3 casas para frente desde que ele não seja um jogador
		 * azarado;
		 */
		
		jogador.setPosicao(this.numCasa);
		if (!this.jogadores.contains(jogador)) {
			this.jogadores.add(jogador);
		}

		// azarado não avança
		if (jogador instanceof JogadorAzarado) {
			JOptionPane.showMessageDialog(null,
					jogador.getCor() + " caiu na casa da sorte, mas é azarado e não avançou!");
			return;
		}

		int novaPosicao = this.numCasa + 3;
		JOptionPane.showMessageDialog(null, jogador.getCor() + " avançou 3 casas!");
		jogador.setPosicao(novaPosicao);
	}
}