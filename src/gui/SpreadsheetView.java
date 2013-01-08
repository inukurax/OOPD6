package gui;

import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListSelectionModel;

import spreadsheet.Spreadsheet;

public final class SpreadsheetView
    extends JTable {

  public static final long serialVersionUID = 1L;

  public SpreadsheetView(final Spreadsheet spreadsheet) {
    super(new SpreadsheetModel(spreadsheet));
    this.setSelectionModel(selectionModel);
    this.setCellSelectionEnabled(true);
    this.hideHeader();
    this.addSpreadsheetSelectionListener();
  }

  private void hideHeader() {
    this.getTableHeader().setVisible(false);
    this.getTableHeader().setPreferredSize(new Dimension(-1,0));
  }

  private void addSpreadsheetSelectionListener() {
    final SpreadsheetSelectionListener listener =
      new SpreadsheetSelectionListener(this);

    this.getSelectionModel().addListSelectionListener(listener);
    this.getColumnModel().getSelectionModel()
      .addListSelectionListener(listener);
  }

}
