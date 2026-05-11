package jogotabuleiro.classes;

public abstract class Jogador {
    protected int id;
    protected String cor;
    protected int posicao;
    protected boolean vaiJogar;
    //talvez criar atributos aqui para fazer a casas especiais funcionarem

    public Jogador(int id, String cor){
        this.id = id;
        this.cor = cor;
        this.posicao = 0;
        this.vaiJogar = true;
    }

    public int getId(){
        return id;
    }

    public String getCor(){
        return cor;
    }

    public int getPosicao(){
        return posicao;
    }

    public boolean getVaiJogar(){
        return jogarAProxima;
    }

    public void setPosicao(int posicao){
        this.posicao = posicao;
    }
    
    public void setVaiJogar(boolean vaiJogar){
        this.vaiJogar = vaiJogar;
    }

    public abstract int jogarDados();

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
    
        if(!(obj instanceof Jogador))
            return false;

        Jogador jog = (Jogador)obj;
        
        return jog.id == this.id;
    }
}
