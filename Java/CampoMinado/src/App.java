import java.util.Set;

public class App {

  private static final Set<String> DIFICULDADES_VALIDA = Set.of("0", "1", "2", "3");

  public static void main(String[] args) {
    runGame();
  }

  private static void runGame() {
    String opcaoMenu;

    do {
      UIGame.writeMenuInicial();
      opcaoMenu = UIGame.readInput();

      switch (opcaoMenu) {
      case "1" -> iniciarGame();
      case "0" -> {
        continue;
      }
      default -> UIGame.writeln("-> Opção inválida");
      }
    } while (!opcaoMenu.equals("0"));
  }

  private static void iniciarGame() {
    String opcaoDificuldade;

    do {
      UIGame.writeMenuDificuldade();
      opcaoDificuldade = UIGame.readInput();

      if (!DIFICULDADES_VALIDA.contains(opcaoDificuldade)) {
        UIGame.writeln("\n-> Dificuldade inválida");
      }
    } while (!DIFICULDADES_VALIDA.contains(opcaoDificuldade));

    Game game = new Game(Integer.parseInt(opcaoDificuldade));
    UIGame uiGame = new UIGame(game);

    game.iniciar();

    final int COMPRIMENTO_TABULEIRO = game.getComprimento();

    do {
      uiGame.writeTabuleiro();

      String[] input = UIGame.readInput().split(" ");

      int x;
      int y;

      boolean isMarcarPosicao = false;

      try {
        switch (input.length) {
        case 1 -> {
          if (input[0].equals("esc")) {
            return;
          }
          if (input[0].equals("h")) {
            uiGame.writeTabuleiro(true);
          }

          continue;
        }
        case 2 -> {
          x = Integer.parseInt(input[0]) - 1;
          y = Integer.parseInt(input[1]) - 1;
        }
        case 3 -> {
          x = Integer.parseInt(input[1]) - 1;
          y = Integer.parseInt(input[2]) - 1;

          if (input[0].equals("!")) {
            isMarcarPosicao = true;
          }
        }
        default -> {
          UIGame.writeln("\n-> Coordenadas inválidas");
          continue;
        }
        }
      } catch (NumberFormatException e) {
        UIGame.writeln("\n-> Coordenadas inválidas");
        continue;
      }

      if (x < 0 || y < 0 || x >= COMPRIMENTO_TABULEIRO || y >= COMPRIMENTO_TABULEIRO) {
        UIGame.writeln("\n-> Coordenadas inválidas");
        continue;
      }

      if (!isMarcarPosicao) {
        game.abrirCasa(x, y);
      } else {
        game.marcarDesmarcarCasa(x, y);
      }
    } while (game.isJogando());

    uiGame.writeTabuleiro(true);

    if (game.isGanhou()) {
      UIGame.writeln("-> Win");
    } else {
      UIGame.writeln("-> Game Over");
    }
  }
}
