package classes;

public abstract class Jogador {
	protected int id;
	protected String cor;
	protected int posicao;
	protected boolean vaiJogar;
	protected int quantJogadas;
	  //talvez criar atributos aqui para fazer a casas especiais funcionarem

	public Jogador(int id, String cor) {
		this.id = id;
		this.cor = cor;
		this.posicao = 0;
		this.vaiJogar = true;
		this.quantJogadas = 0;
	}

	public int getId() {
		return id;
	}

	public String getCor() {
		return cor;
	}

	public int getPosicao() {
		return posicao;
	}

	public boolean getVaiJogar() {
		return vaiJogar;
	}

	public int getQuantJogadas() {
		return quantJogadas;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public void setVaiJogar(boolean v) {
		this.vaiJogar = v;
	}

	public void incrementarJogadas() {
		this.quantJogadas++;
	}

	
	public abstract int jogarDados();

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Jogador))
			return false;
		return ((Jogador) obj).id == this.id;
	}

	@Override
	public String toString() {
		return cor + " (casa " + posicao + ")";
	}
}