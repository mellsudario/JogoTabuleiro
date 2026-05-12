package classes;

public class Casa5 extends Casa{
    
    public Casa5(int numCasa){
        super(numCasa);
    }

    @Override
    public void entrarNaCasa(Jogador jogador){
        /*casas da sorte: ande 3 casas para 
        frente desde que ele não seja um jogador azarado; */
        if(!jogadores.contains(jogador)){
            jogadores.add(jogador);
            jogador.setPosicao(this.id);
        }
        if(jogador instanceof JogadorAzarado){
            return;
        }
        int novaPosicao = jogador.getPosicao();
        novaPosicao +=3;
        jogador.setPosicao(novaPosicao);// tem que fazer entrar na nova casa, usar 
        
    }
 
}
