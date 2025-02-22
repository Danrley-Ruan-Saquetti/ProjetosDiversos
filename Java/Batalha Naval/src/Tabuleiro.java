
public class Tabuleiro {

    private boolean tabuleiro[][], perder;
    private String atacar[][];

    public Tabuleiro() {
        tabuleiro = new boolean[14][14];
        atacar = new String[14][14];
    }

    public Tabuleiro(boolean[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
        atacar = new String[14][14];
    }

    public boolean atacar(Tabuleiro jogador, int x, int y) {
        if (jogador.tabuleiro[x][y]) {
            jogador.atacar[x][y] = "♦";
            jogador.tabuleiro[x][y] = false;
            jogador.naviosRestantes();
            return true;
        } else {
            jogador.atacar[x][y] = "♢";
            return false;
        }
    }

    public void naviosRestantes() {
        boolean per = false;
        for (int i = 0; i < getTabuleiro().length; i++) {
            for (int j = 0; j < getTabuleiro()[i].length; j++) {
                if (getTabuleiro()[i][j]) {
                    per = true;
                    break;
                }
            }
        }
        if (!per) {
            setPerder(true);
        }
    }

    public boolean[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(boolean[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public boolean isPerder() {
        return perder;
    }

    public void setPerder(boolean perder) {
        this.perder = perder;
    }

    public String[][] getAtacar() {
        return atacar;
    }

    public void setAtacar(String[][] atacar) {
        this.atacar = atacar;
    }
}
