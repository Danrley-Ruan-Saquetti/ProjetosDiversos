import java.util.Random;
import java.util.Scanner;

public class Jogar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int menu;
        do {
            Algoritmo alg = new Algoritmo();

            do {
                System.out.print("\n+-\n|MENU:\n|1 - New Game\n|2 - Quit Game\n+-\n-> Executar comando: ");
                menu = s.nextInt();
                if ((menu != 1) && (menu != 2)) {
                    System.out.println("SISTEMA: Valor inválido!");
                }
            } while ((menu != 1) && (menu != 2));

            if (menu == 1) {
                int tabelaG[][] = new int[9][9], quadrante = 1, x, y, valor;
                boolean passar;

                do { //Gerar tabela gabarito
                    int contador = 0;
                    valor = 1;
                    do {
                        int i2, i21, j2, j21;
                        do {
                            x = 0;
                            y = 0;
                            i2 = 0;
                            i21 = 0;
                            j2 = 0;
                            j21 = 0;
                            switch (quadrante) {
                                case 1: //Quadrante 1
                                    i21 = 3;
                                    j21 = 3;
                                    break;
                                case 2: //Quadrante 2
                                    i21 = 3;
                                    j2 = 3;
                                    j21 = 6;
                                    y = 3;
                                    break;
                                case 3: //Quadrante 3
                                    y = 6;
                                    i21 = 3;
                                    j2 = 6;
                                    j21 = 9;
                                    break;
                                case 4: //Quadrante 4
                                    x = 3;
                                    i2 = 3;
                                    i21 = 6;
                                    j21 = 3;
                                    break;
                                case 5: //Quadrante 5
                                    x = 3;
                                    y = 3;
                                    i2 = 3;
                                    i21 = 6;
                                    j2 = 3;
                                    j21 = 6;
                                    break;
                                case 6: //Quadrante 6
                                    x = 3;
                                    y = 6;
                                    i2 = 3;
                                    i21 = 6;
                                    j2 = 6;
                                    j21 = 9;
                                    break;
                                case 7: //Quadrante 7
                                    x = 6;
                                    i2 = 6;
                                    i21 = 9;
                                    j21 = 3;
                                    break;
                                case 8: //Quadrante 8
                                    x = 6;
                                    y = 3;
                                    i2 = 6;
                                    i21 = 9;
                                    j2 = 3;
                                    j21 = 6;
                                    break;
                                case 9: //Quadrante 9
                                    x = 6;
                                    y = 6;
                                    i2 = 6;
                                    i21 = 9;
                                    j2 = 6;
                                    j21 = 9;
                                    break;
                            }
                            x += r.nextInt(3);
                            y += r.nextInt(3);
                        } while (tabelaG[x][y] != 0);
                        passar = true;
                        for (int i = i2; i < i21; i++) {
                            for (int j = j2; j < j21; j++) {
                                if (tabelaG[i][j] == valor) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        contador++;
                        if (contador > 100) {
                            tabelaG = new int[9][9];
                            valor = 1;
                            quadrante = 1;
                            contador = 0;
                        } else {
                            if (passar) {
                                for (int i = 0; i < tabelaG.length; i++) {
                                    if (tabelaG[x][i] == valor) {
                                        passar = false;
                                        break;
                                    }
                                }
                                if (passar) {
                                    for (int k = 0; k < tabelaG.length; k++) {
                                        if (tabelaG[k][y] == valor) {
                                            passar = false;
                                            break;
                                        }
                                    }
                                }
                                if (passar) {
                                    tabelaG[x][y] = valor;
                                    if (valor <= 9) {
                                        valor++;
                                    }
                                }
                            }
                        }
                    } while (valor != 10);
                    quadrante++;
                } while (quadrante <= 9);
                alg.setTabelaGabarito(tabelaG);

                do {
                    System.out.print("\n+- DIFICULDADE\n|1 - Fácil\n|2 - Médio\n|3 - Difícil\n+-\n-> Informe a dificuldade da partida: ");
                    alg.setDificuldade(s.nextInt());
                    if ((alg.getDificuldade() < 1) || (alg.getDificuldade() > 3)) {
                        System.out.println("SISTEMA: Valor inválido!");
                    }
                } while ((alg.getDificuldade() < 1) || (alg.getDificuldade() > 3));
                alg.definirValorFixo();

                do {
                    do {
                        passar = false;
                        alg.setEncerrarPartida(true);
                        System.out.println("\n  0   1   2   3   4   5   6   7   8\n+-----------+-----------+-----------+");
                        for (int i = 0; i < alg.getTabelaJogador().length; i++) {
                            for (int j = 0; j < alg.getTabelaJogador()[i].length; j++) {
                                String t = "  ";
                                if (alg.getTabelaJogador()[i][j] != 0) {
                                    t = Integer.toString(alg.getTabelaJogador()[i][j]) + " ";
                                } else {
                                    alg.setEncerrarPartida(false);
                                }
                                if (alg.getTabelaFixa()[i][j]) {
                                    t = Integer.toString(alg.getTabelaGabarito()[i][j]) + ".";
                                }
                                System.out.print("| " + t);
                            }
                            if ((i + 1) % 3 == 0) {
                                System.out.print("| " + i + "\n+---+---+---+---+---+---+---+---+---+\n");
                            } else {
                                System.out.print("| " + i + "\n|-----------+-----------+-----------|\n");
                            }
                        }
                        System.out.println("Vidas: " + alg.getVidas() + "\n");
                        System.out.print(alg.listarControleValor());
                        if (alg.getVidas() <= 0) {
                            alg.setEncerrarPartida(true);
                        }
                        if (!alg.isEncerrarPartida()) {
                            System.out.println("\nSISTEMA: Informe as coordenadas (x, y) do índice que deseja atribuir o valor (para cancelar, basta teclar 10)");
                            do {
                                passar = true;
                                do {
                                    System.out.print("-> X: ");
                                    x = s.nextInt();
                                    if ((x < 0) || (x > 8)) {
                                        if (x != 10) {
                                            System.out.println("SISTEMA: Coordenada x inválida inválido!");
                                            passar = false;
                                        }
                                    }
                                } while (((x < 0) || (x > 8)) && (x != 10));
                                if (x != 10) {
                                    do {
                                        System.out.print("-> Y: ");
                                        y = s.nextInt();
                                        if ((y < 0) || (y > 8)) {
                                            if (y != 10) {
                                                System.out.println("SISTEMA: Coordenada y inválida inválido!");
                                                passar = false;
                                            }
                                        }
                                    } while (((y < 0) || (y > 8)) && (y != 10));
                                    if (y != 10) {
                                        if (alg.getTabelaFixa()[x][y]) {
                                            System.out.println("SISTEMA: Não é possível agregar valor à este índice!");
                                            passar = false;
                                        }
                                    }
                                }
                            } while ((!passar) && (x != 10) && (y != 10));
                            if ((x != 10) && (y != 10)) {
                                do {
                                    System.out.print("-> Informe um valor para agregar ao índice: ");
                                    valor = s.nextInt();
                                    if ((valor < 1) || (valor > 9)) {
                                        System.out.println("SISTEMA: Valor inválido!");
                                    }
                                } while ((valor < 1) || (valor > 9));
                            }
                        }
                        if ((x != 10) && (y != 10)) {
                            if (!alg.agregarValor(x, y, valor)) {
                                passar = false;
                            }
                        }
                    } while ((!passar) && (!alg.isEncerrarPartida()));
                } while ((alg.getVidas() > 0) && (!alg.isEncerrarPartida()));
                if (alg.getVidas() <= 0) {
                    System.out.println("SISTEMA: Game over! Suas vidas acabaram!\n");
                } else {
                    System.out.println("SISTEMA: Você ganhou!\n");
                }
            }
        } while (menu == 1);
    }
}
