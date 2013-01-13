package gui;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import spreadsheet.Application;
import spreadsheet.Expression;
import spreadsheet.Position;

public final class SpreadsheetSelectionListener
    implements ListSelectionListener {

  private final SpreadsheetView view;
  private static Position position = null;

  public SpreadsheetSelectionListener(final SpreadsheetView view) {
    this.view = view;
  }

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

    this.setPosition(new Position(selectedColumns[0], selectedRows[0]));

    Application.instance.setCurrentPosition(getPosition());
    final Expression exp = Application.instance.get(getPosition());
    final String description = exp.getDescription();


    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
    	if  (!description.equals("Text \"\""))
    		ExpressionView.instance.setExpressionText(description); 
    	else
    		ExpressionView.instance.setExpressionText("");
      StatusView.instance.clearStatus();
      }
    });
  }

	public static Position getPosition() {
		return position;
	}
	
	public static void setPosition(Position position) {
		SpreadsheetSelectionListener.position = position;
	}

}
