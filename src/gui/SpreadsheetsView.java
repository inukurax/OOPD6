package gui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import spreadsheet.Application;
import spreadsheet.Spreadsheet;
import spreadsheet.exception.NoSuchSpreadsheetException;

public final class SpreadsheetsView
    extends JTabbedPane {

  public static final long serialVersionUID = 1L;

  public static final SpreadsheetsView instance = new SpreadsheetsView();

  private SpreadsheetsView() {
	  Spreadsheet sheet0 = Application.instance.getWorksheet();
	  SpreadsheetView pane = new SpreadsheetView(sheet0);
	  this.addChangeListener(new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent arg0) {
			try {
				Application.instance.changeWorksheet(instance.getCurrentTabName());
			} catch (NoSuchSpreadsheetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  
	  });
	  this.addTab(sheet0.getName(), pane);
	  
  }
  
  public void addNewSpreadsheet(Spreadsheet sheet) {
	  SpreadsheetView pane = new SpreadsheetView(sheet);
	  this.addTab(sheet.getName(), pane);
  }
  
  public String getCurrentTabName() {
      int index = this.getSelectedIndex();
	  return this.getTitleAt(index);
  }
  
  public void removeCurrentTab() {
      int index = this.getSelectedIndex();
	  this.remove(index);
  }
  
}
