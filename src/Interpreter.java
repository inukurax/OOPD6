import java.io.PrintStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import ui.*;

final class Interpreter {

  private final PrintStream out;
  private final Scanner scanner;

  public Interpreter() {
    this.scanner = new Scanner(System.in);
    this.out = System.out;
  }

  /** Assumes that in and out are not null. */
  public Interpreter(final InputStream in, final PrintStream out) {
    this.scanner = new Scanner(in);
    this.out = out;
  }

  public void prompt() {
    String command = null;
    while(true) {
      this.out.print("> ");
      command = this.scanner.nextLine();
      CommandInterpreter.interpret(new Scanner(command)).execute();
    }
  }

  public static void main(String[] _) {
    new Interpreter().prompt();
  }

}
