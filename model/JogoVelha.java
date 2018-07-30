package model;
import javax.swing.JOptionPane;
import view.JogoVelhaGUI;
public class JogoVelha{    
    Jogador jogador1;
    Jogador jogador2;    
    Tabuleiro tabuleiro = new Tabuleiro(3,3);    
    boolean vezDoJogador1;    
    int contaJogadas;   
    int contaEmpates; 
    boolean fimDoJogo;   
    Jogador vencedor;   
    boolean sncpu;    
    JogadorComputador computador;    
    public JogoVelha(Jogador jogador1, Jogador jogador2){
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.sncpu = false;       
    }   
    public void iniciar(){
        this.iniciar(false);
    }
    public boolean isSncpu(){
        return this.sncpu;
    }
    public void setSncpu(boolean sncpu){
        this.sncpu = sncpu;
    }    
    public void iniciar(boolean sncpu){
        this.vezDoJogador1 = true;
        this.contaJogadas = 0;
        this.fimDoJogo = false;
        this.vencedor = null;
        this.tabuleiro.esvaziarTabuleiro();
        this.sncpu = sncpu;       
        if (sncpu == true){
            this.computador = new JogadorComputador('O');
        }
    }    
    public Jogador jogadorDaVez(){
        Jogador jogadorvez = null;   
        if (this.vezDoJogador1 ){
            jogadorvez = jogador1;           
        }
        else{
            jogadorvez = jogador2;
        }
        return jogadorvez;
    }    
    public String performJogada(){
        if ((!this.vezDoJogador1) && this.isSncpu()){
            String ret = null;
            ret = computador.fazerJogada(this.getTabuleiro());
            return(ret);
        } 
        else{
            return (null);
        }
    }     
    public boolean ehJogadaValida(int linha, int coluna){
        return ( linha >= 0 && linha <= 2 &&
                coluna >= 0 && coluna <= 2 &&
                this.tabuleiro.estaLivre(linha,coluna));
    }    
    public char fazerJogada(int linha, int coluna){        
        if (ehJogadaValida(linha,coluna)){
            char simbolo = jogadorDaVez().getSimbolo();            
            tabuleiro.setPeca(linha,coluna,simbolo);            
            contaJogadas++;
            if (!verificaFimDoJogo()){ 
                vezDoJogador1 = !vezDoJogador1;
            } 
            else{
                this.fimDoJogo = true;
                if (this.vencedor != null){
                    this.vencedor.Vitorias();

                }
            }
            return simbolo;
        }
        return ' ';
    }
    public void verificaVencedor(){
         if (this.vezDoJogador1){
            this.vencedor  = this.jogador1;
        }
        else{
            this.vencedor  = this.jogador2;
        }
    }
    public boolean verificaFimDoJogo(){
        if (this.contaJogadas >= 5) {
            int linha;
            int coluna;
            char c1,c2,c3;            
            coluna = 0;
            for (linha=0; linha<3; linha++){
                c1 = tabuleiro.getPeca(linha,coluna);
                c2 = tabuleiro.getPeca(linha,coluna+1);
                c3 = tabuleiro.getPeca(linha,coluna+2);
                
                if ((c1==c2) && (c1==c3) && (c1!= ' ')){
                    this.verificaVencedor();
                    return true;
                }
            }
            linha=0;
            for (coluna=0; coluna<3; coluna++){
                c1 = tabuleiro.getPeca(linha,coluna);
                c2 = tabuleiro.getPeca(linha+1,coluna);
                c3 = tabuleiro.getPeca(linha+2,coluna);
                if ((c1==c2) && (c1==c3) && (c1!= ' ')){
                    this.verificaVencedor();
                    return true;
                }
            }
            linha=0;
            coluna=0;
            c1 = tabuleiro.getPeca(linha,coluna);
            c2 = tabuleiro.getPeca(linha+1,coluna+1);
            c3 = tabuleiro.getPeca(linha+2,coluna+2);
            if ((c1==c2) && (c1==c3) && (c1!= ' ')){
                this.verificaVencedor();
                return true;
            }
            linha=0;
            coluna=0;
            c1 = tabuleiro.getPeca(linha,coluna+2);
            c2 = tabuleiro.getPeca(linha+1,coluna+1);
            c3 = tabuleiro.getPeca(linha+2,coluna);
            if ((c1==c2) && (c1==c3) && (c1!= ' ')){
                this.verificaVencedor();
                return true;
            }
            if (this.contaJogadas == 9 ){
                contaEmpates = 2;
                return true;
            }
        }
        return false;
    }
    public boolean houveVencedor(){
        return (vencedor != null);
    }
    //public void zeraEmpates() {
        //contaEmpates = 0;
    //}   
    public boolean isFimDoJogo(){
        return fimDoJogo;
    }    
    public Jogador getVencedor(){
        return vencedor;
    }
    public Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }
    public Jogador getJogador1(){
        return jogador1;
    }
    public Jogador getJogador2(){
        return jogador2;
    }
   public int getContaEmpates(){
        return contaEmpates;
    }
}
