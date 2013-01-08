package gui.language;

/** The language file for the GUI.
 *
 * GUI components should not contain <em>any</em> human-readable strings. All
 * these strings should be in a language file. This class serves as the
 * langauge package front-end. */
public final class Language {

  public static final LanguageSpecification instance = new English();

  public final class MenuBar {
    public static final String FILE = "File";
    public static final String EXIT = "Exit";
    public static final String SPREADSHEET = "Spreadsheet";
    public static final String NEW_SPREADSHEET = "New spreadsheet";

    public static final String EDIT = "Edit";
    public static final String COPY = "Copy";
    public static final String PASTE = "Paste";
  }

}

