package spreadsheet;

public final class CycleException
    extends Exception {

  public static final long serialVersionUID = 1L;

  public CycleException(final Reference.Path path) {
    super(path.toString());
  }

}
