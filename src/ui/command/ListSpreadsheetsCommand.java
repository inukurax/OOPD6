package ui.command;

import spreadsheet.Application;

import ui.StreamView;

public final class ListSpreadsheetsCommand
    extends Command {

  public void execute() {
    for (String spreadsheet : Application.instance.getSpreadsheets()) {
      StreamView.instance.println(spreadsheet);
    }
  }

}
