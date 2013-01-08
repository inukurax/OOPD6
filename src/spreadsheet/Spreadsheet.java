package spreadsheet;

import java.util.HashMap;

public final class Spreadsheet {

  private static final String NAME_PREFIX = "Sheet";
  private static int NAME_OFFSET = 0;

  private static int count;

  private final HashMap<Position, Expression> map;
  private String name;
  private int maxColumn = 20, maxRow = 20;

  public Spreadsheet() {
    this.name = Spreadsheet.NAME_PREFIX + Spreadsheet.NAME_OFFSET;
    Spreadsheet.NAME_OFFSET += 1;
    this.map = new HashMap<Position, Expression>();
  }

  /* Assumes that name is not null. */
  public Spreadsheet(final String name) {
    this.name = name;
    this.map = new HashMap<Position, Expression>();
  }

  /* Guaranteed not null. */
  public String getName() {
    return this.name;
  }

  /* Assumes name is not null. */
  public void setName(final String name) {
    this.name = name;
  }

  /* Assumes position and expression are not null. */
  public void set(final Position position, final Expression expression) {
    this.map.put(position, expression);
  }

  /* Assumes position is not null.
   * Returns null if the position is not associated with an expression. */
  public Expression get(final Position position) {
    return this.map.get(position);
  }

  public int getMaxColumn() {
    return this.maxColumn;
  }

  public int getMaxRow() {
    return this.maxRow;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || !(other instanceof Spreadsheet)) {
      return false;
    }
    return this.name.equals(((Spreadsheet)other).name);
  }

  @Override
  public int hashCode() {
    return this.name.hashCode();
  }

}
