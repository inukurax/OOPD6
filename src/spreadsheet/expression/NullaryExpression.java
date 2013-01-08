package spreadsheet.expression;

import spreadsheet.CycleException;
import spreadsheet.Expression;
import spreadsheet.Reference;
import spreadsheet.Type;

public abstract class NullaryExpression
    extends Expression {

  protected NullaryExpression(final Type type) {
    super(type);
  }

  public void checkAcyclic(final Reference.Path path)
      throws CycleException {
    return;
  }

}
