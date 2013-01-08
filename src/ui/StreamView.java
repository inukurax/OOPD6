package ui;

public final class StreamView {

  public static final StreamView instance = new StreamView();

  private StreamView() {

  }

  public void println(final String text) {
    System.out.println(text);
  }

}
