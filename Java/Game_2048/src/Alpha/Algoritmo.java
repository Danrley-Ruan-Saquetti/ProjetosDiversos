package Alpha;

import java.util.Random;

public class Algoritmo {

    private int tabela[][], pontuacao;
    private boolean perder, vencer;

    public Algoritmo(int x, int y) {
        tabela = new int[4][4];
        tabela[x][y] = 2;
        pontuacao = 0;
    }

    public boolean agregarValor(int x, int y) {
        Random r = new Random();
        for (int i = 0; i < getTabela().length; i++) {
            for (int j = 0; j < getTabela()[i].length; j++) {
                if (getTabela()[i][j] == 0) {
                    if (getTabela()[x][y] == 0) {
                        if (r.nextInt(100) <= 30) {
                            tabela[x][y] = 4;
                        } else {
                            tabela[x][y] = 2;
                        }
                        setTabela(tabela);
                        return true;
                    } else {
                        return false;
                    }
                } else if ((i == 3) && (j == 3)) {
                    setPerder(true);
                    return false;
                }
            }
        }
        return false;
    }

    public void paraCima() {
        for (int j = 0; j < getTabela().length; j++) {
            int x = 4, y = 4;
            for (int i = 0; i < getTabela()[j].length; i++) {
                if (getTabela()[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (getTabela()[x][y] == getTabela()[i][j]) {
                            getTabela()[x][y] += getTabela()[i][j];
                            setPontuacao(getPontuacao() + getTabela()[i][j]);
                            getTabela()[i][j] = 0;
                            setPerder(false);
                            i--;
                            x = 4;
                            y = 4;
                        } else {
                            i--;
                            x = 4;
                            y = 4;
                        }
                    }
                }
            }
            x = 4;
            y = 4;
            for (int i = 0; i < getTabela()[j].length; i++) {
                if (getTabela()[i][j] == 0) {
                    if ((x == 4) && (y == 4)) {
                        y = j;
                        x = i;
                    }
                } else if ((x != 4) && (y != 4)) {
                    getTabela()[x][y] = getTabela()[i][j];
                    getTabela()[i][j] = 0;
                    x = 4;
                    y = 4;
                    i = 0;
                }
            }
        }
    }

    public void paraBaixo() {
        for (int j = getTabela().length - 1; j >= 0; j--) {
            int x = 4, y = 4;
            for (int i = getTabela().length - 1; i >= 0; i--) {
                if (getTabela()[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (getTabela()[x][y] == getTabela()[i][j]) {
                            getTabela()[x][y] += getTabela()[i][j];
                            setPontuacao(getPontuacao() + getTabela()[i][j]);
                            getTabela()[i][j] = 0;
                            setPerder(false);
                            i++;
                            x = 4;
                            y = 4;
                        } else {
                            i++;
                            x = 4;
                            y = 4;
                        }
                    }
                }
            }
            x = 4;
            y = 4;
            for (int i = getTabela().length - 1; i >= 0; i--) {
                if (getTabela()[i][j] == 0) {
                    if ((x == 4) && (y == 4)) {
                        y = j;
                        x = i;
                    }
                } else if ((y != 4) && (x != 4)) {
                    getTabela()[x][y] = getTabela()[i][j];
                    getTabela()[i][j] = 0;
                    x = 4;
                    y = 4;
                    i = getTabela().length - 1;
                }
            }
        }
    }

    public void paraDireita() {
        for (int i = getTabela().length - 1; i >= 0; i--) {
            int x = 4, y = 4;
            for (int j = getTabela().length - 1; j >= 0; j--) {
                if (getTabela()[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (getTabela()[x][y] == getTabela()[i][j]) {
                            getTabela()[x][y] += getTabela()[i][j];
                            setPontuacao(getPontuacao() + getTabela()[i][j]);
                            getTabela()[i][j] = 0;
                            setPerder(false);
                            j++;
                            x = 4;
                            y = 4;
                        } else {
                            j++;
                            x = 4;
                            y = 4;
                        }
                    }
                }
            }
            x = 4;
            y = 4;
            for (int j = getTabela().length - 1; j >= 0; j--) {
                if (getTabela()[i][j] == 0) {
                    if ((x == 4) && (y == 4)) {
                        x = i;
                        y = j;
                    }
                } else if ((x != 4) && (y != 4)) {
                    getTabela()[x][y] = getTabela()[i][j];
                    getTabela()[i][j] = 0;
                    x = 4;
                    y = 4;
                    j = getTabela().length - 1;
                }
            }
        }
    }

    public void paraEsquerda() {
        for (int i = 0; i < getTabela().length; i++) {
            int x = 4, y = 4;
            for (int j = 0; j < getTabela()[i].length; j++) {
                if (getTabela()[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (getTabela()[x][y] == getTabela()[i][j]) {
                            getTabela()[x][y] += getTabela()[i][j];
                            setPontuacao(getPontuacao() + getTabela()[i][j]);
                            getTabela()[i][j] = 0;
                            setPerder(false);
                            j--;
                            x = 4;
                            y = 4;
                        } else {
                            j--;
                            x = 4;
                            y = 4;
                        }
                    }
                }
            }
            x = 4;
            y = 4;
            for (int j = 0; j < getTabela()[i].length; j++) {
                if (getTabela()[i][j] == 0) {
                    if ((x == 4) && (y == 4)) {
                        x = i;
                        y = j;
                    }
                } else if ((x != 4) && (y != 4)) {
                    getTabela()[x][y] = getTabela()[i][j];
                    getTabela()[i][j] = 0;
                    x = 4;
                    y = 4;
                    j = 0;
                }
            }
        }
    }

    public boolean verificarJogada() {
        for (int i = getTabela().length - 1; i >= 0; i--) {
            int x = 4, y = 4;
            for (int j = getTabela().length - 1; j >= 0; j--) {
                if (getTabela()[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (getTabela()[x][y] == getTabela()[i][j]) {
                            return true;
                        } else {
                            j++;
                            x = 4;
                            y = 4;
                        }
                    }
                }
            }
        }
        for (int j = 0; j < getTabela().length; j++) {
            int x = 4, y = 4;
            for (int i = 0; i < getTabela()[j].length; i++) {
                if (getTabela()[i][j] != 0) {
                    if ((x == 4) & (y == 4)) {
                        x = i;
                        y = j;
                    } else {
                        if (getTabela()[x][y] == getTabela()[i][j]) {
                            return true;
                        } else {
                            i--;
                            x = 4;
                            y = 4;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int[][] getTabela() {
        return tabela;
    }

    public void setTabela(int[][] tabela) {
        this.tabela = tabela;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean isPerder() {
        return perder;
    }

    public void setPerder(boolean perder) {
        this.perder = perder;
    }

    public boolean isVencer() {
        return vencer;
    }

    public void setVencer(boolean vencer) {
        this.vencer = vencer;
    }
}
