package ui;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import spreadsheet.Position;

import ui.exception.*;

public final class PositionInterpreter {

  private PositionInterpreter() {
    // The class should not be instanciated.
  }

  public static Position interpret(final String text)
      throws InvalidPositionException {

    int i = 0;
    char c = text.charAt(i);
    if (!isAlpha(c)) {
      throw new InvalidPositionException();
    }
    int column = 0;
    int offset = 1;
    do {
      column += (c - 'A') * offset;
      offset *= 10;
      i++;
      c = text.charAt(i);
    } while (isAlpha(c));

    if (!isNumeric(c)) {
      throw new InvalidPositionException();
    }
    int row = 0;
    offset = 1;
    final int maxIndex = text.length() - 1;
    do {
      row += (c - '0') * offset;
      offset *= 10;
      if (i == maxIndex) {
        return new Position(column, row);
      }
      i++;
      c = text.charAt(i);
    } while (isNumeric(c));

    throw new InvalidPositionException();
  }

  private static boolean isAlpha(final char c) {
    return c >= 'A' && c <= 'Z';
  }

  private static boolean isNumeric(final char c) {
    return c >= '0' && c <= '9';
  }

}
