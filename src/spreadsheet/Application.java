package spreadsheet;

import java.util.ArrayList;
import java.util.Iterator;

import spreadsheet.textual.Text;
import spreadsheet.exception.*;

/** A singleton class representing a spreadsheet application.
 *
 * The instance is initialized on first mention of the class.
 */
public final class Application {

  private ArrayList<Spreadsheet> spreadsheets;
  private Spreadsheet worksheet;
  private Position currentPosition;

  private Application() {
    this.worksheet = new Spreadsheet();
    this.spreadsheets = new ArrayList<Spreadsheet>();
    this.spreadsheets.add(this.worksheet);
    this.currentPosition = new Position(0, 0);
  }

  public static final Application instance = new Application();

  /* Guaranteed not null. */
  public Position getCurrentPosition() {
    return this.currentPosition;
  }

  /* Assumes that position is not null. */
  public void setCurrentPosition(final Position position) {
    this.currentPosition = position;
  }

  /* Guaranteed not null. */
  public Spreadsheet getWorksheet() {
    return this.worksheet;
  }

  public Spreadsheet newSpreadsheet() {
    final Spreadsheet spreadsheet = new Spreadsheet();
    this.spreadsheets.add(spreadsheet);
    return spreadsheet;
  }

  /* Assumes name is not null. If there is no spreadsheet by the given name,
   * nothing happens. Removes only the first occurance. */
  public void removeSpreadsheet(final String name) {
    final Iterator<Spreadsheet> iterator = this.spreadsheets.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getName().equals(name)) {
        iterator.remove();
        return;
      }
    }
  }

  /* Assumes that name is not null. */
  public Spreadsheet getSpreadsheet(final String name)
      throws NoSuchSpreadsheetException {
    for (final Spreadsheet spreadsheet : this.spreadsheets) {
      if (name.equals(spreadsheet.getName())) {
        return spreadsheet;
      }
    }
    throw new NoSuchSpreadsheetException(name);
  }

  /* Assumes that name is not null. */
  public void changeWorksheet(final String name)
      throws NoSuchSpreadsheetException {
    this.worksheet = this.getSpreadsheet(name);
  }

  public Iterable<String> getSpreadsheets() {
    final ArrayList<String> names =
      new ArrayList<String>(this.spreadsheets.size());
    for (final Spreadsheet spreadsheet : this.spreadsheets) {
      names.add(spreadsheet.getName());
    }
    return names;
  }

  public void exit() {
    System.exit(0);
  }

  public void set(final Position position, final Expression expression) {
    this.worksheet.set(position, expression);
  }

  public void set(final Expression expression) {
    this.set(this.currentPosition, expression);
  }

  public Expression get(final Position position) {
    final Expression expression = this.worksheet.get(position);
    if (expression == null) {
      return new Text("");
    }
    return expression;
  }

  public Expression get() {
    return this.get(this.currentPosition);
  }

}
