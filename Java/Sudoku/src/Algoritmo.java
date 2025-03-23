
import java.util.Random;

public class Algoritmo {

    private int tabelaGabarito[][]; //Tabela com o gabarito
    private int tabelaJogador[][]; //Tabela do jogador
    private boolean tabelaFixa[][]; //Tabela com os valores fixos
    private int vidas, controleValor[], dificuldade;
    private boolean encerrarPartida;

    public Algoritmo() {
        tabelaGabarito = new int[9][9];
        tabelaJogador = new int[9][9];
        tabelaFixa = new boolean[9][9];
        controleValor = new int[9];
        vidas = 3;
    }

    public boolean agregarValor(int x, int y, int valor) {
        if (getControleValor()[(valor - 1)] < 9) {
            if (getTabelaGabarito()[x][y] == valor) {
                tabelaJogador[x][y] = valor;
                controleValor[(valor - 1)]++;
            } else {
                System.out.println("SISTEMA: Valor errado!");
                setVidas(getVidas() - 1);
                return false;
            }
        } else {
            System.out.println("SISTEMA: O valor " + valor + " já foi repetido 9 vezes!");
            return false;
        }
        return true;
    }

    public void definirValorFixo() {
        Random r = new Random();
        int x[], y[];
        switch (getDificuldade()) {
            case 1:
                x = new int[45];
                y = new int[45];
                for (int i = 0; i < x.length; i++) {
                    x[i] = r.nextInt(9);
                    y[i] = r.nextInt(9);
                    if (!getTabelaFixa()[x[i]][y[i]]) {
                        tabelaFixa[x[i]][y[i]] = true;
                        tabelaJogador[x[i]][y[i]] = getTabelaGabarito()[x[i]][y[i]];
                        controleValor[(tabelaJogador[x[i]][y[i]] - 1)]++;
                    } else {
                        i--;
                    }
                }
                break;
            case 2:
                x = new int[35];
                y = new int[35];
                for (int i = 0; i < x.length; i++) {
                    x[i] = r.nextInt(9);
                    y[i] = r.nextInt(9);
                    if (!getTabelaFixa()[x[i]][y[i]]) {
                        tabelaFixa[x[i]][y[i]] = true;
                        tabelaJogador[x[i]][y[i]] = getTabelaGabarito()[x[i]][y[i]];
                        controleValor[(tabelaJogador[x[i]][y[i]] - 1)]++;
                    } else {
                        i--;
                    }
                }
                break;
            case 3:
                x = new int[25];
                y = new int[25];
                for (int i = 0; i < x.length; i++) {
                    x[i] = r.nextInt(9);
                    y[i] = r.nextInt(9);
                    if (!getTabelaFixa()[x[i]][y[i]]) {
                        tabelaFixa[x[i]][y[i]] = true;
                        tabelaJogador[x[i]][y[i]] = getTabelaGabarito()[x[i]][y[i]];
                        controleValor[(tabelaJogador[x[i]][y[i]] - 1)]++;
                    } else {
                        i--;
                    }
                }
                break;
        }
    }

    public String listarControleValor() {
        return getControleValor()[0] + " de 1   " + getControleValor()[1]
                + " de 2   " + getControleValor()[2] + " de 3   " + getControleValor()[3]
                + " de 4   " + getControleValor()[4] + " de 5   " + getControleValor()[5]
                + " de 6   " + getControleValor()[6] + " de 7   " + getControleValor()[7]
                + " de 8   " + getControleValor()[8] + " de 9";
    }

    public int[][] getTabelaGabarito() {
        return tabelaGabarito;
    }

    public void setTabelaGabarito(int[][] tabelaGabarito) {
        this.tabelaGabarito = tabelaGabarito;
    }

    public int[][] getTabelaJogador() {
        return tabelaJogador;
    }

    public void setTabelaJogador(int[][] tabelaJogador) {
        this.tabelaJogador = tabelaJogador;
    }

    public boolean[][] getTabelaFixa() {
        return tabelaFixa;
    }

    public void setTabelaFixa(boolean[][] tabelaFixa) {
        this.tabelaFixa = tabelaFixa;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int[] getControleValor() {
        return controleValor;
    }

    public void setControleValor(int[] controleValor) {
        this.controleValor = controleValor;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public boolean isEncerrarPartida() {
        return encerrarPartida;
    }

    public void setEncerrarPartida(boolean encerrarPartida) {
        this.encerrarPartida = encerrarPartida;
    }
}
