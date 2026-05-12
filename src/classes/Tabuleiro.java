package classes;

public class Tabuleiro {
    protected Casa [] casas = new Casa [41];

    public Tabuleiro(){
        criarCasas();
    }

    private void criarCasas(){
        for(int i = 0; i < casas.length; i++){
            switch(i){
                case 5 || 15 || 30:
                    casas[i] = new Casa5(i);
                    break;
                case 10 || 25 || 38:
                    casas[i] = new Casa10(i);
                    break;
                case 13:
                    casas[i] = new Casa13(i);
                    break;
                case 17 || 27:
                    casas[i] = new Casa17(i);
                    break;
                case 20 || 35:
                    casas[i] = new Casa20(i);
                    break;
                default:
                    casas[i] = new CasaComum(i);
                    break;

            }
        }
    }

    public void incluirJogador(Jogador jogador){
        casas[0].entrarNaCasa(jogador);
    }

    public void moverJogador(Jogador jogador, int casaAnterior ,int novaCasa){
        casas[casaAnterior].sairDaCasa(jogador);
        int casaAtual = casas[novaCasa].entrarNaCasa(jogador);// tem mais
        
        if(casaAtual == novaCasa)
            return;
        
        moverJogador(jogador,novaCasa,casaAtual);
    }

}
