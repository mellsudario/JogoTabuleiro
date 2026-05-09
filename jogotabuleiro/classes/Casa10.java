package jogotabuleiro.classes;

public class Casa10 extends Casa {
    public Casa10(int numCasa){
        super(numCasa);
    }

    public int entrarNaCasa(Jogador jogador){
        if(!jogadores.contains(jogador)){
            jogadores.add(jogador);
        }
        /*se o competidor parar em uma dessas 
        casa, ele não joga a próxima rodada; */
    }
}
