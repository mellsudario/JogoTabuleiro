package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Casa17 extends Casa {

	public Casa17(int numCasa) {
		super(numCasa);
	}

	@Override
	public void entrarNaCasa (Jogador jogador, ArrayList<Jogador> jogadores) {

		if (!jogadores.contains(jogador)) {
			jogador.setPosicao(this.numCasa);
			jogadores.add(jogador);
		}

		/*
		 * Se o competidor parar nessa casa, ele escolhe um competidor para voltar para
		 * o início do jogo.
		 */

		// cria vetor com as cores dos jogadores
		String[] cores = new String[jogadores.size()];

		for (int i = 0; i < jogadores.size(); i++) {
			cores[i] = jogadores.get(i).getCor();
		}

		int escolha = JOptionPane.showOptionDialog(null, "Escolha um jogador para voltar ao início:", "Casa Especial",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, cores, cores[0]);

		// verifica se o jogador escolheu alguém
		if (escolha >= 0) {

			Jogador escolhido = jogadores.get(escolha);

			// impede que o jogador escolha a si mesmo
			if (escolhido != jogador) {

				escolhido.setPosicao(0);

				JOptionPane.showMessageDialog(null, "O jogador " + escolhido.getCor() + " voltou para o início!");
			} else {

				JOptionPane.showMessageDialog(null, "Você não pode escolher a si mesmo.");
			}
		}

	}
}