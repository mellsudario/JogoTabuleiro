package jogotabuleiro.classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Casa17 extends Casa {
    public Casa17(int numCasa){
        super(numCasa);
    }

    @Override
    public int entrarNaCasa(Jogador jogador,ArrayList<Jogador> jogadores){
        if(!jogadores.contains(jogador)){
            jogador.setPosicao(this.numCasa);
            jogadores.add(jogador);
        }
        /*se o competidor parar em uma dessas 
        casas, ele escolhe um competidor para 
        voltar para o início do jogo. */
        //escolhe e
        String[] cor = new String[jogadores.size()];
        for(int i = 0; i < jogadores.size(); i++){
            cor[i] = jogadores.get(i).getCor();
        }
		int tipo = JOptionPane.showOptionDialog(null, "Escolha um dos jogadores para voltar para o início: ", "Casa especial",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, null);

        escolhido.setPosicao(0);
        
    }
}
