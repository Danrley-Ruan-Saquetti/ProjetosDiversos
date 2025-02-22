
import java.util.Random;

public class Maos extends Controle_Vitoria_Derrota {

    private Jogador jogador;
    private BaralhoPoker baralho;
    private int cartaMao[], naipaMao[], codigo, melhorMao[], cartaJogo[], naipaJogo[];
    private boolean acao[], rankingCarta[];
    private double saldo, apostar;
    private final double buy_in;

    public Maos(Jogador jogador, BaralhoPoker baralho, double buy, double sal, int cod) {
        this.jogador = jogador;
        this.baralho = baralho;
        rankingCarta = new boolean[10];
        acao = new boolean[5];
        cartaMao = new int[2];
        naipaMao = new int[2];
        melhorMao = new int[5];
        cartaJogo = new int[7];
        naipaJogo = new int[7];
        rankingCarta[0] = true;
        codigo = cod;
        apostar = 0;
        buy_in = buy;
        saldo = sal;
    }

    @Override
    public void vencer(double valor) {
        jogador.atualizarSaldo(valor);
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

    public void darCartasJogador() {
        Random r = new Random();
        int x = 0, y = 0, cont = 0, numero[] = new int[2], naipa[] = new int[2];
        boolean bar[][] = new boolean[4][13];
        do {
            do {
                x = r.nextInt(4);
                y = r.nextInt(13);
            } while (baralho.getBaralho()[x][y]);
            bar[x][y] = true;
            numero[cont] = y + 1;
            naipa[cont] = x;
            cont++;
        } while (cont < 1);
        setCartaMao(numero);
        setNaipaMao(naipa);
        baralho.setBaralho(bar);
    }

    public void classificarMao() {
        for (int i = 0; i < getCartaJogo().length; i++) {
            if (i < 2) {
                cartaJogo[i] = getCartaMao()[i];
                naipaJogo[i] = getNaipaMao()[i];
            } else {
                cartaJogo[i] = baralho.getCartaMesa()[(i - 2)];
                naipaJogo[i] = baralho.getNaipaMesa()[(i - 2)];
            }
        }

        for (int i = 0; i < baralho.getTurno().length; i++) {
            if (baralho.getTurno()[i]) {
                int repetida1 = 0,
                        repetida2 = 0,
                        par1 = -1,
                        par2 = -1;
                switch (i) {
                    case 0:
                        if (getCartaMao()[0] == getCartaMao()[1]) {
                            rankingCarta[1] = true;
                        }
                        break;
                    case 1:
                        for (int j = 0; j < getCartaJogo().length - 2; j++) {
                            for (int k = j; k < getCartaJogo().length - 2; k++) {
                                if (j != k) {
                                    if (getCartaJogo()[j] == getCartaJogo()[k]) {
                                        if (par1 == -1) {
                                            par1 = getCartaJogo()[j];
                                            repetida1++;
                                        } else {
                                            if (par1 == getCartaJogo()[j]) {
                                                repetida1++;
                                            } else {
                                                if (par2 == -1) {
                                                    par2 = getCartaJogo()[j];
                                                    repetida2++;
                                                } else {
                                                    repetida2++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        for (int j = 0; j < getRankingCarta().length; j++) {
                            if (getRankingCarta()[j]) {
                                if ((repetida1 != 0) && (repetida2 != 0)) {
                                    if (((repetida1 == 3) || (repetida2 == 3)) && ((repetida1 == 2) || (repetida2 == 2))) {
                                        if (j < 6) {
                                            rankingCarta[6] = true;
                                            rankingCarta[j] = false;
                                        }

                                    } else if ((repetida1 == 3) || (repetida2 == 3)) {
                                        if (getRankingCarta()[j]) {
                                            if (j < 3) {
                                                rankingCarta[3] = true;
                                                rankingCarta[j] = false;
                                            }
                                        }
                                    } else if ((repetida1 == 2) && (repetida2 == 2)) {
                                        if (getRankingCarta()[j]) {
                                            if (j < 2) {
                                                rankingCarta[2] = true;
                                                rankingCarta[j] = false;
                                            }
                                        }
                                    } else if ((repetida1 == 2) || (repetida2 == 2)) {
                                        if (getRankingCarta()[j]) {
                                            if (j < 1) {
                                                rankingCarta[1] = true;
                                                rankingCarta[j] = false;
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (int j = 0; j < getCartaJogo().length - 1; j++) {
                            for (int k = j; k < getCartaJogo().length - 1; k++) {
                                if (j != k) {
                                    if (getCartaJogo()[j] == getCartaJogo()[k]) {
                                        if (par1 == -1) {
                                            par1 = getCartaJogo()[j];
                                            repetida1++;
                                        } else {
                                            if (par1 == getCartaJogo()[j]) {
                                                repetida1++;
                                            } else {
                                                if (par2 == -1) {
                                                    par2 = getCartaJogo()[j];
                                                    repetida2++;
                                                } else {
                                                    repetida2++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        for (int j = 0; j < getRankingCarta().length; j++) {
                            if (getRankingCarta()[j]) {
                                if ((repetida1 != 0) && (repetida2 != 0)) {
                                    if (((repetida1 == 3) || (repetida2 == 3)) && ((repetida1 == 2) || (repetida2 == 2))) {
                                        if (j < 6) {
                                            rankingCarta[6] = true;
                                            rankingCarta[j] = false;
                                        }

                                    } else if ((repetida1 == 3) || (repetida2 == 3)) {
                                        if (getRankingCarta()[j]) {
                                            if (j < 3) {
                                                rankingCarta[3] = true;
                                                rankingCarta[j] = false;
                                            }
                                        }
                                    } else if ((repetida1 == 2) && (repetida2 == 2)) {
                                        if (getRankingCarta()[j]) {
                                            if (j < 2) {
                                                rankingCarta[2] = true;
                                                rankingCarta[j] = false;
                                            }
                                        }
                                    } else if ((repetida1 == 2) || (repetida2 == 2)) {
                                        if (getRankingCarta()[j]) {
                                            if (j < 1) {
                                                rankingCarta[1] = true;
                                                rankingCarta[j] = false;
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    case 3:
                        for (int j = 0; j < getCartaJogo().length; j++) {
                            for (int k = j; k < getCartaJogo().length; k++) {
                                if (j != k) {
                                    if (getCartaJogo()[j] == getCartaJogo()[k]) {
                                        if (par1 == -1) {
                                            par1 = getCartaJogo()[j];
                                            repetida1++;
                                        } else {
                                            if (par1 == getCartaJogo()[j]) {
                                                repetida1++;
                                            } else {
                                                if (par2 == -1) {
                                                    par2 = getCartaJogo()[j];
                                                    repetida2++;
                                                } else {
                                                    repetida2++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        for (int j = 0; j < getRankingCarta().length; j++) {
                            if (getRankingCarta()[j]) {
                                if ((repetida1 != 0) && (repetida2 != 0)) {
                                    if (((repetida1 == 3) || (repetida2 == 3)) && ((repetida1 == 2) || (repetida2 == 2))) {
                                        if (j < 6) {
                                            rankingCarta[6] = true;
                                            rankingCarta[j] = false;
                                        }

                                    } else if ((repetida1 == 3) || (repetida2 == 3)) {
                                        if (getRankingCarta()[j]) {
                                            if (j < 3) {
                                                rankingCarta[3] = true;
                                                rankingCarta[j] = false;
                                            }
                                        }
                                    } else if ((repetida1 == 2) && (repetida2 == 2)) {
                                        if (getRankingCarta()[j]) {
                                            if (j < 2) {
                                                rankingCarta[2] = true;
                                                rankingCarta[j] = false;
                                            }
                                        }
                                    } else if ((repetida1 == 2) || (repetida2 == 2)) {
                                        if (getRankingCarta()[j]) {
                                            if (j < 1) {
                                                rankingCarta[1] = true;
                                                rankingCarta[j] = false;
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        break;
                }
            }
        }

    }

    public void apostar(double valor) {
        setApostar(valor);
        setSaldo(getSaldo() - valor);
        baralho.setAposta(getApostar() + valor);
        baralho.setApostar(true);
    }

    public void all_in() {
        setApostar(getSaldo());
        baralho.setAposta(getApostar() + getSaldo());
        setSaldo(0);
        baralho.setApostar(true);
    }

    public void pagar(double valor) {
        if (valor > getSaldo()) {
            setApostar(getSaldo());
            setSaldo(0);
        } else {
            setApostar(getSaldo() - valor);
            setSaldo(getSaldo() - valor);
        }
        baralho.setAposta(baralho.getAposta() + getSaldo());
        baralho.setApostar(true);
    }

    public void aumentar(double valor) {
        setApostar(getSaldo());
        baralho.setAposta(baralho.getAposta() + getSaldo());
        setSaldo(0);
        baralho.setApostar(true);
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public BaralhoPoker getBaralho() {
        return baralho;
    }

    public void setBaralho(BaralhoPoker baralho) {
        this.baralho = baralho;
    }

    public int[] getCartaMao() {
        return cartaMao;
    }

    public void setCartaMao(int[] cartaMao) {
        this.cartaMao = cartaMao;
    }

    public int[] getNaipaMao() {
        return naipaMao;
    }

    public void setNaipaMao(int[] naipaMao) {
        this.naipaMao = naipaMao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean[] getAcao() {
        return acao;
    }

    public void setAcao(boolean[] acao) {
        this.acao = acao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int[] getMelhorMao() {
        return melhorMao;
    }

    public void setMelhorMao(int[] melhorMao) {
        this.melhorMao = melhorMao;
    }

    public double getApostar() {
        return apostar;
    }

    public void setApostar(double apostar) {
        this.apostar = apostar;
    }

    public boolean[] getRankingCarta() {
        return rankingCarta;
    }

    public void setRankingCarta(boolean[] rankingCarta) {
        this.rankingCarta = rankingCarta;
    }

    public int[] getCartaJogo() {
        return cartaJogo;
    }

    public void setCartaJogo(int[] cartaJogo) {
        this.cartaJogo = cartaJogo;
    }

    public int[] getNaipaJogo() {
        return naipaJogo;
    }

    public void setNaipaJogo(int[] naipaJogo) {
        this.naipaJogo = naipaJogo;
    }

    public double getBuy_in() {
        return buy_in;
    }
}
