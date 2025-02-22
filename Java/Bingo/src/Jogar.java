
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int menu = 0;
        do {
            List<Bingo> bingo = new ArrayList<>(); //NPCs
            Ranking rank = new Ranking(); //Ranking
            Bingo b = new Bingo(); //Jogador

            do { //Campo do menu
                System.out.print("+- MENU\n|1 - New Game\n|2 - Quit Game\n+-\n-> Executar comando: ");
                menu = s.nextInt();
                if (menu != 1) {
                    if (menu == 2) {
                        System.out.println("Bye Bye!");
                        System.exit(0);
                    } else {
                        System.out.println("SISTEMA: Valor inválido!\n");
                    }
                }
            } while (menu != 1);

            int cont = 1;
            do { //Gerar tabela
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
                Bingo bi = new Bingo(tabela, cont); //Criar o objeto (NPC)
                bingo.add(bi); //Adicioná-lo na lista
                if (cont == 1) {
                    b = bi; //Objeto jogador
                }
                cont++;
            } while (cont < 21);

            cont = 1;
            //Início do jogo
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
                            System.out.print("| " + t); //Mostrar a tabela do jogador
                        }
                        System.out.print("|\t\t\t");
                        if (i <= 5) {
                            String t = "???";
                            if (rank.getClassificacao()[i] != 0) {
                                t = Integer.toString(rank.getClassificacao()[i]);
                            }
                            System.out.print((i + 1) + " - " + t); //Mostrar ranking
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
                            if (bi.getTabela()[i][j] != 0) { //Verificar se a tabela está limpa
                                declararBingo = false;
                            }
                        }
                    }
                    if (declararBingo) { //Declarar Bingo
                        if (!bi.isDeclararBingo()) {
                            if (bi.getNumero() == b.getNumero()) {
                                System.out.print("SISTEMA: Declarar Bingo? S - para sim: ");
                                if ("s".equals(s.next())) {
                                    rank.atualizarRank(bi); //Atualizar o rank
                                    System.out.println("Bingo! " + bi.getNumero());
                                    bi.setDeclararBingo(true);
                                }
                            } else {
                                rank.atualizarRank(bi); //Atualizar o rank
                                System.out.println("Bingo! " + bi.getNumero());
                                bi.setDeclararBingo(true);
                            }
                        }
                    }
                }
                if (!b.isDeclararBingo()) {
                    String executar;
                    do {
                        System.out.print("-> S - Para a próxima rodada: "); //Avançar para a próxima rodada
                        executar = s.next();
                        if (!"s".equals(executar)) {
                            System.out.println("SISTEMA: Valor inválido!");
                        }
                    } while (!"s".equals(executar));
                }
                cont++;
            } while (cont <= 50);
            //Fim do jogo

            System.out.println("\nRANKING:");
            for (int i = 0; i < rank.getClassificacao().length; i++) {
                String t = "???";
                if (rank.getClassificacao()[i] != 0) {
                    t = Integer.toString(rank.getClassificacao()[i]);
                }
                System.out.println((i + 1) + " - " + t); //Mostrar ranking
            }
            System.out.println("");
        } while (menu == 1);
    }
}
