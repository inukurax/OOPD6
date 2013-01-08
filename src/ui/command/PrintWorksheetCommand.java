package ui.command;

import spreadsheet.Application;

import ui.StreamView;

public final class PrintWorksheetCommand
    extends Command {

  public void execute() {
    StreamView.instance.println(Application.instance.getWorksheet().getName());
  }

}
