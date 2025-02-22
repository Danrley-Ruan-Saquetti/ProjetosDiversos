
import java.util.Random;

public class General extends Controle_Vitoria_Derrota {

    private Jogador jogador;
    private int dados[], pontuacao;
    private boolean rodadas[];
    private final int codigo;
    private double aposta;

    public General(Jogador joga, int cod, double apos) {
        jogador = joga;
        dados = new int[5];
        rodadas = new boolean[13];
        pontuacao = 0;
        codigo = cod;
        aposta = apos;
    }

    public void rodarDado() {
        Random r = new Random();
        int pont = 0;

        System.out.println("+---+---+---+---+---+");
        for (int i = 0; i < getDados().length; i++) {
            dados[i] = r.nextInt(5) + 1;
            System.out.print("| " + getDados()[i] + " ");
            setPontuacao(getPontuacao() + getDados()[i]);
            pont += getDados()[i];
        }
        System.out.println("| = " + pont + "\n+---+---+---+---+---+");
    }

    public void avancarRodada() {
        for (int i = 0; i < getRodadas().length; i++) {
            if (!getRodadas()[i]) {
                rodadas[i] = true;
                break;
            }
        }
    }

    @Override
    public void vencer(double valor) {
        jogador.atualizarSaldo(valor);
        jogador.setVitoriaTotal(jogador.getVitoriaTotal() + 1);
        jogador.setVitoriaGeneral(jogador.getVitoriaGeneral() + 1);
        jogador.setSaldoLucrado(jogador.getSaldoLucrado() + valor);
        jogador.setTotalGeneral(jogador.getTotalGeneral() + 1);
    }

    @Override
    public void perder(double valor) {
        jogador.atualizarSaldo(valor * (-1));
        jogador.setDerrotaTotal(jogador.getDerrotaTotal() + 1);
        jogador.setDerrotaGeneral(jogador.getDerrotaGeneral() + 1);
        jogador.setSaldoPerdido(jogador.getSaldoPerdido() + valor);
        jogador.setTotalGeneral(jogador.getTotalGeneral() + 1);
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int[] getDados() {
        return dados;
    }

    public void setDados(int[] dados) {
        this.dados = dados;
    }

    public boolean[] getRodadas() {
        return rodadas;
    }

    public void setRodadas(boolean[] rodadas) {
        this.rodadas = rodadas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getAposta() {
        return aposta;
    }

    public void setAposta(double aposta) {
        this.aposta = aposta;
    }
}
