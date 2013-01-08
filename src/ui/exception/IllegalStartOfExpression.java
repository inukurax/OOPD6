package ui.exception;

public final class IllegalStartOfExpression
    extends Exception {

  public final static long serialVersionUID = 1L;

  public IllegalStartOfExpression(final String keyword) {
    super(String.format(
      "Illegal start of expression \"%s\".", keyword));
  }

}
