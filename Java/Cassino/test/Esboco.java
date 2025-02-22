
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Esboco {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DecimalFormat dF = new DecimalFormat("0.00");

        Jogador jogador = new Jogador();
        jogador.setSaldo(10000);

//        System.out.print("\nSISTEMA: É super recomendado para aqueles iniciantes ler as "
//                + "instruções antes de começar o jogo!\n-> Deseja começar? 1 - para Sim: ");
//        if ((s.nextInt() == 1) && (jogador.getSaldo() >= 5000)) {
//            do {
//                System.out.print("\n-> Informe o valor do Buy-in de no mínimo R$2000,00: ");
//                buy = s.nextDouble();
//                if (buy < 2000) {
//                    System.out.println("SISTEMA: Informe um valor de no mínimo R$2000,00!");
//                }
//                if (buy > jogador.getSaldo()) {
//                    System.out.println("SISTEMA: Saldo insuficiente!!");
//                }
//            } while ((buy < 2000) || (buy > jogador.getSaldo()));
        do {
            List<Maos> maos = new ArrayList<>();
            BaralhoPoker baralho = new BaralhoPoker();

            double buy = jogador.getSaldo();
            Maos m = new Maos(jogador, baralho, buy, buy, 0);

            for (int i = 0; i < 9; i++) {
                Maos ma = new Maos(jogador, baralho, buy, buy, i);
                if (i == 0) {
                    m = ma;
                }
                ma.darCartasJogador();
                maos.add(ma);
            }
            boolean acabar = false;
            double valorAposta = Double.MIN_VALUE;
            int acao = 0;
            do {
                int jogadorVez = 0;
                if (baralho.getTurno()[3]) {
                    acabar = true;
                }
                for (Maos mao : maos) {
                    mao.classificarMao();
                    if (valorAposta < mao.getApostar()) {
                        valorAposta = mao.getApostar();
                    }
                    if (mao.getCodigo() == m.getCodigo()) {
                        String naipaMao[] = new String[2], numeroMao[] = new String[2],
                                naipaMesa[] = new String[5], numeroMesa[] = new String[5],
                                classificacaoMao = "";
                        int cont = 0;
                        do {
                            switch (mao.getNaipaMao()[cont]) {
                                case 0:
                                    naipaMao[cont] = "P";
                                    break;
                                case 1:
                                    naipaMao[cont] = "C";
                                    break;
                                case 2:
                                    naipaMao[cont] = "E";
                                    break;
                                case 3:
                                    naipaMao[cont] = "O";
                                    break;
                            }
                            if (mao.getCartaMao()[cont] > 9) {
                                switch (mao.getCartaMao()[cont]) {
                                    case 10:
                                        numeroMao[cont] = "J";
                                        break;
                                    case 11:
                                        numeroMao[cont] = "Q";
                                        break;
                                    case 12:
                                        numeroMao[cont] = "K";
                                        break;
                                }
                            } else {
                                numeroMao[cont] = Integer.toString(mao.getCartaMao()[cont] + 1);
                            }
                            cont++;
                        } while (cont < 2);
                        cont = 0;
                        do {
                            if (baralho.getCartaMesa()[cont] > 9) {
                                switch (baralho.getCartaMesa()[cont]) {
                                    case 10:
                                        numeroMesa[cont] = "J";
                                        break;
                                    case 11:
                                        numeroMesa[cont] = "Q";
                                        break;
                                    case 12:
                                        numeroMesa[cont] = "K";
                                        break;
                                }
                            } else {
                                numeroMesa[cont] = Integer.toString(baralho.getCartaMesa()[cont] + 1);
                            }
                            switch (baralho.getNaipaMesa()[cont]) {
                                case 0:
                                    naipaMesa[cont] = "P";
                                    break;
                                case 1:
                                    naipaMesa[cont] = "C";
                                    break;
                                case 2:
                                    naipaMesa[cont] = "E";
                                    break;
                                case 3:
                                    naipaMesa[cont] = "O";
                                    break;
                            }
                            cont++;
                        } while (cont < 5);
                        for (int i = 0; i < baralho.getTurno().length; i++) {
                            if (baralho.getTurno()[i]) {
                                switch (i) {
                                    case 1:
                                        cont = 3;
                                        do {
                                            numeroMesa[cont] = "?";
                                            naipaMesa[cont] = "?";
                                            cont++;
                                        } while (cont < 5);
                                        break;
                                    case 2:
                                        cont = 4;
                                        do {
                                            numeroMesa[cont] = "?";
                                            naipaMesa[cont] = "?";
                                            cont++;
                                        } while (cont < 5);
                                        break;
                                }
                                break;
                            }
                        }
                        if (!baralho.getTurno()[0]) {

                        } else {
                            for (int i = 0; i < numeroMesa.length; i++) {
                                numeroMesa[i] = "?";
                                naipaMesa[i] = "?";
                            }
                        }
                        for (int i = 0; i < mao.getRankingCarta().length; i++) {
                            if (mao.getRankingCarta()[i]) {
                                switch (i) {
                                    case 0:
                                        classificacaoMao = "Carta mais Alta";
                                        break;
                                    case 1:
                                        classificacaoMao = "Par";
                                        break;
                                    case 2:
                                        classificacaoMao = "Dois Pares";
                                        break;
                                    case 3:
                                        classificacaoMao = "Trinca";
                                        break;
                                    case 4:
                                        classificacaoMao = "Sequência";
                                        break;
                                    case 5:
                                        classificacaoMao = "Flush";
                                        break;
                                    case 6:
                                        classificacaoMao = "Full House";
                                        break;
                                    case 7:
                                        classificacaoMao = "Quadra";
                                        break;
                                    case 8:
                                        classificacaoMao = "Straight Flush";
                                        break;
                                    case 9:
                                        classificacaoMao = "Royal";
                                        break;
                                }
                            }

                        }

                        System.out.println("Aposta da mão - R$" + dF.format(baralho.getAposta()) + "\n+----------------------------------+\n"
                                + "|                                  |\n"
                                + "|                                  |\n"
                                + "|       +-+ +-+ +-+ +-+ +-+        |\n"
                                + "|       |" + numeroMesa[0] + "| |" + numeroMesa[1]
                                + "| |" + numeroMesa[2] + "| |" + numeroMesa[3] + "| |"
                                + numeroMesa[4] + "|        |\n"
                                + "|       |" + naipaMesa[0] + "| |" + naipaMesa[1]
                                + "| |" + naipaMesa[2] + "| |" + naipaMesa[3] + "| |"
                                + naipaMesa[4] + "|        |\n"
                                + "|       +-+ +-+ +-+ +-+ +-+        |\n"
                                + "|                                  |\n"
                                + "|                                  |\n"
                                + "+----------------------------------+\n"
                                + "Seu Saldo - R$" + dF.format(mao.getSaldo()) + "\n"
                                + "              +-+ +-+\n"
                                + "     Número - |" + numeroMao[0] + "| |" + numeroMao[1] + "|\n"
                                + "      Naipa - |" + naipaMao[0] + "| |" + naipaMao[1] + "|\n"
                                + "              +-+ +-+\n"
                                + "Classificação das suas cartas - " + classificacaoMao + "\n");
                    } else {
                        System.out.println("Saldo do jogador " + mao.getCodigo() + ": R$" + dF.format(mao.getSaldo()));
                    }
                    jogadorVez++;
                }
                for (Maos mao : maos) {

                    if (mao.getCodigo() == m.getCodigo()) {
                        System.out.println("\n+- Legenda\n|\n|\n|\n+-");
                        boolean passar;
                        do {
                            passar = false;
                            System.out.println("\n+- Opção de Ações");
                            if (!baralho.isApostar()) {
                                System.out.println("|1 - Apostar");
                            } else {
                                System.out.println("|2 - Aumentar");
                            }
                            System.out.println("|3 - Mesa");
                            System.out.println("|4 - Correr");
                            if (baralho.isApostar()) {
                                System.out.println("|5 - Paga");
                            }
                            System.out.print("+-\nExecutar ação: ");
                            acao = s.nextInt();
                            switch (acao) {
                                case 1:
                                    if (!baralho.isApostar()) {
                                        double apos = 0;
                                        do {
                                            System.out.print("-> Informe o valor da aposta: ");
                                            apos = s.nextDouble();
                                            if (apos == 0) {
                                                System.out.println("SISTEMA: Informe um valor acima de R$0,00");
                                            } else {
                                                passar = true;
                                            }
                                            if (apos > mao.getSaldo()) {
                                                passar = false;
                                                System.out.print("SISTEMA: Saldo insuficiente! Deseja apostar All-In? 1- para Sim: ");
                                                if (s.nextInt() == 1) {
                                                    mao.all_in();
                                                    passar = true;
                                                }
                                            }
                                        } while ((apos == 0) || (!passar));
                                        mao.apostar(apos);
                                        passar = true;
                                    }
                                    break;
                                case 2:
                                    if (baralho.isApostar()) {
                                        double apos = 0;
                                        do {
                                            System.out.print("-> Informe o valor da aposta: ");
                                            apos = s.nextDouble();
                                            if (apos == 0) {
                                                System.out.println("SISTEMA: Informe um valor acima de R$0,00");
                                            } else {
                                                passar = true;
                                            }
                                            if (apos > mao.getSaldo()) {
                                                passar = false;
                                                System.out.print("SISTEMA: Saldo insuficiente! Deseja apostar All-In? 1- para Sim: ");
                                                if (s.nextInt() == 1) {
                                                    mao.all_in();
                                                    passar = true;
                                                }
                                            }
                                        } while ((apos == 0) || (!passar));
                                        mao.aumentar(apos);
                                        passar = true;
                                    }
                                    break;
                                case 3:
                                    passar = true;
                                    break;
                                case 4:
                                    passar = true;
                                    break;
                                case 5:
                                    if (baralho.isApostar()) {
                                        mao.pagar(valorAposta);
                                        passar = true;
                                    }
                                    break;
                                default:
                                    System.out.println("SISTEMA: Valor inválido! Você deve executar uma das ações listadas a cima!");
                                    break;
                            }
                        } while ((acao < 1) || (acao > 5) || (!passar));
                    } else {

                    }
                }

                if (!baralho.getTurno()[3]) {
                    baralho.passarTurno();
                }
            } while ((!acabar) || (acao == 4));
            if (m.getSaldo() < 0) {
                m.perder(m.getBuy_in());
                System.out.println("Que pena. Não foi dessa vez... Você perdeu R$" + dF.format(m.getBuy_in()) + "\n");
            } else if (m.getSaldo() > m.getBuy_in()) {
                m.vencer(m.getSaldo() - m.getBuy_in());
                System.out.println("SISTEMA: Você lucrou R$" + (m.getSaldo() - m.getBuy_in()) + "!");
            }

            System.out.print("\n-> Deseja jogar outra mão? 1 para sim: ");
        } while (s.nextInt() == 1);
//        } else if (jogador.getSaldo() < 5000) {
//            System.out.println("SISTEMA: Saldo insuficiente. Você precisa ter no mínimo um saldo de R$5000,00!");
//        }

        /*
        0 - 1
        1 - 2
        2 - 3
        3 - 4
        4 - 5
        5 - 6
        6 - 7
        7 - 8
        8 - 9
        9 - 10
        10 - J
        11 - Q
        12 - K
        
        0 - Paus
        1 - Copas
        2 - Espadas
        3 - Ouro

        0 - 
        1 - 
        2 - 
        3 - 
        4 - 
        5 - 
        6 - 
        7 - 
        8 - 
        9 - 
         */
    }
}
