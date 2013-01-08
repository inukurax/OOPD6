package gui.control;

import gui.SpreadsheetsView;
import gui.StatusView;

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
	if (0 != tab.getTabCount()) {
	    Application.instance.removeSpreadsheet(tab.getCurrentTabName());
		tab.removeCurrentTab();
	}
	else 
		StatusView.instance.errorStatus("No TABS");

  }

}
