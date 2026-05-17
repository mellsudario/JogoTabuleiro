package classes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Casa10 extends Casa {

	public Casa10(int numCasa) {
		super(numCasa);
	}

	@Override
	public void entrarNaCasa(Jogador jogador, ArrayList<Jogador> jogadores) {

		/*
		 * se o competidor parar em uma dessas casa, ele não joga a próxima rodada;
		 */

		jogador.setPosicao(this.numCasa);
		jogador.setVaiJogar(false);

		JOptionPane.showMessageDialog(null, jogador.getCor() + " perdeu a próxima rodada!");

		if (!this.jogadores.contains(jogador)) {
			this.jogadores.add(jogador);
		}
	}
}