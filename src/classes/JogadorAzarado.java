package jogotabuleiro.classes;

import java.util.Random;

public class JogadorAzarado extends Jogador {

    private Random random = new Random();

    public JogadorAzarado(int id, String cor) {
        super(id, cor);
    }

    @Override
    public int jogarDados() {
        int soma;

        do {
            int d1 = random.nextInt(6) + 1;
            int d2 = random.nextInt(6) + 1;

            soma = d1 + d2;

        } while(soma > 6);

        return soma;
    }
}