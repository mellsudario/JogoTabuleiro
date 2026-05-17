package main;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import classes.*;
import interfacegrafica.TabuleiroPanel;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();

		frame.setTitle("Jogo de Tabuleiro");
		frame.setSize(1000, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		TabuleiroPanel painel = new TabuleiroPanel();
		frame.add(painel);
		frame.setVisible(true);
		Jogo jogo = new Jogo(painel);

		int quantidade;

		do {
			quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de jogadores (2 a 6):"));
		} while (quantidade < 2 || quantidade > 6);
		String[] coresDisponiveis = { "Vermelho", "Azul", "Verde", "Amarelo", "Branco", "Preto" };
		Color[] coresJava = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.WHITE, Color.BLACK };
		Random random = new Random();

		Jogador[] jogadoresCriados = new Jogador[quantidade];
		boolean tiposValidos = false;
		while (!tiposValidos) {
			tiposValidos = false;
			int[] tiposSorteados = new int[quantidade];

			// sorteia todos os tipos
			for (int i = 0; i < quantidade; i++) {
				tiposSorteados[i] = random.nextInt(3);
			}

			for (int i = 0; i < quantidade; i++) {
				for (int j = i + 1; j < quantidade; j++) {
					if (tiposSorteados[i] != tiposSorteados[j]) {
						tiposValidos = true;
						break;
					}
				}

				if (tiposValidos)
					break;
			}

			// se os tipos forem válidos cria os jogadores
			if (tiposValidos) {

				for (int i = 0; i < quantidade; i++) {
					String corEscolhida = (String) JOptionPane.showInputDialog(null,
							"Escolha a cor do jogador " + (i + 1), "Cor", JOptionPane.PLAIN_MESSAGE, null,
							coresDisponiveis, coresDisponiveis[0]);

					int indiceCor = 0;
					for (int j = 0; j < coresDisponiveis.length; j++) {
						if (coresDisponiveis[j].equals(corEscolhida)) {
							indiceCor = j;
							break;
						}
					}

					Jogador jogador;

					String tipoJogador = "";
					switch (tiposSorteados[i]) {

					case 0:
						jogador = new JogadorSortudo(i + 1, corEscolhida);
						tipoJogador = "Sortudo";
						break;

					case 1:
						jogador = new JogadorAzarado(i + 1, corEscolhida);
						tipoJogador = "Azarado";
						break;

					default:
						jogador = new JogadorNormal(i + 1, corEscolhida);
						tipoJogador = "Normal";
						break;
					}

					jogadoresCriados[i] = jogador;

					jogo.incluirJogador(jogador);

					painel.incluirJogador(0, coresJava[indiceCor]);
					JOptionPane.showMessageDialog(null,
							"Jogador " + corEscolhida + " será do tipo " + tipoJogador + "!");
				}
			}
		}

		int respostaDebug = JOptionPane.showConfirmDialog(null, "Deseja ativar o modo DEBUG?", "Modo DEBUG",
				JOptionPane.YES_NO_OPTION);

		if (respostaDebug == JOptionPane.YES_OPTION) {

			jogo.debug();
		}

		jogo.jogar();
	}
}