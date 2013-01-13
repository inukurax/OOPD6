package gui;

import spreadsheet.Expression;
import spreadsheet.Position;
import spreadsheet.exception.NoSuchSpreadsheetException;
import ui.command.SetCommand;
import ui.ExpressionInterpreter;
import ui.exception.IllegalStartOfExpression;
import ui.exception.InvalidExpression;
import ui.exception.InvalidPositionException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JTextField;

public final class ExpressionView extends JTextField {

  public static final long serialVersionUID = 1L;

  public static final ExpressionView instance = new ExpressionView();

  private JTextField jtfExpression;
  
  private ExpressionView() {
	  this.addActionListener(new ExpressionFieldListener());
	  jtfExpression = this;
  }
  
  public void setExpressionText(String text) {
	  this.setText(text);
  }
  
  /**
   * ExpressionFieldListener is a listener for the Textfield.
   * Uses position interpreter and expression interpreter
   * to add new Expressions to the spreadsheet and repaints SpreadsheetsView
   * @throws InvalidExpression, NoSuchSpreadsheetException, IllegalStartOfExpression
   * 		 InvalidPositionException
   */
  class ExpressionFieldListener implements ActionListener {
	  	StatusView status = StatusView.instance;
	@Override
	public void actionPerformed(ActionEvent e) {
		status.clearStatus();
		String expression = jtfExpression.getText();
	
		Position pos = SpreadsheetSelectionListener.getPosition();
		Expression exp = null;
		try {
			if (!expression.isEmpty())
				exp = ExpressionInterpreter.interpret(new Scanner(expression));
			else 
				status.errorStatus("No expression input");
		}
		catch (InvalidExpression e1) {
				status.errorStatus("Invalid Expression");
		}
		catch (NoSuchSpreadsheetException e1) {
			status.errorStatus("NoSuchSpreadsheetException");
		}
		catch (IllegalStartOfExpression e1) {
			status.errorStatus("IllegalStartOfExpression");
		}
		catch (InvalidPositionException e2) {
			status.errorStatus("Invalid Reference Position");
		}
		
		if (pos != null && exp != null) {
			new SetCommand(pos, exp).execute();
			SpreadsheetsView.instance.repaint();
			jtfExpression.setText("");
		}
		else if (pos == null)
			status.errorStatus("No position");
	}
  }  
}
