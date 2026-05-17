package interfacegrafica;

import java.util.ArrayList;

public class CasaPainel {
    private int x;
    private int y;
    private ArrayList <Peca> pecasNaCasa;
        
    public CasaPainel(int x,int y){
        this.x = x;
        this.y = y;
        this.pecasNaCasa = new ArrayList<>();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public ArrayList<Peca> getPecas(){
        return pecasNaCasa;
    }

    public void adicionarPeca(Peca peca){
        if(pecasNaCasa.contains(peca))
            return;
        pecasNaCasa.add(peca);
    }

    public void sair(Peca peca){
        pecasNaCasa.remove(peca);
    }
}