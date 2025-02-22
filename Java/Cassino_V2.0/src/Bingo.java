
public class Bingo extends Controle_Vitoria_Derrota {

    private Jogador jogador;
    private int tabela[][];
    private boolean declararBingo;
    private final int numero;
    private int premio;

    public Bingo() {
        numero = 0;
        premio = 0;
    }

    public Bingo(Jogador joga, int[][] tabela, int num) {
        jogador = joga;
        this.tabela = tabela;
        numero = num;
        premio = 0;
    }

    @Override
    public void vencer(double valor) {
        jogador.atualizarSaldo(valor);
        jogador.setVitoriaTotal(jogador.getVitoriaTotal() + 1);
        jogador.setVitoriaBingo(jogador.getVitoriaBingo() + 1);
        jogador.setSaldoLucrado(jogador.getSaldoLucrado() + valor);
        jogador.setTotalBingo(jogador.getTotalBingo() + 1);
    }

    @Override
    public void perder(double valor) {
        jogador.atualizarSaldo(valor * (-1));
        jogador.setDerrotaTotal(jogador.getDerrotaTotal() + 1);
        jogador.setDerrotaBingo(jogador.getDerrotaBingo() + 1);
        jogador.setSaldoPerdido(jogador.getSaldoPerdido() + valor);
        jogador.setTotalBingo(jogador.getTotalBingo() + 1);
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

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }
}
