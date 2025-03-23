package Beta;

import java.util.Random;
import java.util.Scanner;

public class Game_2048 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random ale = new Random();

        int tabela[][] = new int[4][4], pontuacao = 0;
        boolean vencer, perder, xy;

        System.out.println("A - Para Esquerda\nD - Para Direita\nW - Para Cima\nS - Para Baixo\n"); //Comandos

        int xx = ale.nextInt(4), yy = ale.nextInt(4);
        tabela[xx][yy] = 2;

        //Início do game
        do {
            int x = 4, y = 4;
            xy = false;
            perder = false;
            vencer = false;

            for (int i = 0; i < tabela.length; i++) {
                for (int j = 0; j < tabela[i].length; j++) {
                    if (tabela[i][j] == 0) { //Verificar se há um índice livre
                        xy = true;
                        break;
                    }
                }
            }
            if (xy) {
                do { //Gerar um valor aleatório para x e y
                    x = ale.nextInt(4);
                    y = ale.nextInt(4);
                    if (tabela[x][y] == 0) { //Verificar se o índice das coordenadas x e y está livre
                        if (ale.nextInt(100) <= 30) { //Agregar valor 4 ao índice
                            tabela[x][y] = 4;
                        } else { //Agregar valor 2 ao índice
                            tabela[x][y] = 2;
                        }
                        xy = true;
                    } else {
                        xy = false;
                    }
                } while (!xy);
            } else { //Tabela completa
                perder = true;
            }
            //Interface do Usuário
            System.out.println("\nPontuação: " + pontuacao + "\n+-------+-------+-------+-------+");
            for (int i = 0; i < tabela.length; i++) {
                for (int j = 0; j < tabela[i].length; j++) {
                    String tab = "";
                    if (tabela[i][j] >= 2048) {
                        vencer = true;
                    }
                    if (tabela[i][j] != 0) {
                        tab = Integer.toString(tabela[i][j]);
                    }
                    if ((x == i) && (y == j)) {
                        tab = "*" + Integer.toString(tabela[i][j]) + "*";
                    } else if ((xx == i) && (yy == j)) {
                        tab = "*" + Integer.toString(tabela[i][j]) + "*";
                        xx = 4;
                        yy = 4;
                    }
                    System.out.print("|" + tab + "\t");
                }
                System.out.println("|\n+-------+-------+-------+-------+");
            }
            if (!vencer) {
                boolean exe;
                int x2, y2;
                do {
                    exe = true;
                    System.out.print("-> Executar comando: ");
                    switch (s.next()) { //Campo dos comandos
                        case "a": //Para Esquerda
                            for (int i = 0; i < tabela.length; i++) {
                                x2 = 4;
                                y2 = 4;
                                for (int j = 0; j < tabela[i].length; j++) { //"for" para somar valores idênticos
                                    if (tabela[i][j] != 0) {
                                        if ((x2 == 4) & (y2 == 4)) { //Capturar as coordenadas do índice
                                            x2 = i;
                                            y2 = j;
                                        } else {
                                            if (tabela[x2][y2] == tabela[i][j]) { //Verificar se o valor do índice atual é igual ao ídice das coordenadas
                                                tabela[x2][y2] += tabela[i][j];
                                                pontuacao += tabela[i][j];
                                                tabela[i][j] = 0;
                                                perder = false;
                                                j--;
                                                x2 = 4;
                                                y2 = 4;
                                            } else {
                                                j--;
                                                x2 = 4;
                                                y2 = 4;
                                            }
                                        }
                                    }
                                }
                                x2 = 4;
                                y2 = 4;
                                for (int j = 0; j < tabela[i].length; j++) { //"for" para "jogar" os valores para o canto
                                    if (tabela[i][j] == 0) { //Achar um índice livre
                                        if ((x2 == 4) && (y2 == 4)) { //Capturar as coordenadas do índice livre
                                            x2 = i;
                                            y2 = j;
                                        }
                                    } else if ((x2 != 4) && (y2 != 4)) { //Achar um valor para substituí-lo no índice livre
                                        tabela[x2][y2] = tabela[i][j];
                                        tabela[i][j] = 0;
                                        perder = false;
                                        x2 = 4;
                                        y2 = 4;
                                        j = 0;
                                    }
                                }
                            }
                            break;
                        case "d": //Para Direita
                            for (int i = tabela.length - 1; i >= 0; i--) {
                                x2 = 4;
                                y2 = 4;
                                for (int j = tabela.length - 1; j >= 0; j--) { //"for" para somar valores idênticos
                                    if (tabela[i][j] != 0) {
                                        if ((x2 == 4) & (y2 == 4)) { //Capturar as coordenadas do índice
                                            x2 = i;
                                            y2 = j;
                                        } else {
                                            if (tabela[x2][y2] == tabela[i][j]) { //Verificar se o valor do índice atual é igual ao ídice das coordenadas
                                                tabela[x2][y2] += tabela[i][j];
                                                pontuacao += tabela[i][j];
                                                tabela[i][j] = 0;
                                                perder = false;
                                                j++;
                                                x2 = 4;
                                                y2 = 4;
                                            } else {
                                                j++;
                                                x2 = 4;
                                                y2 = 4;
                                            }
                                        }
                                    }
                                }
                                x2 = 4;
                                y2 = 4;
                                for (int j = tabela.length - 1; j >= 0; j--) { //"for" para "jogar" os valores para o canto
                                    if (tabela[i][j] == 0) { //Achar um índice livre
                                        if ((x2 == 4) && (y2 == 4)) { //Capturar as coordenadas do índice livre
                                            x2 = i;
                                            y2 = j;
                                        }
                                    } else if ((x2 != 4) && (y2 != 4)) { //Achar um valor para substituí-lo no índice livre
                                        tabela[x2][y2] = tabela[i][j];
                                        tabela[i][j] = 0;
                                        perder = false;
                                        x2 = 4;
                                        y2 = 4;
                                        j = tabela.length - 1;
                                    }
                                }
                            }
                            break;
                        case "w": //Para Cima
                            for (int j = 0; j < tabela.length; j++) {
                                x2 = 4;
                                y2 = 4;
                                for (int i = 0; i < tabela[j].length; i++) { //"for" para somar valores idênticos
                                    if (tabela[i][j] != 0) {
                                        if ((x2 == 4) & (y2 == 4)) { //Capturar as coordenadas do índice
                                            x2 = i;
                                            y2 = j;
                                        } else {
                                            if (tabela[x2][y2] == tabela[i][j]) { //Verificar se o valor do índice atual é igual ao ídice das coordenadas
                                                tabela[x2][y2] += tabela[i][j];
                                                pontuacao += tabela[i][j];
                                                tabela[i][j] = 0;
                                                perder = false;
                                                i--;
                                                x2 = 4;
                                                y2 = 4;
                                            } else {
                                                i--;
                                                x2 = 4;
                                                y2 = 4;
                                            }
                                        }
                                    }
                                }
                                x2 = 4;
                                y2 = 4;
                                for (int i = 0; i < tabela[j].length; i++) { //"for" para "jogar" os valores para o canto
                                    if (tabela[i][j] == 0) { //Achar um índice livre
                                        if ((x2 == 4) && (y2 == 4)) { //Capturar as coordenadas do índice livre
                                            y2 = j;
                                            x2 = i;
                                        }
                                    } else if ((x2 != 4) && (y2 != 4)) { //Achar um valor para substituí-lo no índice livre
                                        tabela[x2][y2] = tabela[i][j];
                                        tabela[i][j] = 0;
                                        perder = false;
                                        x2 = 4;
                                        y2 = 4;
                                        i = 0;
                                    }
                                }
                            }
                            break;
                        case "s": //Para Baixo
                            for (int j = tabela.length - 1; j >= 0; j--) {
                                x2 = 4;
                                y2 = 4;
                                for (int i = tabela.length - 1; i >= 0; i--) { //"for" para somar valores idênticos
                                    if (tabela[i][j] != 0) {
                                        if ((x2 == 4) & (y2 == 4)) { //Capturar as coordenadas do índice
                                            x2 = i;
                                            y2 = j;
                                        } else {
                                            if (tabela[x2][y2] == tabela[i][j]) { //Verificar se o valor do índice atual é igual ao ídice das coordenadas
                                                tabela[x2][y2] += tabela[i][j];
                                                pontuacao += tabela[i][j];
                                                tabela[i][j] = 0;
                                                perder = false;
                                                i++;
                                                x2 = 4;
                                                y2 = 4;
                                            } else {
                                                i++;
                                                x2 = 4;
                                                y2 = 4;
                                            }
                                        }
                                    }
                                }
                                x2 = 4;
                                y2 = 4;
                                for (int i = tabela.length - 1; i >= 0; i--) { //"for" para "jogar" os valores para o canto
                                    if (tabela[i][j] == 0) { //Achar um índice livre
                                        if ((x2 == 4) && (y2 == 4)) { //Capturar as coordenadas do índice livre
                                            y2 = j;
                                            x2 = i;
                                        }
                                    } else if ((x2 != 4) && (y2 != 4)) { //Achar um valor para substituí-lo no índice livre
                                        tabela[x2][y2] = tabela[i][j];
                                        tabela[i][j] = 0;
                                        perder = false;
                                        x2 = 4;
                                        y2 = 4;
                                        i = tabela.length - 1;
                                    }
                                }
                            }
                            break;
                        default:
                            System.out.println("Valor inválido!");
                            exe = false;
                    }
                } while (!exe);
                if (perder) {
                    //Verificar caso haja mais uma jogada disponível
                    for (int i = 0; i < tabela.length; i++) {
                        x2 = 4;
                        y2 = 4;
                        for (int j = 0; j < tabela[i].length; j++) { //"for" para somar valores idênticos
                            if (tabela[i][j] != 0) {
                                if ((x2 == 4) & (y2 == 4)) { //Capturar as coordenadas do índice
                                    x2 = i;
                                    y2 = j;
                                } else {
                                    if (tabela[x2][y2] == tabela[i][j]) {
                                        perder = false;
                                        break;
                                    } else {
                                        j--;
                                        x2 = 4;
                                        y2 = 4;
                                    }
                                }
                            }
                        }
                    }
                    if (perder) {
                        for (int j = 0; j < tabela.length; j++) {
                            x2 = 4;
                            y2 = 4;
                            for (int i = 0; i < tabela[j].length; i++) {
                                if (tabela[i][j] != 0) {
                                    if ((x2 == 4) & (y2 == 4)) {
                                        x2 = i;
                                        y2 = j;
                                    } else {
                                        if (tabela[x2][y2] == tabela[i][j]) {
                                            perder = false;
                                            break;
                                        } else {
                                            i--;
                                            x2 = 4;
                                            y2 = 4;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } while ((!perder) && (!vencer));
        //Fim do game

        if (vencer) { //Verficar se venceu ou perdeu
            System.out.print("\nParabéns! Você venceu!");
        } else if (perder) {
            System.out.print("\nGame Over!");
        }
        System.out.print(" Pontuação Total: " + pontuacao); //Mostrar pontuação
    }
}
