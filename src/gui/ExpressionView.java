package gui;

import javax.swing.JLabel;

public final class ExpressionView
    extends JLabel {

  public static final long serialVersionUID = 1L;

  public static final ExpressionView instance = new ExpressionView();

  private ExpressionView() {
    super("ExpressionView");
    // This is a singleton.
  }

}
