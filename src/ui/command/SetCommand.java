package ui.command;

import spreadsheet.Application;
import spreadsheet.Position;
import spreadsheet.Expression;
import spreadsheet.Spreadsheet;

public final class SetCommand
    extends Command {

  private final Position position;
  private final Expression expression;

  public SetCommand(final Position position, final Expression expression) {
    this.position = position;
    this.expression = expression;
  }

  public void execute() {
    Application.instance.set(position, expression);
  }

}
