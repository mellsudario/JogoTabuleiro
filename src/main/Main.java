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

		int quantidade = incluirJogadores();

		String[] coresDisponiveis = { "Vermelho", "Azul", "Verde", "Amarelo", "Branco", "Preto" };
		String[] tiposDisponiveis = { "Normal" , "Azarado" ,"Sortudo" };
		Color[] coresJava = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.WHITE, Color.BLACK };
		Random random = new Random();

		Jogador[] jogadoresCriados = new Jogador[quantidade];
		boolean tiposValidos = false;

		while (!tiposValidos) {
			tiposValidos = false;
			String[] tiposSorteados = new String[quantidade];

			// sorteia todos os tipos
			for (int i = 0; i < quantidade; i++) {
				String tipo = (String)JOptionPane.showInputDialog(null,
							"Escolha o tipo do jogador " + (i + 1), "Tipo", JOptionPane.PLAIN_MESSAGE, null,
							tiposDisponiveis, tiposDisponiveis[0]);
				tiposSorteados [i] = tipo;
			}

			for (int i = 0; i < quantidade; i++) {
				for (int j = i + 1; j < quantidade; j++) {
					if (!tiposSorteados[i].equals(tiposSorteados[j])) {
						tiposValidos = true;
						break;
					}
				}

				if (tiposValidos)
					break;
			}
			if(!tiposValidos) {
				JOptionPane.showMessageDialog(null,"Deve haver no mínimo dois tipos de jogadores diferentes!");
				continue;
			}

			// se os tipos forem válidos cria os jogadores
			if (tiposValidos) {

				for (int i = 0; i < quantidade; i++) {
					String corEscolhida = (String) JOptionPane.showInputDialog(null,
							"Escolha a cor do jogador " + (i + 1), "Cor", JOptionPane.PLAIN_MESSAGE, null,
							coresDisponiveis, coresDisponiveis[0]);

					int indiceCor = 0;
					String [] novasCores = new String[coresDisponiveis.length - 1];
					Color [] novasCoresJava = new Color[coresDisponiveis.length - 1];
					for (int j = 0, p = 0; j < coresDisponiveis.length; j++, p++) {
						if (coresDisponiveis[j].equals(corEscolhida)) {
							indiceCor = j;
							p--;
							continue;
						}
						novasCores[p] = coresDisponiveis[j];
						novasCoresJava[p] = coresJava[j];
					}

					Jogador jogador = null;

					
					switch (tiposSorteados[i]) {

					case "Sortudo":
						jogador = new JogadorSortudo(i + 1, corEscolhida);
						break;

					case "Azarado":
						jogador = new JogadorAzarado(i + 1, corEscolhida);
						break;

					case "Normal":
						jogador = new JogadorNormal(i + 1, corEscolhida);
						break;
					default:
						break;
					}

					jogadoresCriados[i] = jogador;

					jogo.incluirJogador(jogador);

					painel.incluirJogador(0, coresJava[indiceCor]);

					coresDisponiveis = novasCores;
					coresJava = novasCoresJava;

					JOptionPane.showMessageDialog(null,
							"Jogador " + corEscolhida + " será do tipo " + tiposSorteados[i] + "!");
				}
			}
		}

		int respostaDebug = JOptionPane.showConfirmDialog(null, "Deseja ativar o modo DEBUG?", "Modo DEBUG",
				JOptionPane.YES_NO_OPTION);

		if (respostaDebug == JOptionPane.YES_OPTION) {

			jogo.debug();
		}

		jogo.jogar();

		System.exit(0);
	}

	private static int incluirJogadores(){
		int quantidade;

		do {
			quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de jogadores (2 a 6):"));

			if(quantidade < 2){
				JOptionPane.showMessageDialog(null,"Deve haver no mínimo dois jogadores!");
			}
			if(quantidade > 6){
				JOptionPane.showMessageDialog(null, "Não pode ter mais de 6 jogadores!");
			}
		} while (quantidade < 2 || quantidade > 6);

		return quantidade;
	}
}