package gui;

import javax.swing.JLabel;

public final class StatusView
    extends JLabel {

  public static final long serialVersionUID = 1L;

  public static final StatusView instance = new StatusView();

  private StatusView() {
    super("StatusView");
    // This is a singleton.
  }

}
