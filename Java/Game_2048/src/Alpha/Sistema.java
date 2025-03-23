package Alpha;

import java.util.Random;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int x = r.nextInt(4), y = r.nextInt(4);

        Algoritmo alg = new Algoritmo(x, y);
        Sistema sis = new Sistema();

        do {
            do {
                x = r.nextInt(4);
                y = r.nextInt(4);
            } while ((!alg.agregarValor(x, y)) && (!alg.isPerder()));

            System.out.println("Pontuação: " + alg.getPontuacao() + "\n+-------+-------+-------+-------+");
            for (int i = 0; i < alg.getTabela().length; i++) {
                for (int j = 0; j < alg.getTabela()[i].length; j++) {
                    String tab = "";
                    if (alg.getTabela()[i][j] >= 2048) {
                        alg.setVencer(true);
                    }
                    if (alg.getTabela()[i][j] != 0) {
                        tab = Integer.toString(alg.getTabela()[i][j]);
                    }
                    if ((x == i) && (y == j) && (!alg.isPerder())) {
                        tab = "*" + Integer.toString(alg.getTabela()[i][j]) + "*";
                    }
                    System.out.print("|" + tab + "\t");
                }
                System.out.println("|\n+-------+-------+-------+-------+");
            }
            boolean executar;
            do {
                executar = false;
                System.out.print("-> Executar comando: ");
                switch (s.next()) {
                    case "a":
                        alg.paraEsquerda();
                        break;
                    case "d":
                        alg.paraDireita();
                        break;
                    case "w":
                        alg.paraCima();
                        break;
                    case "s":
                        alg.paraBaixo();
                        break;
                    default:
                        executar = true;
                        break;
                }
            } while (executar);
            if (alg.isPerder()) {
                if (alg.verificarJogada()) {
                    alg.setPerder(false);
                }
            }
            System.out.println("");
        } while ((!alg.isPerder()) && (!alg.isVencer()));
        if (alg.isPerder()) {
            System.out.println("SISTEMA: Game over! Sua pontuação: " + alg.getPontuacao());
        } else if (alg.isVencer()) {
            System.out.println("SISTEMA: Você ganhou! Sua pontuação: " + alg.getPontuacao());
        }
    }
}
