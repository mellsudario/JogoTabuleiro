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
		if (jogador instanceof JogadorAzarado) {
			if (!jogadores.contains(jogador)) {
				jogador.setPosicao(this.numCasa);
				jogadores.add(jogador);
			}
			JOptionPane.showMessageDialog(null,
					jogador.getCor() + " caiu na casa da sorte " + this.numCasa + ", mas por ser Azarado não avança!");
			return;
		}

		if (!jogadores.contains(jogador)) {
			jogadores.add(jogador);
		}

		int novaPosicao = this.numCasa + 3;
		JOptionPane.showMessageDialog(null, jogador.getCor() + " caiu na casa da sorte " + this.numCasa
				+ " e avança 3 casas para a casa " + novaPosicao + "!");

		jogadores.remove(jogador);
		jogador.setPosicao(novaPosicao);
	}
}