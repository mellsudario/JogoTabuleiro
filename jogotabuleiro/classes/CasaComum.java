package jogotabuleiro.classes;

public class CasaComum extends Casa {
    
    public CasaComum(int numCasa){
        super(numCasa);
    }

    public int entrarNaCasa(Jogador jogador){
        if(!jogadores.contains(jogador)){
            jogadores.add(jogador);
        }
    }
}
