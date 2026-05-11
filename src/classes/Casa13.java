package classes;

import java.util.Random;

public class Casa13 extends Casa {
    public Casa13(int numCasa){
        super(numCasa);
    }

    @Override
    public void entrarNaCasa(Jogador jogador){
        Random random = new Random();

        /*casa surpresa, o jogador deve tirar 
        uma carta aleatória que o fará mudar de 
        tipo de jogador de acordo com a carta.*/
    
        int carta = random.nextInt(1);
        if(jogador instanceof JogadorAzarado){
            swicht(carta){
                case 0:
                    jogador = (JogadorNormal)jogador;
                    break;
                case 1:
                    jogador = (JogadorSortudo)jogador;
                    break;
                default:
                    break;
            }
        }
        else if(jogador instanceof JogadorSortudo){
            swicht(carta){
                case 0:
                    jogador = (JogadorNormal)jogador;
                    break;
                case 1:
                    jogador = (JogadorAzarado)jogador;
                    break;
                default:
                    break;
            }
        }
        else{
            swicht(carta){
                case 0:
                    jogador = (JogadorAzarado)jogador;
                    break;
                case 1:
                    jogador = (JogadorSortudo)jogador;
                    break;
                default:
                    break;
            }
        }

        if(!jogadores.contains(jogador)){
            jogadores.add(jogador);
        }
    }
}