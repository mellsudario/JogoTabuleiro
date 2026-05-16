package classes;

import java.util.Random;

public class JogadorSortudo extends Jogador {

    private Random random = new Random();

    public JogadorSortudo(int id, String cor) {
        super(id, cor);
    }

    @Override
    public int jogarDados() {
        do {
            dado1 = random.nextInt(6) + 1;
            dado2 = random.nextInt(6) + 1;
        } while (dado1 + dado2 < 7);
        return dado1 + dado2;
    }
}