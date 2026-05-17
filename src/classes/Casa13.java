package classes;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Casa13 extends Casa {

	public Casa13(int numCasa) {
		super(numCasa);
	}

	@Override
	public void entrarNaCasa(Jogador jogador, ArrayList<Jogador> jogadores) {

		/*
		 * casa surpresa, o jogador deve tirar uma carta aleatória que o fará mudar de
		 * tipo de jogador de acordo com a carta.
		 */
		
		jogador.setPosicao(this.numCasa);
		Random random = new Random();
		int carta = random.nextInt(2);
		Jogador novoJogador = null;

		if (jogador instanceof JogadorAzarado) {

			if (carta == 0) {
				novoJogador = new JogadorNormal(jogador.getId(), jogador.getCor());
			} else {
				novoJogador = new JogadorSortudo(jogador.getId(), jogador.getCor());
			}

		} else if (jogador instanceof JogadorSortudo) {
			if (carta == 0) {
				novoJogador = new JogadorNormal(jogador.getId(), jogador.getCor());
			} else {
				novoJogador = new JogadorAzarado(jogador.getId(), jogador.getCor());
			}
		} else {

			if (carta == 0) {
				novoJogador = new JogadorAzarado(jogador.getId(), jogador.getCor());
			} else {
				novoJogador = new JogadorSortudo(jogador.getId(), jogador.getCor());
			}
		}

		novoJogador.setPosicao(jogador.getPosicao());
		int indice = jogadores.indexOf(jogador);
		jogadores.set(indice, novoJogador);

		String novoTipo = "";
		if (novoJogador instanceof JogadorSortudo) {
			novoTipo = "Sortudo";
		}

		else if (novoJogador instanceof JogadorAzarado) {
			novoTipo = "Azarado";
		}

		else {
			novoTipo = "Normal";
		}

		JOptionPane.showMessageDialog(null, jogador.getCor() + " mudou de tipo!\nNovo tipo: " + novoTipo);
	}
}