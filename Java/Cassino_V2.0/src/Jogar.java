
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        DecimalFormat dF = new DecimalFormat("0.00");
        DaoJogador dao = new DaoJogador();
        Jogador jogador = null;

        String nome, senha;
        do { //Campo de login
            int sair;
            System.out.print("\nSISTEMA: É novo por aqui? Tecle 1 para criar a sua conta. "
                    + "Se já possui uma conta, tecle 2 para logar!\n-> Executar comando: ");
            switch (s.nextInt()) {
                case 1: //Cadastrar conta
                    do {
                        sair = 2;
                        System.out.println("\nSISTEMA: Informe um nome e uma senha.");
                        System.out.print("-> Informe um nome: ");
                        nome = s.next();
                        if (dao.selecionarNome(nome) != null) {
                            System.out.println("SISTEMA: Já existe uma conta com este nome!");
                            System.out.print("-> Deseja voltar? 1 - para Sim: ");
                            sair = s.nextInt();
                        } else {
                            System.out.print("-> Informe uma senha com no mínimo 4 dígitos e no máximo 9 dígitos: ");
                            senha = s.next();
                            if (dao.selecionarCodigo(senha) != null) {
                                System.out.println("SISTEMA: Já existe uma conta com esta senha!");
                                System.out.print("-> Deseja voltar? 1 - para Sim: ");
                                sair = s.nextInt();
                            } else {
                                jogador = new Jogador(nome, senha);
                            }
                        }
                    } while ((jogador == null) && (sair != 1));

                    if (jogador != null) {
                        if (dao.inserir(jogador)) {
                            System.out.println("SISTEMA: Conta criada com sucesso!");
                        } else {
                            System.out.println("SISTEMA: Houve algum erro para criar a conta!");
                        }
                    }
                    break;
                case 2: //Logar conta
                    do {
                        sair = 2;
                        System.out.println("\nSISTEMA: Informe o nome e uma senha.");
                        System.out.print("-> Informe o nome: ");
                        nome = s.next();
                        if (dao.selecionarNome(nome) == null) {
                            System.out.println("SISTEMA: Não existe nenhuma conta com este nome!");
                            System.out.print("-> Deseja voltar? 1 - para Sim: ");
                            sair = s.nextInt();
                        } else {
                            System.out.print("-> Informe a senha: ");
                            senha = s.next();
                            if (dao.selecionarCodigo(senha) == null) {
                                System.out.println("SISTEMA: Não existe nenhuma conta com esta senha!\n");
                                System.out.print("-> Deseja voltar? 1 - para Sim: ");
                                sair = s.nextInt();
                            } else {
                                jogador = dao.selecionarCodigo(senha);
                            }
                        }
                    } while ((jogador == null) && (sair != 1));
                    break;
                default:
                    System.out.println("SISTEMA: Valor inválido!");
            }
        } while (jogador == null);
        System.out.print("\nSISTEMA: Bem vindo " + jogador.getNome() + "! ");
        int executor;
        //Início do jogo
        do {
            System.out.println("Saldo: R$" + dF.format(jogador.getSaldo()));
            System.out.print("+- MENU\n|0 - Estatísticas\n|1 - Roleta\n|2 - Caça Níqueis\n|3 - Bingo"
                    + "\n|4 - General\n|5 - Instruções\n|6 - Quit Game\n+-\n-> Executar comando: ");
            executor = s.nextInt();
            switch (executor) {
                case 0: { //Estatísticas
                    System.out.println("\n" + jogador.toString());
                    break;
                }
                case 1: { //Roleta
                    do {
                        double valor;
                        Roleta rl = new Roleta(jogador);
                        if (jogador.getSaldo() > 0) {
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
                            rl.setAposta(valor);
                            int aposta;
                            do {
                                System.out.print("-> Escolha um número de 0 até 38 que deseja apostar: ");
                                aposta = s.nextInt();
                                if ((aposta < 0) || (aposta > 38)) {
                                    System.out.println("SISTEMA: Escolha apenas um número de 0 até 38 que deseja apostar!\n");
                                }
                            } while ((aposta < 0) || (aposta > 38));
                            rl.jogarRoleta();
                            System.out.print("SISTEMA: O número sorteado é " + rl.getNumeroSorteado() + ". ");
                            if (aposta == rl.getNumeroSorteado()) {
                                System.out.print("Parabéns, você acertou! Você ganhou R$" + dF.format(valor * 5) + "\n");
                                rl.vencer(rl.getAposta());
                            } else {
                                System.out.print("Que pena. Não foi dessa vez... Você perdeu R$" + dF.format(valor) + "\n");
                                rl.perder(rl.getAposta());
                            }
                            dao.editar(jogador);
                            System.out.println("\nSaldo: R$" + dF.format(jogador.getSaldo()));
                            System.out.print("-> Deseja apostar novamente? 1 - para sim: ");
                        } else {
                            System.out.println("SISTEMA: Você não tem saldo suficiente!");
                        }
                    } while (s.nextInt() == 1);
                    break;
                }
                case 2: { //Caça Níqueis
                    System.out.println("");
                    do {
                        System.out.print("-> Aperte 1 para rodar o níquel: ");
                        if (s.nextInt() == 1) {
                            Caca_Niqueis cn = new Caca_Niqueis(jogador);
                            cn.rodarNiquel();
                            if (cn.getPremio() > 0) {
                                System.out.print("SISTEMA: Parabéns! Você conseguiu ");
                                if (cn.getPar() > 0) {
                                    System.out.print(cn.getPar() + " pares");
                                }
                                if (cn.getTrinca() > 0) {
                                    if (cn.getPar() > 0) {
                                        System.out.print(" + ");
                                    }
                                    System.out.print(cn.getTrinca() + " trios");
                                }
                                if (cn.getQuadra() > 0) {
                                    if (cn.getPar() > 0) {
                                        System.out.print(" + ");
                                    }
                                    System.out.print(cn.getQuadra() + " quadra");
                                }
                                if (cn.getPerfeito() > 0) {
                                    System.out.print(cn.getPerfeito() + " perfeito");
                                }
                                System.out.print(" = Você ganhou R$" + dF.format(cn.getPremio()));
                            } else {
                                System.out.print("SISTEMA: Que pena. Não foi dessa vez...");
                            }
                        }
                        System.out.println("\nSaldo: R$" + dF.format(jogador.getSaldo()));
                        System.out.print("\n-> Deseja jogar novamente? 1 - para sim: ");
                    } while (s.nextInt() == 1);
                }
                case 3: { //Bingo
                    System.out.print("\n-> Para jogar, você deve fazer a inscrição, que custa R$50,00. Deseja fazer a inscrissão? 1 - para sim: ");
                    if ((s.nextInt() == 1) && (jogador.getSaldo() >= 50)) {
                        List<Bingo> bingo = new ArrayList<>();
                        Ranking rank = new Ranking();
                        Bingo b = new Bingo();

                        int cont = 1;
                        do {
                            int tabela[][] = new int[4][4], contT, tab[] = new int[16];
                            contT = 0;
                            for (int i = 0; i < tab.length; i++) {
                                tab[i] = r.nextInt(50) + 1;
                                if (i != 0) {
                                    for (int j = 0; j < tab.length; j++) {
                                        if (i != j) {
                                            if (tab[i] == tab[j]) {
                                                tab[i] = r.nextInt(50) + 1;
                                                j = -1;
                                            }
                                        }
                                    }
                                }
                            }
                            for (int i = 0; i < tabela.length; i++) {
                                for (int j = 0; j < tabela[i].length; j++) {
                                    tabela[i][j] = tab[contT];
                                    contT++;
                                }
                            }
                            Bingo bi = new Bingo(jogador, tabela, cont);
                            bingo.add(bi);
                            if (cont == 1) {
                                b = bi;
                            }
                            cont++;
                        } while (cont < 21);

                        cont = 1;
                        do {
                            rank.valorRodada();
                            if (!b.isDeclararBingo()) {
                                System.out.println("\nSISTEMA: Valor da " + cont + "ª Rodada: " + rank.getValorRodada() + "\n+----+----+----+----+\t\t\tRanking:");
                                for (int i = 0; i < b.getTabela().length; i++) {
                                    for (int j = 0; j < b.getTabela()[i].length; j++) {
                                        String t = "   ";
                                        if (b.getTabela()[i][j] < 10) {
                                            if (b.getTabela()[i][j] != 0) {
                                                t = Integer.toString(b.getTabela()[i][j]) + "  ";
                                            }
                                        } else {
                                            if (b.getTabela()[i][j] != 100) {
                                                t = Integer.toString(b.getTabela()[i][j]) + " ";
                                            } else {
                                                t = Integer.toString(b.getTabela()[i][j]);
                                            }
                                        }
                                        System.out.print("| " + t);
                                    }
                                    System.out.print("|\t\t\t");
                                    if (i <= 5) {
                                        String t = "???";
                                        if (rank.getClassificacao()[i] != 0) {
                                            t = Integer.toString(rank.getClassificacao()[i]);
                                        } else if (rank.getClassificacao()[i] == 1) {
                                            t = "Você";
                                        }
                                        System.out.print((i + 1) + "º - " + t);
                                    }
                                    System.out.println("\n+----+----+----+----+\t");
                                }
                            }
                            for (Bingo bi : bingo) {
                                boolean declararBingo = true;
                                for (int i = 0; i < bi.getTabela().length; i++) {
                                    for (int j = 0; j < bi.getTabela()[i].length; j++) {
                                        if (bi.getTabela()[i][j] == rank.getValorRodada()) {
                                            if (bi.getNumero() == b.getNumero()) {
                                                System.out.print("-> Deseja riscar o número " + rank.getValorRodada() + "? S - Para sim: ");
                                                if ("s".equals(s.next())) {
                                                    bi.getTabela()[i][j] = 0;
                                                }
                                            } else {
                                                bi.getTabela()[i][j] = 0;
                                            }
                                        }
                                        if (bi.getTabela()[i][j] != 0) {
                                            declararBingo = false;
                                        }
                                    }
                                }
                                if (declararBingo) {
                                    if (!bi.isDeclararBingo()) {
                                        if (bi.getNumero() == b.getNumero()) {
                                            System.out.print("SISTEMA: Declarar Bingo? S - para sim: ");
                                            if ("s".equals(s.next())) {
                                                rank.atualizarRank(bi);
                                                System.out.println("Bingo! " + bi.getNumero());
                                                bi.setDeclararBingo(true);
                                            }
                                        } else {
                                            rank.atualizarRank(bi);
                                            System.out.println("Bingo! " + bi.getNumero());
                                            bi.setDeclararBingo(true);
                                        }
                                    }
                                }
                            }
                            if (!b.isDeclararBingo()) {
                                String executar;
                                do {
                                    System.out.print("-> S - Para a próxima rodada: ");
                                    executar = s.next();
                                    if (!"s".equals(executar)) {
                                        System.out.println("SISTEMA: Valor inválido!");
                                    }
                                } while (!"s".equals(executar));
                            }
                            cont++;
                        } while (cont <= 50);

                        double valor = 0;
                        System.out.println("\nRANKING:");
                        for (int i = 0; i < rank.getClassificacao().length; i++) {
                            String t = "???";
                            if (rank.getClassificacao()[i] != 0) {
                                t = Integer.toString(rank.getClassificacao()[i]);
                            } else if (rank.getClassificacao()[i] == 1) {
                                t = "Você";
                                switch (i) {
                                    case 0:
                                        valor = 250;
                                        break;
                                    case 1:
                                        valor = 200;
                                        break;
                                    case 2:
                                        valor = 150;
                                        break;
                                    case 3:
                                        valor = 100;
                                        break;
                                }
                            }
                            System.out.println((i + 1) + "º - " + t);
                        }
                        if (valor != 50) {
                            System.out.println("SISTEMA: Parabéns, você ganhou R$" + dF.format(valor));
                            b.vencer(valor);
                        } else {
                            System.out.println("SISTEMA: Que pena. Não foi dessa vez...");
                            b.perder(valor);
                        }
                        dao.editar(jogador);
                    } else if (jogador.getSaldo() < 50) {
                        System.out.println("SISTEMA: Saldo insuficiente!");
                    }
                    break;
                }
                case 4: { //General
                    List<General> generais = new ArrayList();

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
                    dao.editar(jogador);
                    break;
                }
                case 5: { //Instruções
                    System.out.println("\n" + jogador.instrucao());
                    break;
                }
                default: {
                    if (executor != 6) {
                        System.out.println("SISTEMA: Valor inválido!");
                    }
                    break;
                }
            }
            System.out.println("");
        } while (executor != 6);
        //Fim do jogo
        System.out.println("Bye Bye!");
        dao.fechar();
    }
}
