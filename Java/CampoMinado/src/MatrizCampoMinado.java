import java.util.Random;

public class MatrizCampoMinado {

  public static byte CASA_BOMBA = -1;

  private byte[][] tabuleiro;

  private final int comprimento;
  private final int quantidadeBombas;

  public MatrizCampoMinado(int comprimento, int quantidadeBombas) {
    this.quantidadeBombas = quantidadeBombas;
    this.comprimento = comprimento;
  }

  public void carregarTabuleiro() {
    limpar();
    carregarBombas(quantidadeBombas);
    carregarNumeros();
  }

  private void carregarBombas(int quantidade) {
    Random r = new Random();

    for (int i = 0; i < quantidade; i++) {
      int x, y;

      do {
        x = r.nextInt(comprimento);
        y = r.nextInt(comprimento);

      } while (getCasa(x, y) == CASA_BOMBA);

      tabuleiro[x][y] = CASA_BOMBA;
    }
  }

  private void carregarNumeros() {
    for (int i = 0; i < tabuleiro.length; i++) {
      for (int j = 0; j < tabuleiro[i].length; j++) {
        if (!isBomba(i, j)) {
          continue;
        }

        MatrizUtil.iterateAround(tabuleiro, i, j, (x, y) -> {
          if (!isBomba(x, y)) {
            tabuleiro[x][y]++;
          }
        });
      }
    }
  }

  private void limpar() {
    tabuleiro = new byte[comprimento][comprimento];
  }

  public boolean isBomba(int x, int y) {
    return tabuleiro[x][y] == CASA_BOMBA;
  }

  public int getCasa(int x, int y) {
    return tabuleiro[x][y];
  }

  public byte[][] getTabuleiro() {
    return tabuleiro;
  }
}
