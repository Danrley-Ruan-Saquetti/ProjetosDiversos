
import java.util.Random;
import java.util.Scanner;

public class Esboco {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int tabelaG[][] = new int[9][9], quadrante = 1;
        boolean passar, valores[] = new boolean[9];

        do { //Gerar tabela gabarito
            int contador = 0, cont = 1;
            do {
                int x, y, i2, i21, j2, j21;
                do {
                    x = 0;
                    y = 0;
                    i2 = 0;
                    i21 = 0;
                    j2 = 0;
                    j21 = 0;
                    switch (quadrante) {
                        case 1:
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
                        if (tabelaG[i][j] == cont) {
                            passar = false;
                            break;
                        }
                    }
                }
                contador++;
                if (contador > 400) {
                    tabelaG = new int[9][9];
                    cont = 1;
                    quadrante = 1;
                    contador = 0;
                } else {
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            tabelaG[x][y] = cont;
                            if (cont <= 9) {
                                cont++;
                            }
                        }
                    }
                }
            } while (cont != 10);
            quadrante++;
        } while (quadrante <= 9);

        System.out.println("  0   1   2   3   4   5   6   7   8\n+-----------+-----------+-----------+");
        for (int i = 0; i < tabelaG.length; i++) {
            for (int j = 0; j < tabelaG[i].length; j++) {
                String t = "  ";
                if (tabelaG[i][j] != 0) {
                    t = Integer.toString(tabelaG[i][j]) + " ";
                }
                System.out.print("| " + tabelaG[i][j] + " ");
            }
            if ((i + 1) % 3 == 0) {
                System.out.print("| " + i + "\n+---+---+---+---+---+---+---+---+---+\n");
            } else {
                System.out.print("| " + i + "\n|-----------+-----------+-----------|\n");
            }
        }
        
        /*
        int tabelaG[][] = new int[9][9], x, y, cont = 0, contador, valor;
            boolean passar, valores[] = new boolean[9];

            do { //Gerar tabela gabarito
                contador = 0;
                do { //Quadrante 1
                    passar = true;
                    x = r.nextInt(3);
                    y = r.nextInt(3);
                    if (tabelaG[x][y] == 0) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (tabelaG[i][j] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        passar = false;
                    }
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            tabelaG[x][y] = cont;
                        }
                    }
                    contador++;
                    if (contador > 100) {
                        tabelaG = new int[9][9];
                        cont = 0;
                        passar = true;
                    }
                } while (!passar);
                contador = 0;
                do { //Quadrante 5
                    passar = true;
                    x = r.nextInt(3) + 3;
                    y = r.nextInt(3) + 3;
                    if (tabelaG[x][y] == 0) {
                        for (int i = 3; i < 6; i++) {
                            for (int j = 3; j < 6; j++) {
                                if (tabelaG[i][j] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        passar = false;
                    }
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            tabelaG[x][y] = cont;
                        }
                    }
                    contador++;
                    if (contador > 100) {
                        tabelaG = new int[9][9];
                        cont = 0;
                        passar = true;
                    }
                } while (!passar);
                contador = 0;
                do { //Quadrante 9
                    passar = true;
                    x = r.nextInt(3) + 6;
                    y = r.nextInt(3) + 6;
                    if (tabelaG[x][y] == 0) {
                        for (int i = 6; i < 9; i++) {
                            for (int j = 6; j < 9; j++) {
                                if (tabelaG[i][j] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        passar = false;
                    }
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            tabelaG[x][y] = cont;
                        }
                    }
                    contador++;
                    if (contador > 100) {
                        tabelaG = new int[9][9];
                        cont = 0;
                        passar = true;
                    }
                } while (!passar);
                contador = 0;
                do { //Quadrante 2
                    passar = true;
                    x = r.nextInt(3);
                    y = r.nextInt(3) + 3;
                    if (tabelaG[x][y] == 0) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 3; j < 6; j++) {
                                if (tabelaG[i][j] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        passar = false;
                    }
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            for (int i = 0; i < tabelaG.length; i++) {
                                if (tabelaG[x][i] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                            if (passar) {
                                for (int k = 0; k < tabelaG.length; k++) {
                                    if (tabelaG[k][y] == cont) {
                                        passar = false;
                                        break;
                                    }
                                }
                            }
                            if (passar) {
                                tabelaG[x][y] = cont;
                            }
                        }
                    }
                    contador++;
                    if (contador > 100) {
                        tabelaG = new int[9][9];
                        cont = 0;
                        passar = true;
                    }
                } while (!passar);
                contador = 0;
                do { //Quadrante 3
                    passar = true;
                    x = r.nextInt(3);
                    y = r.nextInt(3) + 6;
                    if (tabelaG[x][y] == 0) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 6; j < 9; j++) {
                                if (tabelaG[i][j] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        passar = false;
                    }
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            for (int i = 0; i < tabelaG.length; i++) {
                                if (tabelaG[x][i] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                            if (passar) {
                                for (int k = 0; k < tabelaG.length; k++) {
                                    if (tabelaG[k][y] == cont) {
                                        passar = false;
                                        break;
                                    }
                                }
                            }
                            if (passar) {
                                tabelaG[x][y] = cont;
                            }
                        }
                    }
                    contador++;
                    if (contador > 100) {
                        tabelaG = new int[9][9];
                        cont = 0;
                        passar = true;
                    }
                } while (!passar);
                contador = 0;
                do { //Quadrante 4
                    passar = true;
                    x = r.nextInt(3) + 3;
                    y = r.nextInt(3);
                    if (tabelaG[x][y] == 0) {
                        for (int i = 3; i < 6; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (tabelaG[i][j] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        passar = false;
                    }
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            tabelaG[x][y] = cont;
                        }
                    }
                    contador++;
                    if (contador > 100) {
                        tabelaG = new int[9][9];
                        cont = 0;
                        passar = true;
                    }
                } while (!passar);
                contador = 0;
                do { //Quadrante 6
                    passar = true;
                    x = r.nextInt(3) + 3;
                    y = r.nextInt(3) + 6;
                    if (tabelaG[x][y] == 0) {
                        for (int i = 3; i < 6; i++) {
                            for (int j = 6; j < 9; j++) {
                                if (tabelaG[i][j] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        passar = false;
                    }
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            tabelaG[x][y] = cont;
                        }
                    }
                    contador++;
                    if (contador > 100) {
                        tabelaG = new int[9][9];
                        cont = 0;
                        passar = true;
                    }
                } while (!passar);
                contador = 0;
                do { //Quadrante 7
                    passar = true;
                    x = r.nextInt(3) + 6;
                    y = r.nextInt(3);
                    if (tabelaG[x][y] == 0) {
                        for (int i = 6; i < 9; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (tabelaG[i][j] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        passar = false;
                    }
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            tabelaG[x][y] = cont;
                        }
                    }
                    contador++;
                    if (contador > 100) {
                        tabelaG = new int[9][9];
                        cont = 0;
                        passar = true;
                    }
                } while (!passar);
                contador = 0;
                do { //Quadrante 8
                    passar = true;
                    x = r.nextInt(3) + 6;
                    y = r.nextInt(3) + 3;
                    if (tabelaG[x][y] == 0) {
                        for (int i = 6; i < 9; i++) {
                            for (int j = 3; j < 6; j++) {
                                if (tabelaG[i][j] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        passar = false;
                    }
                    if (passar) {
                        for (int i = 0; i < tabelaG.length; i++) {
                            if (tabelaG[x][i] == cont) {
                                passar = false;
                                break;
                            }
                        }
                        if (passar) {
                            for (int k = 0; k < tabelaG.length; k++) {
                                if (tabelaG[k][y] == cont) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                        if (passar) {
                            tabelaG[x][y] = cont;
                        }
                    }
                    contador++;
                    if (contador > 100) {
                        tabelaG = new int[9][9];
                        cont = 0;
                        passar = true;
                    }
                } while (!passar);
                cont++;
            } while (cont <= 9);
        */
    }
}
