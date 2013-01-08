package spreadsheet.arithmetic;

import spreadsheet.Expression;
import spreadsheet.expression.BinaryExpression;

public final class Add
    extends BinaryExpression {

  public Add(
      final Expression alpha,
      final Expression beta) {
    super(ArithmeticType.instance, alpha, beta);
  }

  @Override
  public int toInt() {
    return this.alpha.toInt() + this.beta.toInt();
  }

}
