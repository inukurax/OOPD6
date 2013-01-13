package gui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import spreadsheet.Application;
import spreadsheet.Expression;
import spreadsheet.Position;
import spreadsheet.Spreadsheet;
import spreadsheet.exception.NoSuchSpreadsheetException;

public final class SpreadsheetsView
    extends JTabbedPane {

  public static final long serialVersionUID = 1L;

  public static final SpreadsheetsView instance = new SpreadsheetsView();

  private SpreadsheetsView() {
	  Spreadsheet sheet0 = Application.instance.getWorksheet();
	  SpreadsheetView pane = new SpreadsheetView(sheet0);
	  
	  this.addTab(sheet0.getName(), pane);
	  this.addChangeListener(new ChangeListener() {

			@Override
			/**
			 * Changes worksheet in Application to match current tab 
			 * when a new tab is clicked.
			 */
		public void stateChanged(ChangeEvent arg0) {
			//SpreadsheetSelectionListener.setPosition(null);
			if (instance.getTabCount() != 0)
				try {
				StatusView.instance.clearStatus();
				Application.instance.changeWorksheet(instance.getCurrentTabName());
				final Position pos = SpreadsheetSelectionListener.getPosition();
				final Expression exp = Application.instance.get(pos);
				if (pos != null)
					ExpressionView.instance.setExpressionText(
							exp.getDescription().replace("Text \"\"", ""));
			} catch (NoSuchSpreadsheetException e) {
				StatusView.instance.errorStatus("No such Spreadsheet");
			}
		}  
	  });
  }
  /**
   * Adds a new tab as SpreadsheetView(Spreadsheet)
   * @param sheet Spreadsheet to be added to new tab
   */
  public void addNewSpreadsheet(Spreadsheet sheet) {
	  SpreadsheetView pane = new SpreadsheetView(sheet);
	  this.addTab(sheet.getName(), pane);
  }
  
  /**
   * Accessor method for getting current tabs name
   * @return String of current tabs name.
   */
  public String getCurrentTabName() {
      int index = this.getSelectedIndex();
	  return this.getTitleAt(index);
  }
  
  /**
   * Removes the current tab
   */
  public void removeCurrentTab() {
      int index = this.getSelectedIndex();
	  this.remove(index);
  }
}
