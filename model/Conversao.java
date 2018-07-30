package model;
import java.util.Scanner;
public class Conversao {
    public static void main(String[] args){
    Scanner leia = new Scanner(System.in);
    int num = 0;   
    System.out.print("Digite um Numero: ");
    String numero = leia.nextLine();
    int conciente = Integer.parseInt(numero);
    while(conciente !=0){
        num = conciente % 2;
        conciente = conciente/2;
        System.out.print(num);
    }
}
}