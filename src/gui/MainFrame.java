package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import gui.language.Language;

/** The main frame of Regneark.
 *
 * Regneark has just one main frame, hence the singleton implementation. */
public final class MainFrame
    extends JFrame {

  public static final long serialVersionUID = 1L;

  public static final MainFrame instance = new MainFrame();

  private MainFrame() {
    super(Language.instance.regneark());

    this.setJMenuBar(MenuBar.instance);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(new MainPanel());
    this.setExtendedState(this.MAXIMIZED_BOTH);  

  }

  private class MainPanel
      extends JPanel {

    public static final long serialVersionUID = 1L;

    public MainPanel() {
      super(new BorderLayout());
      this.add(ExpressionView.instance, BorderLayout.PAGE_START);
      this.add(SpreadsheetsView.instance, BorderLayout.CENTER);
      this.add(StatusView.instance, BorderLayout.PAGE_END);

/*
      this.add(new JLabel("TOP"), BorderLayout.PAGE_START);
      this.add(new JLabel("MIDDLE"), BorderLayout.CENTER);
      this.add(new JLabel("BOTTOM"), BorderLayout.PAGE_END);
*/
    }

  }

}
