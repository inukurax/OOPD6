package spreadsheet;

import spreadsheet.Expression;
import spreadsheet.Type;

final class GenericType extends Type {

  public static final GenericType instance = new GenericType();

  private GenericType() {
    // This is a singleton.
  }

  /* Assumes that expression override toInt. */
  public int toInt(final Expression expression) {
    return expression.toInt();
  }

  /* Assumes that expression override toBoolean. */
  public boolean toBoolean(final Expression expression) {
    return expression.toBoolean();
  }

  /* Assumes that expression override toString. */
  public String toString(final Expression expression) {
    return expression.toString();
  }

}
