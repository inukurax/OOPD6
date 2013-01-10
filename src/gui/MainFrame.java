package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import gui.language.Language;

/** The main frame of Regneark.
 *
 * Regneark has just one main frame, hence the singleton implementation. */
public final class MainFrame
    extends JFrame {

  public static final long serialVersionUID = 1L;

  public static final MainFrame instance = new MainFrame();
  
  /**
   * Sets the MainFrame og the program. Adds MainPanel as ContentPane.
   * Also adds Menubar
   */
  private MainFrame() {
    super(Language.instance.regneark());
    this.setJMenuBar(MenuBar.instance);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new MainPanel());
    this.pack();
//    this.setExtendedState(this.MAXIMIZED_BOTH);  
  }

  private class MainPanel
      extends JPanel {

    public static final long serialVersionUID = 1L;
    
    /**
     * The MainPanel holds ExpressionView, SpreadsheetsView and StatusView.
     */
    public MainPanel() {
      super(new BorderLayout());
      this.add(ExpressionView.instance, BorderLayout.PAGE_START);
      this.add(SpreadsheetsView.instance, BorderLayout.CENTER);
      this.add(StatusView.instance, BorderLayout.PAGE_END);
    }
  }
}
