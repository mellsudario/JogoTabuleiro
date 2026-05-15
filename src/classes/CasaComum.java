package classes;

import java.util.ArrayList;

public class CasaComum extends Casa {
    
    public CasaComum(int numCasa) {
        super(numCasa);
    }

    @Override
    public void entrarNaCasa (Jogador jogador, ArrayList<Jogador> jogadores) {
        if(!jogadores.contains(jogador)){
            jogador.setPosicao(this.numCasa);
            jogadores.add(jogador);
        }
    }
}
