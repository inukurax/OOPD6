package ui.command;

import spreadsheet.Application;

public final class NewSpreadsheetCommand
    extends Command {

  public void execute() {
    Application.instance.newSpreadsheet();
  }

}
