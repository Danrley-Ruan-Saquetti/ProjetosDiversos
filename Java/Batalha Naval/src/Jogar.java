
import java.util.Random;
import java.util.Scanner;

public class Jogar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int menu = 1;
        do {
            do {
                System.out.print("\n+- MENU\n|1 - New Game\n|2 - Quit Game\n+-\n-> Executar comando: ");
                menu = s.nextInt();
                if ((menu != 1) && (menu != 2)) {
                    System.out.println("SISTEMA: Valor inválido!");
                }
            } while ((menu != 1) && (menu != 2));
            if (menu == 1) {
                boolean plano1[][] = new boolean[14][14], corvete = true, submarino = true, fragata = true, destroyer = true, cruzador = true, porta_avioes = true;
                int cont = 0, contador = 0;
                do {
                    System.out.print("\n+-\n|1 - Escolher manualmente a posição dos navios\n|2 - "
                            + "Escolher automaticamente a posição dos navios\n+-\n-> Executar comando: ");
                    menu = s.nextInt();
                    if ((menu != 1) && (menu != 2)) {
                        System.out.println("SISTEMA: Valor inválido!");
                    }
                } while ((menu != 1) && (menu != 2));
                if (menu == 2) {
                    menu = 0;
                    do {
                        int posicao = 0;
                        menu++;
                        switch (menu) {
                            case 1: {
                                posicao = 2;
                                break;
                            }
                            case 2: {
                                posicao = 3;
                                break;
                            }
                            case 3: {
                                posicao = 3;
                                break;
                            }
                            case 4: {
                                posicao = 4;
                                break;
                            }
                            case 5: {
                                posicao = 5;
                                break;
                            }
                            case 6: {
                                posicao = 6;
                                break;
                            }
                        }
                        int vert_hori;
                        if (r.nextInt(100) > 50) {
                            vert_hori = 1;
                        } else {
                            vert_hori = 2;
                        }
                        int x = 0, y = 0;
                        switch (vert_hori) {
                            case 1:
                                y = r.nextInt(14);
                                break;
                            case 2:
                                x = r.nextInt(14);
                                break;
                        }
                        boolean passar;
                        do {
                            passar = true;
                            switch (vert_hori) {
                                case 1:
                                    do {
                                        x = r.nextInt(134);
                                    } while (x > 13 - posicao);

                                    for (int i = 1; i <= posicao; i++) {
                                        if (plano1[x + i][y]) {
                                            passar = false;
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    do {
                                        y = r.nextInt(14);
                                    } while (y > 13 - posicao);

                                    for (int i = 1; i <= posicao; i++) {
                                        if (plano1[x][y + i]) {
                                            passar = false;
                                            break;
                                        }
                                    }
                                    break;
                            }
                            contador++;
                            if (contador > 30) {
                                plano1 = new boolean[14][14];
                                contador = 0;
                                cont = -1;
                                menu = -1;
                                posicao = 0;
                            }
                        } while ((!passar) && (contador != 30));
                        if (contador != 30) {
                            switch (vert_hori) {
                                case 1:
                                    for (int i = 1; i <= posicao; i++) {
                                        plano1[x + i][y] = true;
                                    }
                                    break;
                                case 2:
                                    for (int i = 1; i <= posicao; i++) {
                                        plano1[x][y + i] = true;
                                    }
                                    break;
                            }
                        }
                        cont++;
                    } while (cont < 6);
                } else {
                    do {
                        System.out.println("  0   1   2   3   4   5   6   7   8   9  10  11  12  13\n"
                                + "+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
                        for (int i = 0; i < plano1.length; i++) {
                            for (int j = 0; j < plano1[i].length; j++) {
                                if (plano1[i][j]) {
                                    System.out.print("| + ");
                                } else {
                                    System.out.print("|   ");
                                }
                            }
                            System.out.println("| " + i + "\n+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
                        }
                        System.out.println("\n+- SEUS NAVIOS");
                        if (corvete) {
                            System.out.println("|1 - Corveta");
                        }
                        if (submarino) {
                            System.out.println("|2 - Submarino");
                        }
                        if (fragata) {
                            System.out.println("|3 - Fragata");
                        }
                        if (destroyer) {
                            System.out.println("|4 - Destroyer");
                        }
                        if (cruzador) {
                            System.out.println("|5 - Cruzador");
                        }
                        if (porta_avioes) {
                            System.out.println("|6 - Porta-Aviões");
                        }

                        int posicao = 0, x = 0, y = 0, x2 = 0, y2 = 0, contador2 = 0;
                        do {
                            System.out.print("+-\n-> Informe o navio que deseja posicionar em seu tabuleiro: ");
                            menu = s.nextInt();

                            switch (menu) {
                                case 1: {
                                    if (corvete) {
                                        posicao = 2;
                                    }
                                    break;
                                }
                                case 2: {
                                    if (submarino) {
                                        posicao = 3;
                                    }
                                    break;
                                }
                                case 3: {
                                    if (fragata) {
                                        posicao = 3;
                                    }
                                    break;
                                }
                                case 4: {
                                    if (destroyer) {
                                        posicao = 4;
                                    }
                                    break;
                                }
                                case 5: {
                                    if (cruzador) {
                                        posicao = 5;
                                    }
                                    break;
                                }
                                case 6: {
                                    if (porta_avioes) {
                                        posicao = 6;
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println("SISTEMA: Valor inválido!");
                                }
                            }
                        } while ((menu < 0) || (menu > 6));
                        do {
                            System.out.println("\n" + posicao + " peças restantes\n  0   1   2   3   4   5   6   7   8   9  10  11  12  13\n"
                                    + "+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
                            for (int i = 0; i < plano1.length; i++) {
                                for (int j = 0; j < plano1[i].length; j++) {
                                    if (plano1[i][j]) {
                                        System.out.print("| + ");
                                    } else {
                                        System.out.print("|   ");
                                    }
                                }
                                System.out.println("| " + i + "\n+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
                            }

                            boolean passarXY = false;
                            System.out.print("-> Informe as coordenadas (x, y) do tabuleiro que deseja pôr o navio\n");
                            do {
                                do {
                                    System.out.print("-> X: ");
                                    x = s.nextInt();
                                    if ((x < 0) || (x > 13)) {
                                        System.out.println("SISTEMA: Valor inválido!");
                                    }
                                } while ((x < 0) || (x > 13));
                                do {
                                    System.out.print("-> Y: ");
                                    y = s.nextInt();
                                    if ((y < 0) || (y > 13)) {
                                        System.out.println("SISTEMA: Valor inválido!");
                                    }
                                } while ((y < 0) || (y > 13));
                                switch (contador2) {
                                    case 0:
                                        x2 = x;
                                        y2 = y;
                                        passarXY = true;
                                        break;
                                    case 1:
                                        if ((x == x2 + 1) || (x == x2 - 1) || (y == y2 + 1) || (y == y2 - 1)) {
                                            passarXY = true;
                                        } else {
                                            System.out.println("SISTEMA: Índice inválido!");
                                        }
                                        break;
                                    default:
                                        if (x == x2) {
                                            if ((y == y2 - contador2) || (y == y2 + contador2)) {
                                                passarXY = true;
                                            } else {
                                                System.out.println("SISTEMA: Índice inválido!A");
                                            }
                                        } else if (y == y2) {
                                            if ((x == x2 - contador2) || (x == x2 + contador2)) {
                                                passarXY = true;
                                            } else {
                                                System.out.println("SISTEMA: Índice inválido!B");
                                            }
                                        }
                                        break;
                                }
                            } while (!passarXY);
                            if (!plano1[x][y]) {
                                plano1[x][y] = true;
                                posicao--;
                                contador2++;
                            } else {
                                System.out.println("SISTEMA: Este índice já possui um navio");
                            }
                        } while (posicao != 0);
                        switch (menu) {
                            case 1: {
                                corvete = false;
                                break;
                            }
                            case 2: {
                                submarino = false;
                                break;
                            }
                            case 3: {
                                fragata = false;
                                break;
                            }
                            case 4: {
                                destroyer = false;
                                break;
                            }
                            case 5: {
                                cruzador = false;
                                break;
                            }
                            case 6: {
                                porta_avioes = false;
                                break;
                            }
                        }
                        cont++;
                    } while (cont < 6);
                }

                boolean plano2[][] = new boolean[14][14];
                cont = 0;
                menu = 0;

                do {
                    int posicao = 0;
                    menu++;
                    switch (menu) {
                        case 1: {
                            posicao = 2;
                            break;
                        }
                        case 2: {
                            posicao = 3;
                            break;
                        }
                        case 3: {
                            posicao = 3;
                            break;
                        }
                        case 4: {
                            posicao = 4;
                            break;
                        }
                        case 5: {
                            posicao = 5;
                            break;
                        }
                        case 6: {
                            posicao = 6;
                            break;
                        }
                    }
                    int vert_hori;
                    if (r.nextInt(100) > 50) {
                        vert_hori = 1;
                    } else {
                        vert_hori = 2;
                    }
                    int x = 0, y = 0;
                    switch (vert_hori) {
                        case 1:
                            y = r.nextInt(14);
                            break;
                        case 2:
                            x = r.nextInt(14);
                            break;
                    }
                    boolean passar;
                    do {
                        passar = true;
                        switch (vert_hori) {
                            case 1:
                                do {
                                    x = r.nextInt(14);
                                } while (x > 13 - posicao);

                                for (int i = 1; i <= posicao; i++) {
                                    if (plano2[x + i][y]) {
                                        passar = false;
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                do {
                                    y = r.nextInt(14);
                                } while (y > 13 - posicao);

                                for (int i = 1; i <= posicao; i++) {
                                    if (plano2[x][y + i]) {
                                        passar = false;
                                        break;
                                    }
                                }
                                break;
                        }
                        if (contador > 30) {
                            plano2 = new boolean[14][14];
                            contador = 0;
                            cont = -1;
                            menu = -1;
                        }
                        contador++;
                    } while ((!passar) && (contador != 30));
                    if (contador != 30) {
                        switch (vert_hori) {
                            case 1:
                                for (int i = 1; i <= posicao; i++) {
                                    plano2[x + i][y] = true;
                                }
                                break;
                            case 2:
                                for (int i = 1; i <= posicao; i++) {
                                    plano2[x][y + i] = true;
                                }
                                break;
                        }
                    }
                    cont++;
                } while (cont < 6);

                Tabuleiro jogador1 = new Tabuleiro(plano1);
                Tabuleiro jogador2 = new Tabuleiro(plano2);
                String espaco1[][] = new String[14][14], espaco2[][] = new String[14][14];

                for (int i = 0; i < jogador1.getAtacar().length; i++) {
                    for (int j = 0; j < jogador1.getAtacar()[i].length; j++) {
                        if (!jogador1.getTabuleiro()[i][j]) {
                            espaco1[i][j] = " ";
                        } else {
                            espaco1[i][j] = "+";
                        }
                        espaco2[i][j] = " ";
                    }
                }
                jogador1.setAtacar(espaco1);
                jogador2.setAtacar(espaco2);

                do {
                    System.out.println("\nSeu tabuleiro:\t\t\t\t\t\t\tTabuleiro do inimigo:"
                            + "\n  0   1   2   3   4   5   6   7   8   9  10  11  12  13\t\t"
                            + "  0   1   2   3   4   5   6   7   8   9  10  11  12  13\n"
                            + "+---+---+---+---+---+---+---+---+---+---+---+---+---+---+\t"
                            + "+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
                    for (int i = 0; i < jogador1.getAtacar().length; i++) {
                        for (int j = 0; j < jogador1.getAtacar()[i].length; j++) {
                            System.out.print("| " + jogador1.getAtacar()[i][j] + " ");
                        }
                        System.out.print("| " + i + "\t");
                        for (int j = 0; j < jogador2.getAtacar()[i].length; j++) {
                            System.out.print("| " + jogador2.getAtacar()[i][j] + " ");
                        }
                        System.out.println("| " + i + "\n+---+---+---+---+---+---+---+---+---+---+---+"
                                + "---+---+---+\t+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
                    }
                    int x = 0, y = 0;
                    do {
                        System.out.println("SISTEMA: Informe as coordenadas (x, y) do tabuleiro inimigo onde quer atirar.");
                        do {
                            System.out.print("-> X: ");
                            x = s.nextInt();
                            if ((x < 0) || (x > 13)) {
                                System.out.println("SISTEMA: Valor inválido!");
                            }
                        } while ((x < 0) || (x > 13));
                        do {
                            System.out.print("-> Y: ");
                            y = s.nextInt();
                            if ((y < 0) || (y > 13)) {
                                System.out.println("SISTEMA: Valor inválido!");
                            }
                        } while ((y < 0) || (y > 13));
                        if (!" ".equals(jogador2.getAtacar()[x][y])) {
                            System.out.println("SISTEMA: Já houve um ataque nesta coordenada!\n");
                        }
                    } while (!" ".equals(jogador2.getAtacar()[x][y]));
                    if (jogador1.atacar(jogador2, x, y)) {
                        System.out.println("SISTEMA: Você acertou um navio inimigo!");
                    } else {
                        System.out.println("SISTEMA: Você errou!");
                    }

                    if (!jogador2.isPerder()) {
                        do {
                            do {
                                x = r.nextInt(14);
                            } while ((x < 0) || (x > 13));
                            do {
                                y = r.nextInt(14);
                            } while ((y < 0) || (y > 13));
                        } while (!" ".equals(jogador1.getAtacar()[x][y]));
                        if (jogador2.atacar(jogador1, x, y)) {
                            System.out.println("SISTEMA: O inimigo acertou um de seus navios!");
                        } else {
                            System.out.println("SISTEMA: O inimigo errou o tiro!");
                        }
                    }
                } while ((!jogador1.isPerder()) || (!jogador2.isPerder()));
                if (!jogador1.isPerder()) {
                    System.out.println("SISTEMA: Parabéns! Você derrotou seu inimigo!");
                } else {
                    System.out.println("SISTEMA: Game Over!");
                }
            }
        } while (menu == 1);
    }
}
