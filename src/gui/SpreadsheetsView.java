package gui;

import javax.swing.JTabbedPane;

import spreadsheet.Application;
import spreadsheet.Spreadsheet;

public final class SpreadsheetsView
    extends JTabbedPane {

  public static final long serialVersionUID = 1L;

  public static final SpreadsheetsView instance = new SpreadsheetsView();

  private SpreadsheetsView() {
	  Spreadsheet sheet0 = Application.instance.getWorksheet();
	  SpreadsheetView pane = new SpreadsheetView(sheet0);
	  this.addTab(sheet0.getName(), pane);
  }
  
  public void addNewSpreadsheet(Spreadsheet sheet) {
	  SpreadsheetView pane = new SpreadsheetView(sheet);
	  this.addTab(sheet.getName(), pane);
  }

}
