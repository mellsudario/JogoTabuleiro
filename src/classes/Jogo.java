package classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Jogo {

	private Tabuleiro tabuleiro;
	private ArrayList<Jogador> jogadores;
	private boolean modoDebug;

	public Jogo() {
		tabuleiro = new Tabuleiro();
		jogadores = new ArrayList<>();
		modoDebug = false;
	}

	public void ativarDebug() {
		modoDebug = true;
	}

	public boolean incluirJogador(Jogador novoJogador) {

		if (jogadores.size() >= 6) {
			return false;
		}

		if (jogadores.contains(novoJogador)) {
			return false;
		}

		jogadores.add(novoJogador);
		tabuleiro.incluirJogador(novoJogador);
		return true;
	}

	public String jogar() {

		JOptionPane.showMessageDialog(null, " INÍCIO DO JOGO ");
		while (true) {
			for (Jogador jogador : jogadores) {
                // casa 10
				if (!jogador.getVaiJogar()) {
					JOptionPane.showMessageDialog(null, jogador.getCor() + " perdeu esta rodada!");
					jogador.setVaiJogar(true);
					continue;
				}

				String mensagem = "Posições atuais:\n\n";
				for (Jogador j : jogadores) {
					mensagem += j.getCor() + " está na casa " + j.getPosicao() + "\n";
				}

				mensagem += "\nVez de " + jogador.getCor();
				JOptionPane.showMessageDialog(null, mensagem);
				
				int soma; // resultado dos dados
				// modo debug
				if (modoDebug) {
					String entrada = JOptionPane.showInputDialog(null, "Digite a casa para onde o jogador deve ir:");
					int destino = Integer.parseInt(entrada);
					soma = destino - jogador.getPosicao();

					if (soma < 0) {
						soma = 0;
					}
				} else {
					soma = jogador.jogarDados();
				}

				JOptionPane.showMessageDialog(null, "Soma dos dados: " + soma);
				jogador.incrementarJogadas();
				tabuleiro.moverJogador(jogador, novaCasa, casaAtual);
				JOptionPane.showMessageDialog(null, jogador.getCor() + " foi para a casa " + jogador.getPosicao());

				if (jogador.getPosicao() >= 40) {
					String resultado = " FIM DE JOGO \n\n";
					resultado += "Vencedor: " + jogador.getCor() + "\n\n";
					resultado += "Posições finais:\n";

					for (Jogador j : jogadores) {
						resultado += j.getCor() + " terminou na casa " + j.getPosicao() + " com " + j.getQuantJogadas()
								+ " jogadas.\n";
					}
					JOptionPane.showMessageDialog(null, resultado);
					return jogador.getCor();
				}
			}
		}
	}

	public void debug() {
		ativarDebug();
		JOptionPane.showMessageDialog(null, "Modo DEBUG ativado!");
	}
}