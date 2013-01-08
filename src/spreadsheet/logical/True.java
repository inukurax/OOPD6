package spreadsheet.logical;

import spreadsheet.expression.NullaryExpression;

public final class True
    extends NullaryExpression {

  public True() {
    super(LogicalType.instance);
  }

  @Override
  public boolean toBoolean() {
    return true;
  }

  public String getDescription() {
    return String.format("%s",
      this.getClass().getSimpleName()
    );
  }

}
