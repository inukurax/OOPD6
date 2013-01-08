package gui.control;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ui.command.ExitCommand;

public final class ExitListener
    implements ActionListener {

  public static final ExitListener instance = new ExitListener();

  private ExitListener() {
    // This is a singleton.
  }

  public void actionPerformed(ActionEvent event) {
    new ExitCommand().execute();
  }

}
