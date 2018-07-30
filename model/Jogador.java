package model;
public class Jogador{   
    char simbolo;
    int vitorias;      
    private int empate;
    public Jogador(char simbolo){
        this.simbolo = simbolo;
    }    
    public void zerarVitorias(){
        this.vitorias = 0;
    }    
    public char getSimbolo(){
        return simbolo;
    }   
    public int getVitorias(){
        return this.vitorias;
    }
    public void Vitorias(){
        this.vitorias = vitorias + 5;
    }
    
}
