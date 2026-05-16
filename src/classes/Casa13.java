package classes;

import java.util.ArrayList;
import java.util.Random;

public class Casa13 extends Casa {

	public Casa13(int numCasa) {
		super(numCasa);
	}

	@Override
	public void entrarNaCasa(Jogador jogador, ArrayList<Jogador> jogadores) {
		Random random = new Random();

		/*
		 * casa surpresa, o jogador deve tirar uma carta aleatória que o fará mudar de
		 * tipo de jogador de acordo com a carta.
		 */
		int carta = random.nextInt(2); // 0 ou 1

		Jogador novoJogador = null;

		if (jogador instanceof JogadorAzarado) {
			switch (carta) {
			case 0:
				novoJogador = new JogadorNormal(jogador.getId(), jogador.getCor());
				break;
			case 1:
				novoJogador = new JogadorSortudo(jogador.getId(), jogador.getCor());
				break;
			}
			
		} else if (jogador instanceof JogadorSortudo) {
			switch (carta) {
			case 0:
				novoJogador = new JogadorNormal(jogador.getId(), jogador.getCor());
				break;
			case 1:
				novoJogador = new JogadorAzarado(jogador.getId(), jogador.getCor());
				break;
			}
		} else {
			
			// JogadorNormal
			switch (carta) {
			case 0:
				novoJogador = new JogadorAzarado(jogador.getId(), jogador.getCor());
				break;
			case 1:
				novoJogador = new JogadorSortudo(jogador.getId(), jogador.getCor());
				break;
			}
		}

		if (novoJogador != null) {
			// copia estado do jogador antigo
			novoJogador.setPosicao(this.numCasa);
			novoJogador.setVaiJogar(jogador.getVaiJogar());

			// substitui na lista local desta casa
			int idxLocal = this.jogadores.indexOf(jogador);
			if (idxLocal >= 0) {
				this.jogadores.set(idxLocal, novoJogador);
			} else {
				this.jogadores.add(novoJogador);
			}

			// substitui na lista global passada pelo Tabuleiro
			int idxGlobal = jogadores.indexOf(jogador);
			if (idxGlobal >= 0) {
				jogadores.set(idxGlobal, novoJogador);
			}
		} else {
			if (!jogadores.contains(jogador)) {
				jogador.setPosicao(this.numCasa);
				jogadores.add(jogador);
			}
		}
	}
}
