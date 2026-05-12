package classes;

public class Casa10 extends Casa {
    public Casa10(int numCasa){
        super(numCasa);
    }

    @Override
    public void entrarNaCasa(Jogador jogador){
        if(!jogadores.contains(jogador)){
            jogadores.add(jogador);
            jogador.setPosicao(this.id);
        }
        /*se o competidor parar em uma dessas 
        casa, ele não joga a próxima rodada; */
        jogador.setVaiJogar(false);
    }
}
