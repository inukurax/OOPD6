package spreadsheet.expression;

import spreadsheet.CycleException;
import spreadsheet.Expression;
import spreadsheet.Reference;
import spreadsheet.Type;

public abstract class UnaryExpression
    extends Expression {

  protected final Expression alpha;

  protected UnaryExpression(
      final Type type,
      final Expression alpha) {
    super(type);
    this.alpha = alpha;
  }

  public void checkAcyclic(final Reference.Path path)
      throws CycleException {
    this.alpha.checkAcyclic(path);
  }

  public String getDescription() {
    return String.format("%s %s",
      this.getClass().getSimpleName(),
      this.alpha.getDescription()
    );
  }

}
