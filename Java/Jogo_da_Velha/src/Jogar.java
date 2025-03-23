
import java.util.Random;
import java.util.Scanner;

public class Jogar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int menu;
        do {
            do {
                System.out.print("\n+- MENU\n|1 - New Game\n|2 - Quit Game\n+-\n -> Executar comando: ");
                menu = s.nextInt();
                if ((menu < 1) || (menu > 2)) {
                    System.out.println("SISTEMA: Valor inválido!");
                }
            } while ((menu < 1) || (menu > 2));
            if (menu == 1) {
                Algoritmo alg = new Algoritmo();
                int modo;
                do {
                    System.out.print("\n+-\n|1 - Jogador vs Jogador\n|2 - Jogador vs CPU\n+-\n-> Executar comando: ");
                    modo = s.nextInt();
                    if ((modo < 1) || (modo > 2)) {
                        System.out.println("SISTEMA: Valor inválido!");
                    }
                } while ((modo < 1) || (modo > 2));

                int cont = 0, cont2 = 0;
                switch (modo) {
                    case 1:
                        cont2 = 10;
                        break;
                    case 2:
                        cont2 = 5;
                        break;
                }

                do {
                    cont++;
                    alg.mostrarTabela();
                    if (modo == 1) {
                        if (cont % 2 == 1) {
                            System.out.println("SISTEMA: Jogador 1");
                        } else {
                            System.out.println("SISTEMA: Jogador 2");
                        }
                    }
                    int x, y;
                    do {
                        do {
                            System.out.print("-> X: ");
                            x = s.nextInt();
                            if ((x < 0) || (x > 2)) {
                                System.out.println("SISTEMA: Valor inválido!");
                            }
                        } while ((x < 0) || (x > 2));
                        do {
                            System.out.print("-> Y: ");
                            y = s.nextInt();
                            if ((y < 0) || (y > 2)) {
                                System.out.println("SISTEMA: Valor inválido!");
                            }
                        } while ((y < 0) || (y > 2));
                        if (alg.getTabela()[x][y] != 0) {
                            System.out.println("SISTEMA: Índice ocupado!");
                        }
                    } while (alg.getTabela()[x][y] != 0);
                    switch (modo) {
                        case 1:
                            if (cont % 2 == 1) {
                                alg.jogar(x, y, 1);
                            } else {
                                alg.jogar(x, y, 2);
                            }
                            break;
                        case 2:
                            alg.jogar(x, y, 1);
                            if (alg.getGanhador() == 0) {
                                String jogada = alg.verificarJogada();
                                if (jogada != null) {
                                    alg.jogar(Integer.parseInt(jogada.substring(0, 1)), Integer.parseInt(jogada.substring(1, 2)), 2);
                                } else {
                                    do {
                                        x = r.nextInt(3);
                                        y = r.nextInt(3);
                                    } while (alg.getTabela()[x][y] != 0);
                                    alg.jogar(x, y, 2);
                                }
                            }
                            break;
                    }
                } while ((alg.getGanhador() == 0) && (cont < cont2));
                alg.mostrarTabela();
                switch (alg.getGanhador()) {
                    case 1:
                        System.out.println("SISTEMA: Jogador 1 venceu!");
                        break;
                    case 2:
                        System.out.println("SISTEMA: Jogador 2 venceu!");
                        break;
                    default:
                        System.out.println("SISTEMA: Empate");
                        break;
                }
            }
        } while (menu == 1);
        System.out.println("Bye Bye");
    }
}
