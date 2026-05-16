package classes;

import java.util.Random;

public class JogadorNormal extends Jogador {

    private Random random = new Random();

    public JogadorNormal(int id, String cor) {
        super(id, cor);
    }

    @Override
    public int jogarDados() {
        dado1 = random.nextInt(6) + 1;
        dado2 = random.nextInt(6) + 1;
        return dado1 + dado2;
    }
}