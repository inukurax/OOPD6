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

public final class ExpressionView
    extends JTextField {

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
  

  class ExpressionFieldListener implements ActionListener {
	  	StatusView status = StatusView.instance;
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = jtfExpression.getText();
		String position = null;
		String expression = null;
		int whitespace = text.indexOf(" ");
		if (whitespace != -1) {
			position = text.substring(0, whitespace);
			expression = text.substring(whitespace);
		}
		Position pos = null;
		Expression exp = null;
		try {
			pos = PositionInterpreter.interpret(position);
		} catch (InvalidPositionException e3) {
			status.errorStatus("Invalid Position");
		}
		try {
			if (expression != null)
			exp = ExpressionInterpreter.interpret(new Scanner(expression));
			
			}
		catch (NoSuchSpreadsheetException
				| IllegalStartOfExpression | InvalidExpression e1) {
				status.errorStatus("Invalid Expression");
			}
		catch (InvalidPositionException e2) {
			status.errorStatus("Invalid Reference Position");
		}
		if (pos != null && exp != null) {
			new SetCommand(pos, exp).execute();
			jtfExpression.setText("");
		}
		}
	

  	}  
}
