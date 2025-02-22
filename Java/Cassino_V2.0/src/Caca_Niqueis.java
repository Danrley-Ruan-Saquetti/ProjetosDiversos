
import java.util.Random;

public class Caca_Niqueis extends Controle_Vitoria_Derrota {

    private Jogador jogador;
    private int valor[];
    private int premio, par, trinca, quadra, perfeito;

    public Caca_Niqueis(Jogador jogo) {
        jogador = jogo;
        valor = new int[6];
        premio = 0;
    }

    public void rodarNiquel() {
        jogador.setSaldo(jogador.getSaldo() - 5);
        Random r = new Random();
        int x = 4, combo = 1;

        System.out.println("+---+---+---+---+---+---+");
        for (int i = 0; i < getValor().length; i++) {
            valor[i] = r.nextInt(6);
            System.out.print("| " + getValor()[i] + " ");
        }
        System.out.println("|\n+---+---+---+---+---+---+");
        for (int i = 0; i < getValor().length; i++) {
            if (x == 4) {
                x = i;
            } else if (x != i) {
                if (getValor()[i] == getValor()[x]) {
                    combo++;
                } else {
                    switch (combo) {
                        case 2:
                            setPar(getPar() + 1);
                            break;
                        case 3:
                            setTrinca(getTrinca() + 1);
                            break;
                        case 4:
                            setQuadra(getQuadra() + 1);
                            break;
                        case 5:
                            setPerfeito(getPerfeito() + 1);
                            break;
                    }
                    combo = 1;
                    x = 4;
                    i--;
                }
            }
        }
        setPremio((getPerfeito() * 50) + (getQuadra() * 30) + (getTrinca() * 25) + (getPar() * 15));
        if (getPremio() != 0) {
            vencer(getPremio());
        } else {
            perder(getPremio());
        }
    }

    @Override
    public void vencer(double valor) {
        jogador.atualizarSaldo(valor);
        jogador.setVitoriaTotal(jogador.getVitoriaTotal() + 1);
        jogador.setVitoriaCacaNiquel(jogador.getVitoriaCacaNiquel() + 1);
        jogador.setSaldoLucrado(jogador.getSaldoLucrado() + valor);
        jogador.setTotalCacaNiquel(jogador.getTotalCacaNiquel() + 1);
    }

    @Override
    public void perder(double valor) {
        jogador.atualizarSaldo(valor * (-1));
        jogador.setDerrotaTotal(jogador.getDerrotaTotal() + 1);
        jogador.setDerrotaCacaNiquel(jogador.getDerrotaCacaNiquel() + 1);
        jogador.setSaldoPerdido(jogador.getSaldoPerdido() + valor);
        jogador.setTotalCacaNiquel(jogador.getTotalCacaNiquel() + 1);
    }

    public int[] getValor() {
        return valor;
    }

    public void setValor(int[] valor) {
        this.valor = valor;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public int getTrinca() {
        return trinca;
    }

    public void setTrinca(int trinca) {
        this.trinca = trinca;
    }

    public int getQuadra() {
        return quadra;
    }

    public void setQuadra(int quadra) {
        this.quadra = quadra;
    }

    public int getPerfeito() {
        return perfeito;
    }

    public void setPerfeito(int perfeito) {
        this.perfeito = perfeito;
    }
}
