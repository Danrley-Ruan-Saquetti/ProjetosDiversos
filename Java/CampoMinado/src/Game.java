public class Game {

  public static final byte CASA_VISIVEL_FECHADO = 0;
  public static final byte CASA_VISIVEL_ABERTO = 1;
  public static final byte CASA_VISIVEL_MARCADO = 2;

  private final MatrizCampoMinado matrizCampoMinado;

  private byte[][] tabuleiroVisivel;

  private final int comprimento;
  private final int quantidadeBombas;

  private boolean jogando;
  private boolean ganhou;

  private int quantidadeCasaAberta;

  public Game(int dificuldade) {
    comprimento = getComprimentoByDificuldade(dificuldade);
    quantidadeBombas = getQuantidadeBombasByDificuldade(dificuldade);

    matrizCampoMinado = new MatrizCampoMinado(comprimento, quantidadeBombas);
  }

  private static int getComprimentoByDificuldade(int dificuldade) {
    return switch (dificuldade) {
    case 0 -> 5;
    case 1 -> 9;
    case 2 -> 16;
    case 3 -> 22;
    default -> 10;
    };
  }

  private static int getQuantidadeBombasByDificuldade(int dificuldade) {
    return switch (dificuldade) {
    case 0 -> 5;
    case 1 -> 10;
    case 2 -> 40;
    case 3 -> 90;
    default -> 10;
    };
  }

  public void iniciar() {
    matrizCampoMinado.carregarTabuleiro();
    tabuleiroVisivel = new byte[comprimento][comprimento];

    quantidadeCasaAberta = (comprimento * comprimento) - quantidadeBombas;

    jogando = true;
    ganhou = false;
  }

  public void abrirCasa(int x, int y) {
    if (isMarcado(x, y)) {
      return;
    }

    if (matrizCampoMinado.isBomba(x, y)) {
      exibirCasa(x, y);
      perder();

      return;
    }

    abrirCasas(x, y);

    if (isAllCasasVisiveis()) {
      ganhar();
    }
  }

  public void abrirCasas(int x, int y) {
    if (!isFechado(x, y)) {
      return;
    }

    exibirCasa(x, y);

    if (matrizCampoMinado.getCasa(x, y) > 0) {
      return;
    }

    MatrizUtil.iterateAround(tabuleiroVisivel, x, y, (i, j) -> {
      if (isFechado(i, j)) {
        abrirCasas(i, j);
      }
    });
  }

  public void marcarDesmarcarCasa(int x, int y) {
    if (isFechado(x, y)) {
      tabuleiroVisivel[x][y] = CASA_VISIVEL_MARCADO;
    } else if (isMarcado(x, y)) {
      tabuleiroVisivel[x][y] = CASA_VISIVEL_FECHADO;
    }
  }

  private void exibirCasa(int x, int y) {
    tabuleiroVisivel[x][y] = CASA_VISIVEL_ABERTO;
    quantidadeCasaAberta--;
  }

  private boolean isAllCasasVisiveis() {
    return quantidadeCasaAberta == 0;
  }

  private void ganhar() {
    jogando = false;
    ganhou = true;
  }

  private void perder() {
    jogando = false;
    ganhou = false;
  }

  public boolean isJogando() {
    return jogando;
  }

  public boolean isGanhou() {
    return ganhou;
  }

  public boolean isAberto(int x, int y) {
    return tabuleiroVisivel[x][y] == CASA_VISIVEL_ABERTO;
  }

  public boolean isMarcado(int x, int y) {
    return tabuleiroVisivel[x][y] == CASA_VISIVEL_MARCADO;
  }

  public boolean isFechado(int x, int y) {
    return tabuleiroVisivel[x][y] == CASA_VISIVEL_FECHADO;
  }

  public byte[][] getTabuleiroVisivel() {
    return tabuleiroVisivel;
  }

  public byte[][] getTabuleiroCampoMinado() {
    return matrizCampoMinado.getTabuleiro();
  }

  public int getComprimento() {
    return comprimento;
  }
}
