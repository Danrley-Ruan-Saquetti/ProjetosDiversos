
public class Bingo {

    private int tabela[][]; //Tabela do jogador
    private boolean declararBingo;
    private final int numero;

    public Bingo() {
        numero = 0;
    }

    public Bingo(int[][] tabela, int num) {
        this.tabela = tabela;
        numero = num;
    }

    public int[][] getTabela() {
        return tabela;
    }

    public void setTabela(int[][] tabela) {
        this.tabela = tabela;
    }

    public boolean isDeclararBingo() {
        return declararBingo;
    }

    public void setDeclararBingo(boolean declararBingo) {
        this.declararBingo = declararBingo;
    }

    public int getNumero() {
        return numero;
    }
}
