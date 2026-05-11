package classes;

import java.util.Random;

public class JogadorNormal extends Jogador {

    private Random random = new Random();

    public JogadorNormal(int id, String cor) {
        super(id, cor);
    }

    @Override
    public int jogarDados() {
        int d1 = random.nextInt(6) + 1;
        int d2 = random.nextInt(6) + 1;

        return d1 + d2;
    }
}