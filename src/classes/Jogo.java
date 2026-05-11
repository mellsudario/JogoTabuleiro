package classes;

import java.util.ArrayList;

public class Jogo {
    Tabuleiro tabuleiro;
    ArrayList <Jogadores> jogadores;

    public Jogo(){

        tabuleiro = new Tabuleiro();
        jogadores = new ArrayList<>();
    }

    public String jogar(){
        //?
    }

    public void debug(){
        //?
    }

    public boolean incluirJogador(Jogador novoJogador){
        if(jogadores.size() == 6)
            return false;

        if(jogadores.contains(novoJogador))
            return false;

        jogadores.add(novoJogador);
        tabuleiro.incluirJogador(novoJogador);
        return true;
    }
}