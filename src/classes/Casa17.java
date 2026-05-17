package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Casa17 extends Casa {

	public Casa17(int numCasa) {
		super(numCasa);
	}

	@Override
	public void entrarNaCasa(Jogador jogador, ArrayList<Jogador> jogadores) {

		/*
		 * Se o competidor parar nessa casa, ele escolhe um competidor para voltar para
		 * o início do jogo.
		 */
		
		jogador.setPosicao(this.numCasa);
		if (!this.jogadores.contains(jogador)) {
			this.jogadores.add(jogador);
		}

		String[] cores = new String[jogadores.size()];
		for (int i = 0; i < jogadores.size(); i++) {
			cores[i] = jogadores.get(i).getCor();
		}
		int escolha = JOptionPane.showOptionDialog(null, "Escolha um jogador para voltar ao início:", "Casa Especial",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, cores, cores[0]);

		if (escolha >= 0) {
			Jogador escolhido = jogadores.get(escolha);
			if (escolhido != jogador) {
				escolhido.setPosicao(0);
				JOptionPane.showMessageDialog(null, escolhido.getCor() + " voltou para o início!");
			}
		}
	}
}