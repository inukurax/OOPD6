import gui.MainFrame;

/** A main file to invoke the graphical user interface. */
public final class GUI {

  public static void main(String[] _) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        MainFrame.instance.setVisible(true);
      }
    });
  }

}
