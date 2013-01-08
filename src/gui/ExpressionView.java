package gui;

import spreadsheet.exception.NoSuchSpreadsheetException;
import ui.ExpressionInterpreter;
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

  private ExpressionView() {
    // This is a singleton.
  }
  
  JTextField jtfExpression = new JTextField();  

  class ExpressionFieldListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = jtfExpression.getText();
		Scanner scanner = new Scanner(str);
		try {
			ExpressionInterpreter.interpret(scanner);
			
		} catch (InvalidPositionException | NoSuchSpreadsheetException
				| IllegalStartOfExpression | InvalidExpression e1) {
			StatusView.instance.ErrorStatus("Wrong input");
		}
		}
	  
  }
  
}
