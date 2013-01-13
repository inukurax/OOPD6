package ui;

import java.util.Scanner;

import spreadsheet.*;
import spreadsheet.arithmetic.*;
import spreadsheet.logical.*;
import spreadsheet.textual.*;
import spreadsheet.exception.*;

import ui.exception.*;

public final class ExpressionInterpreter {

  public ExpressionInterpreter() {
    // This class should not be instanciated.
  }

  
  /** We have made minor tweaks to catch more errors */
  /* Assumes that scanner is not null. Returns null if the command was not
   * recognised. 
   */
  public static Expression interpret(final Scanner scanner)
      throws
        InvalidPositionException,
        NoSuchSpreadsheetException,
        IllegalStartOfExpression,
        InvalidExpression {
	  final String keyword;
	  if (scanner.hasNext())
		  keyword = scanner.next();
	  else 
		  keyword = "";
    Expression operand, firstOperand, secondOperand;
    switch(keyword) {
      case "Int":
    	  if (scanner.hasNextInt())
    		  return new Int(scanner.nextInt());
    	  else 
    		  throw new InvalidExpression(keyword);
      case "Neg":
        operand = ExpressionInterpreter.interpret(scanner);
        return new Neg(operand);
      case "Add":
        firstOperand = ExpressionInterpreter.interpret(scanner);
        secondOperand = ExpressionInterpreter.interpret(scanner);
        return new Add(firstOperand, secondOperand);
      case "True":
        return new True();
      case "False":
        return new False();
      case "Not":
        operand = ExpressionInterpreter.interpret(scanner);
        return new Not(operand);
      case "And":
        firstOperand = ExpressionInterpreter.interpret(scanner);
        secondOperand = ExpressionInterpreter.interpret(scanner);
        return new And(firstOperand, secondOperand);
      case "Or":
        firstOperand = ExpressionInterpreter.interpret(scanner);
        secondOperand = ExpressionInterpreter.interpret(scanner);
        return new Or(firstOperand, secondOperand);
      case "Text":
    	  if (scanner.hasNext())
    	  	return new Text(scanner.nextLine());
    	  else 
    		  throw new InvalidExpression(keyword);
      case "Concat":
        firstOperand = ExpressionInterpreter.interpret(scanner);
        secondOperand = ExpressionInterpreter.interpret(scanner);
        return new Concat(firstOperand, secondOperand);
      default:
        return interpretReference(keyword);
    }
  }

  private static Reference interpretReference(String text)
      throws
        NoSuchSpreadsheetException,
        InvalidPositionException {

    Spreadsheet spreadsheet = null;
    final int indexOfBang = text.indexOf('!');
    if (indexOfBang != -1) {
      final String name = text.substring(0, indexOfBang);
      spreadsheet = Application.instance.getSpreadsheet(name);
      text = text.substring(indexOfBang + 1, text.length());
    } else {
      spreadsheet = Application.instance.getWorksheet();
    }

    return new Reference(spreadsheet, PositionInterpreter.interpret(text));
  }

}
