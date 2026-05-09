package jogotabuleiro.classes;

public abstract class Jogador {
    protected int id;
    protected String cor;
    protected int posicao;
    //talvez criar atributos aqui para fazer a casas especiais funcionarem

    public Jogador(int id, String cor){
        this.id = id;
        this.cor = cor;
        this.posicao = 0;
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

    public void setPosicao(int posicao){
        this.posicao = posicao;
    }

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
