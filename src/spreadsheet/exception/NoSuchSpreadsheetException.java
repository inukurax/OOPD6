package spreadsheet.exception;

public final class NoSuchSpreadsheetException
    extends Exception {

  public static final long serialVersionUID = 1L;

  /* Assumes that name is not null. */
  public NoSuchSpreadsheetException(final String name) {
    super(
      String.format("No such spreadsheet, \"%s\".", name));
  }

}
