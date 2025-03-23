
import Components.Game;
import Util.Console;

public class App {

  private static final Console menuInitialConsole = new Console(
      """
          +- Menu
          | 1 - New Game
          | ESC - Quit
          +-""",
      new String[] { "1", "ESC" });

  private static final Game game = new Game();

  public static void main(String[] args) {
    // menu();
    startGame();
  }

  public static void menu() {
    String prompt;
    do {
      prompt = menuInitialConsole.read();

      if (prompt.equalsIgnoreCase("1")) {
        startGame();
      }
    } while (!prompt.equalsIgnoreCase("ESC"));
  }

  public static void startGame() {
    game.run();
  }
}
