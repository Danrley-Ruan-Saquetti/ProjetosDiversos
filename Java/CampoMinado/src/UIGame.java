import java.util.Scanner;

public class UIGame {

  private final static Scanner s = new Scanner(System.in);

  private final Game game;

  public UIGame(Game game) {
    this.game = game;
  }

  public static void writeMenuInicial() {
    write("""
        \n+- Campo Minado
        | 1 - Iniciar
        | 0 - Sair
        +-
        """);
  }

  public static void writeMenuDificuldade() {
    write("""
        \n+- Dificuldade
        | 0 - Partida Rápida
        | 1 - Fácil
        | 2 - Médio
        | 3 - Difícil
        +-
        """);
  }

  public void writeTabuleiro() {
    writeTabuleiro(false);
  }

  public void writeTabuleiro(boolean exibirCasaEscondida) {
    final int COL_WIDTH = 3;
    final String COL_SPACING = " ".repeat(COL_WIDTH);

    byte[][] campoMinado = game.getTabuleiroCampoMinado();

    int linhas = game.getComprimento();
    int colunas = game.getComprimento();

    String header = "  " + COL_SPACING;
    for (int i = 1; i <= colunas; i++) {
      header += String.format("%-" + COL_WIDTH + "d ", i);
    }

    write("\n" + header);

    for (int i = 0; i < linhas; i++) {
      write("\n   " + "-".repeat(colunas * 4 + 1));

      String linha = lpad(String.valueOf(i + 1), 2) + " |";

      for (int j = 0; j < colunas; j++) {
        String casa = game.isAberto(i, j) || exibirCasaEscondida ? formatCasa(campoMinado[i][j]) : game.isMarcado(i, j) ? " ! " : COL_SPACING;

        linha += casa + "|";
      }

      write("\n" + linha);
    }

    writeln("\n   " + "-".repeat(colunas * 4 + 1));
  }

  private static String formatCasa(int value) {
    String valueFormatted = switch (value) {
    case -1 -> "X";
    case 0 -> "_";
    default -> value + "";
    };

    return " " + valueFormatted + " ";
  }

  private static String lpad(String value, int length) {
    return String.format("%" + length + "s", value);
  }

  public static void write(String output) {
    System.out.print(output);
  }

  public static void writeln(String output) {
    System.out.println(output);
  }

  public static String readInput() {
    return readInput("");
  }

  public static String readInput(String inputName) {
    write("$ " + inputName);
    return s.nextLine();
  }
}
