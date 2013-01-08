package spreadsheet.arithmetic;

import java.util.Scanner;

import spreadsheet.expression.NullaryExpression;

public final class Int
    extends NullaryExpression {

  private final int value;

  public Int(final int value) {
    super(ArithmeticType.instance);
    this.value = value;
  }

  public Int(final Scanner scanner) {
    super(ArithmeticType.instance);
    this.value = scanner.nextInt();
  }

  @Override
  public int toInt() {
    return this.value;
  }

  public String getDescription() {
    return String.format("%s %d",
      this.getClass().getSimpleName(),
      this.value
    );
  }

}
