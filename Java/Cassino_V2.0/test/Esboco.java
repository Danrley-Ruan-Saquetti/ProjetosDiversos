
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Esboco {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        DecimalFormat dF = new DecimalFormat("0.00");
        List<General> generais = new ArrayList();
        Jogador jogador = new Jogador("Danrley", "76417654");
        jogador.setSaldo(999999999.99);
        int executor;

        int cont = 0;
        double valor = 0;
        do {
            System.out.print("\n-> Informe um valor para apostar: ");
            valor = s.nextDouble();
            if (valor > jogador.getSaldo()) {
                System.out.println("SISTEMA: Saldo insuficiente!");
            }
            if (valor == 0) {
                System.out.println("SISTEMA: Por favor, informe um valor acima de 0 (zero)!");
            }
        } while ((valor > jogador.getSaldo()) || (valor == 0));

        General g = new General(jogador, 0, valor);
        generais.add(g);
        do {
            cont++;
            General ge = new General(jogador, cont, valor);
            generais.add(ge);
        } while (cont < 3);
        for (General generai : generais) {
            if (generai.getCodigo() == g.getCodigo()) {
                System.out.println("SISTEMA: Você apostou R$" + dF.format(generai.getAposta()));
            } else {
                System.out.println("SISTEMA: O jogador " + generai.getCodigo() + " apostou R$" + dF.format(generai.getAposta()));
            }
        }
        do {
            for (int i = 0; i < g.getRodadas().length; i++) {
                if (!g.getRodadas()[i]) {
                    System.out.println("\nSISTEMA: Rodada " + (i + 1));
                    break;
                }
            }
            for (General generai : generais) {
                cont = 3;
                if (generai.getCodigo() == g.getCodigo()) {
                    do {
                        System.out.print("-> Você tem " + cont + " chances restantes. Deseja rodar os dados? 1 - para Sim: ");
                        executor = s.nextInt();
                        if (executor == 1) {
                            cont--;
                            g.rodarDado();
                        }
                    } while ((executor == 1) && (cont != 0));
                    System.out.println("SISTEMA: Seus pontos totais: " + g.getPontuacao() + "\n");
                } else {
                    do {
                        cont--;
                        generai.rodarDado();
                    } while (cont != 0);
                    System.out.println("SISTEMA: Pontos totais do jogador " + generai.getCodigo() + ": " + generai.getPontuacao() + "\n");
                }
            }
            g.avancarRodada();
        } while (!g.getRodadas()[12]);
        System.out.println("");

        int mai = Integer.MIN_VALUE;
        String cod = " ";
        valor = 0;
        for (General generai : generais) {
            valor += generai.getAposta();
            if (generai.getCodigo() != g.getCodigo()) {
                System.out.println("SISTEMA: Pontuação do jogador " + generai.getCodigo() + " é " + generai.getPontuacao());
            } else {
                System.out.println("SISTEMA: A sua pontuação é " + generai.getPontuacao());
            }
            if (generai.getPontuacao() > mai) {
                mai = generai.getPontuacao();
                if (generai.getCodigo() == g.getCodigo()) {
                    cod = jogador.getNome();
                } else {
                    cod = Integer.toString(generai.getCodigo());
                }
            }
        }
        System.out.print("\nSISTEMA: O vencedor é " + cod + "! ");
        if (jogador.getNome().equals(cod)) {
            System.out.print("Você ganhou R$" + dF.format(valor) + "\n");
            g.vencer(valor);
        } else {
            System.out.print("Não foi dessa vez...\n");
            g.perder(g.getAposta());
        }
    }
}
