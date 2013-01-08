package spreadsheet.textual;

import spreadsheet.Expression;
import spreadsheet.expression.BinaryExpression;

public final class Concat
  extends BinaryExpression {

  public Concat(
      final Expression alpha,
      final Expression beta) {
    super(TextualType.instance, alpha, beta);
  }

  @Override
  public String toString() {
    return this.alpha.toString() + this.beta.toString();
  }

}
