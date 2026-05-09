package jogotabuleiro.classes;

public class Casa13 extends Casa {
    public Casa13(int numCasa){
        super(numCasa);
    }

    public int entrarNaCasa(Jogador jogador){
        if(!jogadores.contains(jogador)){
            jogadores.add(jogador);
        }
        /*casa surpresa, o jogador deve tirar 
        uma carta aleatória que o fará mudar de 
        tipo de jogador de acordo com a carta.   */
    }
}
