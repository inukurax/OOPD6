package spreadsheet.expression;

import spreadsheet.CycleException;
import spreadsheet.Expression;
import spreadsheet.Reference;
import spreadsheet.Type;

public abstract class TernaryExpression
    extends Expression {

  protected final Expression alpha, beta, gamma;

  protected TernaryExpression(
      final Type type,
      final Expression alpha,
      final Expression beta,
      final Expression gamma) {
    super(type);
    this.alpha = alpha;
    this.beta = beta;
    this.gamma = gamma;
  }

  public void checkAcyclic(final Reference.Path path)
      throws CycleException {
    this.alpha.checkAcyclic(path);
    this.beta.checkAcyclic(path);
    this.gamma.checkAcyclic(path);
  }

  public String getDescription() {
    return String.format("%s %s %s %s",
      this.getClass().getSimpleName(),
      this.alpha.getDescription(),
      this.beta.getDescription(),
      this.gamma.getDescription()
    );
  }

}
