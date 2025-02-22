
import java.util.Random;

public class Ranking {

    private int classificacao[], historicoRodada[], valorRodada;

    public Ranking() {
        historicoRodada = new int[50];
        classificacao = new int[20];
    }

    public void atualizarRank(Bingo b) {
        for (int i = 0; i < getClassificacao().length; i++) {
            if (getClassificacao()[i] == 0) {
                classificacao[i] = b.getNumero();
                break;
            }
        }
    }

    public void valorRodada() {
        Random r = new Random();
        for (int i = 0; i < getHistoricoRodada().length; i++) {
            if (getHistoricoRodada()[i] == 0) {
                boolean passar;
                do {
                    passar = true;
                    historicoRodada[i] = r.nextInt(50) + 1;
                    setValorRodada(getHistoricoRodada()[i]);
                    if (i != 0) {
                        for (int j = 0; j < getHistoricoRodada().length; j++) {
                            if (i != j) {
                                if (getHistoricoRodada()[i] == getHistoricoRodada()[j]) {
                                    passar = false;
                                    break;
                                }
                            }
                        }
                    }
                } while (!passar);
                break;
            }
        }
    }

    public int[] getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int[] classificacao) {
        this.classificacao = classificacao;
    }

    public int[] getHistoricoRodada() {
        return historicoRodada;
    }

    public void setHistoricoRodada(int[] historicoRodada) {
        this.historicoRodada = historicoRodada;
    }

    public int getValorRodada() {
        return valorRodada;
    }

    public void setValorRodada(int valorRodada) {
        this.valorRodada = valorRodada;
    }
}
