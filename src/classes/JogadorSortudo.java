package jogotabuleiro.classes;

import java.util.Random;

public class JogadorSortudo extends Jogador {

    private Random random = new Random();

    public JogadorSortudo(int id, String cor) {
        super(id, cor);
    }

    @Override
    public int jogarDados() {
        int soma;

        do {
            int d1 = random.nextInt(6) + 1;
            int d2 = random.nextInt(6) + 1;

            soma = d1 + d2;

        } while(soma < 7);

        return soma;
    }
}