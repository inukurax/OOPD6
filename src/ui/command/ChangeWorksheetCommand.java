package ui.command;

import spreadsheet.Application;
import spreadsheet.exception.*;
import ui.StreamView;

public final class ChangeWorksheetCommand
    extends Command {

  private final String name;

  /* Assumes that name is not null. */
  public ChangeWorksheetCommand(final String name) {
    this.name = name;
  }

  public void execute() {
    try {
      Application.instance.changeWorksheet(this.name);
    }
    catch (NoSuchSpreadsheetException e) {
      StreamView.instance.println(e.getMessage());
    }
  }

}
