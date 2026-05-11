package jogotabuleiro.classes;

public class Casa17 extends Casa {
    public Casa17(int numCasa){
        super(numCasa);
    }

    @Override
    public int entrarNaCasa(Jogador jogador){
        if(!jogadores.contains(jogador)){
            jogadores.add(jogador);
        }
        /*se o competidor parar em uma dessas 
        casas, ele escolhe um competidor para 
        voltar para o início do jogo. */
        
    }
}
