package ui.command;

import spreadsheet.Application;
import spreadsheet.Position;
import spreadsheet.Expression;

import ui.StreamView;

public final class GetCommand
    extends Command {

  private final Position position;

  public GetCommand(final Position position) {
    this.position = position;
  }

  public void execute() {
    final Expression expression = Application.instance.get(this.position);
    if (expression == null) {
      StreamView.instance.println("");
      return;
    }

    StreamView.instance.println(expression.toString());
  }

}
