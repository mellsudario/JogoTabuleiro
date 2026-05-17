package interfacegrafica;

import java.awt.Color;

public class Peca {
	private int posicao;
	private Color cor;

	public Peca(int posicao, Color cor) {
		this.posicao = posicao;
		this.cor = cor;
	}

	public Color getCor() {
		return cor;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Peca))
			return false;
		Peca p = (Peca) obj;
		return p.cor.equals(this.cor);
	}
}