
import java.util.Random;
import java.util.Scanner;

public class Jogar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int menu = 0;
        do {
//            do {
//                System.out.print("\n+- MENIU\n|1 - New Game\n|2 - Quit Game\n+-\n-> Executar comando: ");
//                menu = s.nextInt();
//                if ((menu != 1) && (menu != 2)) {
//                    System.out.println("SISTEMA: Valor inválido!");
//                } else if (menu == 2) {
//                    System.out.println("BYE BYE!");
//                    System.exit(0);
//                }
//            } while (menu != 1);

            boolean tabuleiro[][] = new boolean[8][8];
            String jogador1[][] = new String[8][8], jogador2[][] = new String[8][8];
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            tabuleiro[i][j] = true;
                        }
                    } else {
                        if (j % 2 == 1) {
                            tabuleiro[i][j] = true;
                        }
                    }
                    if (tabuleiro[i][j]) {
                        if (i < 3) {
                            jogador2[i][j] = "X";
                        } else if (i > 4) {
                            jogador1[i][j] = "O";
                        }
                    }
                }
            }

            Algoritmo alg = new Algoritmo(tabuleiro, jogador1, jogador2);

            do {
                System.out.println("  0   1   2   3   4   5   6   7\n+---+---+---+---+---+---+---+---+");
                for (int i = 0; i < tabuleiro.length; i++) {
                    for (int j = 0; j < tabuleiro[i].length; j++) {
                        if (alg.getTabuleiro()[i][j]) {
                            if ("O".equals(jogador1[i][j])) {
                                System.out.print("| " + alg.getJogador1()[i][j] + " ");
                            } else if ("X".equals(jogador2[i][j])) {
                                System.out.print("| " + alg.getJogador2()[i][j] + " ");
                            } else {
                                System.out.print("|   ");
                            }
                        } else {
                            System.out.print("|-|-");
                        }
                    }
                    System.out.println("| " + i + "\n+---+---+---+---+---+---+---+---+");
                }
                int x, y, x2, y2;
                boolean passar;
                do {
                    x = -1;
                    y = -1;
                    passar = false;
                    System.out.print("SISTEMA: Informe as coordenadas (x, y) da peça que deseja mover\n");
                    do {
                        System.out.print("-> X: ");
                        x = s.nextInt();
                        if ((x < 0) || (x > 7)) {
                            System.out.println("SISTEMA: Valor inválido!");
                        }
                    } while ((x < 0) || (x > 7));
                    do {
                        System.out.print("-> Y: ");
                        y = s.nextInt();
                        if ((y < 0) || (y > 7)) {
                            System.out.println("SISTEMA: Valor inválido!");
                        }
                    } while ((y < 0) || (y > 7));
                    if (" ".equals(alg.getJogador1()[x][y])) {
                        System.out.println("SISTEMA: Nenhuma peça encontrada!");
                    } else {
                        if ((alg.getTabuleiro()[x][y])) {
                            if (!alg.verificarMovimento1(x, y)) {
                                System.out.println("SISTEMA: Não há nenhuma jogada possível com esta peça!");
                            } else {
                                passar = true;
                            }
                        } else {
                            System.out.println("SISTEMA: Índice inválido!");
                        }
                    }
                } while (!passar);
                do {
                    x2 = -1;
                    y2 = -1;
                    passar = false;
                    System.out.print("SISTEMA: Informe as coordenadas (x, y) do índice que deseja colocar\n");
                    do {
                        System.out.print("-> X: ");
                        x2 = s.nextInt();
                        if (x2 != alg.getProximoX()) {
                            System.out.println("SISTEMA: Valor inválido!");
                        }
                    } while (x2 != alg.getProximoX());
                    do {
                        System.out.print("-> Y: ");
                        y2 = s.nextInt();
                        if ((y2 != alg.getProximoY()) && ((y2 != alg.getProximoY() + 4)) && ((y2 != alg.getProximoY() + 2))) {
                            System.out.println("SISTEMA: Valor inválido!");
                        }
                    } while ((y2 != alg.getProximoY()) && ((y2 != alg.getProximoY() + 4)) && ((y2 != alg.getProximoY() + 2)));
                    if ((alg.getTabuleiro()[x2][y2]) && (" ".equals(alg.getJogador1()[x2][y2])) && (" ".equals(alg.getJogador2()[x2][y2]))) {
                        alg.mover1(x2, y2, x, y);
                        passar = true;
                    } else {
                        System.out.println("SISTEMA: Índice inválido!");
                    }
                } while (!passar);

            } while (!alg.isEncerrarPartida());
        } while (menu == 1);
    }
}
