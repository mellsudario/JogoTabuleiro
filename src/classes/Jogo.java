package classes;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfacegrafica.TabuleiroPanel;

public class Jogo {

	private Tabuleiro tabuleiro;
	private ArrayList<Jogador> jogadores;
	private boolean modoDebug;
	private TabuleiroPanel painel;

	public Jogo(TabuleiroPanel painel) {
		this.tabuleiro = new Tabuleiro();
		this.jogadores = new ArrayList<>();
		this.modoDebug = false;
		this.painel = painel;
	}

	public void ativarDebug() {
		modoDebug = true;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public boolean incluirJogador(Jogador novoJogador) {

		if (jogadores.size() >= 6)
			return false;

		if (jogadores.contains(novoJogador))
			return false;

		jogadores.add(novoJogador);

		tabuleiro.incluirJogador(novoJogador);

		return true;
	}

	public String jogar() {

		JOptionPane.showMessageDialog(null, "INÍCIO DO JOGO");

		while (true) {

			for (int i = 0; i < jogadores.size(); i++) {

				Jogador jogador = jogadores.get(i);

				// perde rodada
				if (!jogador.getVaiJogar()) {
					JOptionPane.showMessageDialog(null, jogador.getCor() + " perdeu esta rodada!");
					jogador.setVaiJogar(true);
					continue;
				}

				// mostra posições
				String mensagem = "POSIÇÕES ATUAIS\n\n";
				for (Jogador j : jogadores) {
					mensagem += j.getCor() + " está na casa " + j.getPosicao() + "\n";
				}

				mensagem += "\nVez de " + jogador.getCor();
				JOptionPane.showMessageDialog(null, mensagem);
				boolean jogarNovamente;

				do {

					jogarNovamente = false;
					int soma;

					// DEBUG
					if (modoDebug) {

						String entrada = JOptionPane.showInputDialog(null,
								"Digite a casa para onde o jogador deve ir:");
						
						int destino = Integer.parseInt(entrada);
						soma = destino - jogador.getPosicao();

						if (soma < 0)
							soma = 0;

					} else {

						soma = jogador.jogarDados();
					}

					JOptionPane.showMessageDialog(null,
							"Dados: " + jogador.getDado1() + " + " + jogador.getDado2() + "\nSoma: " + soma);

					jogador.incrementarJogadas();
					int novaCasa = jogador.getPosicao() + soma;
					tabuleiro.moverJogador(jogador, jogadores, novaCasa);
					atualizarTodosJogadores(); // casa 17
					jogador = jogadores.get(i); //casa 13
					JOptionPane.showMessageDialog(null, jogador.getCor() + " foi para a casa " + jogador.getPosicao());

					// vitória
					if (jogador.getPosicao() >= 40) {

						String resultado = "FIM DE JOGO\n\n";
						resultado += "VENCEDOR: " + jogador.getCor() + "\n\n";
						resultado += "RESULTADO FINAL:\n\n";
						for (Jogador j : jogadores) {

							resultado += j.getCor() + " terminou na casa " + j.getPosicao() + " com "
									+ j.getQuantJogadas() + " jogadas.\n";
						}

						JOptionPane.showMessageDialog(null, resultado);
						return jogador.getCor();
					}

					// dados iguais
					if (!modoDebug && jogador.getDado1() == jogador.getDado2()) {
						JOptionPane.showMessageDialog(null, jogador.getCor() + " tirou dados iguais e joga novamente!");
						jogarNovamente = jogador.getVaiJogar();
					}

				} while (jogarNovamente);
			}
		}
	}

	private void atualizarPainel(Jogador jogador) {
		Color cor = null;
		switch (jogador.getCor()) {
		case "Vermelho":
			cor = Color.RED;
			break;

		case "Azul":
			cor = Color.BLUE;
			break;

		case "Verde":
			cor = Color.GREEN;
			break;

		case "Amarelo":
			cor = Color.YELLOW;
			break;

		case "Branco":
			cor = Color.WHITE;
			break;

		case "Preto":
			cor = Color.BLACK;
			break;
		}

		painel.moverJogador(jogador.getPosicao(), cor);
	}

	private void atualizarTodosJogadores() {

		for (Jogador jogador : jogadores) {
			atualizarPainel(jogador);
		}
	}

	public void debug() {
		ativarDebug();
		JOptionPane.showMessageDialog(null, "Modo DEBUG ativado!");
	}
}