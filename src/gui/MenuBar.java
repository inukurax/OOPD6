package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.language.Language;

import gui.control.DeleteListener;
import gui.control.ExitListener;
import gui.control.NewSpreadsheetListener;

public final class MenuBar
    extends JMenuBar {

  public static final long serialVersionUID = 1L;

  // Makes sure that MenuBar is only initialized once.
  public static final MenuBar instance = new MenuBar();

  /**
   * Creates a singleton of a JMenuBar
   */
  private MenuBar() {
    super();
    this.add(this.newFileMenu());
    this.add(this.newSpreadsheetMenu());

  }
  /**
   * JMenu called "File"
   * @return JMenu with the JMenuItems 
   * Uses newExitMenuItem() from below
   */
  private JMenu newFileMenu() {
    final JMenu menu = new JMenu(Language.instance.file());
    menu.add(this.newExitMenuItem());
    return menu;
  }
  
  /**
   * JMenu called "Spreadsheet"
   * @return JMenu with the JMenuItems 
   * Uses newSpreadsheetMenuItem() and deleteSpreadsheetMenuItem() from below
   */
  private JMenu newSpreadsheetMenu() {
	    final JMenu menu = new JMenu(Language.instance.regneark());
	    menu.add(this.newSpreadsheetMenuItem());
	    menu.add(this.deleteSpreadsheetMenuItem());
	    return menu;
  }
  
  /**
   * JMenuItem to create new Spreadsheet.
   * @return JMenuItem
   */
  private JMenuItem newSpreadsheetMenuItem() {
	  final JMenuItem menuItem = new JMenuItem(Language.instance.newSpreadsheet());
	  menuItem.addActionListener(NewSpreadsheetListener.instance);
	  return menuItem;
  }
  
  /**
   * JMenuItem to delete Spreadsheet
   * @return JMenuItem
   */
  private JMenuItem deleteSpreadsheetMenuItem() {
	  final JMenuItem menuItem = new JMenuItem(Language.instance.deleteSpreadsheet());
	  menuItem.addActionListener(DeleteListener.instance);
	  return menuItem;
  }

  /**
   * JMenuItem to exit program
   * @return JMenuItem
   */
  private JMenuItem newExitMenuItem() {
	  final JMenuItem menuItem = new JMenuItem(Language.instance.exit());
	  menuItem.addActionListener(ExitListener.instance);
	  return menuItem;
  }

}
