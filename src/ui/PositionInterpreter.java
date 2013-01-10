package ui;

import spreadsheet.Position;

import ui.exception.*;

public final class PositionInterpreter {

  private PositionInterpreter() {
    // The class should not be instantiated.
  }

  /**
   * fixed so doesnt throw out of bounds on empty Strings.
   * @param text a position in format A5 for (0,5)
   * @return a Position
   * @throws InvalidPositionException
  /** We have made minor tweaks to catch more position errors */

  public static Position interpret(final String text)
      throws InvalidPositionException {
	  
	if (text == null || text.isEmpty()) 
		throw new InvalidPositionException();
	
    int i = 0;
    char c = text.charAt(i);
    if (!isAlpha(c) || (text.length() <= 1)) {
      throw new InvalidPositionException();
    }
    int column = 0;
    int offset = 1;
    do {
      column += (c - 'A') * offset;
      offset *= 10;
      i++;
      c = text.charAt(i);
    } while (isAlpha(c) && (text.length() < i));

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
