package gui;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import spreadsheet.Application;
import spreadsheet.CycleException;
import spreadsheet.Expression;
import spreadsheet.Position;

public final class SpreadsheetSelectionListener
    implements ListSelectionListener {

  private final SpreadsheetView view;
  
  
  public SpreadsheetSelectionListener(final SpreadsheetView view) {
    this.view = view;
  }
  
  /**
   * Updates the TextField with info of selected cell.
   */
  public void valueChanged(ListSelectionEvent event) {
	
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        ExpressionView.instance.setExpressionText("");
      }
    });

    if (event.getValueIsAdjusting()) {
      return;
    }

    final int[] selectedRows = view.getSelectedRows();
    final int[] selectedColumns = view.getSelectedColumns();

    if (selectedRows.length > 1 || selectedColumns.length > 1) {
      return;
    }

    final Position position =
      new Position(selectedColumns[0], selectedRows[0]);

    Application.instance.setCurrentPosition(position);
    final Expression exp = Application.instance.get(position);
    final String description = exp.getDescription();


    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
    	if  (!description.equals("Text \"\""))
    		ExpressionView.instance.setExpressionText(position.getDescription() 
    				+ " " + description); 
    	else
    		ExpressionView.instance.setExpressionText(position.getDescription());
      StatusView.instance.clearStatus();
      	}
    });
  }

}
