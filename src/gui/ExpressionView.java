package gui;

import spreadsheet.Expression;
import spreadsheet.Position;
import spreadsheet.exception.NoSuchSpreadsheetException;
import ui.command.SetCommand;
import ui.ExpressionInterpreter;
import ui.PositionInterpreter;
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
   * @throws Fitting errors depending on the users "mistake"
   */
  class ExpressionFieldListener implements ActionListener {
	  	StatusView status = StatusView.instance;
	@Override
	public void actionPerformed(ActionEvent e) {
		status.clearStatus();
		String text = jtfExpression.getText();
		String position = text;
		String expression = "";
		int whitespace = text.indexOf(" ");
		if (whitespace != -1) {
			position = text.substring(0, whitespace);
		}
		if (whitespace != -1 && (text.length()-1) != whitespace)
			expression = text.substring(whitespace);
		Position pos = null;
		Expression exp = null;
		try {
			if (!position.isEmpty())
				pos = PositionInterpreter.interpret(position); 
		try {
			if (!expression.isEmpty())
			exp = ExpressionInterpreter.interpret(new Scanner(expression));
			else if (!position.isEmpty())
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
		
		} catch (InvalidPositionException e3) {
			status.errorStatus("Invalid Position");
		}
		if (pos != null && exp != null) {
			new SetCommand(pos, exp).execute();
			SpreadsheetsView.instance.repaint();
			jtfExpression.setText("");
		}
	}
  }  
}
