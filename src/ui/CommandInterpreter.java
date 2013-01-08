package ui;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import ui.command.*;
import ui.exception.*;

import spreadsheet.exception.*;

public final class CommandInterpreter {

  private CommandInterpreter() {
    // The class should not be instanciated.
  }

  public static Command interpret(final Scanner scanner) {
    final String keyword = scanner.next();
    switch(keyword) {
      case "exit":
        return new ExitCommand();
      case "pws":
        return new PrintWorksheetCommand();
      case "ns":
        return new NewSpreadsheetCommand();
      case "ls":
        return new ListSpreadsheetsCommand();
      case "cws":
        try {
          return new ChangeWorksheetCommand(scanner.next());
        } catch (NoSuchElementException _) {
          return new FailedCommand("Please specify a spreadsheet name.");
        }
      case "set":
        try {
          return new SetCommand(
            PositionInterpreter.interpret(scanner.next()),
            ExpressionInterpreter.interpret(scanner));
        } catch (InvalidPositionException _) {
          return new FailedCommand("Invalid position.");
        } catch (NoSuchSpreadsheetException e) {
          return new FailedCommand(e.getMessage());
        } catch (IllegalStartOfExpression e) {
          return new FailedCommand(e.getMessage());
        } catch (InvalidExpression e) {
          return new FailedCommand(e.getMessage());
        }
      case "get":
        try {
          return new GetCommand(
            PositionInterpreter.interpret(scanner.next()));
        } catch (InvalidPositionException _) {
          return new FailedCommand("Invalid position.");
        }
    }
    return new FailedCommand(
      String.format("Illegal start of command, \"%s\".", keyword));
  }

}
