package classes;

import java.util.ArrayList;

public abstract class Casa {
    protected int numCasa;
    protected ArrayList <Jogador> jogadores;

    public Casa(int numCasa){
        this.numCasa = numCasa;
        this.jogadores = new ArrayList<>();
    }

    public abstract int entrarNaCasa(Jogador jogador);

    public void sairDaCasa(Jogador jogador){
        if(jogadores.contains(jogador)){
            jogadores.remove(jogador);
        }
    }
}
