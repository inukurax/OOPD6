package spreadsheet.arithmetic;

import spreadsheet.Expression;
import spreadsheet.expression.UnaryExpression;

public final class Neg
    extends UnaryExpression {

  public Neg(final Expression alpha) {
    super(ArithmeticType.instance, alpha);
  }

  @Override
  public int toInt() {
    return -this.alpha.toInt();
  }

}
