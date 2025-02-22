
import java.util.Random;

public class Roleta extends Controle_Vitoria_Derrota {

    private Jogador jogador;
    private double aposta;
    private int numeroSorteado;

    public Roleta(Jogador jogo) {
        jogador = jogo;
        aposta = 0;
        numeroSorteado = 0;
    }

    public void jogarRoleta() {
        Random r = new Random();
        setNumeroSorteado(r.nextInt(39));
    }

    @Override
    public void vencer(double valor) {
        jogador.atualizarSaldo(valor * 5);
        jogador.setVitoriaTotal(jogador.getVitoriaTotal() + 1);
        jogador.setVitoriaRoleta(jogador.getVitoriaRoleta() + 1);
        jogador.setSaldoLucrado(jogador.getSaldoLucrado() + (valor * (0.5)));
        jogador.setTotalRoleta(jogador.getTotalRoleta() + 1);
    }

    @Override
    public void perder(double valor) {
        jogador.atualizarSaldo(valor * (-1));
        jogador.setDerrotaTotal(jogador.getDerrotaTotal() + 1);
        jogador.setDerrotaRoleta(jogador.getDerrotaRoleta() + 1);
        jogador.setSaldoPerdido(jogador.getSaldoPerdido() + valor);
        jogador.setTotalRoleta(jogador.getTotalRoleta() + 1);
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public double getAposta() {
        return aposta;
    }

    public void setAposta(double aposta) {
        this.aposta = aposta;
    }

    public int getNumeroSorteado() {
        return numeroSorteado;
    }

    public void setNumeroSorteado(int numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }
}
