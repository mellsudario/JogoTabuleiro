package classes;

import java.util.ArrayList;

public class CasaComum extends Casa {

	public CasaComum(int numCasa) {
		super(numCasa);
	}

	@Override
	public void entrarNaCasa(Jogador jogador, ArrayList<Jogador> jogadores) {

		jogador.setPosicao(this.numCasa);

		if (!this.jogadores.contains(jogador)) {
			this.jogadores.add(jogador);
		}
	}
}
