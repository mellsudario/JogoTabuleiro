package classes;

import java.util.ArrayList;

public class Tabuleiro {
	protected Casa[] casas = new Casa[41];

	public Tabuleiro() {
		criarCasas();
	}

	private void criarCasas() {
		for (int i = 0; i < casas.length; i++) {
			switch (i) {
			case 5:
			case 15:
			case 30:
				casas[i] = new Casa5(i);
				break;
			case 10:
			case 25:
			case 38:
				casas[i] = new Casa10(i);
				break;
			case 13:
				casas[i] = new Casa13(i);
				break;
			case 17:
			case 27:
				casas[i] = new Casa17(i);
				break;
			case 20:
			case 35:
				casas[i] = new Casa20(i);
				break;
			default:
				casas[i] = new CasaComum(i);
				break;
			}
		}
	}

	public void incluirJogador(Jogador jogador) {
		casas[0].entrarNaCasa(jogador, new ArrayList<>());
	}

	
    public void moverJogador(Jogador jogador, ArrayList<Jogador> jogadores, int novaCasa) {
        int casaAnterior = jogador.getPosicao();
 
        casas[casaAnterior].sairDaCasa(jogador);
        casas[novaCasa].entrarNaCasa(jogador, jogadores);
 
      
        int posicaoAposEfeito = jogador.getPosicao();
        if (posicaoAposEfeito != novaCasa && posicaoAposEfeito < casas.length) {
            moverJogador(jogador, jogadores, posicaoAposEfeito);
        }
    }
}