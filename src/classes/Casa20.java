package classes;

public class Casa20 extends Casa {
	public Casa20(int numCasa) {
		super(numCasa);
	}

	public int entrarNaCasa(Jogador jogador) {
		if (!jogadores.contains(jogador)) {
			jogadores.add(jogador);//se eu vou alterar o jogador a última coisa a fazer é adicioná-lo na lista
            jogador.setPosicao(this.id);
		}
		/*
		 * casas mágicas: se o competidor parar em uma delas, ele troca de lugar com o
		 * jogador que está mais atrás no jogo. Caso ele seja o último, ele não sai do
		 * lugar.
		 */
	}
}
