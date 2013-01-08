package gui.control;

import gui.SpreadsheetsView;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import spreadsheet.Application;

public final class DeleteListener
    implements ActionListener {

  public static final DeleteListener instance = new DeleteListener();

  private DeleteListener() {
    // This is a singleton.
  }

  public void actionPerformed(ActionEvent event) {
	SpreadsheetsView tab = SpreadsheetsView.instance;
    Application.instance.removeSpreadsheet(tab.getCurrentTabName());
    tab.removeCurrentTab();
  }

}
