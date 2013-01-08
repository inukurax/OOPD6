package spreadsheet;

import java.util.Iterator;
import java.util.NoSuchElementException;
import spreadsheet.textual.Text;

import spreadsheet.exception.InvalidReference;

public final class Reference
    extends Expression {

  private final Spreadsheet spreadsheet;
  private final Position position;

  public Reference(final Spreadsheet spreadsheet, final Position position) {
    super(GenericType.instance);
    this.spreadsheet = spreadsheet;
    this.position = position;
  }

  private Expression getExpression() {
    final Expression expression = this.spreadsheet.get(this.position);
    if (expression == null) {
      return new Text("");
    }
    return expression;
  }

  public boolean toBoolean() {
    return this.getExpression().toBoolean();
  }

  public int toInt() {
    return this.getExpression().toInt();
  }

  public String toString() {
    return this.getExpression().toString();
  }

  public void checkAcyclic(final Path path)
      throws CycleException {
    if (Reference.IsPositionInPath(this.position, path)) {
      throw new CycleException(path);
    }
    getExpression().checkAcyclic(new Path(this.position, path));
  }

  public String getDescription() {
    final String positionDescription = this.position.getDescription();
    if (Application.instance.getWorksheet().equals(this.spreadsheet)) {
      return positionDescription;
    } else {
      return String.format("%s!%s",
        this.spreadsheet.getName(),
        positionDescription);
    }
  }

  private static boolean IsPositionInPath(
      final Position position,
      final Path path) {
    for (Path tail = path; tail != null; tail = tail.tail) {
      if (tail.head.equals(position)) {
        return true;
      }
    }
    return false;
  }

  public final class Path {

    public final Position head;
    public final Path tail;

    private Path(final Position head, final Path tail) {
      this.head = head;
      this.tail = tail;
    }

    @Override
    public String toString() {
      final StringBuilder builder = new StringBuilder(head.toString());
      for (Path path = this.tail; path != null; path = path.tail) {
        builder.append(path.head.toString());
      }
      return builder.toString();
    }

  }

}
