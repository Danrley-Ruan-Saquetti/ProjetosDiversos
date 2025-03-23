package Util;

public class Console {

  private final String message;
  public String[] inputsEnables = new String[0];

  public Console() {
    this.message = "";
  }

  public Console(String info) {
    this.message = info;
  }

  public Console(String message, String[] inputsEnables) {
    this.message = message;
    this.inputsEnables = inputsEnables;
  }

  public String read() {
    return read(this.message, this.inputsEnables);
  }

  public static String read(String[] inputsEnables) {
    return read("", inputsEnables);
  }

  public static String read(String message, String[] inputsEnables) {
    boolean validInput;
    String prompt;

    do {
      if (!message.isEmpty()) {
        System.out.println(message);
      }

      System.out.print("$ ");

      prompt = Util.scan.nextLine().toUpperCase();

      validInput = validInputPrompt(prompt, inputsEnables);

      if (!validInput) {
        info("Prompt invalid!");
      }
    } while (!validInput);

    return prompt;
  }

  public static String readPrompt() {
    return Util.scan.nextLine().toUpperCase();
  }

  public static void log(String logMessage) {
    System.out.println(logMessage);
  }

  public static void info(String message) {
    System.out.println("-> " + message);
  }

  private static boolean validInputPrompt(String prompt, String[] inputsEnables) {
    if (inputsEnables.length == 0) {
      return true;
    }

    for (String inputEnable : inputsEnables) {
      if (prompt.equalsIgnoreCase(inputEnable)) {
        return true;
      }
    }

    return false;
  }
}
