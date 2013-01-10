package gui.control;

import gui.SpreadsheetsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import spreadsheet.Application;
import spreadsheet.Spreadsheet;

	public final class NewSpreadsheetListener implements ActionListener {
	
	public static final NewSpreadsheetListener instance = new NewSpreadsheetListener();

	private NewSpreadsheetListener() {
		// Singleton
	}
	/**
	 * Adds a new Spreadsheet to Application and a new tab
	 * to SpreadsheetsView
	 */
	public void actionPerformed(ActionEvent arg0) {
	   Spreadsheet sheet = Application.instance.newSpreadsheet();
	   SpreadsheetsView.instance.addNewSpreadsheet(sheet);	
	}	
}
