
import java.util.Random;

public class BaralhoPoker {

    private boolean baralho[][], turno[], aumento, apostar;
    private double apostaMao, aposta;
    private int cartaMesa[], naipaMesa[];

    public BaralhoPoker() {
        baralho = new boolean[4][13];
        turno = new boolean[4];
        cartaMesa = new int[5];
        naipaMesa = new int[5];
        turno[0] = true;
        apostaMao = 0;
        aposta = 0;
        aumento = false;
        apostar = false;
    }

    public void passarTurno() {
        for (int i = 0; i < getTurno().length; i++) {
            if (getTurno()[i]) {
                turno[i] = false;
                turno[(i + 1)] = true;
                dealerVirarCarta();
                aumento = false;
                apostar = false;
                break;
            }
        }
    }

    public void dealerVirarCarta() {
        Random r = new Random();
        int x = 0, y = 0, cont = 0;
        for (int i = 0; i < getTurno().length; i++) {
            if (getTurno()[i]) {
                switch (i) {
                    case 1:
                        do {
                            do {
                                x = r.nextInt(4);
                                y = r.nextInt(13);
                            } while (getBaralho()[x][y]);
                            baralho[x][y] = true;
                            cartaMesa[cont] = y + 1;
                            naipaMesa[cont] = x;
                            cont++;
                        } while (cont < 3);
                        break;
                    case 2:
                        do {
                            x = r.nextInt(4);
                            y = r.nextInt(13);
                        } while (getBaralho()[x][y]);
                        baralho[x][y] = true;
                        cartaMesa[3] = y + 1;
                        naipaMesa[3] = x;
                        break;
                    case 3:
                        do {
                            x = r.nextInt(4);
                            y = r.nextInt(13);
                        } while (getBaralho()[x][y]);
                        baralho[x][y] = true;
                        cartaMesa[4] = y + 1;
                        System.out.println(y);
                        naipaMesa[4] = x;
                        break;
                }
                break;
            }
        }
    }

    public boolean[][] getBaralho() {
        return baralho;
    }

    public void setBaralho(boolean[][] baralho) {
        this.baralho = baralho;
    }

    public boolean[] getTurno() {
        return turno;
    }

    public void setTurno(boolean[] turno) {
        this.turno = turno;
    }

    public double getApostaMao() {
        return apostaMao;
    }

    public void setApostaMao(double apostaMao) {
        this.apostaMao = apostaMao;
    }

    public double getAposta() {
        return aposta;
    }

    public void setAposta(double aposta) {
        this.aposta = aposta;
    }

    public int[] getCartaMesa() {
        return cartaMesa;
    }

    public void setCartaMesa(int[] cartaMesa) {
        this.cartaMesa = cartaMesa;
    }

    public int[] getNaipaMesa() {
        return naipaMesa;
    }

    public void setNaipaMesa(int[] naipaMesa) {
        this.naipaMesa = naipaMesa;
    }

    public boolean isAumento() {
        return aumento;
    }

    public void setAumento(boolean aumento) {
        this.aumento = aumento;
    }

    public boolean isApostar() {
        return apostar;
    }

    public void setApostar(boolean apostar) {
        this.apostar = apostar;
    }
}
